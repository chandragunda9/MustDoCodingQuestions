package trees;

class Node {
    int data;
    int hd;
    Node left, right, nextRight;

    public Node(int data) {
        this.data = data;
        this.hd = Integer.MAX_VALUE;
        this.left = this.right = null;
        this.nextRight = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }
}
