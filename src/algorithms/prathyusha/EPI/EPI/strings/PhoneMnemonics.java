package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PhoneMnemonics {
	
	public static final String[] Maping = {"0","1","ABC","DEF","GHI","JKL","MNO","PQRS","TUV","WXYZ"};
	
	public static void main(String[] args) {
		System.out.println("phone mnemonics: ");
		int[] number = {1,2,3,4};
		resursiveMnemonic(number);
	}

	private static void resursiveMnemonic(int[] number) {
		int index = 0;
		char[] string = new char[number.length];
		recuresiveCall(number, index, string,0);
	}

	private static void recuresiveCall(int[] number, int index, char[] string, int strindex) {
			if(index == number.length) {
				System.out.println(string);
				return;
			}
			String values = Maping[number[index]];
			for (char i : values.toCharArray()) {
				string[strindex] = i;
				recuresiveCall(number, index+1, string,strindex+1);
			}
	}
}
