package primitiveTypes;

public class BitMultiplication {
	
	public static void main(String[] args) {
		System.out.println(bitMultiplication(12, 6));
	}
	
	
	 static int bitMultiplication(int x, int y){
	     //get set bits in y and  shift x with index and add to result
	     int setIndex = -1, result = 0;
	     while(y != 0){
	         setIndex++;
	         if((y & 1) == 1){
	             result = add(result , x<<setIndex);
	         }
	         y>>>=1;
	     }
	     return result;
	 }
	 
	 static int add(int num1, int num2) {
	     int sum = 0,  prevCarry = 0, sumbits, count = 0;
	     while(num1 != 0 || num2 != 0){
	         sumbits = (num1 & 1) ^ (num2 & 1);
	         sumbits ^= prevCarry ;
	         prevCarry = ((num1 & 1) & prevCarry) | ((num2 & 1) & prevCarry) | ((num2 & 1) & (num1 & 1));
	         prevCarry<<=1;
	         sumbits <<= count;
	         count++;
	         sum = sum | sumbits;
	         num1 >>>= 1;
	         num2 >>>= 1;
	     
	     }
		return sum;
	 
	 
	 
	 }
	 
	 
}
