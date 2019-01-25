package org.vivek.myinterview.strings.problems.characters;

public class CharOccurencesCountInAString {

	public CharOccurencesCountInAString() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		String s="leetcode";
		System.out.println(countOccurences(s));

	}
	
	public static String countOccurences(String s) {
		int[] counts = new int[256];//ASCII Characters counter		
		StringBuilder sb = new StringBuilder();
		char currChar;
		for (int i = 0; i < s.length(); i++) {
			currChar = s.charAt(i);			
			counts[currChar]++;			
		}		
		for(char ch = 0; ch < counts.length; ch++) {
			 if( counts[ch]>0) {
			 sb.append((char)ch + " has count " + counts[ch]);
			 sb.append("\n");
			 }
		} 
		return sb.toString();
	}


}
