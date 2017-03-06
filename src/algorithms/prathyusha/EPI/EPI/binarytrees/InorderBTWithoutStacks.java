package binarytrees;

import binarytrees.BinaryTree.Node;

public class InorderBTWithoutStacks {
	//go to left most child
	//parent -> left child - display node
	//parent -> right child - parent = parent.parent;
	//now same for right child if it exists
	
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new BinaryTree.Node(1);

		tree.root.left = new BinaryTree.Node(2);
		tree.root.left.parent = tree.root;
		tree.root.left.left = new BinaryTree.Node(0);
		tree.root.left.left.parent = tree.root.left;
		tree.root.right = new BinaryTree.Node(3);
		tree.root.right.parent = tree.root;
		tree.root.right.left = new BinaryTree.Node(4);
		tree.root.right.left.parent = tree.root.right;
		tree.root.right.right = new BinaryTree.Node(5);
		tree.root.right.right.parent = tree.root.right;
		displayInorderBST(tree.root);
	}

	//go to left most child
	//parent -> left child - display node
	//parent -> right child - parent = parent.parent;
	//now same for right child if it exists

	       
	   static void displayInorderBST( Node node) {
	       while( node != null ) {
	           while(node != null && node.left != null) {
	              node = node.left;
	           }
	           if(node == null || node != null && node.parent == null){
		        	  break;
		          }
	          System.out.print(node.data);
	          if(node != null && node.parent.left == node) { 
	               if(node != null && node.right != null) {
	                  System.out.print(node.parent.data);
	                  node = node.right;
	               }
	               else{
	               
	                  while(node != null  && node.parent != null  && node.parent.right == null) {
	                           System.out.print(node.parent.data);
	                           node = node.parent;
	                   }
	                   if(node != null && node.parent != null && node.parent.right != null ) {
	                          System.out.print(node.parent.data);
	                          node = node.parent.right; 
	                   }
	                   if(node != null && node.parent == null){
	 		        	  break;
	 		          }  
	       
	              }
	              }
	             else {
	                  while (node != null && node.parent != null && node.parent.right != null && node.parent.right == node ) {
	                      node = node.parent;
	                  }
	                  while(node != null && node.parent != null && node.parent.right == null) {
	                           System.out.print(node.parent.data);
	                           node = node.parent;
	                   }
	                  if(node != null && node.parent != null &&  node.parent.right != null ) {
	                          System.out.print(node.parent.data);
	                          node = node.parent.right;
	                    
	                  }
	                  if(node != null && node.parent == null){
			        	  break;
			          }
	   
	   
	    }
	   
	   }
	    
	    
	   }
}
