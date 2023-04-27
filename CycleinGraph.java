import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CycleinGraph {
    public boolean TopoSortingCycleInDirectedGraph(int numCourses, int[][] prerequisites) {
        ArrayList<Integer> adj [] = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new ArrayList<>();
        }
        int[] degree = new int[numCourses];
        for(int i = 0 ; i < prerequisites.length ; i++){
            degree[prerequisites[i][0]]++;
            adj[prerequisites[i][0]].add(prerequisites[i][1]);
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses ; i++){
            if(degree[i] == 0){
                q.add(i);
            }
        }

        int len = 0;
        while(!q.isEmpty()){
            int curr = q.poll();
            len++;
            for(int i = 0 ; i < adj[curr].size() ; i++){
                if(--degree[adj[curr].get(i)] == 0){
                    q.add(adj[curr].get(i));
                }
            }
        }

        if(len == numCourses){
            return true;
        }
        return false;
    }

    public boolean cycleInUndirectedGraph(ArrayList<Integer> adj[], int s, int V, boolean visited[])
    {

        int parent[] = new int[V];
        Arrays.fill(parent, -1);

        Queue<Integer> q = new LinkedList<>();

        visited[s] = true;
        q.add(s);

        while (!q.isEmpty())
        {
            int u = q.poll();
            for (int i = 0; i < adj[u].size(); i++)
            {
                int v = adj[u].get(i);
                if (!visited[v])
                {
                    visited[v] = true;
                    q.add(v);
                    parent[v] = u;
                }
                else if (parent[u] != v)
                    return true;
            }
        }
        return false;
    }


    public boolean cycle(ArrayList<Integer> adj[], int V)
    {
        boolean visited[] = new boolean[V];
        Arrays.fill(visited,false);
        for (int i = 0; i < V; i++)
            if (!visited[i] && cycleInUndirectedGraph(adj, i, V, visited))
                return true;
        return false;
    }
}


