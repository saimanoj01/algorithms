package binarytrees;

import binarytrees.BinaryTree.Node;

public class LeastCommonAncestor {
	  public static class NodeEntry {
	       Node node;
	       int count; 
	       NodeEntry(Node node, int count) {
	           this.node =  node;
	           this.count = count;
	       }
	   }
	    
	    
	    
	    public static NodeEntry getLCA( Node node, Node firstNode, Node secNode) {
	        
	        if(node == null) {
	            return new NodeEntry(null, 0);
	        }
	        int count = 0, expectedCount = 0;
	        if(firstNode != null)
	        	expectedCount++;
	        if(secNode != null)
	        	expectedCount++;
	        NodeEntry leftCount = getLCA(node.left, firstNode, secNode);
	        if(leftCount.count== expectedCount) {
	            return new NodeEntry(leftCount.node , count);
	        }
	        NodeEntry rightCount = getLCA(node.right, firstNode, secNode);
	        if(rightCount.count== expectedCount) {
	            return new NodeEntry(rightCount.node , count);
	        }
	        if( firstNode != null && node.data == firstNode.data) 
	            count++;
	        if( secNode != null && node.data == secNode.data)
	            count++;
	        count += leftCount.count + rightCount.count;
	       
	        return new NodeEntry(node, count);  
	    
	    }
	    
	    public static void main(String[] args) {
	    	BinaryTree tree = new BinaryTree();
			tree.root = new BinaryTree.Node(1);

			tree.root.left = new BinaryTree.Node(2);
			tree.root.left.left = new BinaryTree.Node(4);
			tree.root.right = new BinaryTree.Node(3);
			tree.root.right.left = new BinaryTree.Node(5);
			tree.root.right.right = new BinaryTree.Node(6);
			System.out.println(getLCA(tree.root,tree.root.right.right,tree.root.right.right).node.data);

		}
	    
}
