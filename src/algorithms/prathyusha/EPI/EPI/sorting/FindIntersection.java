package sorting;

import java.util.ArrayList;

public class FindIntersection {

	public static void main(String[] args) {
		int[] arrayOne = {2,3,3,5,5,6,7,7,8,9,12};
		int[] arrayTwo = {5,5,6,8,8,9,10,10};
		int firstHead = 0, secondHead = 0;
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		while( (firstHead < arrayOne.length)  && (secondHead < arrayTwo.length)) {
			if(arrayOne[firstHead] == arrayTwo[secondHead]) {
				if(!(!arrayList.isEmpty() && arrayList.get(arrayList.size()-1)==arrayOne[firstHead]))
					arrayList.add(arrayOne[firstHead]);
				firstHead++;secondHead++;					
			}
			else if(arrayOne[firstHead] < arrayTwo[secondHead]) {
				firstHead++;
			}
			else {
				secondHead++;
			}
		}
		for (Integer integer : arrayList) {
			System.out.print(integer+" ");
		}
	}
	
}
