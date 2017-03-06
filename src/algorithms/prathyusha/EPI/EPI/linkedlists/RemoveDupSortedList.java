package linkedlists;

import java.util.ArrayList;

import linkedlists.LinkedList.Node;

public class RemoveDupSortedList {
	public static void main(String[] args) {
		int[] array = {1,2,3};
		LinkedList li = new LinkedList(array);
		Node n = removeDuplicates(li.head);
		li.head = n;
		ArrayList<Integer> list = li.getAllElements();
		for (Integer i : list) {
			System.out.print(i+" ");
		}
	}

   static Node removeDuplicates(Node head) {
    Node tempHead = head, secHead;
    //2 succesive pointers
    while(tempHead != null) {
        secHead = tempHead.next;
        while(secHead != null && secHead.data == tempHead.data) {
            tempHead.next = secHead.next; 
            secHead = secHead.next;               
        }
        tempHead = tempHead.next;
    }
	return head;
   }
}

