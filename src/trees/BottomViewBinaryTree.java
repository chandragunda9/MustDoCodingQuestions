package trees;

import java.util.*;

class NodeHd {
    Node node;
    int hd;

    public NodeHd(Node node, int hd) {
        this.node = node;
        this.hd = hd;
    }
}


public class BottomViewBinaryTree {
    public ArrayList<Integer> bottomView(Node root) {
        Map<Integer, Integer> map = new TreeMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        root.hd = 0;
        q.add(root);
        while (!q.isEmpty()) {
            Node rem = q.poll();
            int hd = rem.hd;
            map.put(hd, rem.data);
            if (rem.left != null) {
                rem.left.hd = hd - 1;
                q.add(rem.left);
            }
            if (rem.right != null) {
                rem.right.hd = hd + 1;
                q.add(rem.right);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ans.add(entry.getValue());
        }
        return ans;
    }
}
