package graphs;

import java.util.List;

public class EulerCircuitAndPath {
    static boolean isConnectedGraph(int v, List<Integer>[] adj) {
        //checking if all edges present in a single component
        boolean[] vis = new boolean[v];
        //finding first non-zero degree vertex
        int node = -1;
        for (int i = 0; i < v; i++) {
            if (adj[i].size() > 0) {
                node = i;
                break;
            }
        }
        if (node == -1)
            return true;
        dfs(node, adj, vis);
        for (int i = 0; i < v; i++) {
            if (!vis[i] && adj[i].size() > 0)
                return false;
        }
        return true;
    }

    static void dfs(int v, List<Integer>[] adj, boolean[] vis) {
        vis[v] = true;
        List<Integer> conn = adj[v];
        for (Integer ele : conn) {
            if (!vis[ele])
                dfs(ele, adj, vis);
        }
    }

    public int isEulerCircuit(int V, List<Integer>[] adj) {
        if (!isConnectedGraph(V, adj))
            return 0;
        int oddDegVertices = 0;
        for (int i = 0; i < V; i++) {
            if ((adj[i].size() & 1) != 0)
                oddDegVertices++;
        }
        if (oddDegVertices > 2)
            return 0;
        return oddDegVertices == 0 ? 2 : 1;
    }
}
