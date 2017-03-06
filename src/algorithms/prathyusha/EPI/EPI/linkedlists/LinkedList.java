package linkedlists;

import java.util.ArrayList;

public  class LinkedList {
	public static class Node {
		public int data;
		public Node next;
		public Node random;
		public Node(int i) {
			this.data = i;
			this.next = null;
		}
		public Node(int i, Node n) {
			this.data = i;
			this.next = n;
		}
		public Node(int i, Node n, Node n1) {
			this.data = i;
			this.next = n;
			this.random = n1;
		}
		public Node() {
			// TODO Auto-generated constructor stub
		}
	}
	Node head;
	
	
	LinkedList ( int[] arrayList ) {
		for ( int i=0; i < arrayList.length; i++ ) {
			insert(arrayList[i]);
		}
	}
	
	public LinkedList() {
	}
	
	
	public void insert ( int data ) {
		if ( head == null ) {
			head = new Node(data);
		}
		else {
			Node temp = head;
			while ( temp.next!= null ){
				temp = temp.next;
			}
			temp.next = new Node(data);
		}
	}
	
	public void insertAfter ( int data, int key) {
		if ( head != null) {
			Node temp = head;
			while ( temp.data != key && temp.next != null ) {
				temp = temp.next;
			}
			Node newNode = new Node (data);
			newNode.next = temp.next;
			temp.next = newNode;
		}
		else{
			head = new Node(data);
		}
	}
	
	public boolean search ( int data ) {
			Node temp = head;
			int index = -1;
			while ( temp != null && temp.data != data) {
				temp = temp.next;
			}
			return temp != null;
	}
	
	public  boolean delete ( int data ) {
		if ( head!= null ) {
			Node temp = head;
			Node parent = null;
			while ( temp != null ){
				if ( temp.data == data ) {
					head = temp.next ;
					break;
				}
				else if ( temp.data == data && parent != null) {
					parent.next = temp.next;
					return true;
				}
				else if ( temp.next != null ) {
					parent = temp;
					temp = temp.next;
				}
				else {
					System.out.println("data not found");
					return false;
				}
			}
		}
		return false;
	}
	
	public void print () {
		System.out.print("[ ");
		Node temp = head;
		while ( temp!=null ) {
			System.out.print(temp.data);
			if ( temp.next != null ) {
				temp = temp.next;
				System.out.print(", ");
			}
			else break;
		}
		System.out.println(" ]");
	}
	
	public ArrayList getAllElements() {
		ArrayList<Integer> list = new ArrayList<>();
		if ( head != null ) {
			Node temp = head;
			while ( temp != null ) {
				list.add(temp.data);
				if ( temp.next != null ) temp =temp.next;
				else break;
			}
		}
		return list;
	}
	
	public void merge ( LinkedList sec ) {
		Node first = head;
		Node second = sec.head;
		Node sorted = new Node(0);
		Node sortedHead = sorted;
		while ( first != null  && second != null) {
			if ( first.data <= second.data ){
					sorted.next = first;
					first = first.next;
			}
			else {
					sorted.next = second;
					second = second.next;
			}
			sorted = sorted.next;
		}
		sorted.next = ( first != null) ? first : second;
		head = sortedHead.next;
	}
	
	public void mergeRecursive (LinkedList second ){
		head = recursiveMerge(head ,second.head);
	}
	
	
	
	//using recursion
	public Node recursiveMerge ( Node first, Node second) {
		if ( first == null ) {
			return second;
		}
		 if ( second == null ) {
			return first;
		}		
			if (first.data <= second.data) {
				first.next = recursiveMerge(first.next, second);
				return first;
			}
			else {
				second.next = recursiveMerge(first, second.next);
				return second;
			}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
