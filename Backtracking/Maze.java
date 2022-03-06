package Backtracking;

import java.util.ArrayList;

/**
 * Kunal Kushwaha DSA bootcamp
 * https://www.youtube.com/watch?v=zg5v2rlV1tM&list=RDCMUCBGOUQHNNtNGcGzVq5rIXjw&index=2
 * Backtracking introduction + Maze problems
 */
public class Maze {
    public static void main(String args[]){
        System.out.println("No of paths:"+countPaths(2,3));
        System.out.println("Paths:"+ getPath("", 3, 3));
        System.out.println("Paths including diagonal paths:"+ getPathDiagonal("", 3, 3));
    }

    /**
     * Count paths from (r,c) to 1,1 
     * 
     */
    public static int countPaths(int r , int c){
        if(r==1 || c==1){
            return 1;
        }
        int down = countPaths(r-1, c);
        int right = countPaths(r, c-1);
        return down + right;
    }

    /**
     * Get list of paths from (r,c) to 1,1 
     * 
     */
    public static ArrayList<String> getPath(String p, int r, int c){
        ArrayList<String> list = new ArrayList<>();
        if(r==1 && c==1){
            list.add(p);
            return list;
        }
        if(r>1) list.addAll(getPath(p+"D", r-1, c)); //Down/Vertical path
        if(c>1) list.addAll(getPath(p+"R", r, c-1)); //Right/Horizontal path
        return list;
    }

    public static ArrayList<String> getPathDiagonal(String p, int r, int c){
        ArrayList<String> list = new ArrayList<>();
        if(r==1 && c==1){
            list.add(p);
            return list;
        }
        if(r>1 && c>1) list.addAll(getPathDiagonal(p+"D", r-1, c-1));
        if(r>1) list.addAll(getPathDiagonal(p+"V", r-1, c)); //Down/Vertical path
        if(c>1) list.addAll(getPathDiagonal(p+"H", r, c-1)); //Right/Horizontal path
        return list;
    }
}
