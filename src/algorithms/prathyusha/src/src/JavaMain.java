//import java.util.Calendar;
import java.util.Scanner;

public class JavaMain {
	
	 public static void main(String[] args) {
		 	//Calendar currentyr=Calendar.getInstance();
	        //Long startTime=currentyr.getTimeInMillis();
	     
		 /*Scanner in = new Scanner(System.in);
	     int arr[][] = new int[6][6];
	     for(int i=0; i < 6; i++){
	       for(int j=0; j < 6; j++){
	          arr[i][j] = in.nextInt();
	       }
	     }*/
	 
	       /* Runtime runtime = Runtime.getRuntime();
	        // Run the garbage collector
	        runtime.gc();
	        // Calculate the used memory
	        long memory = runtime.totalMemory() - runtime.freeMemory();
	        System.out.println("Used memory is bytes: " + memory);
	        System.out.println("Time Taken: "+(endTime-startTime));*/
		/* int coordinates[][]=new int[3][2];
		 Scanner stdin = new Scanner(System.in);
	       while(stdin.hasNextLine()) 
	       {
	    	   for(int i=0;i<3;i++){
	    		   coordinates[i][0]=stdin.nextInt();
	    		   coordinates[i][1]=stdin.nextInt();
	    	   }
	       }
	       stdin.close();*/
		 Scanner stdin = new Scanner(System.in);
		 int price=stdin.nextInt();
		 int numWrappers=stdin.nextInt();
		 int noOfPpl=stdin.nextInt();
		 int amountPPL[]=new int[noOfPpl];
	       for(int i=0;i<noOfPpl;i++){
	    	   amountPPL[i]=stdin.nextInt();
	       }
	       stdin.close();
	       for(int i=0;i<noOfPpl;i++){
	    	   int chocsBought=(amountPPL[i]/price);
	    	   int x=chocsBought/numWrappers;
	    	   int wrappers=(chocsBought/numWrappers)+(chocsBought%numWrappers);
	    	   System.out.println(chocsBought+wrappers+getChocLeft(wrappers, numWrappers));
	       }       
	       
	       
	 }

	private static int getChocLeft(int wrappers, int numWrappers) {
		if(wrappers<numWrappers){
			return 0;
		}
		else if (wrappers==numWrappers){
			return 1;
		}
		else{
			int x=wrappers/numWrappers;
			System.out.println("wrappers "+wrappers);
			wrappers=(wrappers/numWrappers)+(wrappers%numWrappers);
			wrappers=(wrappers/numWrappers)+getChocLeft(wrappers, numWrappers);
			System.out.println(wrappers);
		}
		return wrappers;
	}
}




