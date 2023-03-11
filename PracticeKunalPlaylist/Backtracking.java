package PracticeKunalPlaylist;

import java.util.Arrays;

public class Backtracking {
    public static void main(String args[]){
        boolean[][] maze ={
            {true,true,true},
            {true,true,true},
            {true,true,true}
           };
           
        //mazeWithObstacles("", maze, 0, 0);
        printMatrixAndPath("", maze, new int[maze.length][maze[0].length], 1, 0, 0);

    }

    private static void mazeWithObstacles(String path, boolean[][] maze, int r, int c){
        if(r== maze.length-1 && c==maze[0].length-1){
            System.out.println(path);
            return;
        }
        //System.out.println(r + "," + c);
        if(maze[r][c] == false) return;
        maze[r][c] = false;
        if(r < maze.length-1) mazeWithObstacles(path + " D ", maze, r+1, c);
        if(c < maze[0].length-1) mazeWithObstacles(path + " R ", maze, r, c+1);
        if(r > 0) mazeWithObstacles(path + " U ", maze, r-1, c);
        if(c > 0) mazeWithObstacles(path + " L ", maze, r, c-1);
        maze[r][c] =  true;
    }

    //Print matrix and paths
    private static void printMatrixAndPath(String path, boolean[][] maze, int[][] matrix, int step, int r, int c){
        if(r== maze.length-1 && c==maze[0].length-1){
            matrix[r][c] = step;
            for(int arr[]: matrix){
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(path);
            System.out.println();
            return;
        }
        //System.out.println(r + "," + c);
        if(maze[r][c] == false) return;
        maze[r][c] = false;
        matrix[r][c] = step;
        if(r < maze.length-1) printMatrixAndPath(path + " D ", maze, matrix, step+1, r+1, c);
        if(c < maze[0].length-1) printMatrixAndPath(path + " R ", maze, matrix, step+1, r, c+1);
        if(r > 0) printMatrixAndPath(path + " U ", maze, matrix, step+1, r-1, c);
        if(c > 0) printMatrixAndPath(path + " L ", maze, matrix, step+1, r, c-1);
        maze[r][c] =  true;
        matrix[r][c] = 0;
    }
}
