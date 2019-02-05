package org.vivek.myinterview.strings.problems.common.anagrams;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AnagramsInSubStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	

	static int sherlockAndAnagrams(String s) {
		Map<String, Integer> map = new HashMap<String, Integer>();

		// Keep track of how many anagrams we've seen
		int totalCount = 0;

		// Generate all substrings (N^2)
		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j <= s.length(); j++) {
				String currentSubString = s.substring(i, j);

				// Sort all strings E.g. ab & ba both == ab now
				char[] chars = currentSubString.toCharArray();
				Arrays.sort(chars);//cool
				currentSubString = String.valueOf(chars);

				// If sorted substring has been seen before
				if (map.containsKey(currentSubString)) {
					// Check how many times we've seen it and add that amount to
					// the count
					int currentCounter = map.get(currentSubString);
					totalCount = totalCount + currentCounter;

					// Increment the times we've seen the string
					map.put(currentSubString, currentCounter + 1);
				} else {
					// Never seen it before = insert and set to 1 to indiciate
					// we've now seen it
					map.put(currentSubString, 1);
				}
			}
		}
		return totalCount;
	}

	static int sherlockAndAnagrams2(String s) {
		int n = s.length();

		// This will control the length of each substring each pass.
		// For the first pass, it will 1(every single character), next 2, every
		// 2 blocks of characters etc..
		int I = 1;

		int numOfAnagrams = 0;

		// Looping through n - 1 (number of substrings).
		// 2nd loop, looks at each substring for each length.
		// 3rd loop loops through the rest of the substrings of the same length
		// as s1.
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j <= n - I; j++) {
				String s1 = s.substring(j, j + I);
				for (int k = j + 1; k <= n - I; k++) {
					String s2 = s.substring(k, k + I);

					if (checkAnagrams(s1, s2))
						numOfAnagrams++;
				}
			}
			I++;
		}
		return numOfAnagrams;
	}

	static boolean checkAnagrams(String s1, String s2) {

		// Creating 2 HashMaps to hold each char of strings and their
		// frequncies, then checking if they are equal or not. If they are
		// equal, they are anagrams.
		Map<Character, Integer> s1Map = new HashMap<>();
		Map<Character, Integer> s2Map = new HashMap<>();

		char[] s1Chars = s1.toCharArray();
		char[] s2Chars = s2.toCharArray();

		// s1 and s2 will be coming in as the same length.
		for (int i = 0; i < s1.length(); i++) {
			Character s1Char = Character.valueOf(s1Chars[i]);
			Character s2Char = Character.valueOf(s2Chars[i]);

			if (s1Map.containsKey(s1Char))
				s1Map.put(s1Char, s1Map.get(s1Char) + 1);
			else
				s1Map.put(s1Char, 1);

			if (s2Map.containsKey(s2Char))
				s2Map.put(s2Char, s2Map.get(s2Char) + 1);
			else
				s2Map.put(s2Char, 1);
		}

		return s1Map.equals(s2Map);
	}

}
