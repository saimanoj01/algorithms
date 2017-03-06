import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class ThirdSideRect {
	public static void main(String[] args) {
		long n = 1L;
		//to get primefactorization
		HashMap<Long, Integer> factorsMap = new HashMap<>();
		long minValue = 1L;
		boolean inLoop = false;
		for(long index = (long) Math.sqrt(n)+1; index >=1; index--){
			if((n%(index*index) == 0)){
				getFactorsMap(index,factorsMap);
				getFactorsMap(n/index,factorsMap);
				inLoop = true;
				break;
			}
		}
		if(!inLoop) {
			getFactorsMap(n,factorsMap);
		}
		ArrayList<Long> multiplyArray = new ArrayList<>(); 
		ArrayList<Long> tempArr = new ArrayList<>(); 
		for (Long l : factorsMap.keySet()) {
			int count = factorsMap.get(l);
			if(count%2 != 0) {
				minValue *= l;
				factorsMap.replace(l, count-1);
			}
		}
		multiplyArray.add(minValue);
		for (Long l : factorsMap.keySet()) {
			long count = factorsMap.get(l);	
			System.out.println("count "+count);
			while(count>=2) {
				count = count -2;
				System.out.println(count);
				tempArr = new ArrayList<>();
				for (Long long1 : multiplyArray) {
					long toAdd = long1*l*l;
					if(!multiplyArray.contains(toAdd))
						tempArr.add(toAdd);
				}
				multiplyArray.addAll(tempArr);
				System.out.println(multiplyArray);
			}
		}
		Collections.sort(multiplyArray);
		for (Long long1 : multiplyArray) {
			System.out.print(long1+" ");
		}
	}

	private static void getFactorsMap(long n, HashMap<Long, Integer> factorsMap) {
		long end =  n;
		for(long index = 2;index <= end && n != 1 ; index++){
			int count = 0;
			while(n%index == 0){
				count++;
				n = n/index;
			}
			if(count!=0) {
				if(factorsMap.containsKey(index)){
					count+= factorsMap.get(index);
					factorsMap.replace(index, count);
				}
				factorsMap.put(index, count);	
			}
		}
	}
}
