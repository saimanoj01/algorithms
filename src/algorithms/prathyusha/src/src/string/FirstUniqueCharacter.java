package string;
import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacter {
	public static void main(String[] args) {
		String name = "Prathyusha";
		System.out.println(uniqueFirstChar(name));
	}

	private static String uniqueFirstChar(String name) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for ( int i=0;i <name.length(); i++) {
			map.put(name.charAt(i), (map.containsKey(name.charAt(i)) ? (map.get(name.charAt(i))+1) : 1 ));
		}
		for ( int i=0;i <name.length(); i++) {
			if (map.get(name.charAt(i)) == 1) return Character.toString(name.charAt(i));
		}
		return "";
	}
}
