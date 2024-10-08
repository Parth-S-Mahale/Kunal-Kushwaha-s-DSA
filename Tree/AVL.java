class AVL {
    public class Node {
        private int value;
        private int height;
        private Node left;
        private Node right;

        public Node(int value){
            this.value = value;
            this.height = 0; // Initially, a new node is a leaf, so height is 0
        }

        public int getValue(){
            return value;
        }
    }

    private Node root;

    public AVL(){}

    public int height(Node node){
        if(node == null){
            return -1;  // For AVL trees, we define null nodes as having height -1
        }
        return node.height;
    }

    public int height() {
        return height(root);
    }

    public boolean isEmpty(){
        return root == null;
    }

    public void insert(int value){
        root = insert(value, root);
    }

    private Node insert(int value, Node node){
        if(node == null){
            return new Node(value);
        }

        if(value < node.value){
            node.left = insert(value, node.left);
        } else if(value > node.value){
            node.right = insert(value, node.right);
        } else {
            return node; // Duplicate values are not allowed, return the current node
        }

        // Update the height of this node after the insertion
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // Now balance the node if it became unbalanced
        return balance(node);
    }

    private Node balance(Node node) {
        int balanceFactor = height(node.left) - height(node.right);

        // Left heavy case
        if(balanceFactor > 1) {
            if(height(node.left.left) >= height(node.left.right)) {
                // Left-Left case
                return rightRotate(node);
            } else {
                // Left-Right case
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }

        // Right heavy case
        if(balanceFactor < -1) {
            if(height(node.right.right) >= height(node.right.left)) {
                // Right-Right case
                return leftRotate(node);
            } else {
                // Right-Left case
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }

        return node; // Node is balanced
    }

    private Node rightRotate(Node p){
        Node c = p.left;
        Node t = c.right;

        // Perform rotation
        c.right = p;
        p.left = t;

        // Update heights
        p.height = 1 + Math.max(height(p.left), height(p.right));
        c.height = 1 + Math.max(height(c.left), height(c.right));

        return c; // Return the new root of this subtree
    }

    private Node leftRotate(Node c){
        Node p = c.right;
        Node t = p.left;

        // Perform rotation
        p.left = c;
        c.right = t;

        // Update heights
        c.height = 1 + Math.max(height(c.left), height(c.right));
        p.height = 1 + Math.max(height(p.left), height(p.right));

        return p; // Return the new root of this subtree
    }

    public void populate(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            this.insert(nums[i]);
        }
    }

    public void populatedSorted(int[] nums){
        populatedSorted(nums, 0, nums.length);
    }

    private void populatedSorted(int[] nums, int start, int end){
        if(start >= end){
            return;
        }
        int mid = (start + end) / 2;

        this.insert(nums[mid]);
        populatedSorted(nums, start, mid);
        populatedSorted(nums, mid + 1, end);
    }

    public boolean balanced(){
        return balanced(root);
    }

    private boolean balanced(Node node){
        if(node == null){
            return true;
        }
        return Math.abs(height(node.left) - height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
    }

    public void display(){
        display(this.root, "Root Node: ");
    }

    private void display(Node node, String details){
        if(node == null){
            return;
        }
        System.out.println(details + node.getValue());

        display(node.left, "Left child of " + node.getValue() + " : ");
        display(node.right, "Right child of " + node.getValue() + " : ");
    }

    public static void main(String[] args){
        AVL tree = new AVL();

        for (int i = 0; i < 1000; i++) {
            tree.insert(i);
        }

        System.out.println("Height of AVL tree: " + tree.height());
    }
}
