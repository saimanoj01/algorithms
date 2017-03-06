package sorting;

public class MergeSort {

	public static void main(String[] args) {
		int[] input = {5,4,3,2,1};
		int[] output = mergeSort(input);
		for (int i : output) {
			System.out.print(i+" ");
		}
	}
	public static int[] mergeSort(int[] input) {
	      return recMergeSort(input, 0 , input.length-1);
	   }
	   
	  public static int[] recMergeSort(int[] input, int startIndex, int endIndex){
	       int resultSize = (endIndex-startIndex+1);
	       int[] output = new int[resultSize];
	       if(startIndex == endIndex) {
	           output[0] = input[startIndex];
	           return output;
	       }
	       int mean = (endIndex-startIndex)/2, itr1 = startIndex, itr2 = itr1+mean+1 , resultPtr = 0;
	       int[] output1 = recMergeSort(input, itr1, itr1+mean);
	       int[] output2 = recMergeSort(input, itr2, endIndex);
	       int output1Size = output1.length, output2Size = output2.length;
	       //merging two arrays
	       itr1 = 0; itr2 = 0;
	       while(resultPtr < resultSize && itr1 < output1Size && itr2 < output2Size){
	           if(output1[itr1] <= output2[itr2])
	               output[resultPtr++] = output1[itr1++];
	           else
	               output[resultPtr++] = output2[itr2++];
	     }
	     while(itr1 < output1Size && resultPtr < resultSize){
	         output[resultPtr++] = output1[itr1++];
	     }
	      while(itr2 < output2Size && resultPtr < resultSize){
	         output[resultPtr++] = output2[itr2++];
	     }
	     return output;
	     
	          
	     
	   }
	   
	   
	   
}
