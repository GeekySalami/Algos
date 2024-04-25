import java.util.*;

class Edge {
    int src, dest, weight;

    Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}

class Graph {
    int V;
    List<Edge> edges;

    Graph(int V) {
        this.V = V;
        edges = new ArrayList<>();
    }

    void addEdge(int src, int dest, int weight) {
        Edge edge = new Edge(src, dest, weight);
        edges.add(edge);
    }

    void primMST() {
        boolean[] inMST = new boolean[V];
        int[] key = new int[V];
        int[] parent = new int[V];

        for (int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
            inMST[i] = false;
        }

        key[0] = 0;
        parent[0] = -1;

        for (int count = 0; count < V - 1; count++) {
            
            int u = -1;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < V; i++) {
                if (!inMST[i] && key[i] < min) {
                    min = key[i];
                    u = i;
                }
            }

            inMST[u] = true;
            
            for (Edge edge : edges) {
                if (edge.src == u || edge.dest == u) {
                    int v = (edge.src == u) ? edge.dest : edge.src;
                    if (!inMST[v] && edge.weight < key[v]) {
                        parent[v] = u;
                        key[v] = edge.weight;
                    }
                }
            }
        }

        printMST(parent);
    }

    void printMST(int[] parent) {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < V; i++) {
            System.out.println(parent[i] + " - " + i + "\t" + i);
        }
    }
}

public class PrimMST {
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 3, 1);
        graph.addEdge(1, 2, 3);
        graph.addEdge(1, 3, 1);
        graph.addEdge(2, 3, 5);
        graph.addEdge(2, 4, 2);

        graph.primMST();
    }
}