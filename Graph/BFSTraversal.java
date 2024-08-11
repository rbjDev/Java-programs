import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSTraversal {
    public static void main(String[] args){
        int edges[][] = {{0,1},{0,2},{1,3},{2,4}};
        boolean[] visited = new boolean[6];
        //System.out.println("Has path : "+ validPath(6,edges,0,5));
        ArrayList<Integer> graph[] = buildAdjacencyList(edges);
        BFSTraversal(graph, 0, visited);

    }

    public static ArrayList<Integer>[] buildAdjacencyList(int edges[][]){
        int n = 5;
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

    public static void BFSTraversal(ArrayList<Integer>[] graph, int source, boolean[] visited ){
        Queue<Integer> queue = new LinkedList<>();
        visited[source] = true;
        queue.add(source);
        while(!queue.isEmpty()){
            int vertex = queue.poll();
            System.out.println(vertex);
            for(int neighbor : graph[vertex]){
                if(visited[neighbor]==false){
                    visited[neighbor] = true;
                    queue.add(neighbor);
                    
                }
            }
        }
    }
}
