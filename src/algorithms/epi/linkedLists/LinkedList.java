package algorithms.epi.linkedLists;

import java.util.ArrayList;

/**
 * Created by saima_000 on 2/4/2017.
 *
 * Simple Implementation of Linked Lists.
 * TODO - Currently this version of Linked List stores only integer data. Expand this functionality to support other data types
 */

public class LinkedList {
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Constructor to insert array of elements.
    public LinkedList(int[] data) {
        for(int i=0;i<data.length;i++)
            insert(data[i]);
    }

    public LinkedList() {

    }

    Node head;

    public void insert(int data) {
        Node newNode = new Node(data);
        if(head == null) {
            this.head = newNode;
        }
        else {
            Node temp = head;
            while(temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public void insertAfter(int data, int after) {
        Node newNode = new Node(data);
        if(head == null) {
            this.head = newNode;
        }
        else {
            Node temp = head;
            while (temp.next !=  null && temp.data != after) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }

    public boolean search(int data) {
        Node temp = head;
        while(temp != null && temp.data != data) {
            temp = temp.next;
        }
        return temp != null;
    }

    public boolean delete(int data) {
        if(head == null)
            return false;
        else if(head != null && head.data == data) {
            head = head.next;
            return true;
        }
        Node temp = head;
        while(temp.next != null && temp.next.data != data) {
            temp = temp.next;
        }
        if(temp.next == null) return false;
        temp.next = temp.next.next;
        return true;
    }

    protected ArrayList<Integer> getAllElements() {
        Node temp = head;
        ArrayList<Integer> list = new ArrayList<Integer>();
        while(temp != null) {
            list.add(temp.data);
            temp = temp.next;
        }
        return list;
    }

    public void mergeRecursive(LinkedList list) {
        this.head = recur(this.head, list.head);
    }

    private Node recur(Node head1, Node head2) {
        if(head1 == null)
            return head2;
        if(head2 == null)
            return head1;

        if(head1.data <= head2.data) {
            head1.next = recur(head1.next, head2);
            return head1;
        }
        else {
            head2.next = recur(head1, head2.next);
            return head2;
        }
    }

    public void merge(LinkedList list) {
        Node temp1 = this.head;
        Node temp2 = list.head;
        Node prev = null;

        if(temp1 == null) {
            this.head = temp2;
            return;
        }
        while(temp1 != null && temp2 != null) {
            while(temp1 != null && temp1.data <= temp2.data) {
                prev = temp1;
                temp1 = temp1.next;
            }
            if(temp1 == null) {
                prev.next = temp2;
                return;
            }

            Node temp = temp2;
            temp2 = temp2.next;
            temp.next = temp1;
            if(prev == null) {
                head = temp;
                prev = head;
                continue;
            }
            prev.next = temp;
            prev = temp;
        }
    }
}
