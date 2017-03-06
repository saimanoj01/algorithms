package arrays;

import java.util.ArrayList;

public class MaxValidTime {
	public static void main(String[] args) {
		String time = "1719";
		int maxTime= 0;
		for ( int i=23; i>=0 ; i-- ) {
			int input = Integer.parseInt(time);
			ArrayList<Integer> list = new ArrayList<Integer>();
			for ( int in=time.length()-1; in>=0;in--){
				list.add(input%10);
				input=input/10;
			}
			if(list.contains(i/10) && list.contains(i%10)){
				list.remove(list.indexOf(i/10));
				if(!list.contains(i%10)){
					continue;
				}
				list.remove(list.indexOf(i%10));
				int var1=list.get(0)*10+list.get(1);
				int var2=list.get(0)+list.get(1)*10;
				if( var1 < 60 && var2<60 ){
					maxTime = i*100+ Math.max(var1,var2);
					break;
				}
				else if ( var2 < 60 )
				{
					maxTime = i*100+var2;
					break;
				}
				else if(var1 <60){
					maxTime = i*100+var1;
					break;
				}
			}
		} 
		System.out.println((maxTime==0) ? "Invalid input" : maxTime); 
		
	}
}
