package dp;

public class StairCaseProblem {
	public static void main(String[] args) {
		System.out.println(stairCase(3));
	}
	
	public static int stairCase( int num ) {
		int[] arr=new int[] {1,1,2};
		if ( num==0 ) {
			return 0;
		}
		for ( int i=3; i <= num; i++ ){
			arr[i%3] = arr[0] + arr[1] +arr[2];
		}
		return arr[num%3] ;
	}
}
