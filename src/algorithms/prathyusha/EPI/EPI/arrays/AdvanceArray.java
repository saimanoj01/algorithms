package arrays;

public class AdvanceArray {
	
	public static void main(String[] args) {
		int[] input = {3,2,0,0,2,0,1};
		System.out.println(advance(input));
	}
	
	//Advancing through an array

	 public static boolean advance(int[] input){
	     int numOfSteps = 0, totalSteps = input.length, maxDest = 0;
	     int[] result = new int[totalSteps];
	     if(totalSteps == 0) 
	         return true;
	     while(numOfSteps <= maxDest) {
	         maxDest = Math.max((numOfSteps + input[numOfSteps]), maxDest);
	         result[numOfSteps++] = maxDest;
	         if(maxDest >= totalSteps)
	                 return true;;
	     }
	     return false;   
	 
	 }
	 
}
