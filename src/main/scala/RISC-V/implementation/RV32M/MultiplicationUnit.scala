package RISCV.implementation.RV32M

import chisel3._
import chisel3.util._

import RISCV.interfaces.generic.AbstractExecutionUnit
import RISCV.model._


class MultiplicationUnit extends AbstractExecutionUnit {

    io.misa := "b01__0000__0_00000_00000_00100_00000_00000".U

    io.valid := false.B    
    io.stall := STALL_REASON.NO_STALL

    io_data <> DontCare
    io_reg <> DontCare
    io_pc <> DontCare
    io_reset <> DontCare
    
    //TODO: Your solution to Problem 2.4 should go here

    // val opcode = RISCV_OP(io.instr(6, 0))
    // val funct7 = RISCV_FUNCT7(io.instr(31, 25))
    // val funct3 = RISCV_FUNCT3(io.instr(14, 12))

    // val noMulButDiv= io.instr(14)       // 0 for MUL, 1 for DIV

    // val RS1 = io.instr(19, 15)
    // val RS2 = io.instr(24, 20)
    // val RD  = io.instr(11, 7)

    // // val decoderState :: controlUnitState :: processorState :: Nil = Enum (3)
    // // val state = RegInit(decoderState);

    

    // // switch (state) {
    // //     is (decoderState) {
            
    //         when (opcode === RISCV_OP.OP) {
        
    //             when (!noMulButDiv && funct7 === RISCV_FUNCT7.MULDIV) {
    //                 io.valid := true.B
    //                 // RS1 := io.instr(19, 15)
    //                 // RS2 := io.instr(24, 20)
    //                 // RD := io.instr(11, 7)

    //                 // state := controlUnitState

                
    //                 io_pc.pc_wdata := io_pc.pc + 4.U
    //                 io_reg.reg_write_en := true.B

    //                 when ( io.instr(14, 12) === "b000".U ) { // MUL
    //                 io_reg.reg_write_data := (RS1 * RS2) &  31.U
    //                 } 

    //                 when ( io.instr(14, 12) === "b011".U ){  //MULHU
    //                     io_reg.reg_write_data := (RS1 * RS2) &  992.U
    //                 }

    //                 when ( io.instr(14, 12) === "b001".U ) { // MULH

    //                     when ( (RS1(4) & RS2 (4)) === 1.U) { // bitwise chisel and**
    //                             io_reg.reg_write_data := -1.U *((RS1 * RS2) &  992.U)
    //                     }
    //                     .otherwise {
    //                             io_reg.reg_write_data := (RS1 * RS2) &  992.U
    //                     }  
    //                 } 
    //                 when ( io.instr(14, 12) === "b010".U ){  // MULHSU

    //                     io_reg.reg_write_data := (RS1 * RS2) &  992.U
    //                 }
    //             }
    //         }
    //     // }
    //     // is (controlUnitState) {

    //                         // state := processorState
            
    //     // }
    //     // is (processorState) {

            
            
    //     // }
    // // }
    
}
