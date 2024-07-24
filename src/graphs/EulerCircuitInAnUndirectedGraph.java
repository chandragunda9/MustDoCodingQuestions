package graphs;

import java.util.ArrayList;

public class EulerCircuitInAnUndirectedGraph {

    static void dfs(int v, boolean[] vis, ArrayList<ArrayList<Integer>> adj) {
        vis[v] = true;
        ArrayList<Integer> conn = adj.get(v);
        for (int ele : conn) {
            if (!vis[ele]) {
                dfs(ele, vis, adj);
            }
        }
    }

    static boolean isConnectedGraph(int v, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[v];
        int node = -1;
        //finding first non-zero degree node
        for (int i = 0; i < v; i++) {
            if (adj.get(i).size() > 0) {
                node = i;
                break;
            }
        }
        if (node == -1)
            return true;
        dfs(node, vis, adj);
        for (int i = 0; i < v; i++) {
            if (!vis[i] && adj.get(i).size() > 0)
                return false;
        }
        return true;
    }

    public boolean isEularCircuitExist(int v, ArrayList<ArrayList<Integer>> adj) {
        if (!isConnectedGraph(v, adj))
            return false;
        int noOfOddVertices = 0;
        for (int i = 0; i < v; i++) {
            if ((adj.get(i).size() & 1) != 0)
                noOfOddVertices++;
        }
        return noOfOddVertices == 0;
    }
}
