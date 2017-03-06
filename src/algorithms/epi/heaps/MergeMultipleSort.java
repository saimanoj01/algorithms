package algorithms.epi.heaps;


import java.util.*;

/**
 * Created by saima_000 on 2/14/2017.
 */
public class MergeMultipleSort {
    public static class ArrayEntry {
        int value;
        int arrayId;
        int index;

        public ArrayEntry(int value, int arrayId, int index) {
            this.value = value;
            this.arrayId = arrayId;
            this.index = index;
        }
    }

    public static ArrayList<Integer> mergeSortedArrays(ArrayList<ArrayList<Integer>> lists) {
        PriorityQueue<ArrayEntry> heap = new PriorityQueue<ArrayEntry>(lists.size(), new Comparator<ArrayEntry>() {
            @Override
            public int compare(ArrayEntry o1, ArrayEntry o2) {
                return Integer.compare(o1.value, o2.value);
            }
        });

        for(int i=0;i<lists.size();i++) {
            if(lists.get(i).size() != 0) {
                heap.add(new ArrayEntry(lists.get(i).get(0), i, 0));
            }
        }

        ArrayList<Integer> result = new ArrayList<Integer>();
        while(heap.size() != 0) {
            ArrayEntry entry = heap.poll();
            result.add(entry.value);
            if(entry.index + 1 < lists.get(entry.arrayId).size()) {
                heap.add(new ArrayEntry(lists.get(entry.arrayId).get(entry.index + 1), entry.arrayId, entry.index + 1));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        list1.addAll(Arrays.asList(1, 2, 3, 4, 9));

        ArrayList<Integer> list2 = new ArrayList<Integer>();
        list2.addAll(Arrays.asList(6, 7, 8));

        ArrayList<Integer> list3 = new ArrayList<Integer>();
        list3.addAll(Arrays.asList(10));

        ArrayList<Integer> list4 = new ArrayList<Integer>();
        list4.addAll(Arrays.asList(5, 13));

        ArrayList<Integer> list5 = new ArrayList<Integer>();
        list5.addAll(Arrays.asList(11, 12));
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        lists.add(list4);
        lists.add(list5);

        ArrayList<Integer> result = mergeSortedArrays(lists);
        for (int i : result) {
            System.out.print(i + "  ");
        }

        System.out.print(-1/2);
    }
}
