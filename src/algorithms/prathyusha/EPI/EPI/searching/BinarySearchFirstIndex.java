package searching;

import java.util.ArrayList;
import java.util.Arrays;

public class BinarySearchFirstIndex {
	
	public static void main(String[] args) {
		ArrayList<Integer> array = new ArrayList<Integer>();
		array.addAll(Arrays.asList(1,2,3,3,3,3,3,4,4,4,4,4,5,6,7,8,9,10));
	  	System.out.print("index is " + binarySearchRec(array, 4, 0, array.size()-1));
	  	System.out.print("index is " + binarySearchItr(array, 4, 0, array.size()-1));
	}

	private static int binarySearchItr(ArrayList<Integer> array,int num, int left, int right) {
		if(array.get(right) < num && array.get(left) > num ) {
			return -1;
		}
		int savedIndex = -1;
		while(left <= right) {
			int mid = left + ((right - left)/2);
			if(array.get(mid) < num) {
				left = mid+1;
			}
			else if(array.get(mid) == num) {
				savedIndex = mid;
				right = mid-1;
			}
			else{
				right = mid - 1;
			}
		}
		return savedIndex;
	}

	private static int binarySearchRec(ArrayList<Integer> array, int num, int left, int right) {
		int index = -1;
		if(left == right) {
			return (array.get(left) == num)?left:index;
		}
		if(array.get(right) < num ) {
			return index;
		}
		if(array.get(left) > num ) {
			return index;
		}
		if(left < right && left < array.size() && right < array.size()) {
			int mid = (left) + ((right - left)/2);
			if(array.get(mid) == num ) {
				index = binarySearchRec(array, num, left, mid);
			}
			else if(array.get(mid) < num ) {
				index = binarySearchRec(array, num, mid+1, right);
			}
			else {
				index = binarySearchRec(array, num, left, mid-1);
			}
		}
		return index;
	}
	
	
}
