package trees;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidthOfBinaryTreeGFG {
    int getMaxWidth(Node root) {
        int max = 0;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int n = q.size();
            max = Math.max(max, n);
            for (int i = 0; i < n; i++) {
                Node rem = q.poll();
                if (rem.left != null)
                    q.add(rem.left);
                if (rem.right != null)
                    q.add(rem.right);
            }
        }
        return max;
    }
}
