package trees;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestorInBinaryTree {

    Node method1(Node root, int n1, int n2) {
        List<Node> path1 = new ArrayList<>();
        List<Node> path2 = new ArrayList<>();
        if (!findPath(root, n1, path1) || !findPath(root, n2, path2))
            return null;
        int i = 0;
        for (i = 0; i < path1.size() && i < path2.size(); i++) {
            if (path1.get(i) != path2.get(i))
                break;
        }
        return path1.get(i - 1);
    }

    boolean findPath(Node root, int n, List<Node> path) {
        if (root == null)
            return false;
        path.add(root);
        if (root.data == n)
            return true;
        if (findPath(root.left, n, path) ||
                findPath(root.right, n, path))
            return true;
        path.remove(path.size() - 1);
        return false;
    }

    Node LCA(Node root, int n1, int n2) {
        if (root == null)
            return null;
        if (root.data == n1 || root.data == n2)
            return root;
        Node leftLca = LCA(root.left, n1, n2);
        Node rightLca = LCA(root.right, n1, n2);
        if (leftLca != null && rightLca != null)
            return root;
        return leftLca != null ? leftLca : rightLca;
    }
}
