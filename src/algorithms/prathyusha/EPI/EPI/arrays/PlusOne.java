package arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class PlusOne {
	public static void main(String[] args) {
		ArrayList<Integer> array = new ArrayList<Integer>();
		array.addAll(Arrays.asList(9,2));
		int lastIndex = array.size()-1;
		while (lastIndex >= 0 && array.get(lastIndex) == 9) {
				array.set(lastIndex, 0);
				lastIndex--;
		}
		if(lastIndex != -1) 
			array.set(lastIndex, array.get(lastIndex)+1);
		else
			array.add(0,1);
		for(int index=0; index < array.size();index++) {
			System.out.print(array.get(index)+" ");
		}
	}
}
