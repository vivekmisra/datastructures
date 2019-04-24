package org.vivek.myinterview.classictechniques;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SlidingWindowExamples {

	public static void main(String[] args) {
		String s1 = "abcabcbb";
		int len = lengthOfLongestSubstring(s1);
		System.out.println(len);
		String s2="cbaebabacd",t2="abc";
		List<Integer> anagramList =findAnagrams( s2,  t2);
		anagramList.forEach(item->System.out.print(item+","));
		System.out.println();

	}

	//@formatter:off
	/*  3. Longest Substring Without Repeating Characters
	 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
	 * Given a string, find the length of the longest substring without repeating characters.

	Example 1:
	
	Input: "abcabcbb"
	Output: 3 
	Explanation: The answer is "abc", with the length of 3. 
	Example 2:
	
	Input: "bbbbb"
	Output: 1
	Explanation: The answer is "b", with the length of 1.
	Example 3:
	
	Input: "pwwkew"
	Output: 3
	Explanation: The answer is "wke", with the length of 3. 
	             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
	 */
	public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int begin = 0, end = 0, counter = 0, d = 0;

        while (end < s.length()) {
            // > 0 means repeating character
            //if(map[s.charAt(end++)]-- > 0) counter++;
            char c = s.charAt(end);
            if(map.containsKey(c)) {
            	 map.put(c, map.get(c) + 1);
            }else {
            	 map.put(c, 1);
            }
           
            int val = map.get(c);
            if(val > 1) {
            	counter++;
            }
            end++;
            
            while (counter > 0) {
                //if (map[s.charAt(begin++)]-- > 1) counter--;
                char charTemp = s.charAt(begin);
                int tempval = map.get(charTemp);
                if (tempval > 1) {
                	counter--;
                }
                map.put(charTemp, map.get(charTemp)-1);
                begin++;
            }
            d = Math.max(d, end - begin);
        }
        return d;
    }
	
	/*
	 * https://leetcode.com/problems/find-all-anagrams-in-a-string/
	 * 438. Find All Anagrams in a String

		Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
		
		Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
		
		The order of output does not matter.
		
		Example 1:
		
		Input:
		s: "cbaebabacd" p: "abc"
		
		Output:
		[0, 6]
		
		Explanation:
		The substring with start index = 0 is "cba", which is an anagram of "abc".
		The substring with start index = 6 is "bac", which is an anagram of "abc".
		Example 2:
		
		Input:
		s: "abab" p: "ab"
		
		Output:
		[0, 1, 2]
		
		Explanation:
		The substring with start index = 0 is "ab", which is an anagram of "ab".
		The substring with start index = 1 is "ba", which is an anagram of "ab".
		The substring with start index = 2 is "ab", which is an anagram of "ab".
	 */
	 public static List<Integer> findAnagrams(String s, String p) {
	      
	        // Initializes result list.
	        List<Integer> result = new ArrayList<>();
	        
	        // Checks invalid cases where we could return faster.
	        if (s == null || s.length() == 0 || p.length() > s.length()) {
	            return result;
	        }
	        
	        // Saves 'letter -> occurrence' of String p into a HashMap. 
	        // When scanning through String s, by checking against this HashMap, we will know
	        // whether certain character is required (or if still required) for finding p's anagram.
	       Map<Character, Integer> requiredLetters = new HashMap<>();
	        for (char c : p.toCharArray()) {
	            if (requiredLetters.containsKey(c)) {
	                requiredLetters.put(c, requiredLetters.get(c) + 1);
	            } else {
	                requiredLetters.put(c, 1);
	            }
	        }
	        
	        // Initializes a sliding window. Both 'start' and 'end' start as 0. 
	        // 'count' starts as the length of p, and will be used to track the number of 
	        // characters needed for finding an anagram of p.
	        int start = 0, end = 0;
	        int count = p.length();
	        
	        while (end < s.length()) {
	            // ++ moves 'end' by 1 regardless of below conditions.
	            char c = s.charAt(end++);
	            if (requiredLetters.containsKey(c)) {
	                // If current character has value > 0 in the HashMap, it means 
	                // to find p's anagram with the current 'start', this letter is still
	                // required. 
	                //
	                // Then we can decrease 'count' since the current character contributes 
	                // 1 character to the anagram we are looking for.
	                if (requiredLetters.get(c) > 0) {
	                    count--;                    
	                }
	                // As long as the current character exists in HashMap, we need to update the 
	                // HashMap by decreasing its occurrence by 1. This will affect next round of the loop. 
	                requiredLetters.put(c, requiredLetters.get(c) - 1);                                
	            }
	            
	            // If 'count' equals to 0, it means all characters required to construct p's anagram 
	            // have been found. Then current 'start' should be one of the valid results.
	            if (count == 0) {
	                result.add(start);
	            }
	            
	            // When the size of the sliding window equals to p's length, it means at this point we 
	            // need to move 'start' and 'end' together to move the sliding window until we hit the end
	            // of String s. A substring can be possibly an anagram of p only if its length is p.length().
	            if (end - start == p.length()) {
	                // ++ moves 'start' by 1 regardless of below conditions.
	                char startC = s.charAt(start++);
	                if (requiredLetters.containsKey(startC)) {
	                    // Since we didn't find an anagram with the current 'start', while we need to move 
	                    // the sliding window forward due to the length requirement, we need to give up the 
						// current 'start' character, refund the credit to 'count' and move on.
	                    if (requiredLetters.get(startC) >= 0) {
	                        count++;                    
	                    }        
	                    
	                    // Because we do 'start++' to move the sliding window, the current character should
	                    // then the current character should not be taken into account any more for finding 
						// the anagram. We need to return it back to the HashMap.
	                    requiredLetters.put(startC, requiredLetters.get(startC) + 1);                       
	                }                      
	            }
	        }
	        return result;
	    }

}
