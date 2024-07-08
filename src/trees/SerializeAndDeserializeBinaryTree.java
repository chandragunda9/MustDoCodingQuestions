package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {
    // Function to serialize a tree and return a list containing nodes of tree.
    public ArrayList<Integer> serialize(Node root) {
        // Level order traversal
        ArrayList<Integer> ser = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node rem = q.poll();
            if (rem == null) {
                ser.add(null);
                continue;
            }
            ser.add(rem.data);
            q.add(rem.left);
            q.add(rem.right);
        }
        return ser;
    }

    // Function to deserialize a list and construct the tree.
    public Node deSerialize(ArrayList<Integer> A) {
        if (A == null)
            return null;
        Node root = new Node(A.get(0));
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        for (int i = 1; i < A.size(); i++) {
            Node parent = q.poll();
            if (A.get(i) != null) {
                parent.left = new Node(A.get(i));
                q.add(parent.left);
            }
            if (A.get(++i) != null) {
                parent.right = new Node(A.get(i));
                q.add(parent.right);
            }
        }
        return root;
    }
}
