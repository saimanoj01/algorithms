package algorithms.dp;

/**
 * Created by saima_000 on 9/25/2016.
 */
public class Partition {
    private static boolean partition(int[] data, int index, int size) {
        if(size == 0) {
            return true;
        }
        if(size < 0)
            return false;
        if(index >= data.length)
            return false;
        return partition(data, index+1, size) || partition(data, index+1, size-data[index]);
    }

    public static void main(String[] args) {
        int[] input = {1, 5, 11, 5};
        int size = 0;
        for(int i=0;i<input.length;i++) {
            size = size + input[i];
        }
        if(size % 2 != 0)
            System.out.println(false);
        else
            System.out.println(partition(input, 0, size/2));
    }
}
