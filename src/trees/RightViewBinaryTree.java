package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class RightViewBinaryTree {

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
                if (rem.right != null)
                    q.add(rem.right);
                if (rem.left != null)
                    q.add(rem.left);
            }
        }
        return ans;
    }

    ArrayList<Integer> rightView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        int level = 0;
        reversePreOrder(root, level, ans);
        return ans;
    }

    static void reversePreOrder(Node root, int level, ArrayList<Integer> ans) {
        if (root == null)
            return;
        if (level == ans.size())
            ans.add(root.data);
        reversePreOrder(root.right, level + 1, ans);
        reversePreOrder(root.left, level + 1, ans);
    }
}
