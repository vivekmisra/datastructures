package org.vivek.myinterview.strings.problems;
import java.util.HashSet;
import java.util.Set;

public class StringExamples {

	static int ecount(String s) {
		int ecount = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'e') {
				ecount++;
			}
		}
		return ecount;

	}

	static String concat(String[] str) {
		String ret = null;
		if (str == null)
			ret = null;
		String ans = "";
		for (int i = 0; i < str.length; i++) {
			ans = ans + str[i];
			ret = ans;
		}
		return ret;
	}

	static boolean sorted(String s[]) {
		boolean flag = false;
		for (int i = 1; i < s.length; i++) {
			if (s[i - 1].compareTo(s[i]) > 0) {
				flag = false;
			} else {
				flag = true;
			}
		}
		return flag;

	}

	static void pic() {
		char[][] pic = new char[6][6];
		for (int i = 0; i < 6; i++)
			for (int j = 0; j < 6; j++) {
				if (i == j || i == 0 || i == 5)
					pic[i][j] = '*';
				else
					pic[i][j] = '.';
			}
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++)
				System.out.print(pic[i][j]);
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String[] s = { "Vivek", "misra", "anand" };
		//System.out.println(concat(s));
		//sorted(s);
		System.out.println(DigitsToWords.convertDigitsToWords(999));
		//pic() ;
	 String s = "abcdef";
	// System.out.println("Original String="+s);
	// s=  swapChars(s,2,3);
	// System.out.println("swapped String="+s);
	 permutation("",s);
	}

	public String toString() {
		return "";

	}

	private static void permutation(String prefix, String str) {
		System.out.println("==permutation("+prefix+",");
		System.out.println(str+")");
		int n = str.length();
		if (n == 0) {
			System.out.println("==permutation("+"n==0),prefix="+prefix);
			System.out.println("Permuted="+prefix);
		} else {
			for (int i = 0; i < n; i++) {
				System.out.println("i = "+i);
				System.out.println("prefix = "+prefix);
				System.out.println("str = "+str);
				String arg1=prefix + str.charAt(i);
				System.out.println("permutation("+arg1+",");
				System.out.println(str.substring(0, i) + str.substring(i + 1, n)+")");
				permutation(prefix + str.charAt(i),
						str.substring(0, i) + str.substring(i + 1, n));
			}
		}
	}

	 private static String swapChars(String str, int lIdx, int rIdx) {
	        StringBuilder sb = new StringBuilder(str);
	        char l = sb.charAt(lIdx), 
	        r = sb.charAt(rIdx);
	        sb.setCharAt(lIdx, r);
	        sb.setCharAt(rIdx, l);
	        return sb.toString();
	    }

}

// Print a number in words. The number can be up to three digits long, and
// must only use the digits 0, 1, 2.

class DigitsToWords {
	
	 

	static String convertDigitsToWords(int input) {
		if (input < 0 || input > 9999)
			throw new IllegalArgumentException("Out of range: " + input);

		if (input == 0) {
			return "zero";
		}

		String[] group1 = { "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

		String[] group2 = { "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
				"nineteen" };

		String[] group3 = { "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety" };

		StringBuffer result = new StringBuffer();

		if (input >= 1000) {
			int tmp = input / 1000;
			result.append(group1[tmp - 1] + " thousand");
			input -= tmp * 1000;
			if (input == 0)
				return result.toString();
			result.append(" ");
		}

		if (input >= 100) {
			int tmp = input / 100;
			result.append(group1[tmp - 1] + " hundred");
			input -= tmp * 100;
			if (input == 0)
				return result.toString();
			result.append(" and ");
		}

		if (input >= 10 && input <= 19) {
			result.append(group2[input - 10]);
			return result.toString();
		}

		if (input >= 20) {
			int tmp = input / 10;
			result.append(group3[tmp - 2]);
			input -= tmp * 10;
			if (input == 0)
				return result.toString();
			result.append("-");
		}

		result.append(group1[input - 1]);
		return result.toString();
	}
	
}
