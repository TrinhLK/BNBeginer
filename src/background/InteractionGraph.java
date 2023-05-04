package background;

import java.util.*;

public class InteractionGraph {

    public static void main(String[] args) {
        // Define the Boolean network as an array of Boolean functions
        boolean[][] functions = {{true, true}, {false, true}, {false, false}};

        // Compute the signed graph
        List<String> vertices = new ArrayList<>();
        vertices.add("A");
        vertices.add("B");
        vertices.add("C");

        List<String> edges = new ArrayList<>();
        edges.add("B->A");
        edges.add("C->A");
        edges.add("A->B");
        edges.add("C->B");
        edges.add("A->C");

        List<String> signs = new ArrayList<>();
        for (int i = 0; i < functions.length; i++) {
            for (int j = 0; j < functions[i].length; j++) {
                boolean value = functions[i][j];
                if (value) {
                    signs.add("+");
                } else {
                    signs.add("-");
                }
            }
        }

        // Print the signed graph
        System.out.println("Vertices: " + vertices);
        System.out.println("Edges: " + edges);
        System.out.println("Signs: " + signs);
    }
}
