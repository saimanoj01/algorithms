package linkedlists;

import java.util.ArrayList;

public class BasicOperations {
	public static void main(String[] args) {
		/*LinkedList list = new LinkedList();
		list.insert(1);
		list.insert(2);
		list.insert(4);
		list.insert(5);
		list.print();
		list.insertAfter(2, 3);
		list.print();
		list.search(2);
		list.delete(1);
		list.print();
		ArrayList lList = list.getAllElements();
		System.out.println(lList);*/
		int[] x = {1,3,5,7};
		LinkedList list1 = new LinkedList(x);
		list1.print();
		int[] y = {2,4,6,8};
		LinkedList list2 = new LinkedList(y);
		list2.print();
		//list1.recMerge(list2.head);
		list1.print();
	}
}
