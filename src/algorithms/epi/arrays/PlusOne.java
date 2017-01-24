package algorithms.epi.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by saima_000 on 12/23/2016.
 */
public class PlusOne {
    private static List<Integer> getRandomList(int size) {
        List<Integer> list = new ArrayList<Integer>();
        Random random = new Random();
        list.add(random.nextInt(9) + 1);
        for(int i=0;i<size-1;i++) {
            list.add(random.nextInt(10));
        }
        return list;
    }

    private static void printList(List<Integer> list) {
        for(int i=0;i<list.size();i++) {
            System.out.print(list.get(i) + "    ");
        }
        System.out.println();
    }

    private static void plusOne(List<Integer> list) {
        int n = list.size() - 1;
        list.set(n, list.get(n) + 1);
        for(int i=n; i>0 && list.get(i)==10; i--) {
            list.set(i, 0);
            list.set(i-1, list.get(i-1) + 1);
        }
        if(list.get(0) == 10) {
            list.set(0, 0);
            list.add(0, 1);
        }
    }

    public static void main(String[] args) {
        int size = 10;
        List<Integer> list = getRandomList(size);
        printList(list);
        plusOne(list);
        printList(list);
    }
}
