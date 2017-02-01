package algorithms.epi.arrays;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by saima_000 on 1/31/2017.
 *
 * Tried to implement the same DutchNationalFlag algorithm again.
 */
public class DutchNationalFlag2 {
    public enum Color {
        RED("red"), WHITE("white"), BLUE("blue");
        String text;
        Color(String text) {
            this.text = text;
        }
        public String getText() {
            return text;
        }
    }

    static void partition(ArrayList<DutchNationalFlag2.Color> input) {
        int red = 0, white = 0, blue = input.size() - 1;
        while(white <= blue) {
            if(input.get(white) == DutchNationalFlag2.Color.RED) {
                Collections.swap(input, red, white);
                red++;
                white++;
            }
            else if(input.get(white) == DutchNationalFlag2.Color.WHITE) {
                white++;
            }
            else {
                Collections.swap(input, white, blue);
                blue--;
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<DutchNationalFlag2.Color> list = new ArrayList<DutchNationalFlag2.Color>();
        list.add(DutchNationalFlag2.Color.WHITE);
        list.add(DutchNationalFlag2.Color.BLUE);
        list.add(DutchNationalFlag2.Color.WHITE);
        list.add(DutchNationalFlag2.Color.RED);
        list.add(DutchNationalFlag2.Color.RED);
        list.add(DutchNationalFlag2.Color.BLUE);
        list.add(DutchNationalFlag2.Color.RED);
        list.add(DutchNationalFlag2.Color.WHITE);
        list.add(DutchNationalFlag2.Color.BLUE);
        list.add(DutchNationalFlag2.Color.WHITE);
        partition(list);
        for(DutchNationalFlag2.Color item : list) {
            System.out.print(item.getText() + " ");
        }
    }
}
