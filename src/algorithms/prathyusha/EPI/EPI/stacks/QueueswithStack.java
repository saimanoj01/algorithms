package stacks;

import java.util.Stack;

public class QueueswithStack {

	static Stack<Integer> stack1 = new Stack<Integer>();
	static Stack<Integer> stack2 = new Stack<Integer>();
	   
	public static void main(String[] args) {
		System.out.println(enqueue(1));
		System.out.println(enqueue(2));
		System.out.println(enqueue(3));
		System.out.println(enqueue(4));
		System.out.println(dequeue());
		System.out.println(dequeue());
		System.out.println(dequeue());
		System.out.println(dequeue());
	}
	
	public static boolean enqueue(int data){
	    return (stack1.push(data) == data) ? true : false;    
	}
	   
	public static int dequeue(){
	     if(!stack2.isEmpty()){
	          return stack2.pop();
	      } 
	      else{
	          int data;
	          while(!stack1.isEmpty()) {
	            data = stack1.pop();  
	            stack2.push(data);       
	          }
	          return stack2.pop();      
	      }  
	   }
	
}
