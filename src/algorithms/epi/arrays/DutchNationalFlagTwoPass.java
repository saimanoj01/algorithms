package algorithms.epi.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by saima_000 on 12/19/2016.
 *
 * https://github.com/adnanaziz/epicode/blob/master/java/src/main/java/com/epi/DutchNationalFlagTwoPasses.java
 */
public class DutchNationalFlagTwoPass {
    // Colors in Dutch national flag.
    public static enum Color {
        RED, WHITE, BLUE
    }

    // Method which does the Dutch Flag Partition.
    private static void dutchFlagPartition(List<Color> list, Color pivot) {
        // First Pass
        int smaller = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).ordinal() < pivot.ordinal()) {
                Collections.swap(list, smaller++, i);
            }
        }

        // Second pass
        int larger = list.size() - 1;
        for (int i = list.size() - 1; i > 0 && list.get(i).ordinal() >= pivot.ordinal(); i--) {
            if (list.get(i).ordinal() > pivot.ordinal()) {
                Collections.swap(list, larger--, i);
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
