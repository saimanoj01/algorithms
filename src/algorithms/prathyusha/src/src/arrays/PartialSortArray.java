package arrays;

public class PartialSortArray {
	public static void main(String[] args) {
		int arr[] = new int[] {1,2,3,4,5,6};
		int head = 0 , tail = arr.length-1;
		while ( head+1 < arr.length ) {
			if ( arr[head+1] > arr[head] ) 	head++;
			else break;
		}
		while ( tail-1 >= 0 ) {
			if ( arr[tail-1] < arr[tail] ) tail--;
			else break;
		}
		int minValue = arr[head], maxValue = 0;
		for ( int index = head; index <= tail ; index++ ) {
			minValue = Math.min(minValue, arr[index]);
			maxValue = Math.max(maxValue, arr[index]);
		}
		while ( head>0 && arr[head-1] > minValue ) head--;
		while ( tail<arr.length-1 && arr[tail+1] < maxValue ) tail++;
		for ( int index = head; index <= tail ; index++) {
			System.out.print(arr[index]+" ");
		}
	}
}
