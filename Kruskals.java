import java.util.*;

public class Kruskals {

    static class Edge implements Comparable<Edge> {
        int src, dest, weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return this.weight - other.weight;
        }

        @Override
        public String toString() {
            return src + " - " + dest + " : " + weight;
        }
    }

    static class Union {
        int[] parent, rank;

        Union(int n) {
            parent = new int[n];
            rank = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        boolean union(int x, int y) {
            int px = find(x);
            int py = find(y);

            if (px == py) {
                return false;
            }

            if (rank[px] < rank[py]) {
                parent[px] = py;
            } else if (rank[py] < rank[px]) {
                parent[py] = px;
            } else {
                parent[py] = px;
                rank[px]++;
            }

            return true;
        }
    }

    static List<Edge> kruskals(int v, List<Edge> edges) {
        Collections.sort(edges);
        Union u = new Union(v);
        List<Edge> mst = new ArrayList<>();

        for (Edge edge : edges) {
            if (u.union(edge.src, edge.dest)) {
                mst.add(edge);
            }

            if (mst.size() == v - 1) {
                break;
            }
        }

        return mst;
    }

    public static void main(String[] args) {
        int v = 4;
        List<Edge> edges = new ArrayList<>();

        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 6));
        edges.add(new Edge(0, 3, 5));
        edges.add(new Edge(1, 3, 15));
        edges.add(new Edge(2, 3, 4));

        List<Edge> mst = kruskals(v, edges);

        int totalWeight = 0;
        System.out.println("Edges in MST:");
        for (Edge e : mst) {
            System.out.println(e);
            totalWeight += e.weight;
        }

        System.out.println("Total weight of MST: " + totalWeight);
    }
}