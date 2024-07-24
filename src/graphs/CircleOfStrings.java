package graphs;

import java.util.ArrayList;
import java.util.List;

public class CircleOfStrings {

    public static void main(String[] args) {
//        int n = 4;
//        String[] arr = {"ab", "bc", "cd", "da"};
        int n = 4;
        String[] arr = {"aa", "aa", "aa", "aa"};
        System.out.println(isCircle(n, arr));
    }

    static List<List<Integer>> buildAdjList(int n, String[] words, int[] inDeg) {
        int v = 26;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            String word = words[i];
            int fi = word.charAt(0) - 'a', li = word.charAt(word.length() - 1) - 'a';
            adj.get(fi).add(li);
            inDeg[li] += 1;
        }
        return adj;
    }

    static boolean isStronglyConnected(List<List<Integer>> adj) {
        int v = 26;
        boolean[] vis = new boolean[v];
        //finding the first non-zero degree vertex
        int node = -1;
        for (int i = 0; i < v; i++) {
            if (adj.get(i).size() > 0) {
                node = i;
                break;
            }
        }
        if (node == -1)
            return false;
        dfs(node, vis, adj);
        for (int i = 0; i < v; i++) {
            if (adj.get(i).size() > 0 && !vis[i])
                return false;
        }
        return true;
    }

    static void dfs(int v, boolean[] vis, List<List<Integer>> adj) {
        vis[v] = true;
        List<Integer> conn = adj.get(v);
        for (int ele : conn) {
            if (!vis[ele]) {
                dfs(ele, vis, adj);
            }
        }
    }

    static int isCircle(int N, String A[]) {
        int v = 26;
        int[] inDeg = new int[v];
        List<List<Integer>> adj = buildAdjList(N, A, inDeg);
        if (!isStronglyConnected(adj))
            return 0;
        for (int i = 0; i < v; i++) {
            if (inDeg[i] != adj.get(i).size())
                return 0;
        }
        return 1;
    }
}
