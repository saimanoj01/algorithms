package algorithms.epi.strings;

/**
 * Created by saima_000 on 2/24/2017.
 */
public class PhoneMnemonic {
    private static final String[] MAPPING = {"0", "1", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};

    public static void phoneMnemonic(int[] data, int index, char[] output, int outputIndex) {
        if(index == data.length) {
            for(int i=0;i<outputIndex;i++) {
                System.out.print(output[i] + "  ");
            }
            System.out.println();
            return;
        }

        String chars = MAPPING[data[index]];
        for(int i=0;i<chars.length();i++) {
            output[outputIndex] = chars.charAt(i);
            phoneMnemonic(data, index + 1, output, outputIndex + 1);
        }
    }


    public static void main(String[] args) {
        int[] data = new int[]{2,2,7,6,6,9,6};
        char[] output = new char[256];
        phoneMnemonic(data, 0, output, 0);
    }
}
