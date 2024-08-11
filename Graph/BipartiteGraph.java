import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph {
    public static void main(String[] args){
        int edges[][] = {{0,1},{1,2},{1,4},{2,3},{3,4}};
        int[] color = new int[9];
        Arrays.fill(color, -1);
        //System.out.println("Has path : "+ validPath(6,edges,0,5));
        ArrayList<Integer> graph[] = buildAdjacencyList(edges);
        System.out.println(isBipartiteViaBFS(graph, 0, color));


    }

    public static boolean isBipartiteViaBFS(ArrayList<Integer> graph[], int source,int color[]){
        Queue<Integer> queue = new LinkedList<>();
        color[source] = 0;
        queue.add(source);
        while(!queue.isEmpty()){
            int vertex = queue.remove();
            for(int neighbor : graph[vertex]){
                if(color[neighbor]==-1){
                    queue.add(neighbor);
                    color[neighbor] = color[vertex]^1;
                }
                else if(color[neighbor]==color[vertex])
                    return false;
            }
        }
        return true;

    }

    public static ArrayList<Integer>[] buildAdjacencyList(int edges[][]){
        int n = 9;
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
}
