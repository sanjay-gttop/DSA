 import java.util.*;
 public class Diji{
    static final int INF = Integer.MAX_VALUE;
    static void dijis(int[][] graph,int src,int v){
        int[] dis = new int[v];
        boolean[] visited = new boolean[v];

        Arrays.fill(dis,INF);
        dis[src] = 0;
        for(int i=0;i<v-1;i++){
            int u = mindis(dis,visited,v);
            visited[u] = true;
            for(int j=0;j<v;j++){
                if(!visited[j] && dis[u]+graph[u][j] < dis[j] && graph[u][j] !=0 && dis[u] != INF){
                    dis[j] = dis[u] + graph[u][j];
                }
            }
        }
        printSolution(dis,src,v);
    }
    static int mindis(int[] dis,boolean [] visited,int v){
        int min=INF;
        int minIndex = -1;
        for(int i=0;i<v;i++){
            if(!visited[i] && dis[i]<min){
                min = dis[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
    static void printSolution(int[] dis,int src,int v){
        System.out.println("shortest distance from  the source "+ src);
        for(int i=0;i<v;i++){
            if(dis[i] == INF){
                System.out.println("INF");
            }else if(dis[i] != INF){
                System.out.println(dis[i]);
            }
        }
    }
    public static void main(String[] args){
        int v=5;
        int[][] graph = {{0, 4, 0, 0, 0, 8},
            {4, 0, 8, 0, 0, 11},
            {0, 8, 0, 7, 0, 0},
            {0, 0, 7, 0, 9, 14},
            {0, 0, 0, 9, 0, 10},
            {8, 11, 0, 14, 10, 0}
        };
        dijis(graph,0,v);        
    }
 }
