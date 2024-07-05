package trees;

class Node {
    int data;
    int hd;
    Node left, right;

    public Node(int data) {
        this.data = data;
        this.hd = Integer.MAX_VALUE;
        this.left = this.right = null;
    }
}
