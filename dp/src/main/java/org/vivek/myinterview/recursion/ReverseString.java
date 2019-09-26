package org.vivek.myinterview.recursion;

public class ReverseString {

	public static void main(String[] args) {
		String s = "Hello";
		printReverse(s.toCharArray());

	}

	private static void printReverse(char[] chars) {
		helper(0, chars);
	}

	private static void helper(int index, char[] chars) {
		if (chars == null || index >= chars.length) {
			return;
		}
		helper(index + 1, chars);
		System.out.print(chars[index]);
	}
	
	static String reverseRecursive(String s) {
		if ((null == s) || (s.length() <= 1)) {
	        return s;
	    }
		return reverseRecursive(s.substring(1)) + s.charAt(0);
		
	}

}
