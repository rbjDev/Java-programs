package Backtracking;

public class NQueensProblem {
    public static void main(String[] args){
        boolean[][] board1 = new boolean[1][1];
        boolean[][] board4 = new boolean[4][4];
        boolean[][] board5 = new boolean[5][5];
        boolean[][] board2 = new boolean[2][2];
        //System.out.println("Count:"+nQueens(board, 0));
        System.out.println("Count:"+nQueensRecursive(board1, 0, 0, 1));
    }

    public static int nQueensRecursive(boolean[][] board, int row, int col, int target){
        if(target==0){
            displayBoard(board);
            System.out.println();
            return 1;
        }
        int count=0;
        if(row==board.length ||col==board.length) return 0;

        if(row==board.length-1 && col==board.length){
            return 0;
        }

        if(col==board.length){ 
            count+=nQueensRecursive(board, row+1,0,target);           
        }

        if(isSafe(board,row,col)){
            board[row][col]=true;
            count+= nQueensRecursive(board, row+1,0,target-1);
            board[row][col]=false; //set to false when backtracking
         }

        count+= nQueensRecursive(board, row, col+1, target) ;
        return count;
    }

     public static int nQueens(boolean[][] board, int row){
         if(row==board.length){
             displayBoard(board);
             System.out.println();
             return 1;
         }
         int count=0;
         for(int col=0;col<board[0].length;col++){ //placing the queen and checking for every row ad col
             if(isSafe(board,row,col)){
                board[row][col]=true;
                count+= nQueens(board, row+1);
                board[row][col]=false; //set to false when backtracking
             }
         }
         return count;
     }

     public static boolean isSafe(boolean[][] board, int row, int col){
        //check vertical col 
        for(int i=0;i<row;i++){
            if(board[i][col])
                return false;
        }

        //check left upper diagonal
        int maxLeft = Math.min(row,col);
        for(int i=1;i<=maxLeft;i++){
            if(board[row-i][col-i])
                return false;
        }

        //check right upper diagonal
        int maxRight = Math.min(row,board.length-col-1);
        for(int i=1;i<=maxRight;i++){
            if(board[row-i][col+i])
                return false;
        }
        return true;
     }

     public static void displayBoard(boolean[][] board){
         for(boolean[] row: board){
             for(boolean element: row ){
                 if(element){
                     System.out.print("Q ");
                 }
                 else
                    System.out.print("X ");
             }
             System.out.println();
         }
     }
}
