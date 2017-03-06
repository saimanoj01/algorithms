package heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class MinSumOfTwoConsecArray {
	
	public static void main(String[] args) {
		ArrayList<Integer> array = new ArrayList<Integer>();
		array.addAll(Arrays.asList(3,4,7,6,1));
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>();;
		heap.addAll(array);
		while(!(heap.size() < 2)) {
			int a = heap.poll();
			int b = heap.poll();
			int sum = a+b;
			heap.add(sum);
			if(heap.size() == 1) {
				break;
			}
		}
		System.out.print("Sum is "+heap.poll());
	}
	
}
