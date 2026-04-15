import java.util.*;

public class Sudoku {
    int[][] board = new int[9][9];
    ArrayList<Integer> numbers = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
    
    
    public void cyclicGeneration(){
        Collections.shuffle(numbers);
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                int value = (row * 3 + row / 3 + col) % 9;
                board[row][col] = numbers.get(value);
            }
        }
        resetNums();
    }
    
    
    public void randomGeneration(){
        // fills the board with 0s first
        for (int i = 0; i < 9; i++) {
            Arrays.fill(board[i], 0);
        }
        Collections.shuffle(numbers);
        // fills the very first row
        for(int i = 0; i < 9; i++){
            board[0][i] = numbers.get(i);
        }
        recurse(1,0);
    }
    
    public boolean recurse(int row, int col){
        // just goes to the next row, when it reaches 9 for row, its done
        if(col == 9){
            row++;
            col = 0;
        }
        if(row == 9){
            return true;
        }
        
        if (board[row][col] != 0) {
            return recurse(row, col + 1);
        }
        
        Collections.shuffle(numbers);
        
        for(int num: numbers){
            if(check(num, row, col)){
                board[row][col] = num;
                if(recurse(row, col+1)){
                    return true;
                }
            }
            
            board[row][col] = 0;
        }
        return false;
    }
    
    public boolean check(int num, int row, int col){
        // check row
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == num) return false;
        }
    
        // check column
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) return false;
        }
    
        // check 3x3 box
        int startRow = row - row % 3;
        int startCol = col - col % 3;
    
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[startRow + i][startCol + j] == num) return false;
            }
        }
    
        return true;
    }
    
    public void resetNums(){
        numbers = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
    }
    
    public void printBoard(){
        for (int i = 0; i < 9; i++) {
        if (i % 3 == 0 && i != 0) {
            System.out.println("------+-------+------");
        }

        for (int j = 0; j < 9; j++) {
            if (j % 3 == 0 && j != 0) {
                System.out.print("| ");
            }
            System.out.print(board[i][j] + " ");
        }
        System.out.println();
    }
    }
}