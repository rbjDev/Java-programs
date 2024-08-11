/**
 * 200. Number of Islands
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 */

//package Graph;

public class LeetCode200 {
    public static void main(String[] args) {
        char[][] grid = {
                { '1', '1', '1', '1', '0' },
                { '1', '1', '0', '1', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '0', '0', '1' }
        };
        System.out.println(numIslands(grid));
    }

    public static  int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int noOfIslands = 0;
        for(int i=0;i<grid.length;i++){
            for(int j =0 ; j<grid[i].length; j++){
                if(grid[i][j]=='1' && visited[i][j]==false){
                    noOfIslands++;
                    traverseLandNodes(grid,visited,i,j);
                }
            }
        }
        return noOfIslands;
        
    }

    private static void traverseLandNodes(char[][] grid, boolean[][] visited, int i, int j) {

        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || visited[i][j]==true || grid[i][j]=='0'){
            return;
        }
        visited[i][j] = true ;
        traverseLandNodes(grid, visited, i-1, j);
        traverseLandNodes(grid, visited, i+1, j);
        traverseLandNodes(grid, visited, i, j-1);
        traverseLandNodes(grid, visited, i, j+1);
    }
    
}
