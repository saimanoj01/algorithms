package arrays;

public class KSumInArray {
	public static void main(String[] args) {
		int[] arr=new int[]{1,1,2,2,3,3,4,4,5,5};
		int startPointer = 0, endPointer = arr.length-1, value = arr[0] , k=6, count = 0;
		while ( startPointer < endPointer ) {
			if ( arr[endPointer] == k-arr[startPointer] ){
				count++;
				startPointer++;
			}
			else if ( arr[endPointer] < k-arr[startPointer] ) {
				startPointer++;
			}
			else {
				endPointer--;
			}
		}
		System.out.println(count);
		System.out.println(1.2%1==0);
	}
}
