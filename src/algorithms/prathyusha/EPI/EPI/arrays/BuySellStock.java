package arrays;

public class BuySellStock {
	//https://www.google.com/url?q=https%3A%2F%2Fgithub.com%2Fadnanaziz%2Fepicode%2Ftree%2Fmaster%2Fjava%2Fsrc%2Fmain%2Fjava%2Fcom%2Fepi&sa=D&sntz=1&usg=AFQjCNEVATad_7rvE3Zw5YLNJBbgdpfFcg
	public static void main(String[] args) {
		int arr[] = { 310, 315, 275, 295, 260, 270, 290, 230, 255, 250};
		//sol1-- at any i-> check if it is less than min Var -> if less -> update minVar;
		// if the ith element is  greater than minVar then check if greater than count.
		// if greater than count then update count;
		/*int minVar = arr[0], count = 0;
		for(int i = 1; i< arr.length; i++) {
			int diff = arr[i] - minVar;
			if(count < diff){
				count = diff;
			}
			else if (diff < 0){
				minVar = arr[i];
			}
		}
		System.out.println(count);*/
		//sol2
		int minPrice = arr[0] , maxProfit = 0;
		for ( int i = 1; i < arr.length; i++) {
			maxProfit = Math.max( maxProfit, arr[i] - minPrice);
			minPrice = Math.min( minPrice , arr[i]);
		}
		System.out.println(maxProfit);
	}
}
