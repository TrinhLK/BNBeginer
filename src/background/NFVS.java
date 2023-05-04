package background;
import java.util.*;

public class NFVS {

    static int n; // number of vertices
    static List<Integer>[] adjList; // adjacency list of the graph

    // function to compute the negative feedback vertex set (NFVS)
    static Set<Integer> computeNFVS() {
        Set<Integer> nfvs = new HashSet<>(); // set to store the NFVS
        boolean[] visited = new boolean[n]; // array to mark visited vertices

        // loop through all vertices to check if they are in the NFVS
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true; // mark vertex as visited
                List<Integer> neighbors = adjList[i]; // get neighbors of the vertex
                boolean hasPositiveInNeighbor = false; // flag to indicate if vertex has a positive in-neighbor

                // check if any in-neighbor is positive
                for (int neighbor : neighbors) {
                    if (!visited[neighbor]) { // check only unvisited neighbors
                        if (adjList[neighbor].contains(i)) { // check if neighbor is an in-neighbor
                            if (adjList[neighbor].size() == 1) { // check if neighbor has only this in-neighbor
                                nfvs.add(neighbor); // add neighbor to the NFVS
                                visited[neighbor] = true; // mark neighbor as visited
                            } else {
                                hasPositiveInNeighbor = true; // set flag to true
                            }
                        }
                    }
                }

                // if vertex does not have a positive in-neighbor, add it to the NFVS
                if (!hasPositiveInNeighbor) {
                    nfvs.add(i); // add vertex to the NFVS
                }
            }
        }

        return nfvs;
    }

    // main function to test the code
    public static void main(String[] args) {
        // define the Boolean Network
        n = 2; // number of vertices
        adjList = new List[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }
        adjList[0].add(1); // x1 -> x2 (+)
        adjList[1].add(0); // x2 -> x1 (-)
        adjList[1].add(1); // x2 -> x2 (+)

        // compute the NFVS of the BN
        Set<Integer> nfvs = computeNFVS();

        // print the NFVS
        System.out.println("Negative feedback vertex set: " + nfvs);
    }
}
