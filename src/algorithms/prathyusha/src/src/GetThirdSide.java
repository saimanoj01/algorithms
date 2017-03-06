import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class GetThirdSide {
	public static void main(String[] args) {
		Long n = Long.valueOf(78);
		for (Long l : getPrimeFactors(new HashMap<Long, Integer>(), n)) {
			System.out.print(l+" ");
		}
	}
	
	
	
	
		
	public static ArrayList<Long> getPrimeFactors(HashMap<Long, Integer> factorsMap, long num) {
			ArrayList<Long> multiplyArray = new ArrayList<>(); 
			ArrayList<Long> tempArr = new ArrayList<>(); 
			long minValue = 1;
			long maxIndex = (long) Math.sqrt(num);
			for(long index = 2; index < maxIndex +1; index++) {
				if(num%index == 0 && !isDivisible(index,factorsMap)){
					int count = 1;
					num = (num/index);
					while(num%index == 0) {
						count++;
						num = num/index;
					}
					//System.out.println(index+"index");
					if(count==1 || count%2 == 1) {
						minValue = minValue * index;
						//System.out.println(minValue);
						count = count -1;
					}
					if(count != 0)
						factorsMap.put(index, count);
				}
			}
			/*for (Long l : factorsMap.keySet()) {
				System.out.println(l+" ");
			}*/
			//System.out.println(minValue);
			multiplyArray.add(minValue);
			for (Long l : factorsMap.keySet()) {
				multiplyArray.add(l*minValue);
			}
			for (Long l : factorsMap.keySet()) {
				tempArr = new ArrayList<>();
				long count = factorsMap.get(l);	
				count = count/2;
				while(count>=2 && count%2 == 0) {
					for (Long long1 : multiplyArray) {
						tempArr.add(long1*l*l);
					}
					count = count/2;
				}
				multiplyArray.addAll(tempArr);	
			}
			Collections.sort(multiplyArray);
			return multiplyArray;
	}

	private static boolean isDivisible(long index, HashMap<Long, Integer> factorsMap) {
		for (Long l : factorsMap.keySet()) {
			if(index%l == 0) {
				return true;
			}
		}
		return false;
	}
		
		
}
