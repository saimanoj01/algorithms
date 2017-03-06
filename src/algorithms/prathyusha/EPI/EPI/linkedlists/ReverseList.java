package linkedlists;

import java.util.ArrayList;

import linkedlists.LinkedList.Node;

public class ReverseList {
	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6,7};
		LinkedList li = new LinkedList(array);
		Node n = reverseList(li.head);
		li.head = n;
		ArrayList<Integer> list = li.getAllElements();
		for (Integer i : list) {
			System.out.print(i+" ");
		}
	}
	
	
	
	static Node reverseList(Node head){
        Node tempHead = head, reverse = null, tempRevHead = null;
        while(tempHead != null){
            tempRevHead = reverse;
            Node temp = tempHead;
            tempHead = tempHead.next;
            reverse = temp;
            reverse.next = tempRevHead;
        }
        return reverse;
    
   }
}


