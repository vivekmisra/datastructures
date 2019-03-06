package org.vivek.myinterview.classictechniques.twopointers;

import java.util.Stack;
import java.util.StringTokenizer;

public class ReverseWords2 {

	public ReverseWords2() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		char[] str={ 't','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};
		String input = new String(str);
		//Output: ['b','l','u','e',' ','i','s',' ','s','k','y',' ','t','h','e']
		printArray(str);
		ReverseWords2 r = new ReverseWords2();
		r.reverseWords(str);
		printArray(str);
		char[] str1={ 't','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};
		doStringReverseWord(str1);
		printArray(str1);
	}

	public void reverseWords(char[] str) {
		int i = 0;
		for (int j = 0; j < str.length; j++) {
			if (str[j] == ' ') {
				reverse(str, i, j - 1);
				i = j + 1;
			}
		}
		reverse(str, i, str.length - 1);
		reverse(str, 0, str.length - 1);
	}

	public void reverse(char[] s, int i, int j) {
		while (i < j) {
			swap(s, i, j);
			i++;
			j--;
		}
	}

	private void swap(char[] str, int i, int j) {
		char temp = str[i];
		str[i] = str[j];
		str[j] = temp;
	}

	private static void printArray(char[] anArray) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < anArray.length; i++) {
			if (i > 0) {
				sb.append(", ");
			}
			sb.append(anArray[i]);
		}
		System.out.println(sb.toString());
	}
	
	private static void doStringReverseWord(char[] str) {
		String a = new String(str);

		Stack stack = new Stack();
		StringTokenizer tempStringTokenizer = new StringTokenizer(a);

		while (tempStringTokenizer.hasMoreTokens()) {
			stack.push(tempStringTokenizer.nextElement());
		}

		//System.out.println("\nOriginal string: " + a);
        StringBuffer sb = new StringBuffer();
		//System.out.print("Reverse word string: ");
		while (!stack.empty()) {
			sb.append(stack.pop());
			sb.append(" ");
		}

		String s = sb.toString() ;
		str = s.toCharArray();
		printArray(str);
	}
}
