package algorithms.epi.arrays;

/**
 * Created by saima_000 on 2/23/2017.
 */
public class DeleteDuplicates {
    public static void deleteDuplicates(int[] data) {
        int current = 0, result = 0;
        while(current < data.length) {
            while(current+1 < data.length && data[current] == data[current + 1]) {
                current++;
            }
            data[result++] = data[current++];
        }

        for(int i=result;i<data.length;i++)
            data[i] = 0;
    }
    public static void main(String[] args) {
        int[] data = new int[] {2, 3, 5, 5, 7, 11, 11, 11, 13, 13};
        deleteDuplicates(data);
        for(int i=0;i<data.length;i++)
            System.out.print(data[i] + "    ");
    }
}
