package algorithms.bst;

import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created by saima_000 on 2/25/2017.
 *
 * https://www.hackerrank.com/contests/visa-codesprint/challenges/fee-queries
 */
public class FeeQueries {
    public class Node {
        int no;
        int fee;

        public Node(int no, int fee) {
            this.no = no;
            this.fee = fee;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int no_of_shops = in.nextInt(), no_of_queries = in.nextInt();
        TreeSet<Node> set = new TreeSet();
    }
}
