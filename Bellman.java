import java.util.*;

public class Bellman {
    static final int INF = Integer.MAX_VALUE;

    static class Edge {
        int src;
        int dest;
        int weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    void bellmanFord(List<Edge> edges, int src, int v) {
        int[] dist = new int[v];
        int[] parent = new int[v];

        Arrays.fill(dist, INF);
        Arrays.fill(parent, -1);
        dist[src] = 0;

        // Relax all edges V-1 times
        for (int i = 0; i < v - 1; i++) {
            for (Edge edge : edges) {
                if (dist[edge.src] != INF && dist[edge.src] + edge.weight < dist[edge.dest]) {
                    dist[edge.dest] = dist[edge.src] + edge.weight;
                    parent[edge.dest] = edge.src;
                }
            }
        }

        // Check for negative weight cycle
        for (Edge edge : edges) {
            if (dist[edge.src] != INF && dist[edge.src] + edge.weight < dist[edge.dest]) {
                System.out.println("Graph contains a negative weight cycle");
                return;
            }
        }

        printSolution(dist, parent, src, v);
    }

    void printSolution(int[] dist, int[] parent, int src, int v) {
        System.out.println("Vertex\tDistance\tPath");

        for (int i = 0; i < v; i++) {
            String distance = (dist[i] == INF) ? "INF" : String.valueOf(dist[i]);
            String path = (dist[i] == INF) ? "No Path" : getPath(parent, src, i);

            System.out.println(i + "\t" + distance + "\t\t" + path);
        }
    }

    static String getPath(int[] parent, int src, int target) {
        if (target == src) {
            return String.valueOf(src);
        }

        if (parent[target] == -1) {
            return "No Path";
        }

        Deque<Integer> stack = new ArrayDeque<>();
        int curr = target;

        while (curr != -1) {
            stack.push(curr);
            curr = parent[curr];
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
            if (!stack.isEmpty()) {
                sb.append("->");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Bellman graph = new Bellman();
        List<Edge> edges = new ArrayList<>();

        edges.add(new Edge(0, 1, 6));
        edges.add(new Edge(0, 2, 7));
        edges.add(new Edge(1, 2, 8));
        edges.add(new Edge(1, 3, 5));
        edges.add(new Edge(1, 4, -4));
        edges.add(new Edge(2, 3, -3));
        edges.add(new Edge(2, 4, 9));
        edges.add(new Edge(3, 1, -2));
        edges.add(new Edge(4, 0, 2));
        edges.add(new Edge(4, 3, 7));

        int vertices = 5;
        int source = 0;

        graph.bellmanFord(edges, source, vertices);
    }
}