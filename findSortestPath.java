import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

class pair{
    public pair(int first, int second , int third) {
        this.node = first;
        this.distance = second;
        this.color = third;
    }

    int node;
    int distance;
    int color;
}

class pairComp  implements Comparator<pair> {

    @Override
    public int compare(pair o1, pair o2) {
        return  o2.color - o1.color;
    }
}

class printcomparable implements Comparable{

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}


public class findSortestPath {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int adj[][][] = new int[2][n][n];
        int ans[] = new int[n];
        for(int i = 0 ; i < redEdges.length ; i++) {
            adj[0][redEdges[i][0]][redEdges[i][1]] = 1;
        }

        for(int i = 0 ; i < blueEdges.length ; i++){
            adj[1][blueEdges[i][0]][blueEdges[i][1]] = 1;
        }

        Queue<pair> q = new LinkedList<>();
        q.add(new pair(0,0, -1));

        int dist[] = new int[n];
        Arrays.fill(dist,-1);

        int vis[][] = new int[2][n];
        Arrays.fill(vis[0],0);
        Arrays.fill(vis[1],0);

        vis[0][0] = 1;
        vis[1][0] = 1;
        dist[0] = 0;

        while (!q.isEmpty()){
            pair curr = q.poll();
            int node = curr.node;
            int distance = curr.distance;
            int color = curr.color;
            if(color == -1) {
                for (int i = 0; i < adj[0][node].length; i++) {
                    if(vis[0][i] == 0 && adj[0][node][i] == 1 ) {
                        if(dist[i] == -1){
                            dist[i] = distance + 1;
                        }
                        q.add(new pair(i,distance+1,0));
                        vis[0][i] = 1;
                    }
                }

                for (int i = 0; i < adj[1][node].length; i++) {
                    if(vis[1][i] == 0 && adj[1][node][i] == 1) {
                        if(dist[i] == -1){
                            dist[i] = distance + 1;
                        }
                        q.add(new pair(i,distance+1,1));
                        vis[1][i] = 1;
                    }
                }
            }else{
                color = (color + 1)%2;
                for (int i = 0; i < adj[color][node].length; i++) {
                    if(vis[color][i] == 0 && adj[color][node][i] == 1) {
                        if(dist[i] == -1){
                            dist[i] = distance + 1;
                        }
                        q.add(new pair(i,distance+1,color));
                        vis[color][i] = 1;
                    }
                }
            }

        }
        return dist;
    }
}
