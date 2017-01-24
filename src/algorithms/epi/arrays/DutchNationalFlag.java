package algorithms.epi.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by saima_000 on 12/19/2016.
 *
 * https://github.com/adnanaziz/epicode/blob/master/java/src/main/java/com/epi/DutchNationalFlag.java
 */
public class DutchNationalFlag {
    // Colors in Dutch national flag.
    public static enum Color {
        RED, WHITE, BLUE
    }

    // Method which does the Dutch Flag Partition.
    private static void dutchFlagPartition(List<Color> list, Color pivot) {
        int middle = 0, unclassified_start = 0, unclassfied_end = list.size()-1;
        while(unclassified_start <= unclassfied_end) {
            Color color = list.get(unclassified_start);
            if(color.ordinal() < pivot.ordinal()) {
                Collections.swap(list, middle++, unclassified_start++);
            }
            else if(color.ordinal() == pivot.ordinal()) {
                unclassified_start++;
            }
            else {
                Collections.swap(list, unclassified_start, unclassfied_end--);
            }
        }
    }

    // Randomly generated input.
    private static List<Color> randArray(int size) {
        List<Color> list = new ArrayList<Color>();
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            list.add(Color.values()[rand.nextInt(3)]);
        }
        return list;
    }

    public static void main(String[] args) {
        int size = 1000;
        List<Color> list = randArray(size);
        Color pivot = Color.WHITE;
        dutchFlagPartition(list, pivot);
        int i = 0;
        while (i < size && list.get(i).ordinal() < pivot.ordinal()) {
            System.out.print(list.get(i) + " ");
            i++;
        }

        while (i < size && list.get(i).ordinal() == pivot.ordinal()) {
            System.out.print(list.get(i) + " ");
            i++;
        }

        while (i < size && list.get(i).ordinal() > pivot.ordinal()) {
            System.out.print(list.get(i) + " ");
            i++;
        }

        assert (i == size);
    }
}
