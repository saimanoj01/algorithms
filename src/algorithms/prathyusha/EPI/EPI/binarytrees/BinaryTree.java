package binarytrees;

/* 
https://github.com/adnanaziz/epicode/blob/master/java/src/main/java/com/epi/BalancedBinaryTree.java 
 */

public class BinaryTree {
	static class Node {
		int data;
		Node left, right,parent;
		
		public Node() {
			
		}
		
		public Node(int data) {
			this.data = data;
			left = right = null;
		}
	}
	
	Node root;
	
	public BinaryTree() {
		// TODO Auto-generated constructor stub
	}
	
	
	public boolean isBalanced() {
		return isBalanced(root) != -1;
	}	
	
	public int isBalanced ( Node node ) {
		if ( node == null ) {
			return 0;
		}
		int maxLeft = isBalanced(node.left), maxRight = isBalanced(node.right);
		if (maxLeft == -1 || maxRight == -1) {
			return -1;
		}
		int difference = Math.abs(maxLeft-maxRight);
		if (difference <= 1) {
			return Math.max(maxLeft, maxRight)+1;
		}
		else {
			return -1;
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
