public class SudokuGenerator
{
    public static void main(String[] args)
    {
        Sudoku s = new Sudoku();
        s.randomGeneration();
        s.printBoard();
    }
}