import java.util.*;

public class TreeTraversals {
    public TreeTraversals() {

    }

    private static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    // insert elements
    public void insert(Scanner sc) {
        System.out.println("Do you want to enter left of: ");
        boolean ROOT = sc.nextBoolean();
        if (ROOT) {
            System.out.println("Enter the root Node: ");
            int value = sc.nextInt();
            root = new Node(value);
            insert(sc, root);
        }
    }

    private void insert(Scanner sc, Node node) {
        System.out.println("Do you want to enter left of: " + node.value);
        boolean left = sc.nextBoolean();
        if (left) {
            System.out.println("Enter the value of the left of: " + node.value);
            int value = sc.nextInt();
            node.left = new Node(value);
            insert(sc, node.left);
        }

        System.out.println("Do you want to enter right of: " + node.value);
        boolean right = sc.nextBoolean();
        if (right) {
            System.out.println("Enter the value of the right of: " + node.value);
            int value = sc.nextInt();
            node.right = new Node(value);
            insert(sc, node.right);
        }
    }

    public void prettyDisplay() {
        prettyDisplay(root, 0);
    }

    private void prettyDisplay(Node node, int level) {
        if (node == null) {
            return;
        }

        prettyDisplay(node.right, level + 1);
        if (level != 0) {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|-------->" + node.value);
        } else {
            System.out.println(node.value);
        }
        prettyDisplay(node.left, level + 1);
    }

    // ----- pre-order Traversal -----
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    // ----- in-order Traversal -----
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.value + " ");
        inOrder(node.right);
    }

    // ----- post-order Traversal -----
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.value + " ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeTraversals tree = new TreeTraversals();

        tree.insert(sc);

        tree.insert(sc); // Allows user to build the tree interactively

        // Traversals
        System.out.println("Pre-order Traversal:");
        tree.preOrder();

        System.out.println("In-order Traversal:");
        tree.inOrder();

        System.out.println("Post-order Traversal:");
        tree.postOrder();

        System.out.println("Pretty Tree Display:");
        tree.prettyDisplay();
    }
}
