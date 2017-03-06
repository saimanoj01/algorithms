package arrays;
import java.util.ArrayList;

public class EPI_DutchNationalFlagSol1 {
	
	 public enum Color {
	        RED("red"), WHITE("white"), BLUE("blue");
	        String text;
	        Color(String text) {
	            this.text = text;
	        }
	        public String getText() {
	            return text;
	        }
	    }

	    static void partition(ArrayList<EPI_DutchNationalFlagSol1.Color> input) {
	    	int redIndex = 0 , blueIndex = input.size()-1;
	    	for (int i = redIndex; i <= blueIndex; i++) {
				if(input.get(i).equals(EPI_DutchNationalFlagSol1.Color.RED)){
					input.set(i, input.get(redIndex));
					input.set(redIndex, EPI_DutchNationalFlagSol1.Color.RED);
					redIndex++;
				}
				else if(input.get(i).equals(EPI_DutchNationalFlagSol1.Color.BLUE)){
					input.set(i, input.get(blueIndex));
					input.set(blueIndex, EPI_DutchNationalFlagSol1.Color.BLUE);
					blueIndex--;
					i--;
				}
			}
	    }

	    public static void main(String[] args) {
	        ArrayList<EPI_DutchNationalFlagSol1.Color> list = new ArrayList<EPI_DutchNationalFlagSol1.Color>();
	        list.add(EPI_DutchNationalFlagSol1.Color.WHITE);
	        list.add(EPI_DutchNationalFlagSol1.Color.BLUE);
	        list.add(EPI_DutchNationalFlagSol1.Color.WHITE);
	        list.add(EPI_DutchNationalFlagSol1.Color.RED);
	        list.add(EPI_DutchNationalFlagSol1.Color.RED);
	        list.add(EPI_DutchNationalFlagSol1.Color.BLUE);
	        list.add(EPI_DutchNationalFlagSol1.Color.RED);
	        list.add(EPI_DutchNationalFlagSol1.Color.WHITE);
	        list.add(EPI_DutchNationalFlagSol1.Color.BLUE);
	        list.add(EPI_DutchNationalFlagSol1.Color.WHITE);
	        partition(list);
	        System.out.println(list);
	    }
	
}
