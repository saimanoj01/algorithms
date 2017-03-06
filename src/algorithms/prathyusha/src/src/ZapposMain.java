
public class ZapposMain {
	public static void main(String[] args) {
		String input = "43597658" ;
		int remove = 2;
		System.out.println(getMinOutput(input,0, remove)) ;
	}

	private static String getMinOutput(String input, int start,int remove) {
		StringBuilder output = new StringBuilder();
		int desiredOutputLen = input.length()-remove;
		if( !(remove >= input.length())) {
			while(start < input.length() && desiredOutputLen != 0) {
				int end = input.length()-desiredOutputLen;
				start = findMinimumIndex(input,start,end);
				output = output.append(input.charAt(start));
				start = start + 1;
				desiredOutputLen--;
			}
			return output.toString();
		}
		else{
			return "0";
		}
		
	}

	private static int findMinimumIndex(String input, int start, int end) {
		int minimum = Integer.MAX_VALUE;
		int minIndex = start;
		while(start <= end){
			if(minimum > input.charAt(start) - (int)'0') {
				minimum = input.charAt(start) - (int)'0';
				minIndex = start;
			}
			start++;
		}
		return minIndex;
	}
}
