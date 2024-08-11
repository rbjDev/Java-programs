package GraphPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import javafx.beans.binding.IntegerExpression;
import javafx.util.Pair;

public class BFSProblems {
    public static void main(String[] args) {
        // int edges[][] = {{0,1},{0,2},{1,2},{1,3},{2,4},{3,4},{1,5}};
         int n = 6;
        // ArrayList<Integer> graph[] = buildGraph(edges,n);
        // displayGrah(graph,n);
        // boolean visited[] = new boolean[n];
        // System.out.println("BFS Traversal!!");
        // BFSTraversal(graph, 0, visited);
        // int edges1[][] = {{0,1},{0,2},{2,3},{2,5},{3,4}};        
        // n = 6;
        // ArrayList<Integer> graph1[] = buildGraph(edges1,n);
        // System.out.println("\nHas cycle:" + hasCycle(graph1));


        // int edges2[][] = {{0,1},{1,2},{1,4},{2,3},{4,5},{3,5},{3,6},{6,7}};
        // n = 8;
        // ArrayList<Integer> graph2[] = buildGraph(edges2,n);
        // System.out.println("\nIs Bipartite:" + isBipartite(graph2));

        // int edges3[][] = {{0,1},{1,2},{2,3},{3,5},{1,4},{4,3}};
        // n = 6;
        // ArrayList<Integer> graph3[] = buildGraph(edges3,n);
        // System.out.println("\nIs Bipartite:" + isBipartite(graph3));

        int edges[][] = {{5,2},{5,0},{2,3},{3,1},{4,0},{4,1}};
        n = 6;
        ArrayList<Integer> graph[] = buildDirectedGraph(edges,n);
        System.out.println("Topological ordering:" + getTopoList(graph,n));
        
    }

    static class Edge{
        int vertex;
        int weight;
        public Edge(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
        
    }

    private static void djikstraAlgo(ArrayList<Integer> graph[],int n){
        int distance[] = new int[n];
        Queue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(edge ->edge.weight));
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;
        queue.add(new Edge(0, 0));
        while(!queue.isEmpty()){
            Edge edge = queue.poll();
            for(int nbr : graph[edge.vertex]){
                if( < distance[nbr])
            }
        }

    }

    private static List<Integer> getTopoList(ArrayList<Integer> graph[],int n){
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int inDegrees[] = new int[n];
        for(ArrayList<Integer> list : graph ){
            for(int v : list){
                inDegrees[v]++;
            }
        }
        System.out.println("Indegrees array: " + Arrays.toString(inDegrees));
        for(int i=0; i<inDegrees.length ; i++){
            if(inDegrees[i]==0)
                queue.add(i);
        }
        while(!queue.isEmpty()){
            int v = queue.poll();
            System.out.println("v="+v);
            result.add(v);
            for(int nbr : graph[v]){
                inDegrees[nbr]--;
                if(inDegrees[nbr]==0) 
                    queue.add(nbr);
            }
        }

        return result;
    }

    private static ArrayList<Integer>[] buildDirectedGraph(int[][] edges, int n) {
        ArrayList<Integer> graph[] = new ArrayList[n];
        for(int i=0;i<n;i++)
            graph[i] = new ArrayList<>();
        for(int arr[] : edges){
            int from = arr[0];
            int to = arr[1];
            graph[from].add(to);
        }
        return graph;

    }

    private static boolean isBipartite(ArrayList<Integer> graph[]){
        Queue<Integer> queue = new LinkedList<>();
        int[] color = new int[graph.length];
        Arrays.fill(color,-1);
        queue.add(0);
        color[0] = 0;
        while(!queue.isEmpty()){
            int v = queue.poll();
            for(int nbr: graph[v]){
                if(color[nbr] == -1){
                    color[nbr] = (color[v] + 1)%2;
                    queue.add(nbr);
                }
                else if(color[nbr]== color[v])
                    return false;
            }
        }

        return true;
    }

    private static void BFSTraversal(ArrayList<Integer> graph[],int src,boolean visited[] ){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        visited[src] = true;
        while(!queue.isEmpty()){
            int front = queue.poll();
            System.out.print(front + "-");
            for(Integer nbr : graph[front]){
                if(visited[nbr] == false){
                    visited[nbr] = true;
                    queue.add(nbr);
                }
            }
        }
    }

    private static boolean hasCycle(ArrayList<Integer> graph[]){
        Queue<Pair<Integer,Integer>> queue = new LinkedList<>();
        boolean visited[] = new boolean[graph.length];
        queue.add(new Pair<Integer,Integer>(0, -1));
        visited[0] =  true;
        while(!queue.isEmpty()){
            int vertex = queue.peek().getKey();
            int parent = queue.peek().getValue();
            queue.poll();
            for(Integer nbr : graph[vertex]){
                if(visited[nbr] == false){
                    visited[nbr] = true;
                    queue.add(new Pair<Integer,Integer>(nbr, vertex));                    
                }
                else if(parent!=nbr){
                    return true;
                }
            }


        }
        return false;
    }

    private static void displayGrah(ArrayList<Integer>[] graph, int n) {
        int i=0;
       for(ArrayList<Integer> list : graph){
        System.out.println(i + ":" + list);
        i++;
       }
    }

    private static ArrayList<Integer>[] buildGraph(int[][] edges, int n) {
        ArrayList<Integer> graph[] = new ArrayList[n];
        for(int i=0;i<n;i++)
            graph[i] = new ArrayList<>();
        for(int arr[] : edges){
            int from = arr[0];
            int to = arr[1];
            graph[from].add(to);
            graph[to].add(from);
        }
        return graph;

    }
}
