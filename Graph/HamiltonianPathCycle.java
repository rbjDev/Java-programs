import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class HamiltonianPathCycle {
    public static void main(String[] args){
        int edges[][] = {{0,1},{0,3},{1,2},{2,3},{2,5},{3,4},{4,5},{4,6},{5,6}};
       //boolean[] visited = new boolean[6];
        //System.out.println("Has path : "+ validPath(6,edges,0,5));
        ArrayList<Integer> graph[] = buildAdjacencyList(edges);
        //dfs(graph, 0, visited);
        Set<Integer> visited = new HashSet<>();
        int source = 0 ;
        int ossrc = 0;
        String psf = "";
        printHamiltonianPathsCycles(graph,source,visited,source+psf,ossrc);

    }

    public static void printHamiltonianPathsCycles(ArrayList<Integer> graph[], int source, Set<Integer> visited, String psf, int osrc){
        if(psf.length()==graph.length){
            boolean pathExistsToSource = false;
            for(int nbr : graph[source]){
                if(nbr==osrc){
                    pathExistsToSource = true;
                    break;
                }
            }
            if(pathExistsToSource)
                System.out.println("Hamiltonian cycle: " +psf);
            else
                System.out.println("Hamiltonian path: " +psf);
            return;
        }
        visited.add(source);
        for(int neighbor: graph[source]){
            if(!visited.contains(neighbor)){
                printHamiltonianPathsCycles(graph, neighbor, visited, psf + neighbor, osrc);
            }
        }
        visited.remove(source);
    }

    public static ArrayList<Integer>[] buildAdjacencyList(int edges[][]){
        int n = 7;
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
