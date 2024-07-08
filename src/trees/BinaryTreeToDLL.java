package trees;

public class BinaryTreeToDLL {
    Node prev = null;
    Node head = null;

    Node bToDLL(Node root) {
        inorderTraversal(root);
        return head;
    }

    void inorderTraversal(Node node) {
        if (node == null)
            return;
        inorderTraversal(node.left);
        if (prev == null) {
            //first node in DLL
            head = node;
        } else {
            prev.right = node;
            node.left = prev;
        }
        prev = node;
        inorderTraversal(node.right);
    }
}
