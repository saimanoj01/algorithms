package algorithms.epi.arrays;

/**
 * Created by saima_000 on 1/31/2017.
 *
 * Different approach of partitioning than what is implemented in 'EvenOddPartition'
 */
public class EvenOddPartition2 {
    static void evenOdd(int[] input) {
        int partition = 0;
        for(int i=0;i<input.length;i++) {
            if(input[i] % 2 == 0) {
                int temp = input[partition];
                input[partition++] = input[i];
                input[i] = temp;
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
