package bST;

import java.util.LinkedList;
import java.util.Queue;

import bST.ValidateBSTinBT.BinaryTree.Node;

/* 
https://github.com/adnanaziz/epicode/blob/master/java/src/main/java/com/epi/BalancedBinaryTree.java 
 */

public class ValidateBSTinBT {
	
	static class BinaryTree {
		static class Node {
			int data;
			Node left, right;
			
			public Node(int data) {
				this.data = data;
				left = right = null;
			}
		}
		
		Node root;
		
		public BinaryTree() {
		}
	}
	
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new BinaryTree.Node(5);

		tree.root.left = new BinaryTree.Node(4);
		tree.root.left.left = new BinaryTree.Node(3);
		tree.root.right = new BinaryTree.Node(6);
		tree.root.right.left = new BinaryTree.Node(5);
		tree.root.right.right = new BinaryTree.Node(8);
		//System.out.println(isBST(tree.root,Integer.MIN_VALUE,Integer.MAX_VALUE));
		System.out.println(itrBST(tree.root));
	}


	private static boolean isBST(Node node, int minValue, int maxValue) {
		if(node == null) {
			return true;
		}
		if((node.data < minValue) || (node.data > maxValue)) {
			return false;
		}
		return isBST(node.left, minValue, node.data) && isBST(node.right,node.data,maxValue);
	}
	
	static class Qentry {
		Node node;
		int lower;
		int upper;
		public Qentry(Node node, int lower, int upper) {
			this.node = node;
			this.lower = lower;
			this.upper = upper;
		}
	}
	
	
	private static boolean itrBST(Node node) {
		if(node == null) {
			return true;
		}
		Queue<Qentry> queue = new LinkedList<Qentry>();
		queue.add(new Qentry(node, Integer.MIN_VALUE, Integer.MAX_VALUE));
		while(!queue.isEmpty()) {
			Qentry qentry = queue.poll();
			node = qentry.node;
			if((node.data < qentry.lower) || (node.data > qentry.upper)) {
				return false;
			}
			if(node.left != null){
					queue.add(new Qentry(node.left, qentry.lower, node.data));
			}
			if(node.right != null) {
					queue.add(new Qentry(node.right, node.data, qentry.upper));
			}
		}
		return true;
	}
	
}
