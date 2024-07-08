package trees;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectNodesAtSameLevel {
    public void connect(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int n = q.size();
            while (n > 0) {
                Node rem = q.poll();
                if (n == 1)
                    rem.nextRight = null;
                else
                    rem.nextRight = q.peek();
                if (rem.left != null)
                    q.add(rem.left);
                if (rem.right != null)
                    q.add(rem.right);
                n--;
            }
        }
    }
}
