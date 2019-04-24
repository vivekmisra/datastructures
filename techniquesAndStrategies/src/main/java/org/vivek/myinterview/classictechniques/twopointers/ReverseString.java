package org.vivek.myinterview.classictechniques.twopointers;

public class ReverseString {

	public static void main(String[] args) {
		System.out.println(reverseIterative("Hello"));
		System.out.println(reverseRecursive("Hello"));
	}
	
	static String reverseIterative(String s) {
		if(s==null||s.length()==0) return null;
		char[] chars = s.toCharArray();
		int i = 0;
		int j = s.length()-1;
		while(i<j) {
			swap(chars ,i,j);
			i++;
			j--;
		}
		return new String(chars);
	}

	private static void swap(char[] chars, int i, int j) {
		char temp = chars[i];
		chars[i] = chars[j];
		chars[j] = temp;
		
	}
	/*
	 * reverseRecursive("Hello")
		(reverseRecursive("ello")) + "H"
		((reverseRecursive("llo")) + "e") + "H"
		(((reverseRecursive("lo")) + "l") + "e") + "H"
		((((reverseRecursive("o")) + "l") + "l") + "e") + "H"
		(((("o") + "l") + "l") + "e") + "H"
		"olleH"
	 */
	static String reverseRecursive(String s) {
		if ((null == s) || (s.length() <= 1)) {
	        return s;
	    }
		return reverseRecursive(s.substring(1)) + s.charAt(0);
		
	}

}
