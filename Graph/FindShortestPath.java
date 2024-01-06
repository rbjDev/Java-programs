package Graph;

import java.util.ArrayList;
import java.util.List;

public class FindShortestPath {
    static int spath =Integer.MAX_VALUE;
    static String shortestPath ;

    public static class Edge{
        int source , neighbor, weight;
        public Edge(){}
        public Edge(int source, int neighbor, int weight){
            this.source = source;
            this.neighbor = neighbor;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        int edges[][] =  { {0,1,10}, {0,3,20},{1,2,10},{2,3,10},{3,4,2},{4,5,3},{4,6,8},{5,6,3} };        
        showShortestPath(7, edges, 0, 6);
    }

    public static void showShortestPath(int n, int[][] edgesList, int source, int destination) {
        boolean visited[] = new boolean[n];
        //Create an array of ArrayList
        ArrayList<Edge> graph[] = new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i] = new ArrayList<Edge>();
        }
        //Create adjacency List from edges
        for(int[] edge: edgesList){
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            graph[from].add(new Edge(from,to,weight));
            graph[to].add(new Edge(to,from,weight));
        }
        //getPath(graph,source,destination,visited,source+"");
        getShortestPath(graph,source,destination,visited,source+"",0);
        System.out.println("SHortest Path: "+ shortestPath  + " , Shortest path weight:" + spath);

    }


    public static void getShortestPath(ArrayList<Edge> graph[], int source, int destination,boolean visited[],String path,int wsf ){
        List<String> paths = new ArrayList<String>();
        if(source==destination) {    
            if(wsf<spath){
                spath = wsf;
                shortestPath = path;
            }       
            return ;            
        }
        visited[source] =true;
        for(Edge edge : graph[source]){
            if(visited[edge.neighbor] == false){                
                getShortestPath(graph,edge.neighbor,destination,visited,path+edge.neighbor, wsf+edge.weight );                
            }
        }
        visited[source] = false;   
        
    }
    
}
