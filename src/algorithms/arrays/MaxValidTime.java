package algorithms.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by saima_000 on 2/1/2017.
 *
 * LiveRamp coding challenge
 */
public class MaxValidTime {
    public static void main(String[] args) {
        String input = "1832";
        int maxTime = -1;
        for(int i=23;i>=0;i--) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(int j=0;j<input.length();j++) {
                list.add(input.charAt(j) - (int)'0');
            }

            if(list.contains(i/10) && list.contains(i%10)) {
                list.remove(list.indexOf(i/10));
                if(!list.contains(i%10))
                    continue;
                list.remove(list.indexOf(i%10));
                int min = list.get(0) * 10 + list.get(1);
                if(min < 60) {
                    maxTime = Math.max(maxTime, i * 100 + min);
                }
                min = list.get(1) * 10 + list.get(0);
                if(min < 60) {
                    maxTime = Math.max(maxTime, i * 100 + min);
                }
            }
        }
        System.out.println(maxTime);
    }
}
