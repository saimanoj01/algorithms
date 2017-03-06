package linkedlists;

import java.util.ArrayList;

import linkedlists.LinkedList.Node;

public class EvenOddMerge {
	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6,7};
		LinkedList li = new LinkedList(array);
		Node n = getEvenOdd(li.head);
		li.head = n;
		ArrayList<Integer> list = li.getAllElements();
		for (Integer i : list) {
			System.out.print(i+" ");
		}
	}

//even odd merge
//even elemets and odd placed elements
	static Node getEvenOdd(Node head){
	 if(head == null)
	     return  null;
	 Node tempEven = head, tempOdd = head.next, tempHead = head, tempOddHead = tempOdd;
	 while(tempOdd != null && tempEven != null) {
		if(tempOdd.next == null) {
			tempEven.next = tempOddHead;
			break;
		}
		tempEven.next = tempOdd.next;
		tempEven = tempEven.next;
	    if(tempEven.next != null) {
	    	tempOdd.next = tempEven.next;
	    }
	    else{
	    	tempOdd.next = null;
	    	tempEven.next = tempOddHead;
			break;
	    }
	    tempOdd = tempOdd.next;
	 }
	 return tempHead;
	}
}