

# System Architecture Project: Hardware Design with Chisel

## Table of Contents
1. [Project Overview](#project-overview)
2. [Project Setup](#project-setup)
3. [Project Structure](#project-structure)
4. [Part 1: Arithmetic Circuits in Chisel](#part-1-arithmetic-circuits-in-chisel)
   - [Problem 1.1: Division Circuit](#problem-11-division-circuit)
   - [Problem 1.2: Bonus: Faster Division](#problem-12-bonus-faster-division)
   - [Problem 1.3: Vector Unit](#problem-13-vector-unit)
5. [Part 2: RISC-V Processor](#part-2-risc-v-processor)
   - [Problem 2.1: Modular RISC-V Implementation](#problem-21-modular-risc-v-implementation)
   - [Problem 2.2: Function Calls](#problem-22-function-calls)
   - [Problem 2.3: Load Instructions](#problem-23-load-instructions)
   - [Problem 2.4: Multiplication and Division Instructions](#problem-24-multiplication-and-division-instructions)
   - [Problem 2.5: Bonus: Division](#problem-25-bonus-division)
6. [Submission Guidelines](#submission-guidelines)
7. [Collaboration Policy](#collaboration-policy)
8. [Additional Resources](#additional-resources)

---

## Project Overview

This project is part of the System Architecture course for the Summer Semester 2024. It focuses on designing and implementing arithmetic circuits and extending a RISC-V processor using Chisel, a hardware description language embedded in Scala.

The project is divided into two main parts:
1. **Arithmetic Circuits in Chisel**: Implementing a division circuit, enhancing it for faster performance, and designing a vector unit.
2. **RISC-V Processor**: Extending an existing RISC-V processor implementation to support additional instructions and functionalities.

## Project Setup

### Tools and Environment

To work on this project, you will need the following:
- **Java** and **Scala** installed on your machine.
- **sbt (Simple Build Tool)** for building the project, running tests, and generating submission files.

Follow these steps to set up your environment:
1. Install Java and Scala by following the instructions at [Scala Downloads](https://www.scala-lang.org/download/).
2. Install sbt by following the instructions at [sbt Setup](https://www.scala-sbt.org/1.x/docs/Setup.html).
3. Clone the project repository using the following command:
   ```bash
   git clone https://gitlab.cs.uni-saarland.de/reineke/sysarch-project-one
   ```
4. Use an IDE such as **VSCode** with the **Scala** extension and **Metals language server** for development. The repository includes a `.vscode` folder for easy setup.

### Important sbt Commands

| Command                             | Description                                                       |
|-------------------------------------|-------------------------------------------------------------------|
| `sbt compile`                       | Compiles the project.                                             |
| `sbt clean`                         | Cleans the project.                                               |
| `sbt test`                          | Runs all tests in the project.                                     |
| `sbt "testOnly *TestName*"`         | Runs a specific test (replace `*TestName*` with the test name).    |
| `sbt check`                         | Runs sanitizer tests.                                             |
| `sbt createSubmission`              | Creates a submission file in the `submissions` folder.            |
| `sbt checkAndSubmission`            | Runs sanitizer tests and creates a submission file if they pass.   |

## Project Structure

The project is organized into two main directories corresponding to the two parts of the project:

1. **src/main/scala/arithmetic**: Contains the implementation files for arithmetic circuits.
2. **src/main/scala/RISC-V**: Contains the implementation files for the RISC-V processor.

The tests for each part are located in the corresponding `src/test/scala` directories.

## Part 1: Arithmetic Circuits in Chisel

### Problem 1.1: Division Circuit

**Points**: 5

**Description**: Implement a sequential division circuit based on the grade school division algorithm. The circuit should have two n-bit inputs (dividend and divisor) and two n-bit outputs (quotient and remainder). The computation begins when the `start` signal is set to `true` and completes in n clock cycles, at which point the `done` signal is set to `true`.

**Guidelines**:
- Use registers to store the current state of the division.
- Implement the multiplication by a shift operation to minimize hardware cost.

### Problem 1.2: Bonus: Faster Division

**Points**: 2 (Bonus)

**Description**: Optimize the division circuit to terminate early under certain conditions. Identify and implement these conditions to reduce the number of cycles required for the division.

**Submission**: Describe the identified conditions and implementation in `CONTRIBUTIONS.md`.

### Problem 1.3: Vector Unit

**Points**: 5

**Description**: Implement a vector unit generator (`ParallelUnit`) that can perform operations on multiple data elements in parallel. The generator should accept parameters for array size, vector size, unit width, and a computational unit for scalar operations.

## Part 2: RISC-V Processor

### Problem 2.1: Modular RISC-V Implementation



**Description**: Familiarize yourself with the provided RISC-V processor implementation. This task does not carry any points but is crucial for understanding the following problems.

### Problem 2.2: Function Calls



**Description**: Implement support for the `jal` and `jalr` instructions, which are essential for function calls in RISC-V. Modify the decoder, control unit, and execution unit as necessary.

### Problem 2.3: Load Instructions



**Description**: Add support for load instructions (`lw`, `lb`, `lbu`, `lh`, `lhu`). Update the processor to correctly decode and execute these instructions.

### Problem 2.4: Multiplication and Division Instructions



**Description**:
- **Multiplication**: Implement the `mul`, `mulh`, `mulhsu`, `mulhu` instructions.
- **Division**: Implement the `div`, `divu`, `rem`, `remu` instructions.

### Problem 2.5: Bonus: Division

**Points**: 4 (Bonus)

**Description**: Integrate the division circuit from Problem 1.1 into the RISC-V processor to handle division instructions. Implement appropriate stall signals to manage the non-combinatorial nature of the circuit.

## Submission Guidelines

1. **Run Tests**: Ensure that your project passes all tests by running `sbt check`.
2. **Create Submission**: Generate a submission file using `sbt createSubmission`. The file will be saved in the `submissions` folder.
3. **Upload**: Submit the generated file to the CMS system by the deadline.



## Additional Resources

- **Chisel Documentation**: [Chisel](https://www.chisel-lang.org/)
- **RISC-V Specification**: [RISC-V Specifications](https://riscv.org/specifications/)


