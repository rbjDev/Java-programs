package PracticeKunalPlaylist;

public class NQueens {
    public static void main(String args[]){
        int n=5;
        boolean[][] board = new boolean[n][n];
        System.out.println("Count: " + showNQueensSoln(board, 0));

    }

    private static int showNQueensSoln(boolean[][] board, int row){

        if(row==board.length){
            display(board);
            System.out.println();
            return 1;
        }

        int count = 0;
        for(int col = 0; col<board.length ; col++){
            if(isSafe(board,row,col)){
                board[row][col] = true;
                count+= showNQueensSoln(board, row+1);
                board[row][col] = false;
            }
        }
        
        return count;
    }

    private static void display(boolean[][] board) {
        for(boolean arr[]: board){
            for(boolean t: arr){
                if(t==true)  System.out.print("Q ") ;
                else  System.out.print("X ");
            }
            System.out.println();
        }
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        //check up
        for(int i=0; i<row; i++){
            if(board[i][col]==true)
                return false;
        }

        //check left diagonal
        int maxLeft = Math.min(row,col);
        for(int i = 1 ; i<=maxLeft ; i++){
            if(board[row-i][col-i]==true)
            return false;
        }

        //check right diagonal
        int maxRight = Math.min(row,board[0].length - col - 1);
        for(int i = 1 ; i<=maxRight ; i++){
            if(board[row-i][col+i]==true)
            return false;
        }


        return true;
    }
}
