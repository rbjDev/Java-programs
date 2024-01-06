package Graph;

import java.util.ArrayList;

public class CheckPath {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean visited[] = new boolean[n];
        //Create an array of ArrayList
        ArrayList<Integer> graph[] = new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i] = new ArrayList<Integer>();
        }
        //Create adjacency List from edges
        for(int[] edge: edges){
            int from = edge[0];
            int to = edge[1];
            graph[from].add(to);
            graph[to].add(from);
        }
        return hasPath(graph,source,destination,visited);

    }

    public boolean hasPath(ArrayList<Integer> graph[], int source, int destination,boolean visited[] ){

        if(source==destination) return true;
        visited[source] =true;
        for(int vertex : graph[source]){
            if(visited[vertex] == false){
                boolean pathExists = hasPath(graph,vertex,destination,visited);
                if(pathExists==true) return true;
            }
        }
        return false;
    }
}