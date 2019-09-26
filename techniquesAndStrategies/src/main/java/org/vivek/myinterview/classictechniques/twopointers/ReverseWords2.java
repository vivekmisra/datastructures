package org.vivek.myinterview.classictechniques.twopointers;

import java.util.Stack;
import java.util.StringTokenizer;

public class ReverseWords2 {

	public ReverseWords2() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		char[] charArray={ 't','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};
		String input = new String(charArray);
		//Output: ['b','l','u','e',' ','i','s',' ','s','k','y',' ','t','h','e']
		printArray(charArray);
		ReverseWords2 r = new ReverseWords2();
		r.reverseWords(charArray);
		printArray(charArray);
		char[] str1={ 't','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};
		doStringReverseWord(str1);
		printArray(str1);
	}

	public void reverseWords(char[] charArray) {
		int i = 0;
		for (int j = 0; j < charArray.length; j++) {
			if (charArray[j] == ' ') {//if blank
				//==>charArray[j-1] would be non blank
				reverse(charArray, i, j - 1);
				i = j + 1;//skip jth blank & go to next
			}
		}
		reverse(charArray, i, charArray.length - 1);//if ,for the last word there wont be '',this will take care 
		System.out.println("Before full revrise="+ new String(charArray));
		reverse(charArray, 0, charArray.length - 1);//now reverse all reverses word
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
