package org.vivek.myinterview.strings.problems;

public class SuperReducedString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "aaabccddd";
		String output = superReducedString(input);
		System.out.println(output);

	}/*
		 * Input Format
		 * 
		 * A single string, .
		 * 
		 * Constraints
		 * 
		 * Output Format
		 * 
		 * If the final string is empty, print Empty String; otherwise, print the final
		 * non-reducible string.
		 * 
		 * Sample Input :aaabccddd
		 * 
		 * Sample Output :abd 
		 * 
		 * Explanation:
		 * 
		 * Steve performs the following sequence of operations to get the final string:
		 * 
		 * aaabccddd → abccddd → abddd → abd 
		 *
		 * 
		 * Sample Input :aa
		 * 
		 * Sample Output :Empty String
		 * 
		 * Explanation :
		 * 
		 * aa → Empty String 
		 * 
		 * Sample Input :baab
		 * 
		 * Sample Output :Empty String
		 * 
		 * Explanation :
		 * 
		 * baab → bb → Empty String
		 */

	static String superReducedString(String s) {

		int N = 2;
		StringBuilder sb = new StringBuilder(s);
		// System.out.println("Orignal string=" + s);
		int acsciiCounter = 0;
		int consecutiveRepeatedCharactersCounter = 0;
		for (int i = 0; i < s.length(); i++) {
			char currChar = s.charAt(i);
			int ascii = (int) currChar;
			acsciiCounter = ascii + acsciiCounter;
			int totalAscii = acsciiCounter % currChar;
			if (totalAscii == 0) {
				consecutiveRepeatedCharactersCounter = consecutiveRepeatedCharactersCounter + 1;
				if (consecutiveRepeatedCharactersCounter == N) {
					int startIndex = i - N + 1;
					sb = sb.delete(startIndex, i + 1);
					s = sb.toString();
					i = -1;
					acsciiCounter = 0;
					consecutiveRepeatedCharactersCounter = 0;
				}
			} else {
				acsciiCounter = ascii;
				consecutiveRepeatedCharactersCounter = 1;
			}
		}
		String result = sb.toString();
		if (result.length() == 0) {
			return "Empty String";
		} else {
			return sb.toString();
		}
	}

}
