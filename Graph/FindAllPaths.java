package Graph;

import java.util.ArrayList;
import java.util.List;

public class FindAllPaths {
    public static void main(String[] args) {
        int edges[][] =  { { 0,1 }, { 0, 3 },{1,2},{2,3},{3,4},{4,5},{4,6},{5,6} };
        
        showValidPaths(7, edges, 0, 6);
    }
    public static void showValidPaths(int n, int[][] edges, int source, int destination) {
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
        //getPath(graph,source,destination,visited,source+"");
        System.out.println(getPaths(graph,source,destination,visited,source+""));

    }

    public static void getPath(ArrayList<Integer> graph[], int source, int destination,boolean visited[],String path ){

        if(source==destination) {
            System.out.println(path);
            return ;
        }
        visited[source] =true;
        for(int vertex : graph[source]){
            if(visited[vertex] == false){
                getPath(graph,vertex,destination,visited,path+vertex);
            }
        }
        visited[source] = false;
        
    }

     public static List<String> getPaths(ArrayList<Integer> graph[], int source, int destination,boolean visited[],String path ){
        List<String> paths = new ArrayList<String>();
        if(source==destination) {
            System.out.println(path);            
            paths.add(path);
            return paths;
            
        }
        visited[source] =true;
        for(int vertex : graph[source]){
            if(visited[vertex] == false){
                
                paths.addAll(getPaths(graph,vertex,destination,visited,path+vertex));
                //return paths;
            }
        }
        visited[source] = false;
        return paths;
        
    }
}
