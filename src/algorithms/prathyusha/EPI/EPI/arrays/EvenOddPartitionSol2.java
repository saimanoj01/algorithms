package arrays;

public class EvenOddPartitionSol2 {
	public static void main(String[] args) {
		int arr[] = {13,24,15,23,35,34,23,23,23,12};
		int pointer = 0 , index = 0; //implementation-2 -> using a single pointer which is the end of even part
		for (; index < arr.length; index++){ //increments index
			if(arr[index] % 2 == 0){
				int temp = arr[pointer];
				arr[pointer] = arr[index];
				arr[index] = temp;
				pointer++;
			} //skip the odd parts and swap with the partition pointer if an even is found at the index.
		}
		for(int i = 0; i <= 9; i++){
			System.out.println(arr[i]);
		}
	}
}
