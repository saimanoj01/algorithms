package stacks;

import java.util.AbstractMap;
import java.util.Map.Entry;
import java.util.Stack;

//TODO : implement same with deque.
/* 
https://github.com/adnanaziz/epicode/blob/master/java/src/main/java/com/epi/StackWithMaxImproved.java 
Paste it in comments for the previous question
*/

public class MaxInStack {
		
	int elements[] = new int[1];
	
	int top = 0;
	
	Stack<Entry<Integer, Integer>> maxStack = new Stack<Entry<Integer, Integer>>();
	
	public int push ( int item ) {
		if ( top == elements.length ) {
			int tempArray[] = new int[2*(elements.length)];
			for ( int i =0; i < elements.length; i++ ) {
				tempArray[i] = elements[i];
			}
			elements = tempArray;
		}
		elements[top] = item;
		if ( (!maxStack.isEmpty()) && (maxStack.peek().getKey() == item ) ) {
			Entry<Integer, Integer> maxEntry = maxStack.pop();
			maxEntry.setValue(maxEntry.getValue()+1);
			maxStack.push(maxEntry);
		}
		else if ( maxStack.isEmpty() ||  ((!maxStack.isEmpty()) && (maxStack.peek().getKey() < item )) ) {
			Entry<Integer, Integer> maxEntry = new AbstractMap.SimpleEntry(item, 1);
			maxStack.push(maxEntry);
		}
		top++;
		return item;
	}
	
	public int size () {
		return top;
	}
	
	public int pop ( ) throws Exception {
		if ( top == 0 ) {
			throw new Exception("Stack is empty");
		}
		int item = elements[top-1];
		if ( (!maxStack.isEmpty()) && (maxStack.peek().getKey() == item ) ) {
			Entry<Integer, Integer> maxEntry = maxStack.pop();
			if ((maxEntry.getValue()-1) > 0) {
				maxEntry.setValue(maxEntry.getValue()-1);
				maxStack.push(maxEntry);
			}
		}
		top--;		
		return item;
	}
	
	public int max() throws Exception {
		if ( top == 0 ) {
			throw new Exception("Stack is empty");
		}
		return maxStack.peek().getKey();
	}
	
	public void print ( ) {
		System.out.print("[ ");
		for ( int i = 0 ; i < top ; i ++ ) {
			System.out.print(elements[i]+" ");
		}
		System.out.println("]");
	}
	
	public boolean isEmpty () {
		return (top==0);
	}
	
	public static void main(String[] args) throws Exception {
		MaxInStack max = new MaxInStack();
		int[] arr = {2,2,1,4,5,5,3};
		for ( int i = 0; i < arr.length ; i++ ) {
			System.out.println(max.push(arr[i])+" with max value : "+max.max());
		}
		for ( int i = 0; i < arr.length ; i++ ) {
			System.out.println(max.pop()+" element popped with max value : "+max.max());
		}
		//max.print();
	}
	
}
