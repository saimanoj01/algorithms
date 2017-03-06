package algorithms;

/**
 * Created by saima_000 on 2/23/2017.
 */
public class Test {
    public static void main(String[] args) {
        int i = 5;
        i=i << 31;
        System.out.println(i );
        System.out.println(i << 3);
        i = 5;
        i=i << 35;
        System.out.println(i );
        int j = 5;
        System.out.println(i << 34);
        System.out.println(Integer.MIN_VALUE);
    }
}
