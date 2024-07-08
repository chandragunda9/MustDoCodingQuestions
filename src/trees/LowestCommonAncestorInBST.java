package trees;

public class LowestCommonAncestorInBST {
    Node LCA(Node root, int n1, int n2) {
        if (root == null)
            return null;
        if (root.data == n1 || root.data == n2)
            return root;
        if (n1 > root.data && n2 > root.data)
            return LCA(root.right, n1, n2);
        else if (n1 < root.data && n2 < root.data)
            return LCA(root.left, n1, n2);
        return root;
    }
}
