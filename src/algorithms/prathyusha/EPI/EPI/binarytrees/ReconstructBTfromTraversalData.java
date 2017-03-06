package binarytrees;

import binarytrees.BinaryTree.Node;

public class ReconstructBTfromTraversalData {

	
	//inorder , preorder- given 
	//finding left subtree - // 1. find root from preorder 2. find that root in inorder and find right child 
	//3. search for right child in the preorder -  send array elements from root+1 to right child as left subtree
	//4. send right child inorder (right child place known), post order also
	//5. base cases : logic: if one element - return that element;

	public static void main(String[] args) {
		int[] inorder = {4,2,5,1,6,3};
		int[] preorder = {1,2,4,5,3,6};
		Node head = getTree(inorder, preorder);
		InorderWithoutRecursion.inOrderBT(head);
	}
	
	
	 public static Node getTree(int[] inorder, int[] preorder) {
	    return getBinaryTree(inorder, 0, inorder.length, preorder, 0, preorder.length);
	 }
	 
	 
	 public static Node getBinaryTree(int[] inorder, int inStart, int inEnd,int[] preorder, int preStart, int preEnd) {
	     Node head = new Node();
	     if(inorder.length == 0 || preorder.length == 0) 
	         return null;
	     if(preStart > preorder.length || inStart > inorder.length || inStart == -1 || inEnd == -1 || preStart == -1 || preEnd == -1 ) 
	         return null;
	     //1
	     head.data = preorder[preStart++];
	     //2.
	     int headIndexIn = -1;
	     for( int i = inStart; i <= inEnd; i++ ) {
	         if(inorder[i] == head.data) {
	             headIndexIn = i;
	             break;
	         }
	     }
	     //3.
	     int rightChildPre = -1;
	     if(headIndexIn < inorder.length-1) {
	         int rightChild = inorder[headIndexIn+1];
	         for( int i = preStart; i <= preEnd; i++ ) {
	             if(preorder[i] == rightChild ) {
	                 rightChildPre = i;
	                 break;
	             }
	         }         
	      }
	      
	      //4.
	      head.left = getBinaryTree(inorder, inStart, headIndexIn-1, preorder , preStart, rightChildPre );
	      head.right = getBinaryTree(inorder, headIndexIn+1, inEnd, preorder, rightChildPre, preEnd);
	      
	          
	     return head;
	 }
}
