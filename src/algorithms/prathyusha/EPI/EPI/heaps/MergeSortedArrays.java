package heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeSortedArrays {
	
	static class ArrayEntry {
		int value;
		int arrayIndex;
		int arrayId;
		
		public ArrayEntry(int value, int arrayIndex, int arrayId) {
			this.value = value;
			this.arrayIndex = arrayIndex;
			this.arrayId = arrayId;
		}
		
	}
	
	public static void main(String[] args) {
		int arrayOne[] = {1,2,3,4,5};
		int arrayTwo[] = {2,3,4,20};
		int arrayThree[] = {6,7,8,9};
		int arrayFour[] = {10,11,12,13};
		int arrayFive[] = {13,14,15,16};
		ArrayList<int[]> arrayList = new ArrayList<int[]>(){ {
			add(arrayOne);
			add(arrayTwo);
			add(arrayThree);
			add(arrayFour);
			add(arrayFive);
		}
		};
		int arraySize = 5;
		int sortedArraySize = 0;
		PriorityQueue<ArrayEntry> heap = new PriorityQueue<>(arraySize, new Comparator<ArrayEntry>() {

			@Override
			public int compare(ArrayEntry e1, ArrayEntry e2) {
				return (Integer.compare(e1.value,e2.value));
			}
		});
		for (int i=0; i < arraySize; i++){
			if (arrayList.get(i).length != 0) {
				sortedArraySize+= arrayList.get(i).length;
				heap.add(new ArrayEntry(arrayList.get(i)[0], 1, i));
			}
		}
		int[] sortedArray = new int[sortedArraySize];
		int index = 0;
		while(! heap.isEmpty()){
			ArrayEntry temp = heap.poll();
			sortedArray[index++] = temp.value;
			int array[] = arrayList.get(temp.arrayId);
			if(!(array.length == temp.arrayIndex))
				heap.add(new ArrayEntry(array[temp.arrayIndex], ++temp.arrayIndex, temp.arrayId));
		}
		for(int i=0;i<sortedArray.length;i++){
			System.out.print(sortedArray[i]+" ");
		}
		
	}
}
