public class SegmentTree {
    private static class Node {
        int data;
        int startInterval;
        int endInterval;
        Node left;
        Node right;

        public Node(int startInterval, int endInterval) {
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }
    }

    private Node root;

    public SegmentTree(int[] arr) {
        // create a tree using this array
        this.root = constructNode(arr, 0, arr.length - 1);
    }

    private Node constructNode(int[] arr, int start, int end) {
        if (start == end) {
            // leaf node
            Node leaf = new Node(start, end);
            leaf.data = arr[start];
            return leaf;
        }

        // create new node with index you are at
        Node node = new Node(start, end);

        int mid = (start + end) / 2;

        node.left = this.constructNode(arr, start, mid);
        node.right = this.constructNode(arr, mid + 1, end);

        node.data = node.left.data + node.right.data;
        return node;
    }

    public void display() {
        display(this.root);
    }

    private void display(Node node) {
        if (node == null) {
            return;
        }

        String str = "";

        if (node.left != null) {
            str += "Interval=[" + node.left.startInterval + "-" + node.left.endInterval + "] and data: " + node.left.data + " => ";
        } else {
            str += "No left child => ";
        }

        str += "Interval=[" + node.startInterval + "-" + node.endInterval + "] and data: " + node.data + " => ";

        if (node.right != null) {
            str += "Interval=[" + node.right.startInterval + "-" + node.right.endInterval + "] and data: " + node.right.data;
        } else {
            str += "No right child";
        }

        System.out.println(str);

        // call recursion
        display(node.left);
        display(node.right);
    }

    // query
    public int query(int qsi, int qei) {
        return this.query(this.root, qsi, qei);
    }

    private int query(Node node, int qsi, int qei) {
        if (node.startInterval >= qsi && node.endInterval <= qei) {
            // node is completely lying inside query
            return node.data;
        } else if (node.endInterval < qsi || node.startInterval > qei) {
            // completely outside the range
            return 0;
        } else {
            return this.query(node.left, qsi, qei) + this.query(node.right, qsi, qei);
        }
    }

    // update
    public void update(int index, int value) {
        update(this.root, index, value);
    }

    private int update(Node node, int index, int value) {
        if (node.startInterval == node.endInterval) {
            // leaf node
            if (node.startInterval == index) {
                node.data = value;
            }
            return node.data;
        }

        int mid = (node.startInterval + node.endInterval) / 2;
        if (index <= mid) {
            update(node.left, index, value);
        } else {
            update(node.right, index, value);
        }

        node.data = node.left.data + node.right.data;
        return node.data;
    }

    public static void main(String[] args) {
        int[] arr = {3, 8, 7, 6, -2, -8, 4, 9};
        SegmentTree tree = new SegmentTree(arr);
        // tree.display();

        System.out.println("Query [1,6]: " + tree.query(1,6));

    }
}

/*  
    Corrected Node constructor.
    Added Node as return type in constructNode.
    Fixed the string formation for the current node in the display method.
    Updated the condition in query to use && for checking if a node is out of range.
    Fixed the update method's leaf node logic and ensured recursive propagation of changes.
*/ 
