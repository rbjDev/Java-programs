package Graph;
/**
 * https://leetcode.com/problems/number-of-provinces/description/
 * Logic:  Start a DFS at every node (except if it's already been vsited) and mark all reachable nodes as being part of the
 * same component.Increment the count by 1 whenever you are able to initate a dfs traversal
 */
public class LeetCode547 {

    public static void main(String[] args) {
        int isConnected[][] =  { { 1, 0, 0 }, { 0, 1, 0 },{0,0,1} };
        System.out.println("Count: " + findCircleNum(isConnected));
    }

    public static int findCircleNum(int[][] isConnected) {
        boolean visited[] =  new boolean[isConnected.length]; 
        int connectedCount = 0;
        for(int i =0; i<isConnected.length ; i++){
            if(!visited[i]){
                dfsTraverse(isConnected,visited,i);                
                connectedCount++;
            }

        }
        return connectedCount;
    }

    private static void dfsTraverse(int[][] isConnected, boolean[] visited, int i) {
        if(i==isConnected.length) return;
        visited[i] = true;
        for(int j = 0 ; j<isConnected.length ; j++){
            if(!visited[j] && isConnected[i][j]==1){
                dfsTraverse(isConnected, visited, j);
            }
        }
    }
    
}
