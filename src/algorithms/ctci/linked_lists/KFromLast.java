package algorithms.ctci.linked_lists;

/**
 * Created by saima_000 on 2/27/2017.
 */
public class KFromLast {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node getKthNodeFromLast(Node head, int k) {
        Node ptr1 = head, ptr2 = head;
        for(int i=0;i<k;i++) {
            if(ptr1 == null)
                return null;
            ptr1 = ptr1.next;
        }

        while(ptr1 != null) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        return ptr2;
    }

    public static Node llPartition(Node node, int x) {
        Node head = node, tail = node;
        Node temp = tail.next;
        while(temp != null) {
            if(temp.data < x) {
                tail.next = temp.next;
                temp.next = head;
                head = temp;
                temp = tail.next;
            }
            else {
                tail = tail.next;
                temp = tail.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(3);
        Node tail = head;

        Node temp = new Node(5);
        tail.next = temp;
        tail = tail.next;

        temp = new Node(8);
        tail.next = temp;
        tail = tail.next;

        temp = new Node(5);
        tail.next = temp;
        tail = tail.next;

        temp = new Node(10);
        tail.next = temp;
        tail = tail.next;

        temp = new Node(2);
        tail.next = temp;
        tail = tail.next;

        temp = new Node(1);
        tail.next = temp;
        tail = tail.next;

        head = llPartition(head, 5);

        Node n = head;
        while(n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }

    }
}
