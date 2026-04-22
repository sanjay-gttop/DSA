import java.util.*;

public class Prims {
    static final int INF = Integer.MAX_VALUE;

    static void prims(int[][] graph, int v) {
        int[] parent = new int[v];
        int[] key = new int[v];
        boolean[] inMST = new boolean[v];

        Arrays.fill(key, INF);
        Arrays.fill(inMST, false);

        key[0] = 0;
        parent[0] = -1;

        for (int i = 0; i < v - 1; i++) {
            int u = minMST(key, inMST, v);
            inMST[u] = true;

            for (int j = 0; j < v; j++) {
                if (graph[u][j] != 0 && !inMST[j] && graph[u][j] < key[j]) {
                    parent[j] = u;
                    key[j] = graph[u][j];
                }
            }
        }

        printSolution(parent, graph, v);
    }

    static int minMST(int[] key, boolean[] inMST, int v) {
        int min = INF;
        int minIndex = -1;

        for (int i = 0; i < v; i++) {
            if (!inMST[i] && key[i] < min) {
                min = key[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    static void printSolution(int[] parent, int[][] graph, int v) {
        int totalWeight = 0;

        System.out.println("Edge \tWeight");
        for (int i = 1; i < v; i++) {
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
            totalWeight += graph[i][parent[i]];
        }

        System.out.println("Total Weight = " + totalWeight);
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 2, 0, 6, 0},
            {2, 0, 3, 8, 5},
            {0, 3, 0, 0, 7},
            {6, 8, 0, 0, 9},
            {0, 5, 7, 9, 0}
        };

        int v = graph.length;
        prims(graph, v);
    }
}