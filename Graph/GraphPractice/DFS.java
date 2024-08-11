package GraphPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

import javax.naming.ldap.InitialLdapContext;

public class DFS {
    public static void main(String[] args) {
        // int edges[][] = {{0,1},{0,2},{1,3},{3,5},{5,4},{4,3}};
        // int n = 6;
        // ArrayList<Integer> graph[] = buildGraph(edges,n);
        // displayGrah(graph,n);
        // boolean visited[] = new boolean[n];
        // System.out.println("Dfs traversal!!");
        // dfstraversal(graph,0,visited);
        // Arrays.fill(visited, false);
        // System.out.println(" \nHas Path:" + hasPath(graph,visited,0,5));
        // Arrays.fill(visited, false);
        // printAllPaths(graph, visited, 2, 5, 2 + "");
        // System.out.println("Print connected components: ");
        // int edges1[][] = {{0,1},{2,3},{5,6},{5,4},{4,6}};
        // ArrayList<Integer> graph1[] = buildGraph(edges1,7);
        // System.out.println(getConnectedComponents(graph1, 7));

        int edges[][] = {{5,2},{5,0},{2,3},{3,1},{4,0},{4,1}};
        int n = 6;
        ArrayList<Integer> graph[] = buildDirectedGraph(edges,n);
        topoSort(graph);
    }

    private static void topoSort(ArrayList<Integer>[] graph){
        Stack<Integer> stack = new Stack<>();
        boolean visited[] = new boolean[graph.length];
        
        for(int i=0;i<graph.length;i++){
            if(!visited[i])
                doDFS(graph,visited,stack,i);
        }
        List<Integer> result = new ArrayList<>();
        while(!stack.isEmpty()){
            result.add(stack.peek());
            stack.pop();
        }
        System.out.println(result);
    }

    private static void doDFS(ArrayList<Integer>[] graph, boolean[] visited, Stack<Integer> stack,int vertex) {
        visited[vertex] = true;
        for(Integer nbr : graph[vertex]){
            if(!visited[nbr]){
                doDFS(graph, visited, stack, nbr);
            }
        }
        stack.push(vertex);
    }

    private static List<List<Integer>> getConnectedComponents(ArrayList<Integer>[] graph, int n){
        List<List<Integer>> listOfComponents = new ArrayList<>();
        boolean visited[] = new boolean[n];
        for(int vertex=0;vertex<n;vertex++){
            if(visited[vertex] ==false){
                ArrayList<Integer> vertices = new ArrayList<>();
                traverseDFS(graph,vertex,visited,vertices);
                listOfComponents.add(vertices);
            }
        }        
        return listOfComponents; 
    }

    private static void traverseDFS(ArrayList<Integer>[] graph, int vertex, boolean[] visited, ArrayList<Integer> vertices) {
                visited[vertex]  = true;
                vertices.add(vertex);
                for(Integer v : graph[vertex]){
                    if(visited[v] == false){
                        traverseDFS(graph, v, visited, vertices);
                    }
                }        
    }

    private static void printAllPaths(ArrayList<Integer>[] graph, boolean[] visited, int src, int dest, String psf){
        if(src==dest){
            System.out.println(psf);
            return;
        }
        visited[src] = true;
        for(Integer vertex : graph[src]){
            if(visited[vertex] == false){
                printAllPaths(graph, visited, vertex, dest, psf+vertex);                
            }
        }
        visited[src] = false;
    }

    private static boolean hasPath(ArrayList<Integer>[] graph, boolean[] visited, int src, int dest) {
        if(src==dest)
            return true;
        
        visited[src] = true;
        for(Integer vertex : graph[src]){
            if(visited[vertex] == false){
                boolean hasPath = hasPath(graph, visited, vertex, dest);
                if(hasPath==true)
                    return true;
            }
        }
        return false;
    }

    private static void dfstraversal(ArrayList<Integer>[] graph, int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " - ");
        for(int i=0 ;i<graph[v].size() ;i++){
            int neighbor = graph[v].get(i);
            if(!visited[neighbor]){ 
                dfstraversal(graph, neighbor, visited);
            }
        }
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
}
