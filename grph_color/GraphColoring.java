import java.util.*;

public class GraphColoring {
    private int V; // Number of vertices in the graph
    private int[] colors; // Array to store colors assigned to vertices
    private List<Integer>[] graph; // Adjacency list representation of the graph

    public GraphColoring(int V) {
        this.V = V;
        colors = new int[V];
        graph = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }
    }

    // Function to add an edge between vertices u and v
    public void addEdge(int u, int v) {
        graph[u].add(v);
        graph[v].add(u);
    }

    // Function to check if it is safe to color vertex v with color c
    private boolean isSafe(int v, int c) {
        for (int neighbor : graph[v]) {
            if (colors[neighbor] == c) {
                return false;
            }
        }
        return true;
    }

    // Function to recursively assign colors to vertices using backtracking
    private boolean graphColoringUtil(int v, int numColors) {
        // Base case: If all vertices are colored
        if (v == V) {
            return true;
        }

        // Try assigning colors one by one
        for (int c = 1; c <= numColors; c++) {
            // Check if it is safe to assign color c to vertex v
            if (isSafe(v, c)) {
                colors[v] = c; // Assign color c to vertex v

                // Recur for the next vertex
                if (graphColoringUtil(v + 1, numColors)) {
                    return true;
                }

                // If assigning color c doesn't lead to a solution, backtrack
                colors[v] = 0;
            }
        }

        // If no color can be assigned to vertex v, return false
        return false;
    }

    // Function to perform graph coloring using backtracking
    public boolean graphColoring(int numColors) {
        if (graphColoringUtil(0, numColors)) {
            System.out.println("Graph can be colored with " + numColors + " colors.");
            System.out.println("Coloring of vertices:");
            for (int i = 0; i < V; i++) {
                System.out.println("Vertex " + i + ": Color " + colors[i]);
            }
            return true;
        } else {
            System.out.println("Graph cannot be colored with " + numColors + " colors.");
            return false;
        }
    }

    public static void main(String[] args) {
        int numVertices = 5;
        GraphColoring graph = new GraphColoring(numVertices);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        int numColors = 3;
        graph.graphColoring(numColors);
    }
}
