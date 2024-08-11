import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceUndirectedGraphBFS {
    public static void main(String[] args){
        int edges[][] = {{0,1},{1,2},{1,5},{2,3},{3,4},{4,5}};
        boolean[] visited = new boolean[6];
        //System.out.println("Has path : "+ validPath(6,edges,0,5));
        ArrayList<Integer> graph[] = buildAdjacencyList(edges);
        findShortestDistancesUsingBFS(graph, 0);

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

    public static void findShortestDistancesUsingBFS(ArrayList<Integer>[] graph, int source ){
        Queue<Integer> queue = new LinkedList<>();
        int distance[] = new int[graph.length];
        Arrays.fill(distance, (int)1e9);
        distance[source] = 0;
        queue.add(source);
        while(!queue.isEmpty()){
            int vertex = queue.poll();
            //System.out.println(vertex);
            for(int neighbor : graph[vertex]){
                if(distance[vertex] + 1 < distance[neighbor]){
                    distance[neighbor] = distance[vertex] + 1;
                    queue.add(neighbor);                    
                }
            }
        }
        for(int i=0; i<distance.length; i++){
            if(i== 1e9){
                distance[i] = -1;
            }
        }
        System.out.println(Arrays.toString(distance));
    }
}
