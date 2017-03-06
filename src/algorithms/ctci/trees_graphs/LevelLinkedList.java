package algorithms.ctci.trees_graphs;

/**
 * Created by saima_000 on 2/28/2017.
 */

import java.util.ArrayList;
import java.util.LinkedList;

/**
 1. Create an List of linked lists.
 2. Initially create a list with just one entry which is the root.
 3. Add that list to the list of lls
 4. Now iterate over the nodes in the list and add its children to a new list.
 5. Add this list to the list of lls and repeat steps 4-5 till all nodes are covered.
 **/

public class LevelLinkedList {
    public static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public ArrayList<LinkedList<Node>> createLists(Node root) {
        ArrayList<LinkedList> lists = new ArrayList<LinkedList>();
        LinkedList<Node> list = new LinkedList<Node>();
        list.add(root);

        while(!list.isEmpty()) {
            lists.add(list);
            LinkedList<Node> newList = new LinkedList<Node>();
            for(Node node : list) {
                if(node.left != null)
                    newList.add(node.left);
                if(node.right != null)
                    newList.add(node.right);
            }
            list = newList;
        }
        return null;
    }
}
