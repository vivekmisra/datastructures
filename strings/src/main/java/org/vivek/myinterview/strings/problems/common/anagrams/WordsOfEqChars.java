package org.vivek.myinterview.strings.problems.common.anagrams;

import java.net.*;
import java.io.*;
import java.util.*;
 /*
  * When two or more words are composed of the same characters, but in a different order, 
  * they are called anagrams.
Task
Using the word list at   http://wiki.puzzlers.org/pub/wordlists/unixdict.txt,
find the sets of words that share the same characters that contain the most words in them. 
  */
public class WordsOfEqChars {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://wiki.puzzlers.org/pub/wordlists/unixdict.txt");
        InputStreamReader isr = new InputStreamReader(url.openStream());
        BufferedReader reader = new BufferedReader(isr);
 
        Map<String, Collection<String>> anagrams = new HashMap<String, Collection<String>>();
        String word;
        int count = 0;
        while ((word = reader.readLine()) != null) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if (!anagrams.containsKey(key))
                anagrams.put(key, new ArrayList<String>());
            anagrams.get(key).add(word);
            count = Math.max(count, anagrams.get(key).size());
        }
 
        reader.close();
 
        for (Collection<String> ana : anagrams.values())
            if (ana.size() >= count)
                System.out.println(ana);
    }   
}