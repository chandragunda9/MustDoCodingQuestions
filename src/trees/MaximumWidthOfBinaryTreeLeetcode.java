package trees;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

class TreeNodeIndex {
    TreeNode node;
    int index;

    public TreeNodeIndex(TreeNode node, int index) {
        this.node = node;
        this.index = index;
    }
}

public class MaximumWidthOfBinaryTreeLeetcode {
    public int widthOfBinaryTree(TreeNode root) {
        int max = 0;
        Queue<TreeNodeIndex> q = new LinkedList<>();
        q.add(new TreeNodeIndex(root, 0));
        while (!q.isEmpty()) {
            int minIndInPreLevel = q.peek().index;
            int n = q.size();
            int firstIndex = 0, lastIndex = 0;
            for (int i = 1; i <= n; i++) {
                TreeNodeIndex rem = q.poll();
                if (i == 1)
                    firstIndex = rem.index;
                if (i == n)
                    lastIndex = rem.index;
                int currInd = rem.index - minIndInPreLevel;
                if (rem.node.left != null) {
                    q.add(new TreeNodeIndex(rem.node.left, 2 * currInd + 1));
                }
                if (rem.node.right != null) {
                    q.add(new TreeNodeIndex(rem.node.right, 2 * currInd + 2));
                }
            }
            max = Math.max(max, lastIndex - firstIndex + 1);
        }
        return max;
    }
}
