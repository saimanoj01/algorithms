package arrays;

public class EvenOddPartitionSol1 {
	public static void main(String[] args) {
		int arr[]={13,24,15,23,35,34,23,23,23,12};
		int evenPtr=0, oddPtr=9; //even pointer set from the statrt && odd pointer to  the end
		while(evenPtr<=oddPtr){ // runs till even pointer is equal to odd pointer
			if(arr[evenPtr]%2==0){
				evenPtr++; // if even it remains in the same place
			}
			else{
				int temp=arr[oddPtr]; // if odd we swap it to the odd pointer place
				arr[oddPtr]=arr[evenPtr];
				arr[evenPtr]=temp;
				oddPtr--;
			}
		}// thus all evens accumulmate to the start and all odds acc to the end.
		for(int i=0;i<=9;i++){
			System.out.println(arr[i]);
		}
	}
}
