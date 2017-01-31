package algorithms.epi.arrays;

import java.util.Arrays;

/**
 * Created by saima_000 on 1/31/2017.
 * Sample problem given in the arrays section of Elements of programming interview.
 */
public class EvenOddPartition {
    static void evenOdd(int[] input) {
        // if input is null or empty or it contains just one element.
        if (input == null || input.length <= 1) {
            return;
        }
        // start -> start of the unseen array, all the elements before start should be maintained to be even.
        // end   -> end of the unseen array, all the elements after end should be maintained to be odd.
        int start = 0, end = input.length - 1;
        while (start < end) {
            // if the number under consideration is odd -> move it to the end of the array.
            if (input[start] % 2 != 0) {
                // swap elements of start and end.
                int temp = input[start];
                input[start] = input[end];
                input[end--] = temp;
            } else {
                // Just increment the 'start' pointer as the element at 'start' is already even.
                start++;
            }
        }
    }

    public static void main(String[] args) {
        int[] input = new int[]{32, 67, 99, 100, 107, 109, 108, 36, 4};
        evenOdd(input);
        for (int i : input)
            System.out.print(i + " ");
    }
}
