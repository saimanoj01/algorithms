package linkedlists;

import java.util.ArrayList;

import linkedlists.LinkedList.Node;

public class ReverseSublist {
	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6,7};
		LinkedList l = new LinkedList(array);
		Node n = reverse(l.head,5,7);
		l.head = n;
		ArrayList<Integer> list = l.getAllElements();
		for (Integer i : list) {
			System.out.print(i+" ");
		}
	}
	
	//reverse a single sublist s,f
	 static Node reverse(Node head, int start, int finish) {
	     int count = 1;
	     Node tempStart = head , tempFinish = head, tempEnd;
	     //go to s-1th node 
	     while(count < start-1) {
	         count++;
	         tempStart = tempStart.next;
	         tempFinish = tempFinish.next;
	     }
	     System.out.println(tempStart.data);
	     // 2nd ponter goes to f node
	     while(count < finish) {
	         count++;
	         tempFinish = tempFinish.next;
	     }
	     System.out.println(tempFinish.data);
	     //save f+1  th nodes
	     tempEnd = tempFinish.next;
	     tempFinish.next = null;
	     //reverse nodes from s to f
	     Node temp = null;
	     if(start > 1) 
	          temp = tempStart.next;
	     else
	         temp = head;
	     Node reverse = null;
	     while(temp != null) {
	         Node tempRevHead = reverse;
	         Node reversehead = temp;
	         System.out.println("added to reverse "+ reversehead.data);
	         temp= temp.next; 
	         reversehead.next = tempRevHead; 
	         reverse = reversehead; 
	     }
	     //attach reversed part
	       if(start != 1) {
	         tempStart.next = reverse;
	       	System.out.println("reversed start "+reverse.data);
	       }
	       else {
	           tempStart = reverse;
	           head = reverse;
	           System.out.println("head data "+head.data);
	          
	       }	    
	       //go to end and attach end part
	     Node t = head;
	     while(t != null ){
	    	 System.out.println("T data" + t.data);
	    	 if(t.next == null)
	    		 break;
	    	 t = t.next;
	     }
	     t.next = tempEnd;
	     // to return head       
	     return head;
	}


}
