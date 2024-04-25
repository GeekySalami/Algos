public class AllPairsShortestPath {
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[][] graph = {
                {0, 5, INF, 10},
                {INF, 0, 3, 9},
                {2, INF, 0, 1},
                {INF, INF, INF, 0}
        };

        int[][] shortestDistances = floydWarshall(graph);

        System.out.println("Shortest distances between every pair of vertices:");
        for (int i = 0; i < shortestDistances.length; i++) {
            for (int j = 0; j < shortestDistances[i].length; j++) {
                if (shortestDistances[i][j] == INF)
                    System.out.print("INF\t");
                else
                    System.out.print(shortestDistances[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static int[][] floydWarshall(int[][] graph) {
        int V = graph.length;
        int[][] dist = new int[V][V];

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF &&
                            dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        return dist;
    }
}
