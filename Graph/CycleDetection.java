//import java.util.ArrayList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import javafx.util.Pair;


public class CycleDetection {
    public static void main(String[] args){
        int edges[][] = {{0,1},{0,2},{1,3},{3,5},{5,4}};
        boolean[] visited = new boolean[6];
        //System.out.println("Has path : "+ validPath(6,edges,0,5));
        ArrayList<Integer> graph[] = buildAdjacencyList(edges);
        System.out.println("Cycle exists ?" + checkCycleBFS(graph, 0, visited.clone()) );
        System.out.println("Has cycle via DFS : " + checkCycleDFS(graph, 0, -1, visited.clone()));
        
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

    public static boolean checkCycleBFS(ArrayList<Integer>[] graph,int source, boolean[] visited){
        Queue<int[]> queue =new LinkedList<>();
        visited[source] = true;        
        queue.add(new int[]{source,-1});
        while(!queue.isEmpty()){
            int[] pair = queue.remove();
            int vertex = pair[0];
            int parent = pair[1];
            for(int neighbor : graph[vertex]){
                if(visited[neighbor]==false){
                    visited[neighbor] = true;
                    queue.add(new int[]{neighbor,vertex});
                }
                else if(neighbor!=parent)
                    return true;
            }
        }

        return false;
    }

    public static boolean checkCycleDFS(ArrayList<Integer>[] graph,int source, int parent,  boolean[] visited){
        visited[source] = true;
        for(int neighbor : graph[source]){
            if(visited[neighbor]==false){
                boolean hasCycle = checkCycleDFS(graph, neighbor, source, visited);
                if(hasCycle==true) return true;
            }
            else if(neighbor!=parent) {
                System.out.println(neighbor + "," + parent + "," + source);
                return true;
            }
        }
        return false;
    }
}
