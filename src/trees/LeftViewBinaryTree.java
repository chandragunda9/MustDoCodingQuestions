package trees;

import java.util.*;

public class LeftViewBinaryTree {

    ArrayList<Integer> method1(Node root) {
        if (root == null)
            return new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int si = q.size();
            for (int i = 1; i <= si; i++) {
                Node rem = q.poll();
                if (i == 1) {
                    ans.add(rem.data);
                }
                if (rem.left != null)
                    q.add(rem.left);
                if (rem.right != null)
                    q.add(rem.right);
            }
        }
        return ans;
    }

    ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        int level = 0;
        preOrder(root, level, ans);
        return ans;
    }

    static void preOrder(Node root, int level, ArrayList<Integer> ans) {
        if (root == null)
            return;
        if (level == ans.size())
            ans.add(root.data);
        preOrder(root.left, level + 1, ans);
        preOrder(root.right, level + 1, ans);
    }
}
