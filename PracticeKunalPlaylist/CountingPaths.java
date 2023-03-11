package PracticeKunalPlaylist;

import java.util.ArrayList;
import java.util.List;

public class CountingPaths {
    public static void main(String args[]){
      //  System.out.println(count(3,3));
       // printPaths(3,3,"");
       //System.out.println(getPaths(3, 3, ""));
       boolean[][] maze ={
        {true,true,true},
        {true,false,true},
        {true,true,true}
       };
       
       mazeWithObstacles("", maze, 0, 0);
        
    }

    private static void printPaths(int r, int c, String proc) {
        if(r==1 && c==1){
            System.out.println(proc);
            return;
        }
        if(r>1) printPaths(r-1, c, proc + " D ");
        if(c>1) printPaths(r, c-1, proc + " R ");
    }

    private static List<String> getPaths(int r, int c, String proc){
        List<String> list = new ArrayList<>();
        if(r==1 && c==1){
            list.add(proc);
            //System.out.println(proc);
            return list;
        }
        if(r>1) list.addAll(getPaths(r-1, c, proc + " D "));
        if(c>1) list.addAll(getPaths(r, c-1, proc + " R "));
        return list;        
    }

    private static int count(int r, int c) {
        if(r==1||c==1){
            return 1;
        }
        return count(r-1,c) + count(r,c-1);
    }

    private static void mazeWithObstacles(String path, boolean[][] maze, int r, int c){
        if(r== maze.length-1 && c==maze[0].length-1){
            System.out.println(path);
            return;
        }
        //System.out.println(r + "," + c);
        if(maze[r][c] == false) return;
        if(r < maze.length-1) mazeWithObstacles(path + " D ", maze, r+1, c);
        if(c < maze[0].length-1) mazeWithObstacles(path + " R ", maze, r, c+1);
    }


}
