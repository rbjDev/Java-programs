package Graph;

import java.util.ArrayList;

public class CheckPath {
    public static void main(String[] args){
        int edges[][] = {{0,1},{0,2},{1,3},{3,5},{5,4},{4,3}};
        boolean[] visited = new boolean[6];
        //System.out.println("Has path : "+ validPath(6,edges,0,5));
        ArrayList<Integer> graph[] = buildAdjacencyList(edges);
        dfs(graph, 0, visited);

    }

    public static ArrayList<Integer>[] buildAdjacencyList(int edges[][]){
        int n = 6;
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
        return graph;
    }

    public static boolean validPath(int n, int[][] edges, int source, int destination) {
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

    public static boolean hasPath(ArrayList<Integer> graph[], int source, int destination,boolean visited[] ){

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

    public static void dfs(ArrayList<Integer> graph[], int source, boolean visited[] ){
        
        visited[source] =true;
        System.out.println(source + " , ");
        for(int vertex : graph[source]){
            if(visited[vertex] == false){
                dfs(graph, vertex, visited);
            }
        }
    }


}