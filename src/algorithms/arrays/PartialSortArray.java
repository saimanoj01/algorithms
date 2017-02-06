package algorithms.arrays;

/**
 * Created by saima_000 on 2/1/2017.
 */
public class PartialSortArray {
    public static void main(String[] args) {
        //int[] input = {43, 44, 45, 68, 69, 46, 97, 98, 88, 89, 99, 100};
        int[] input = {1, 2, 3, 4, 5, 8, 7, 6, 9, 10};
        int start = 0;
        while(start+1 < input.length && input[start] < input[start+1]) {
            start++;
        }

        int end = input.length - 1;
        while(end - 1 >= 0 && input[end] > input[end - 1]) {
            end--;
        }

        if(start > end) {
            return;
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i = start; i <= end; i++) {
            max = Math.max(max, input[i]);
            min = Math.min(min, input[i]);
        }

        start = 0;
        while(input[start] < min) {
            start++;
        }

        end = input.length - 1;
        while(input[end] > max) {
            end--;
        }

        System.out.println(start + " " + end);
    }
}
