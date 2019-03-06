package org.vivek.myinterview.classictechniques.twopointers;

import java.util.Stack;
import java.util.StringTokenizer;

/*https://leetcode.com/problems/reverse-words-in-a-string-iii/
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:
Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
 */
public class ReverseWords3 {

	public ReverseWords3() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		String str ="Let's take LeetCode contest";
		// Output: "s'teL ekat edoCteeL tsetnoc"
		
		ReverseWords3 r = new ReverseWords3();
		String s = r.reverseWords(str.toCharArray());
		System.out.println(s);

	}
    public String reverseWords(char[] str) {
		int i = 0;
		for (int j = 0; j < str.length; j++) {
			if (str[j] == ' ') {
				reverse(str, i, j - 1);
				i = j + 1;
			}
		}
		 reverse(str, i, str.length - 1);
        return new String(str);
		//reverse(str, 0, str.length - 1);
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
}

