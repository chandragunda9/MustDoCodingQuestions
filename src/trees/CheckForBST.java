package trees;

public class CheckForBST {
    boolean isBST(Node root) {
        int minValue = Integer.MIN_VALUE, maxValue = Integer.MAX_VALUE;
        return check(root, minValue, maxValue);
    }

    boolean check(Node root, int minValue, int maxValue) {
        if (root == null)
            return true;
        if (root.data >= maxValue || root.data <= minValue)
            return false;
        return check(root.left, minValue, root.data) &&
                check(root.right, root.data, maxValue);
    }
}
