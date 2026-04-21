# Rishav_Sudoku
Sudoku Generator
Rishav Banik

## Description
A Java console application that generates a fully solved 9x9 Sudoku board.
The program uses two generation methods, which are a fast cyclic pattern approach
and a randomized recursive backtracking approach.

## How to Run
1. Download or clone the repository
2. Open a terminal in the project folder
3. Compile the program:
javac Sudoku.java
4. Run the program:
java Sudoku

## How the Board is Generated
Cyclic Generation: Uses the formula `(row * 3 + row / 3 + col) % 9`
on a shuffled list of 1-9 to fill the board in O(1) time while satisfying
all Sudoku constraints.

Backtracking Generation: Fills the first row randomly, then uses a
recursive method that tries shuffled digits at each empty cell, backtracking
whenever a conflict is found.

## Files
- `Sudoku.java` - Main source code containing all generation logic and methods
- `SudokuGenerator.java` - Main entry point that runs the program
- `README.md` - Project description
- `DesignDocument.pdf` - Design document with full explanation
