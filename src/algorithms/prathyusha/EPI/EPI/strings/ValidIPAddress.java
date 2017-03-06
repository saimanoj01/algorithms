package strings;

public class ValidIPAddress {
	
	public static void main(String[] args) {
		validIpAddresses("192121314");
	}
	
	//valid ip address
	// take first digit and append . -> send the result string and startindex and input string,count
	//take 2 digits and repeat the same
	//take 3 digits and see if the number is less than 255.

	  static  void validIpAddresses( String input ) {
	    	validIPAdresses(input, new StringBuilder(), 0, 0);
	    }
	    
	   static void validIPAdresses( String input, StringBuilder result, int startIndex, int count) {
	        if(count == 4) {
	            System.out.print("IP Address : "+result);
	            System.out.println();
	            return;
	        }
	        //case 1
	        
	        result.append(input.charAt(startIndex));
	        result.append(".");
	        validIPAdresses(input,result,startIndex+1,count+1);
	        result.delete(result.length()-2,result.length());
	        
	        //case 2
	        if((startIndex+1+3-count) < input.length()){
	        	System.out.println("added "+input.charAt(startIndex)+input.charAt(startIndex+1)+".");
	            result.append(input.charAt(startIndex));
	            result.append(input.charAt(startIndex+1));
	            result.append(".");
	            validIPAdresses(input,result,startIndex+2,count+1);
	            result.delete(result.length()-3,result.length());
	        }
	        
	         //case 3
	         if((startIndex+2+3-count) < input.length()){
	         if(( (input.charAt(startIndex)-(int)'0')*100+(input.charAt(startIndex+1)-(int)'0')*10+(input.charAt(startIndex+2)-(int)'0')) <= 255 ){ 
	             result.append(input.charAt(startIndex));
	             result.append(input.charAt(startIndex+1));
	             result.append(input.charAt(startIndex+2));
	             result.append(".");
	             validIPAdresses(input,result,startIndex+3,count+1);
	             result.delete(result.length()-4,result.length());
	         
	         }
	         }
	        
	        
	        return;
	    
	    }
}
