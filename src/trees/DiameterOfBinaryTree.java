package trees;

public class DiameterOfBinaryTree {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        System.out.println(diameter(root));
    }

    int diameterN(Node root) {
        if (root == null)
            return 0;
        int ld = diameterN(root.left);
        int rd = diameterN(root.right);
        int lh = heightN(root.left);
        int rh = heightN(root.right);
        return Math.max(1 + lh + rh, Math.max(ld, rd));
    }

    int heightN(Node node) {
        if (node == null)
            return 0;
        return 1 + Math.max(heightN(node.left), heightN(node.right));
    }

    static int diameter(Node root) {
        int[] ans = new int[1];
        height(root, ans);
        return ans[0];
    }

    static int height(Node node, int[] ans) {
        if (node == null)
            return 0;
        int lh = height(node.left, ans);
        int rh = height(node.right, ans);
        ans[0] = Math.max(ans[0], 1 + lh + rh);
        return 1 + Math.max(lh, rh);
    }
}
