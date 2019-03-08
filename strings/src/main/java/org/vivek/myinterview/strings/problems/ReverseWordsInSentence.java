/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/02/reverse-words-of-sentence.html
 */

package org.vivek.myinterview.strings.problems;

import java.util.Stack;
import java.util.StringTokenizer;

public class ReverseWordsInSentence {
	public static void main(String[] args) {
		String str = "reverse words of a sentence";
		String result = reverseWords(str);
		System.out.println(result);
	}
	
	

	private static String reverseWords(String str) {
		char[] chars = str.toCharArray();
		reverse(chars, 0, chars.length - 1);
		int wordStart = 0;
		int wordEnd = 0;
		while (wordEnd < chars.length) {
			if (chars[wordEnd] == ' ') {
				reverse(chars, wordStart, wordEnd - 1);
				wordStart = wordEnd + 1;
			}
			wordEnd++;
		}
		reverse(chars, wordStart, wordEnd - 1);
		return new String(chars);
	}

	private static void doStringReverseWord(String s) {
		String a = s;

		Stack stack = new Stack();
		StringTokenizer tempStringTokenizer = new StringTokenizer(a);

		while (tempStringTokenizer.hasMoreTokens()) {
			stack.push(tempStringTokenizer.nextElement());
		}

		System.out.println("\nOriginal string: " + a);

		System.out.print("Reverse word string: ");
		while (!stack.empty()) {
			System.out.print(stack.pop());
			System.out.print(" ");
		}

		System.out.println("\n");
	}

	static String reverseWordsUsingStringBuilder(String string) {
		StringTokenizer tokenizer = new StringTokenizer(string, " ");
		StringBuilder buffer = new StringBuilder();
		while (tokenizer.hasMoreTokens()) {
			buffer.insert(0, tokenizer.nextToken() + " ");
		}
		return buffer.toString();
	}

	private static void reverse(char[] chars, int i, int j) {
		while (i < j) {
			char temp = chars[i];
			chars[i] = chars[j];
			chars[j] = temp;
			i++;
			j--;
		}
	}
}
