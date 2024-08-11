import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.management.QueryEval;

public class TopologicalSort {
    public static void main(String[] args){
        int edges[][] = {{1,0},{0,1}};//{{0,1},{1,2},{2,0}};//{{5,0},{5,2},{4,0},{4,1},{2,3},{3,1}};//{{2,3},{3,1},{4,0},{4,1},{5,0},{5,2}};
       
        ArrayList<Integer> DAG[] = buildAdjacencyListForDAG(edges);
        System.out.println(kahnsAlgoTopoSort(DAG));
        
    }

    public static ArrayList<Integer>[] buildAdjacencyListForDAG(int edges[][]){
        int n = 2;
        ArrayList<Integer> graph[] = new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i] = new ArrayList<Integer>();
        }
        //Create adjacency List from edges
        for(int[] edge: edges){
            int from = edge[0];
            int to = edge[1];
            graph[from].add(to);            
        }
        return graph;
    }

    public static List<Integer> kahnsAlgoTopoSort(ArrayList<Integer> graph[]){
        int[] inDegrees = new int[graph.length];
        List<Integer> result = new ArrayList<>();

        for(List<Integer> list :graph){
            for(int v : list){
                inDegrees[v]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<inDegrees.length ; i++){
            if(inDegrees[i]==0)
                queue.add(i);
        }

        while(!queue.isEmpty()){
            int vertex = queue.poll();
            result.add(vertex);
            for(int neighbor : graph[vertex]){
                inDegrees[neighbor]--;
                if(inDegrees[neighbor]==0)
                    queue.add(neighbor);
            }
        }

        if(result.size()!=graph.length) throw new IllegalArgumentException("Graph contains a cycle!");
        return result; 
    }

}
