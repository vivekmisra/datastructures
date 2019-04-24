package org.vivek.myinterview.strings.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CommonInterviewQuestionsOnStrings {
	//@formatter:off
	public static void main(String[] args) {
		String s = "A man, a plan, a canal: Panama";
		boolean palCheck = isPalindrome(s);
		System.out.println(palCheck);
		//////////////////////////////////
		s = "abcdefedba";
		palCheck = validPalindrome(s);
		System.out.println(palCheck);
		////////////////////////////////
		s="carerac";
		boolean canPermute= canPermutePalindrome( s);
		System.out.println(canPermute);
		s="code";
		canPermute= canPermutePalindrome( s);
		System.out.println(canPermute);
		/////////////////////////////////
		s= "aabb";
		//Output: ["abba", "baab"]
		List<String> palindromicList = generatePalindromes( s);
		System.out.print("[");	
		palindromicList.forEach(palindrome->System.out.print(palindrome+","));	
		System.out.println("]");	
		s= "abc";
		//Output: []
		palindromicList = generatePalindromes( s);
		System.out.print("[");	
		palindromicList.forEach(palindrome->System.out.print("["+palindrome+","));	
		System.out.println("]");
		String s1 ="abcd";
		String s2 = "abcdeba";
		System.out.println("shortest1 of s1=" + s1 + " is-->"+ shortestPalindrome(s1)+" shortest1 of s2=" + s2 + " is-->"+ shortestPalindrome(s2)); 
	}

	/*
	 * https://leetcode.com/problems/valid-palindrome/ 
	 * 125. Valid Palindrome
	 * 
	 * Given a string, determine if it is a palindrome, considering only
	 * alphanumeric characters and ignoring cases.
	 * 
	 * Note: For the purpose of this problem, we define empty string as valid
	 * palindrome.
	 * 
	 * Example 1:
	 * 
	 * Input: "A man, a plan, a canal: Panama" Output: true Example 2:
	 * 
	 * Input: "race a car" Output: false
	 */
	public static boolean isPalindrome(String s) {
		System.out.println("////isPalindrome////"+s);
		if (s == null)
			return false;
		s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
		int i = 0, j = s.length() - 1;
		while (i < j) {
			char first = s.charAt(i);
			char last = s.charAt(j - i);
			if (first != last) {
				return false;
			}
			i++;
		}
		return true;
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	/*
	 * https://leetcode.com/problems/valid-palindrome-ii/ 
	 * 680. Valid Palindrome II
		Easy
		Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
		Example 1:
		Input: "aba"
		Output: True
		Example 2:
		Input: "abca"
		Output: True
         Explanation: You could delete the character 'c'.
	 */
	public static boolean validPalindrome(String s) {
		System.out.println("////validPalindrome////"+s);
		if (s == null)
			return false;
		s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
		int i = 0, j = s.length() - 1;
		while (i < j) {
			char first = s.charAt(i);
			char last = s.charAt(j - i);
			int left = i;
			int right = j - i;
			if (first != last) {
				return isPalindromeRange(s, i + 1, j - i) || isPalindromeRange(s, i, j - i - 1);
			}

			i++;
		}
		return true;
	}

	public static boolean isPalindromeRange(String s, int i, int j) {
		System.out.println("  validPalindrome::isPalindromeRange");
		int mid = i + (j - i) / 2;
		int k = i;
		// i-------------mid---------------j
		// |--(k-i)--|
		// ----------k---------------------j
		while (k <= mid) {
			char first = s.charAt(k);
			char last = s.charAt(j - (k - i));
			if (first != last) {
				return false;
			}
			k++;
		}

		return true;

	}
	/*214. Shortest Palindrome
	Hard

	602

	74

	Favorite

	Share
	Given a string s, you are allowed to convert it to a palindrome
	 by adding characters in front of it. Find and return the shortest palindrome 
	 you can find by performing this transformation.

	Example 1:

	Input: "aacecaaa"
	Output: "aaacecaaa"
	Example 2:

	Input: "abcd"
	Output: "dcbabcd"
	*/
	public static  String shortestPalindrome(String s) {
	    int i=0; 
	    int j=s.length()-1;
	 
	    while(j>=0){
	        if(s.charAt(i)==s.charAt(j)){
	            i++;
	        }
	        j--;
	    }
	 
	    if(i==s.length())
	        return s;
	 
	    String suffix = s.substring(i);
	    String prefix = new StringBuilder(suffix).reverse().toString();
	    String mid = shortestPalindrome(s.substring(0, i));
	    return prefix+mid+suffix;
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * https://leetcode.com/problems/palindrome-permutation/
	 * 266. Palindrome Permutation Easy
	
	 * Share Given a string, determine if a permutation of the string could form a
	 * palindrome.
	 * 
	 * Example 1:
	 * 
	 * Input: "code" Output: false
	 * 
	 *  Example 2:
	 * 
	 * Input: "aab" Output: true 
	 * 
	 * Example 3:
	 * 
	 * Input: "carerac" Output: true
	 * 
	 */
	public static boolean canPermutePalindrome(String s) {
		System.out.println("////canPermutePalindrome////"+s);
		int [] freqTable = new int[128];
		int count =0;
		for(int i = 0 ; i < s.length();i++) {
			freqTable[s.charAt(i)]++;
			if(freqTable[s.charAt(i)]%2==0) {
				count--;
			}else {
				count++;
			}
		}
          return count<=1;
	}

	
	//////////////////////////////////////////////////////////////////////////////////////////////
	/*
	 * 267. Palindrome Permutation II
		Medium
		Given a string s, return all the palindromic permutations (without duplicates) of it. 
		Return an empty list if no palindromic permutation could be form.
		
		Example 1:
		
		Input: "aabb"
		Output: ["abba", "baab"]
		Example 2:
		
		Input: "abc"
		Output: []
	 */
	public static List<String> generatePalindromes(String s) {
		System.out.println("////generatePalindromes////"+s);
		int[] freqTable = new int[128];
		//character occuring even number of times will be just half of length
		//in a palindromic string
		char[] st = new char[s.length() / 2];
		char ch =0;
		int k=0;
		//check if all permuted variations of s are Palindromic strings are pssible
		//if not return empty list
		if (!canPermutePalindrome(s, freqTable)) {
			return new ArrayList<>();
		}
		//Important check
		//lopp thru freq table to find out even and odd occuring
		//chars
		for (int i = 0; i < freqTable.length; i++) {
			/*
			 * //grab the  char occuring odd count
			 * there should be only 1 such
			 */
            if (freqTable[i] % 2 == 1) {
                ch = (char) i;
            }
           /*
            * grab all chars occurring even count times in st char char array
            for even count we dont need to traverse whole
            table,just half is enough as they are same chars set
            
             */
            for (int j = 0; j < freqTable[i] / 2; j++) {
                st[k++] = (char) i;
            }
		}  
         Set<String> permutedSet = generateUniquePermutationsForPalindrome(new String(st), ch);
         return new ArrayList<>(permutedSet);
    }

	
	public static boolean canPermutePalindrome(String s,int [] freqTable) {
		System.out.println("   generatePalindromes::canPermutePalindrome");
		int count =0;
		for(int i = 0 ; i < s.length();i++) {
			freqTable[s.charAt(i)]++;
			if(freqTable[s.charAt(i)]%2==0) {
				count--;
			}else {
				count++;
			}
		}
          return count<=1;
	}

	public static Set<String> generateUniquePermutationsForPalindrome(String input, char c) {
		System.out.println("   generatePalindromes::generateUniquePermutationsForPalindrome");
		String prefix = "";
		String suffix = input;
		Set<String> permutatedList = new HashSet<String>();
		uniquePermutationForPalindrome(prefix, suffix, permutatedList, c);
		return permutatedList;
	}

	private static void uniquePermutationForPalindrome(String prefix, String suffix, Set<String> permutatedList,
			char ch) {
		if (suffix.isEmpty()) {
			//note that half of the string permuted is reversed and if there is odd ch it is added
			String s = prefix + (ch == 0 ? "" : ch) + new StringBuffer(new String(prefix)).reverse();
			permutatedList.add(s);
		} else {
			for (int i = 0; i < suffix.length(); i++) {
				uniquePermutationForPalindrome(prefix + suffix.charAt(i),
						suffix.substring(0, i) + suffix.substring(i + 1, suffix.length()), permutatedList, ch);
			}
		}

	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////

}
