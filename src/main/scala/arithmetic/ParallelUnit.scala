package arithmetic

import chisel3._
import chisel3.util._

abstract class ComputationalUnit(width: Int) extends Module {
  val io = IO(new Bundle {
    val a = Input(UInt(width.W))
    val b = Input(UInt(width.W))
    val c = Output(UInt(width.W))
  })
}

class ParallelUnit(vectorSize: Int, arraySize: Int, unitWidth: Int, comp: (Int) => ComputationalUnit) extends Module {
  require(vectorSize % arraySize == 0)

  val io = IO(new Bundle {
    val a = Input(Vec(vectorSize, UInt(unitWidth.W)))
    val b = Input(Vec(vectorSize, UInt(unitWidth.W)))
    val start = Input(Bool())
    val done = Output(Bool())
    val c = Output(Vec(vectorSize, UInt(unitWidth.W)))
  })

  val units = Seq.fill(arraySize)(Module(comp(unitWidth)))

  val index = RegInit(0.U(log2Ceil(vectorSize).W))
  val cycle = RegInit(0.U(log2Ceil(vectorSize / arraySize).W))
  val running = RegInit(false.B)
  val result = Reg(Vec(vectorSize, UInt(unitWidth.W)))
  val doneReg = RegInit(false.B)

  var j = 0;
  
  for (i <- 0 until arraySize) 
  {
    units(i).io.a := 0.U
    units(i).io.b := 0.U
  }

  when(io.start) 
  {
    index := 0.U
    cycle := 0.U
    running := true.B
    doneReg := false.B
  }

  when(running) 
  { 
    while(j < arraySize)
    {
        units(j).io.a := io.a(index + j.U)
        units(j).io.b := io.b(index + j.U)
        result(index + j.U) := units(j).io.c

        j += 1;
    }
    
    index := index + arraySize.U
    cycle := cycle + 1.U

    when(cycle === (vectorSize / arraySize - 1).U) 
    {
      running := false.B
      doneReg := true.B
    }
  }

  io.c := result
  io.done := doneReg
}
