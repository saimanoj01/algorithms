package algorithms.ctci.trees_graphs;

/**
 * Created by saima_000 on 2/28/2017.
 */
public class LCA {
    public class Node {
        int data;
        Node left, right;
        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static class LCAReturn {
        Node ancestor;
        int count;

        public LCAReturn(Node ancestor, int count) {
            this.ancestor = ancestor;
            this.count = count;
        }
    }

    public static LCAReturn lcaHelper(Node root, Node node1, Node node2) {
        if(root == null) {
            return new LCAReturn(null,0);
        }

        LCAReturn left = lcaHelper(root.left, node1, node2);
        LCAReturn right = lcaHelper(root.right, node1, node2);

        if(left.ancestor != null) {
            return new LCAReturn(left.ancestor,2);
        }
        else if(right.ancestor != null) {
            return new LCAReturn(right.ancestor,2);
        }
        else {
            int count = left.count + right.count;
            if(root.data == node1.data || root.data == node2.data)
                count = count + 1;
            if(count == 2) {
                return new LCAReturn(root, 2);
            }
            else {
                return new LCAReturn(null, count);
            }
        }
    }

    public static Node lca(Node root, Node node1, Node node2) {
        return lcaHelper(root, node1, node2).ancestor;
    }
}
