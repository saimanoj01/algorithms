import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class TestMain {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int numProcess=scan.nextInt();
		int memNum=scan.nextInt();
		int duration[]=new int[numProcess];
		int memory[]=new int[numProcess];
		for (int i=0;i<numProcess;i++) {
			duration[i]=scan.nextInt();
			memory[i]=scan .nextInt();
		}
		PQsort comp=new PQsort();
		PriorityQueue<Process> pq=new PriorityQueue<Process>(10, comp);
		int time=0;
		int remMem=memNum;
		for(int i=0;i<numProcess;i++){

            while(!(memory[i]<=remMem)){
				Process head=pq.remove();
				time=time+head.time;
				updateTime(head.time,pq);
				remMem=remMem+memory[head.processNo];
			}
            if(memory[i]<remMem){
				Process tempP=new Process();
				tempP.setTime(duration[i]);
				tempP.setProcessNo(i);
				pq.add(tempP);
            }
            int remTime=0;
            for (Process process : pq) {
				if(process.getTime()>remTime){
					remTime=process.getTime();
				}
			}
		}
	}
	
	private static void updateTime(int time, PriorityQueue<Process> pq) {
		for (Process process : pq) {
			process.setTime(process.getTime()-time);
		}
	}

	static class Process{
		int time,processNo;

		public int getTime() {
			return time;
		}

		public void setTime(int time) {
			this.time = time;
		}

		public int getProcessNo() {
			return processNo;
		}

		public void setProcessNo(int processNo) {
			this.processNo = processNo;
		}
		
	}
	 
	static class PQsort implements Comparator<Process>{
		@Override
		public int compare(Process one, Process two) {
			if(one.time<two.time){
				return -1;
			}
			else if(one.time>two.time){
				return 0;
			}
			else{
				return 0;
			}
		}
	}
}
