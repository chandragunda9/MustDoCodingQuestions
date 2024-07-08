package trees;

import java.util.*;

public class SpiralTraversal {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(60);
        System.out.println(findSpiral(root));
    }

    static ArrayList<Integer> findSpiral(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        boolean rightToLeft = true;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int qs = q.size();
            Integer[] li = new Integer[qs];
            for (int i = 0; i < qs; i++) {
                Node rem = q.poll();
                int ind = rightToLeft ? qs - i - 1 : i;
                li[ind] = rem.data;
                if (rem.left != null)
                    q.add(rem.left);
                if (rem.right != null)
                    q.add(rem.right);
            }
            ans.addAll(new ArrayList<>(Arrays.asList(li)));
            rightToLeft = !rightToLeft;
        }
        return ans;
    }
}
