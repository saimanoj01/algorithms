package linkedlists;

import linkedlists.LinkedList.Node;

public class CloneRandomPointer {
	public static void main(String[] args) {
		Node node1 = new Node(1,null,null);
		Node node2 = new Node(2, null, null);
		Node node3 = new Node(3, null, null);
		Node node4 = new Node(4, null, null);
		Node node5 = new Node(5, null, null);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		
		node1.random = node3;
		node2.random = node5;
		node3.random = node1;
		node4.random = node2;
		node5.random = node4;
		
		Node clone = getClone(node1);
		Node temp = clone;
		System.out.println("Node1:" + temp.data);
		System.out.println("Node1->next:" + temp.next.data);
		System.out.println("Node1->random" + temp.random.data);
		
		temp = temp.next;
		System.out.println("Node1:" + temp.data);
		System.out.println("Node1->next:" + temp.next.data);
		System.out.println("Node1->random" + temp.random.data);
		
		temp = temp.next;
		System.out.println("Node1:" + temp.data);
		System.out.println("Node1->next:" + temp.next.data);
		System.out.println("Node1->random" + temp.random.data);
		
		
		temp = temp.next;
		System.out.println("Node1:" + temp.data);
		System.out.println("Node1->next:" + temp.next.data);
		System.out.println("Node1->random" + temp.random.data);
	}
	
	public static Node getClone(Node head) {
	    //add same node to list
	    //update random pointers of the duplicate node
	    //get the second list
	    Node tempPtr = head, result = null, resultHead = null;
	    while(tempPtr != null){
	        Node temp = new Node(tempPtr.data);
	        temp.next = tempPtr.next;
	        tempPtr.next = temp;
	        tempPtr = tempPtr.next.next;
	    }
	    tempPtr = head;
	    while(tempPtr != null){
	        tempPtr.next.random = tempPtr.random.next;
	        tempPtr = tempPtr.next.next;
	    }
	    result = head.next;
	    resultHead = result;
	    tempPtr = head;
	    while(result != null) {
	    	if(result.next == null || tempPtr.next == null)
	    		break;
	    	tempPtr.next = tempPtr.next.next;
	    	tempPtr = tempPtr.next;
	        result.next = result.next.next;
	        result = result.next;
	    }
	    return resultHead;
	}
}


