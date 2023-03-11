package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class LeetCode51 {
    public static void main(String[] args){
       // System.out.println(solveNQueens(4));
       int n=5;
       boolean[][] board = new boolean[n][n];
       System.out.println(nQueens(board, 0));
    }

    public static List<List<String>> solveNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        List<List<String>> list = nQueensRecursive(board,0,0,n);
        if(list.size()==0){
            List<List<String>> l = new ArrayList<>();
            return l;
        }
        else
            return list;
        
    }

    

    public static List<List<String>> nQueensRecursive(boolean[][] board, int row, int col, int target){
        List<List<String>> list = new ArrayList<>();
        if(target==0){
            List<String> solnList = boardToList(board);
            list.add(solnList);
            return list;
        }
        int count=0;
        if(row==board.length ||col==board.length) return list;

        if(row==board.length-1 && col==board.length){
            return list;
        }

        if(col==board.length){ 
            list.addAll(nQueensRecursive(board, row+1,0,target));           
        }

        if(isSafe(board,row,col)){
            board[row][col]=true;
            list.addAll(nQueensRecursive(board, row+1,0,target-1));
            board[row][col]=false; //set to false when backtracking
         }

         list.addAll(nQueensRecursive(board, row, col+1, target)) ;
        return list;
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

    public static List<String> boardToList(boolean[][] board){
        List<String> list = new ArrayList<String>();
        for(boolean[] row:board){
            StringBuilder rowString = new StringBuilder();
            for(boolean element:row){
                if(element)
                    rowString.append('Q');
                else 
                    rowString.append('.');
            }
            list.add(rowString.toString());    

        }
        return list;
    }

    public static List<List<String>> nQueens(boolean[][] board, int row){
        List<List<String>> list = new ArrayList<>();
        if(row==board.length){
            List<String> solnList = boardToList(board);
            list.add(solnList);
            return list;
        }
        for(int col=0;col<board[0].length;col++){ //placing the queen and checking for every row ad col
            if(isSafe(board,row,col)){
               board[row][col]=true;
               list.addAll(nQueens(board, row+1));
               board[row][col]=false; //set to false when backtracking
            }
        }
        return list;
    }
}

