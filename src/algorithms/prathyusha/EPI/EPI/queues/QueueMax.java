package queues;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueMax {
	//max in queue
	// using dequeue - if new element comes-  first time- if queue is empty add element as max
	//- any element enters - if element is less than max put the element
	// when new element is greater than latest element added as max - delete the elements less than current elementt
	
	public static void main(String[] args) {
		Que q = new Que();
		System.out.println(q.push(5));
		System.out.println(q.push(4));
		System.out.println(q.push(11));
		System.out.println("max is :"+q.max());
		System.out.println(q.push(0));
		System.out.println("max is :"+q.max());
		System.out.println(q.push(1));
		System.out.println("max is :"+q.max());
		System.out.println(q.push(9));
		System.out.println("max is :"+q.max());
		q.pop();
		q.pop();
		q.pop();
		q.pop();
		System.out.println("max is :"+q.max());
		q.pop();
		System.out.println("max is :"+q.max());
	}

	    public static class Que {
	    
	        Queue<Integer> q = new LinkedList<Integer>();
	        Deque<Integer> maxq = new LinkedList<Integer>();
	        
	        boolean push(int data) {
	            if(maxq.size() == 0) {
	                maxq.addFirst(data);            
	            }
	            else{
	                if(data <= maxq.getLast()){
	                  maxq.addLast(data);
	                }
	                else{
	                    while (maxq.size() > 0 && data > maxq.getLast()){
	                        int queueData = maxq.removeLast();
	                    }
	                    maxq.addLast(data);                    
	                }
	            }
	            return q.add(data);
	        }
	        
	        int pop(){
	            int data =  q.remove();
	            if(maxq.getFirst() == data){
	                maxq.removeFirst();
	            }
	            return data;
	        }
	        
	        int max(){
	            if(maxq.size() != 0) {
	                return maxq.getFirst();            
	            }
	            return -1;
	        }
	             
	   
	   
	   }
	    
}
