package binarytrees;

import java.util.Stack;

import binarytrees.BinaryTree.Node;

public class InorderWithoutRecursion {
	
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new BinaryTree.Node(1);

		tree.root.left = new BinaryTree.Node(2);
		tree.root.left.left = new BinaryTree.Node(0);
		tree.root.right = new BinaryTree.Node(3);
		tree.root.right.left = new BinaryTree.Node(4);
		tree.root.right.right = new BinaryTree.Node(5);
		inOrderBT(tree.root);
	}
	
	
	
	//inorder without recursion
	//method 1 to add left elements in a row into the stack. 
	//method 2 -while stack is not empty - pop, display and add m1(right)

//	            1
//	         2    3
//	            4    5

	    public static void inOrderBT( Node root) {
	        Stack<Node> stack = new Stack<Node>();
	        addNodesIntoStack(root,stack);
	        //while stack not empty pop and display and add right subtree elements
	        while( ! stack.isEmpty()) {
	            Node temp = stack.pop();
	            System.out.print(temp.data+" ");
	            addNodesIntoStack(temp.right, stack);            
	        }
	    }
	    
	    public static void addNodesIntoStack(Node node, Stack<Node> stack) {
	        if(node == null) {
	            return;
	        }
	        Node temp = node;
	        while(temp != null ) {
	            stack.push(temp);
	            temp = temp.left;
	        }    
	    } 
	    
	 
}
