package trees;

import java.util.*;

public class VerticalTraversalBinaryTree {
    static ArrayList<Integer> verticalOrder(Node root) {
        Map<Integer, ArrayList<Integer>> map = new TreeMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<NodeHd> q = new LinkedList<>();
        q.add(new NodeHd(root, 0));
        while (!q.isEmpty()) {
            NodeHd rem = q.poll();
            Node n = rem.node;
            int hd = rem.hd;

            ArrayList<Integer> al = map.getOrDefault(hd, new ArrayList<>());
            al.add(rem.node.data);
            map.put(hd, al);

            if (n.left != null) {
                q.add(new NodeHd(n.left, hd - 1));
            }
            if (n.right != null) {
                q.add(new NodeHd(n.right, hd + 1));
            }
        }

        for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
            ans.addAll(entry.getValue());
        }
        return ans;
    }
}
