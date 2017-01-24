package algorithms;

import java.util.Arrays;

/**
 * Created by saima_000 on 10/22/2016.
 */
public class Permutation {
    private static void function(int a, int b, int c, int d) {
        int[] arr = {a, b, c, d};
        checkPermutation(arr, 0);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static boolean isValid(int[] arr) {
        int hours = arr[3] * 10 + arr[2];
        int minutes = arr[1] * 10 + arr[0];
        return (hours >= 0 && hours <= 23 && minutes >= 0 && minutes <= 59);
    }

    private static int[] max(int[] time1, int[] time2) {
        int hours1 = time1[3] * 10 + time1[2], minutes1 = time1[1] * 10 + time1[0];
        int hours2 = time2[3] * 10 + time2[2], minutes2 = time2[1] * 10 + time2[0];
        if(hours1 > hours2)
            return time1;
        else if(hours1 < hours2)
            return time2;
        else {
            if(minutes1 >= minutes2)
                return time1;
            else
                return time2;
        }
    }

    private static int[] MAX = {-1,-1,-1,-1};
    private static void checkPermutation(int[] arr, int no) {
        if(no == arr.length-1) {
            if(isValid(arr)) {
                int[] newMax = new int[4];
                System.arraycopy(max(MAX, arr),0,newMax,0,newMax.length);
                MAX = newMax;
            }
        }
        else {
            for(int i=no;i<arr.length;i++) {
                swap(arr, no, i);
                checkPermutation(arr, no+1);
                swap(arr, i, no);
            }
        }
    }

    public static void main(String[] args) {
        function(1,2,3,4);
        for(int i=0;i<4;i++)
            System.out.print(MAX[i] + " ");
    }
}
