package algorithms.epi.bst;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by saima_000 on 2/15/2017.
 */

public class ValidateBSTInBT {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static class QueueEntry {
        Node node;
        int min, max;

        public QueueEntry(Node node, int min, int max) {
            this.node = node;
            this.min = min;
            this.max = max;
        }
    }

    Node root;

    public boolean isBST() {
        return isBstQueApproach(root);
    }


    public static int temp = Integer.MIN_VALUE;
    private boolean inOrder(Node node) {
        if(node == null)
            return true;
        boolean left = inOrder(node.left);
        if(node.data < temp) {
            System.out.println(temp + " " + node.data);
            return false;
        }
        else
            temp = node.data;
        boolean right = inOrder(node.right);
        if(!left || ! right)
            return false;
        return true;
    }

    public static boolean isBst(Node node, int min, int max) {
        if(node == null)
            return true;
        else if(node.data < min || node.data > max) {
            return false;
        }

        return isBst(node.left, min, node.data) && isBst(node.right, node.data, max);
    }

    public static boolean isBstQueApproach(Node node) {
        if(node == null)
            return true;
        Queue<QueueEntry> queue = new LinkedList<QueueEntry>();
        queue.add(new QueueEntry(node, Integer.MIN_VALUE, Integer.MAX_VALUE));
        while(!queue.isEmpty()) {
            QueueEntry temp = queue.poll();
            if(temp.node.data < temp.min || temp.node.data > temp.max)
                return false;
            if(temp.node.left != null)
                queue.add(new QueueEntry(temp.node.left, temp.min, temp.node.data));
            if(temp.node.right != null)
                queue.add(new QueueEntry(temp.node.right, temp.node.data, temp.max));
        }
        return true;
    }

    public static void main(String[] args) {
        ValidateBSTInBT tree = new ValidateBSTInBT();
        tree.root = new ValidateBSTInBT.Node(10);

        tree.root.left = new ValidateBSTInBT.Node(5);
        tree.root.left.left = new ValidateBSTInBT.Node(3);
        tree.root.right = new ValidateBSTInBT.Node(15);
        tree.root.right.left = new ValidateBSTInBT.Node(13);
        tree.root.right.right = new ValidateBSTInBT.Node(18);
        System.out.println(tree.isBST());

        tree = new ValidateBSTInBT();
        tree.root = new ValidateBSTInBT.Node(1);
        tree.root.left = new ValidateBSTInBT.Node(2);
        tree.root.left.left = new ValidateBSTInBT.Node(3);
        System.out.println(tree.isBST());


        tree = new ValidateBSTInBT();
        tree.root = new ValidateBSTInBT.Node(5);

        tree.root.left = new ValidateBSTInBT.Node(4);
        tree.root.left.left = new ValidateBSTInBT.Node(3);
        tree.root.right = new ValidateBSTInBT.Node(6);
        tree.root.right.left = new ValidateBSTInBT.Node(7);
        tree.root.right.right = new ValidateBSTInBT.Node(8);
        System.out.println(tree.isBST());
    }
}

