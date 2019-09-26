package org.vivek.myinterview.strings.problems.common.palindrome;

public class PalindromeChecksOfTwoStrings {

	public static void main(String[] args) {
		String s1 = "abcbbbb";
		String s2 = "xxxbcba";
		//s1 = "abcbbbb";
		// s2 = "xxxbaba";
		s1 = "xycbtac";
		s2 = "catbapq";
		PalindromeChecksOfTwoStrings p = new PalindromeChecksOfTwoStrings();
		boolean valid = p.isValidPalindromeSplitPossible(s1, s2);
		System.out.println(valid);

		String s = p.longestPalindromeBySplit(s1, s2);
		System.out.println(s);

	}

	private boolean isValidPalindromeSplitPossible(String s1, String s2) {
		if (s1 == null || s2 == null)
			return false;
		if (s1.length() <= 1 && s2.length() <= 1)
			return true;
		s1 = s1.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
		s2 = s2.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

		int i = 0;
		int j = s2.length() - 1;
		int c = 0;
		while (i < j) {
			char a1 = s1.charAt(i);
			char b2 = s2.charAt(j - i);
			if (a1 != b2) {
				break;
			} else {
				c = j - i;
				i++;
			}
		}
		c = c + 1;
		int k = s1.length() - 1;;
		int l = 0;
		int d =0;
		while (l<k) {
			char a2 = s1.charAt(k-l);
			char b1 = s2.charAt(l);
			if (a2 != b1) {
				break;
			} else {
				d=k-l;
				l++;

			}
		}
        d=d+1;
		if ((i > 0 && i == c) || (k > 0 && l == d)) {
			return true;
		} else {
			return false;
		}
	}

	private String longestPalindromeBySplit(String s1, String s2) {
		StringBuffer sb1 = new StringBuffer();
		StringBuffer sb2 = new StringBuffer();
		if (s1 == null || s2 == null)
			return null;
		if (s1.length() <= 1 && s2.length() <= 1)
			return null;
		s1 = s1.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
		s2 = s2.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

		int i = 0;
		int j = s2.length() - 1;
		int c = 0;
		while (i < j) {
			char a1 = s1.charAt(i);
			char b2 = s2.charAt(j - i);
			if (a1 != b2) {
				break;
			} else {
				c = j - i;
				i++;
				sb1.append(a1);
			}
		}
		c = c + 1;
		int k = s1.length() - 1;;
		int l = 0;
		int d =0;
		while (l<k) {
			char a2 = s1.charAt(k-l);
			char b1 = s2.charAt(l);
			if (a2 != b1) {
				break;
			} else {
				d=k-l;
				l++;				
				sb2.append(a2);

			}
		}
        d=d+1;

		if ((i > 0 && i == c) || (l > 0 && l == d)) {
			int length1 = sb1.length();
			int length2 = sb2.length();
			if (length1 > length2) {
				return sb1.toString();
			} else {
				return sb2.toString();
			}
		} else {
			return null;
		}
	}

}
