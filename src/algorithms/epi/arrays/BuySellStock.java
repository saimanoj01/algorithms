package algorithms.epi.arrays;

/**
 * Created by saima_000 on 1/31/2017.
 *
 * https://github.com/adnanaziz/epicode/blob/master/java/src/main/java/com/epi/BuyAndSellStock.java
 * Given stock prices, calculate the max profit which can be obtained.
 *
 * For the following example: Max profit obtained 290-260 = 30
 */
public class BuySellStock {
    public static void main(String[] args) {
        int[] arr = new int[]{310, 315, 275, 295, 260, 270, 290, 230, 255, 250};
        int max = 0;
        int min_stock = arr[0];
        for(int i = 1; i < arr.length; i++) {
            max = Math.max(max, arr[i] - min_stock);
            min_stock = Math.min(arr[i], min_stock);
        }
        System.out.print(max);
    }
}
