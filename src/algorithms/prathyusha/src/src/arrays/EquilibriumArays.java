package arrays;

public class EquilibriumArays {
	 public int solution(int[] A) {
	        // write your code in Java SE 8
	        int lsum = 0, rsum = 0;
	        for ( int i=0; i< A.length ; i++) {
	            rsum = rsum + A[i];
	        }
	        if (rsum - A[0] ==0)    return 0;
	        else if (rsum - A[A.length-1] ==0) return (A.length-1);
	        for ( int i = 1; i< A.length-1 ; i++ ) {
	            lsum = lsum + A[i-1];
	            rsum = rsum - A[i];
	            if (lsum == rsum) return i;
	        }
	        return -1;
	    }
}
