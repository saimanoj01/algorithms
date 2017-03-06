package arrays;

public class DeleteDuplicates {
	public static void main(String[] args) {
		int[] a = {2,3,5,5,7,11,11,11,13};
		/*int current = 1, result = 0;
		while(current < a.length) {
			if(a[current] != a[result]){
				a[++result] = a[current];
			}
				current++;
		}
		for(int i = result+1 ; i < a.length; i++) {
			a[i] = 0;
		}
		for (int i : a) {
			System.out.print(i+" ");
		}*/
		
		int end = deleteDuplicates(a);
		for(int i = 0; i <= end; i++){
			System.out.print(a[i]+" ");
		}
		
	}
	
	public static int deleteDuplicates(int[] input){
		 if(input.length == 0) {
	          return -1;
	      }
	      int uniquePtr = 0, currentPtr = 1, size = input.length;
	      while( currentPtr < size ) {
	          if( input[currentPtr] != input[uniquePtr] ) {
	              input[++uniquePtr] = input[currentPtr];
	          }
	          currentPtr++;
	      
	      }
	      return uniquePtr;
	  }
}
