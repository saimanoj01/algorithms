package algorithms.epi.search;

/**
 * Created by saima_000 on 2/14/2017.
 */
public class BinarySearchFirstIndex {
    public static int binarySearchRecursive(int[] input, int start, int end, int k) {
        if(start > end)
            return -1;
        else if(start == end) {
            if(input[start] == k)
                return start;
            else
                return -1;
        }
        int middle = start + (end - start)/2;
        if(input[middle] < k) {
            start = middle + 1;
        }
        else if(input[middle] > k) {
            end = middle - 1;
        }
        else {
            end = middle;
        }
        return binarySearchRecursive(input, start, end, k);
    }

    public static int binarySearch(int[] input, int start, int end, int k) {
        int index = -1;
        while(start <= end) {
            int middle = start + (end - start)/2;
            if(input[middle] < k) {
                start = middle + 1;
            }
            else if(input[middle] > k) {
                end = middle - 1;
            }
            else {
                end = middle;
                index = middle;
            }
            if(start == end)
                break;
        }
        return index;
    }
    public static void main(String[] args) {
        int[] input = {1,2,3,4,5};
        System.out.println(binarySearchRecursive(input, 0, input.length-1, 4));
    }
}
