package trees;

public class MirrorTree {
    public static boolean isSymmetric(Node root) {
        return root == null || isMirror(root.left, root.right);
    }

    static boolean isMirror(Node left, Node right) {
        if (left == null || right == null)
            return left == right;
        if (left.data != right.data)
            return false;
        return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }
}
