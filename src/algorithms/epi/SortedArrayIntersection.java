package algorithms.epi;

import java.util.ArrayList;

/**
 * Created by saima_000 on 2/15/2017.
 */
public class SortedArrayIntersection {
    public static ArrayList<Integer> intersect(int[] arr1, int[] arr2) {
        int i=0, j=0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        while(i < arr1.length && j < arr2.length) {
            if(arr1[i] < arr2[j]) {
                i++;
            }
            else if(arr1[i] > arr2[j]) {
                j++;
            }
            else{
                if(list.isEmpty() || (list.get(list.size() - 1) != arr1[i]))
                    list.add(arr1[i]);
                i++;
                j++;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 3, 3, 5, 5, 6, 7, 7, 8, 12}, arr2 = {5, 5, 6, 8, 8, 9, 10, 10};
        ArrayList<Integer> list = intersect(arr1, arr2);
        for(int i=0;i<list.size();i++) {
            System.out.print(list.get(i) + "    ");
        }
    }
}
