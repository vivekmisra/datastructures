/**
 * 
 */
package org.vivek.myinterview.regex;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class Solution {
  public static void main(String args[]) throws Exception {
    String[] words = new String[] {"abc", "abd", "cbd", "dog", "god", "xyz", "xab"};
        System.out.println(groupByAnagrams(words));
  }

  public static List<List<String>> groupByAnagrams(String[] words) {
    if (words.length == 0)
      return new ArrayList();
    List<List<String>> anagramGroupList = new ArrayList<>();
    List<String> list = null;
    boolean qualifyForAnagram = false;
    for (int i = 0; i < words.length; i++) {// O(n)
      String word1 = words[i];
      Set<String> set = new HashSet<>();
      for (int j = i + 1; j < words.length; j++) {
        String word2 = words[j];
        boolean doesthisQualify = (makeAnagram(word1, word2) == 2);
        boolean doesthisQualifyByDefault = (makeAnagram(word1, word2) == 0);
        if (doesthisQualify || doesthisQualifyByDefault) {
          set.add(word2);
          qualifyForAnagram = true;
        }
        if (qualifyForAnagram) {
          if (!set.contains(word1)) {
            set.add(word1);
          }

          qualifyForAnagram = false;
        }
      }

      if (set != null && set.size() > 0) {
        list = new ArrayList<>(set);
        anagramGroupList.add(list);
      }
    }



    return anagramGroupList;
  }

  // jmj@uber.com

  static int makeAnagram(String s1, String s2) {
    int charArray[] = new int[26];
    // creare fre table for s1
    for (int i = 0; i < s1.length(); i++) {
      s1 = s1.toLowerCase();
      charArray[s1.charAt(i) - 'a']++;
    }

    for (int i = 0; i < s2.length(); i++) {
      s2 = s2.toLowerCase();
      charArray[s2.charAt(i) - 'a']--;
    }
    int count = 0;
    for (int i = 0; i < 26; i++) {
      count = count + Math.abs(charArray[i]);
    }
    return count;
  }
}

/*
 * abc --> c -> ab abd --> d -> ab
 * 
 * 
 * abc, cba --> yes abc, cbd --> yes dog, god --> yes
 * 
 * xyz, xab --> not
 * 
 * 
 * words = ['dog', 'elvis', 'forest', 'fortes', 'foster', 'goat', 'god', 'heros', 'horse', 'lives',
 * 'shore', 'softer'] # Expected: # [ # ['elvis', 'lives'], # ['forest', 'fortes', 'foster',
 * 'softer'], # ['heros', 'horse', 'shore'], # ['dog', 'god'], # ['goat'] # ]
 * 
 */
