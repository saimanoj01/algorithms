package algorithms.ctci.trees_graphs;

/**
 * Created by saima_000 on 2/28/2017.
 */
public class MinimalBST {
    public static class Node {
        int data;
        Node left = null, right = null;
        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public Node createTree(int[] data, int start, int end) {
            if(start > end)
                return null;
            if(start == end) {
                return new Node(data[start]);
            }
            int middle = (start + end)/2;
            Node node = new Node(data[middle]);
            node.left = createTree(data, start, middle-1);
            node.right = createTree(data, middle+1, end);
            return node;
        }
    }
}
