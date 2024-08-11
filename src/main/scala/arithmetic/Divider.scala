package arithmetic

import chisel3._
import chisel3.util._

class Divider(bitWidth: Int) extends Module {
  val io = IO(new Bundle {
    val start = Input(Bool())
    val done = Output(Bool())
    val dividend = Input(UInt(bitWidth.W))
    val divisor = Input(UInt(bitWidth.W))
    val quotient = Output(UInt(bitWidth.W))
    val remainder = Output(UInt(bitWidth.W))
  })

  val remainder = RegInit(0.U(bitWidth.W))
  val quotient = RegInit(0.U(bitWidth.W))
  val divisor = RegInit(0.U(bitWidth.W))

  val i = RegInit(0.U(bitWidth.W))
  val doneReg = RegInit(false.B)

  io.done := doneReg

  when(io.start) {
    when(io.divisor === 0.U) {
      quotient := (1.U << bitWidth) - 1.U
      remainder := io.dividend
      doneReg := true.B
    }.elsewhen(io.dividend < io.divisor) {
      quotient := 0.U

      when(io.dividend === 0.U) {
        remainder := 0.U
      }.otherwise {
        remainder := io.dividend
      }

      doneReg := true.B
    }.otherwise {
      remainder := 0.U
      quotient := io.dividend
      divisor := io.divisor
      i := (bitWidth - 1).U
      doneReg := false.B
    }
  }.elsewhen(i >= 0.U && !doneReg) {
    val rPrime = (remainder << 1) + quotient(i)

    when(rPrime < divisor) {
      remainder := rPrime
      quotient := quotient.bitSet(i, false.B)
    }.otherwise {
      remainder := rPrime - divisor
      quotient := quotient.bitSet(i, true.B)
    }

    when(i === 0.U) {
      doneReg := true.B
    }.otherwise {
      i := i - 1.U
    }
  }

  io.quotient := quotient
  io.remainder := remainder
}
