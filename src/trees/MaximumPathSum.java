package trees;

import java.util.Arrays;

public class MaximumPathSum {
    public static void main(String[] args) {
//        Node root = new Node(1);
//        root.left = new Node(8);
//        root.right = new Node(6);
//        root.left.left = new Node(-7);
//        root.left.right = new Node(-10);
//        root.right.left = new Node(-9);

//        Node root = new Node(-9);
//        root.left = new Node(6);
//        root.right = new Node(-10);

        Node root = new Node(5);
        root.right = new Node(6);
        root.right.left = new Node(-5);
        root.right.right = new Node(5);
        System.out.println(maxPathSum(root));
    }

    static int maxPathSum(Node root) {
        int[] ans = new int[1];
        Arrays.fill(ans, Integer.MIN_VALUE);
        maxPath(root, root, ans);
        return ans[0];
    }

    static int maxPath(Node node, Node head, int[] ans) {
//        if (node == null) return 0;
//        int leftMaxSum = maxPath(node.left, head, ans);
//        int rightMaxSum = maxPath(node.right, head, ans);
//        if (node.left != null && node.right != null)
//            ans[0] = Math.max(ans[0], node.data + leftMaxSum + rightMaxSum);
//        return node.data + Math.max(leftMaxSum, rightMaxSum);

        if (node == null) return 0;
        if (node.left == null && node.right == null)
            return node.data;
        int leftMaxSum = maxPath(node.left, head, ans);
        if (node.left != null && node.right == null) {
            if (node == head)
                ans[0] = Math.max(ans[0], node.data + leftMaxSum);
            return node.data + leftMaxSum;
        }

        int rightMaxSum = maxPath(node.right, head, ans);
        if (node.right != null && node.left == null) {
            if (node == head)
                ans[0] = Math.max(ans[0], node.data + rightMaxSum);
            return node.data + rightMaxSum;
        }
        ans[0] = Math.max(ans[0], node.data + leftMaxSum + rightMaxSum);
        return node.data + Math.max(leftMaxSum, rightMaxSum);
    }
}
