import java.util.HashMap;
import java.util.Scanner;

import binarytrees.BinaryTree;

public class FeeQueriesVisa {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numOfShops = in.nextInt();
		int queries = in.nextInt();
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < numOfShops; i++) {
			map.put(i, in.nextInt());
		}
		while(queries != 0){
			queries--;
			String s = in.next();
			if(s.equals("change")){
				map.put(in.nextInt(), in.nextInt());
			}
			else{
				System.out.println(count(in.nextInt(),map));
			}
		}
	}

	private static int count(int nextLine, HashMap<Integer, Integer> map) {
		int count = 0;
		for (Integer i : map.keySet()) {
			if(map.get(i) >= nextLine)
				count++;
		}
		return count;
	}

}