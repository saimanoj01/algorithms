package algorithms.epi.arrays;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by saima_000 on 2/16/2017.
 */
public class PlusOne2 {
    public static ArrayList<Integer> plusOne(ArrayList<Integer> input) {
        int i = input.size() - 1;
        while(i != -1 && input.get(i) == 9) {
            input.set(i, 0);
            i--;
        }

        if(i != -1) {
            input.set(i, input.get(i) + 1);
        }
        else {
            input.add(0, 1);
        }
        return input;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.addAll(Arrays.asList(2 , 2, 9, 9));
        list = plusOne(list);
        for(int i=0;i<list.size();i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
