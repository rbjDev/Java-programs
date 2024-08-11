package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class DFSTraversalMultiSolver {
    static class Graph{
        int vertices;
        Map<Integer,List<Integer>> adjacencyList;

        public Graph(int vertices){
           this.vertices = vertices;
            adjacencyList = new HashMap<>();
            for(int i=0;i<vertices;i++){
                adjacencyList.put(i,new ArrayList<Integer>());
            } 
        }

        public Graph(int vertices, int edges[][]){
            this(vertices);
            for(int[] edge : edges){
                int src = edge[0];
                int dest = edge[1];
                adjacencyList.get(src).add(dest);
                adjacencyList.get(dest).add(src);
            }

        }

        public void addEdge(int source, int destination){
            adjacencyList.get(source).add(destination);
            adjacencyList.get(destination).add(source);
        }

        public void dfsRecursive(int source, boolean[] visited){
            visited[source] = true;
            System.out.print(source + "->");
            for(Integer neighbor : adjacencyList.get(source)){
                if(visited[neighbor]==false){
                    dfsRecursive(neighbor, visited);
                }
            }
        }

        public void dfsIterative(int source){
            boolean[] visited = new boolean[vertices];
            Stack<Integer> stack = new Stack<>();

            stack.push(source);

            while (!stack.isEmpty()) {
                int currentNode = stack.pop();

                if (!visited[currentNode]) {
                    System.out.print(currentNode + " ");
                    visited[currentNode] = true;
                }

                for (int neighbor : adjacencyList.get(currentNode)) {
                    if (!visited[neighbor]) {
                        stack.push(neighbor);
                    }
                }
            }
        }

        public boolean hasPath(int source, int destination, boolean[] visited){
            if(source==destination){
                return true;
            }
            visited[source] = true;
            for(Integer neighbor: adjacencyList.get(source)){
                if(visited[neighbor]==false){
                    boolean pathExists = hasPath(neighbor, destination, visited);
                    if(pathExists==true)
                        return true;
                }                
            }
            return false;
        }

        public void printAllPaths(int source,int destination,boolean[] visited, String psf){
            if(source==destination){
                System.out.println(psf);
                return;
            }
            visited[source]=true;
            for(int neighbor: adjacencyList.get(source)){
                if(visited[neighbor]==false){
                    printAllPaths(neighbor, destination, visited, psf + neighbor);
                }
            }
            visited[source] = false;
        }

        public List<String> getAllPaths(int source,int destination,boolean[] visited, String psf){
            ArrayList<String> list = new ArrayList<>();
            if(source==destination){                
                list.add(psf);
                return list;
            }
            visited[source]=true;
            for(int neighbor: adjacencyList.get(source)){
                if(visited[neighbor]==false){
                     
                    list.addAll(getAllPaths(neighbor, destination, visited, psf+neighbor ));
                }
            }
            visited[source] = false;
            return list;
        }
    }
        public static void main(String[] args) {
        int edges[][] = {{1,0},{0,2},{2,1},{0,3},{1,4}};
        boolean[] visited = new boolean[6];
        Graph graph1 = new Graph(6, edges);
        graph1.dfsIterative(0);
        visited = new boolean[6];
        System.out.println("Has Path?" + graph1.hasPath(2,4,visited));
        visited = new boolean[6];
        graph1.printAllPaths(3, 4, visited, "3");
        visited = new boolean[6];
        System.out.println(graph1.getAllPaths(3,4, visited, "3"));
    }
}

