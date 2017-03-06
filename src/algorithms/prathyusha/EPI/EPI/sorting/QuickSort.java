package sorting;

public class QuickSort {
	public static void main(String[] args) {
		int[] input = {5,4,3,2,1};
		quickSort(input);
		for (int i : input) {
			System.out.print(i+" ");
		}
	}
	
	 //quick sort 
	 
	 //1. sselect pivot element and store it temp
	 //2. use 2 pointers - move lesser elements to the front, 3. greater to right
	 // recsort of the individual pieces 
	 // insert equal pieces -output
	 
	   public static void quickSort( int[] input){
	       quicksort(input, 0, input.length-1);
	   }
	   
	   public static void quicksort(int[] input, int start, int end) {
	       if(end < start)
	           return;
	       if(start == end) {
	           return;       
	       }
	       int pivot = input[start];
	       int headPtr = start, tailPtr = end, itr = start;
	       while(headPtr < tailPtr) {
	           if(input[itr] < pivot){
	               input[headPtr++] = input[itr++];
	           }
	           else if (input[itr] > pivot) {
	               input[tailPtr--] = input[itr++];
	           }
	           else{
	        	   itr++;
	           }
	       }
	       
	       quicksort(input, start, headPtr-1);
	       quicksort(input, tailPtr+1, end);
	       while(headPtr <= tailPtr) {
	           input[headPtr++] = pivot;
	       }
	       return;
	       
	   }
}
