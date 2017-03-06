package algorithms.collections;

import java.util.*;

/**
 * Created by saima_000 on 3/1/2017.
 */
public class ArrayListTest {
    public static class Node implements Comparable {
        int data;
        String name;
        public Node(int data, String name) {
            this.data = data;
            this.name = name;
        }


        @Override
        public int compareTo(Object o) {
            Node node = (Node)o;
            if(data == node.data)
                return 0;
            else if(data > node.data)
                return 1;
            else
                return -1;
        }
    }

    public static void main(String[] args) {
        ArrayList<Node> list = new ArrayList<Node>();
        list.add(new Node(1, "sai"));
        list.add(new Node(2, "sai"));
        list.add(new Node(3, "sai"));
        list.add(new Node(4, "sai"));
        list.add(new Node(5, "sai"));

        for(Node node : list) {
            System.out.print(node.data + " ");
        }
        System.out.println();
        list.add(3, new Node(0, "sai"));

        Iterator<Node> it = list.iterator();
        while(it.hasNext()) {
            System.out.print(it.next().data + " ");
        }

//        list.set(0, new Node(10, "sai"));
//
//        it = list.iterator();
//        while(it.hasNext()) {
//            System.out.print(it.next().data + " ");
//        }
//
//       Collections.sort(list);
//        System.out.println();
//        it = list.iterator();
//        while(it.hasNext()) {
//            System.out.print(it.next().data + " ");
//        }
    }
}
