package TicTakToe;

public class Board {
    private final char[][]grid;
    private int moveCount;
    public Board() {
        grid = new char[3][3];
        moveCount = 0;
        initializeBoard();
    }

    private void initializeBoard() {
        for(int row=0; row<3; row++){
            for(int col=0; col<3; col++){
                grid[row][col] = '-';
            }
        }
    }

    public void makeMove(int row,int col,char symbol){
        if(row<0 || row>=3 || col<0 || col>=3 || grid[row][col] != '-'){
            throw new IllegalArgumentException("Invalid move!");
        }
        grid[row][col]=symbol;
        moveCount++;
    }

    public boolean isFull() {
        return moveCount ==9;
    }

    public boolean hasWinner(){

        //check rows
        for(int row=0; row<3; row++){
            if(grid[row][0]!='-' && grid[row][0]==grid[row][1] && grid[row][1]==grid[row][2]){
                return true;
            }
        }

        //check columns
        for(int col=0; col<3; col++){
            if(grid[0][col]!='-' && grid[0][col]==grid[1][col] && grid[1][col]==grid[2][col]){
                return true;
            }
        }

        //check diagonals
        if(grid[0][0]!='-' && grid[0][0]==grid[1][1] && grid[1][1]==grid[2][2]){
            return true;
        }

        if(grid[0][2]!='-' && grid[0][2]==grid[1][1] && grid[1][1]==grid[2][0]){
            return true;
        }
        return false;
    }

    public void printBoard() {
        for(int row=0; row<3; row++){
            for(int col=0; col<3; col++){
                System.out.print(grid[row][col]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
