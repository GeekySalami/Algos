import java.util.*;

class Edge implements Comparable<Edge> {
    int source;
    int destination;
    int weight;

    // Constructor to initialize Edge object
    public Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) {
        return Integer.compare(this.weight, other.weight);
    }
}

class DisjointSet {
    int[] parent;

    public DisjointSet(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    int find(int u) {
        if (parent[u] != u) {
            parent[u] = find(parent[u]);
        }
        return parent[u];
    }

    void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parent[rootY] = rootX;
        }
    }
}

public class KruskalMST {

    public static List<Edge> kruskalMST(List<Edge> edges, int V) {
        Collections.sort(edges); // Sort edges by weight

        DisjointSet ds = new DisjointSet(V);

        List<Edge> mst = new ArrayList<>();

        int count = 0; // To keep track of selected edges
        for (Edge edge : edges) {
            int x = ds.find(edge.source);
            int y = ds.find(edge.destination);

            if (x != y) { // Check if adding edge creates cycle
                mst.add(edge);
                ds.union(x, y);
                count++;
            }
            if (count == V - 1) { // MST is formed with V-1 edges
                break;
            }
        }

        return mst;
    }

    public static void main(String[] args) {
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 2));
        edges.add(new Edge(0, 3, 6));
        edges.add(new Edge(1, 2, 3));
        edges.add(new Edge(1, 3, 8));
        edges.add(new Edge(2, 3, 5));
        edges.add(new Edge(2, 4, 7));

        int V = 5; // Number of vertices in the graph

        List<Edge> mst = kruskalMST(edges, V);

        System.out.println("Edges in MST:");
        for (Edge edge : mst) {
            System.out.println(edge.source + " -- " + edge.destination + " == " + edge.weight);
        }
    }
}
