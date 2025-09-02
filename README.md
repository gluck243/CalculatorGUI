# Java Swing Calculator

A robust calculator built with Java and the Swing GUI framework. This project implements the core logic for parsing and evaluating complex mathematical expressions, including correct operator precedence, parentheses, and advanced features like implicit multiplication.

## Features

This calculator goes beyond basic arithmetic and includes features found in scientific calculators:

* **Standard Operations:** Addition, Subtraction, Multiplication, Division, and Modulus.
* **Correct Order of Operations (PEMDAS):** The calculator correctly handles operator precedence (e.g., `5 + 3 * 2` is correctly evaluated to `11`).
* **Parentheses Support:** Full support for nested parentheses to override the standard order of operations.
* **Switchable Bracket Modes:** A unique feature that allows the user to toggle between:
    * **Automatic Mode:** A single "smart" button that automatically places `(` or `)`.
    * **Manual Mode:** Two separate, dedicated buttons for full control over parenthesis placement.
* **Floating-Point Arithmetic:** Handles decimal numbers and calculations.
* **Unary Operator Support:** Correctly processes negative numbers (e.g., `5 * -2`).
* **Implicit Multiplication:** Understands expressions where the multiplication sign is skipped, such as `5(2+3)` or `(5+3)(2+1)`.
* **User-Friendly GUI:** A clean and intuitive interface built with Java Swing.
* **Robust Error Handling:** Catches and provides user-friendly messages for invalid expressions like mismatched parentheses or division by zero.

---

## Technologies Used

* **Java:** The core programming language.
* **Java Swing:** For building the graphical user interface.
* **`jpackage` (JDK Tool):** Used to bundle the application into a native Windows executable installer.

---

## How to Use

### For Users

You can download the Windows installer from the [Releases](https://github.com/gluck243/CalculatorGUI/releases) section of this repository. The `MyCalculator.exe` file will install the application on your system, and it does not require you to have Java installed.

### For Developers

To run the project from the source code:

1. Clone the repository:
   ```bash
   git clone https://github.com/gluck243/CalculatorGUI.git
   ```

2. Open the project in IDE of your choice (e.g., IntelliJ IDEA).

3. Locate the `Main.java` file and run it.

---

## Core Logic: The Shunting-Yard Algorithm

The heart of this calculator is its ability to parse mathematical expressions. This is achieved by implementing the **Shunting-yard algorithm**, a classic computer science algorithm developed by Edsger Dijkstra.

The process involves two main steps:

1. **Tokenization:** The input string (e.g., `"5 * (3 + 2)"`) is broken down into a list of "tokens" (`[5, *, (, 3, +, 2, )]`).

2. **Conversion to Postfix:** The Shunting-yard algorithm converts this list from standard "infix" notation to "postfix" notation (also known as Reverse Polish Notation). In postfix, the operators come *after* their operands.
    * `5 * (3 + 2)` becomes `5 3 2 + *`

3. **Evaluation:** The postfix expression is then evaluated using a stack, which is a simple and efficient process that naturally handles the correct order of operations.

---

## Bugs Report

* **If you have found any bugs or have questions about the application, please contact me via email *anton.ivanov.forwork@gmail.com***

## Author

* **Anton**
