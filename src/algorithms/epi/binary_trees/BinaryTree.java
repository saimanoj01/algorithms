package algorithms.epi.binary_trees;

/**
 * Created by saima_000 on 2/6/2017.
 *
 * Algorithms related to Binary Trees.
 */
public class BinaryTree {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    Node root;

    public boolean isBalanced() {
        return isBalanced(root) != -1;
    }

    /**
     *
     * Method to check whether a tree is height balanced or not. A tree is not height balanced if the difference of heights of children is
     * greater than 1
     *
     * https://github.com/adnanaziz/epicode/blob/master/java/src/main/java/com/epi/BalancedBinaryTree.java
     *
     * The recursive function returns -1 if the tree is unbalanced. Otherwise it returns the height of the tree.
     */
    private int isBalanced(Node node) {
        if(node == null)
            return 0;
        int leftHeight = isBalanced(node.left), rightHeight = isBalanced(node.right);
        if(leftHeight == -1 || rightHeight == -1)
            return -1;
        else {
            if(Math.abs(leftHeight - rightHeight) > 1)
                return -1;
            else
                return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new BinaryTree.Node(1);

        tree.root.left = new BinaryTree.Node(1);
        tree.root.left.left = new BinaryTree.Node(1);
        tree.root.right = new BinaryTree.Node(1);
        tree.root.right.left = new BinaryTree.Node(1);
        tree.root.right.right = new BinaryTree.Node(1);
        System.out.println(tree.isBalanced());

        tree = new BinaryTree();
        tree.root = new BinaryTree.Node(1);
        tree.root.left = new BinaryTree.Node(1);
        tree.root.left.left = new BinaryTree.Node(1);
        System.out.println(tree.isBalanced());
    }
}
