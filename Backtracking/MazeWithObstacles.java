package Backtracking;
/**
 * Kunal Kushwaha DSA bootcamp
 * Backtracking intro + maze problems
 * https://www.youtube.com/watch?v=zg5v2rlV1tM&list=RDCMUCBGOUQHNNtNGcGzVq5rIXjw&index=2
 */
import java.util.ArrayList;
import java.util.List;

public class MazeWithObstacles {
    public static void main(String args[]){
        boolean[][] maze = {
            {true,true,true},
            {true,false,true},
            {true,true,true}
        };
        boolean[][] maze2 = {
            {true,true,true},
            {true,false,true},
            {true,true,true},
            {true,true,true},
            {true,false,true}
        };
        boolean[][] maze3 = {
            {true,true,true},
            {true,true,true},
            {true,true,true}            
        };

        int path[][] = new int[maze.length][maze[0].length];

        // printPathWithObstacles("", maze, 0, 0, 2, 2);
        // System.out.println("List of paths:"+getPathsWithObstacles("", maze2, 0,0, 4, 2));
        // System.out.println("List of all possible paths(up/down,left/right :" + getAllPaths("", maze3, 0, 0, 2, 2));   
        getAllPathsAndPrintMatrix("", maze3, 0, 0, 2, 2, path, 1);      
    }  

    static void printPathWithObstacles(String p, boolean maze[][], int sr , int sc,int dr, int dc){
        if(sr == dr && sc==dc){
            System.out.println(p);
            return;
        }
        if(!maze[sr][sc]){
            return;
        }
        if(sr<dr){
            printPathWithObstacles(p+"V", maze, sr+1, sc, dr, dc);

        }
        if(sc<dc){
            printPathWithObstacles(p+"H", maze, sr, sc+1, dr, dc);
        }

    }
 /**
  * Reach from (sr,sc) to (dr,dc) using only two moves: Down and Right
  maze[i][j] is false if its an obstacle
  * p stands for path which is initially empty
  */
    static List<String> getPathsWithObstacles(String p, boolean maze[][], int sr , int sc,int dr, int dc){
        List<String> list = new ArrayList<>();
        if(sr == dr && sc==dc){
            list.add(p);
            return list;
        }
        if(!maze[sr][sc]){
            return list;
        }
        if(sr<dr){
            list.addAll(getPathsWithObstacles(p+"Down", maze, sr+1, sc, dr, dc)); //Go down

        }
        if(sc<dc){
            list.addAll(getPathsWithObstacles(p+"Right", maze, sr, sc+1, dr, dc)); // Go right
        }
        return list;

    }

    /**
  * Reach from (sr,sc) to (dr,dc) using all moves: Up,Down,Left and Right
  * p stands for path which is initially empty
  Example of backtracking
  */
  static List<String> getAllPaths(String p, boolean maze[][], int sr , int sc,int dr, int dc){
    List<String> list = new ArrayList<>();
    if(sr == dr && sc==dc){
        list.add(p);
        return list;
    }
    if(!maze[sr][sc]){
        return list;
    }

    maze[sr][sc]=false; //mark as visited

    if(sr<maze.length-1){
        list.addAll(getAllPaths(p+"Down", maze, sr+1, sc, dr, dc));

    }
    if(sc<maze[0].length-1){
        list.addAll(getAllPaths(p+"Right", maze, sr, sc+1, dr, dc));
    }

    if(sr>0){
        list.addAll(getAllPaths(p+"Up", maze, sr-1, sc, dr, dc));

    }

    if(sc>0){
        list.addAll(getAllPaths(p+"Up", maze, sr, sc-1, dr, dc));
    }

    maze[sr][sc]=true; //mark as unvisited when returning from function call.
    return list;

}

/**
  * Reach from (sr,sc) to (dr,dc) using all moves: (Up,Down,Left and Right) and also print in matrix form
  * p stands for path which is initially empty
  * 
  Example of backtracking
  */
  static List<String> getAllPathsAndPrintMatrix(String p, boolean maze[][], int sr, int sc, int dr, int dc, int[][] path,
        int step) {
    List<String> list = new ArrayList<>();
    if (sr == dr && sc == dc) {
        path[sr][sc] = step;
        System.out.println("Path Matrix:");
        printPathMatrix(path);
        list.add(p);
        return list;
    }
    if (!maze[sr][sc]) {
        return list;
    }

    maze[sr][sc] = false; // mark as visited
    path[sr][sc] = step;
    if (sr < maze.length - 1) {
        list.addAll(getAllPathsAndPrintMatrix(p + "Down", maze, sr + 1, sc, dr, dc, path, step + 1));

    }
    if (sc < maze[0].length - 1) {
        list.addAll(getAllPathsAndPrintMatrix(p + "Right", maze, sr, sc + 1, dr, dc, path, step + 1));
    }

    if (sr > 0) {
        list.addAll(getAllPathsAndPrintMatrix(p + "Up", maze, sr - 1, sc, dr, dc, path, step + 1));

    }

    if (sc > 0) {
        list.addAll(getAllPathsAndPrintMatrix(p + "Up", maze, sr, sc - 1, dr, dc, path, step + 1));
    }

    maze[sr][sc] = true; // mark as unvisited when returning from function call.
    path[sr][sc] = 0;
    return list;

}

    public static void printPathMatrix(int[][] path){
        for(int i = 0; i<path.length ; i++){
            for(int j= 0; j<path[0].length ; j++){
                System.out.print(path[i][j] + " ");
            }
            System.err.println();
        }
    }





}
