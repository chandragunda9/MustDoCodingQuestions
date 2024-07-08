package trees;

public class BalancedBinaryTree {
    boolean isBalanced(Node root) {
        return height(root) != -1;
    }

    int height(Node root) {
        if (root == null)
            return 0;
        int lh = height(root.left);
        if (lh == -1)
            return -1;
        int rh = height(root.right);
        if (rh == -1)
            return -1;
        if (Math.abs(lh - rh) > 1)
            return -1;
        return 1 + Math.max(lh, rh);
    }
}
