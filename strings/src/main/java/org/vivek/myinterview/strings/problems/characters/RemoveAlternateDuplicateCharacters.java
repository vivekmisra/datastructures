package org.vivek.myinterview.strings.problems.characters;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class RemoveAlternateDuplicateCharacters {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String text = "you got beautiful eyes";
		String expected="you gtbeaiful es";
		System.out.println( "here="+expected.equals(removeAlternateDuplicates(text)));
		
		 text = "Today is the day";
		
		System.out.println( "here="+removeAlternateDuplicates(text));
	    
	}
	
	public static char[] delete(char[] word,int charAt) {
        if (word.length > 0 && charAt >= 0 && charAt < word.length) {
            char[] fix = new char[word.length - 1];

            System.arraycopy(word, 0, fix, 0, charAt);
            System.arraycopy(word, charAt + 1, fix, charAt, word.length - charAt - 1);

            word = fix;
        }
        return word;
    }
	/*
	 * Remove Alternate Duplicate characters from a char array you have to do it in
	 * Place.Like keeping only the odd occurences of each character. 
	 * <p>Example:
	 * Input: â€œyou got beautiful eyesâ€� Output: â€�you gtbeaiful esâ€� 
	 * Allowed Time
	 * Complexity was O(n) and Space Complexity was O(1)</p>
	 * 
	 */
	public static String deleteDuplicateOccurrences(String s ) {
		 int k=0;
		 int[] counts = new int[256]; // maximum value of an ASCII character
		  char[] chars = s.toCharArray();
		  char[] updatedchars = null;
		  for (int i=0;i<chars.length;++i) {
		      k=++counts[chars[i]];
		      if(k>1) {
		    	  System.out.println("c="+ chars[i] + " freq="+ k + "index="+ i);
		    	  if(chars[i]==s.charAt(i)) {
		    		  System.out.println("deleting c="+ s.charAt(i));
		    		  updatedchars=delete(s.toCharArray(),i);
		    	  }
		      }
		  }
		  System.out.println("[");
		      for(char c : updatedchars) {
		    	  System.out.print(c);
		    	  System.out.print( " ");
		      }
		      System.out.println("]");
			return new String(chars);

	}
	
	
	public static String removeAlternateDuplicates(String str) {
		StringBuffer sb = new StringBuffer();
		int letters[] = new int[256];
		char c;
		for (int i = 0; i < str.length(); i++) {
			c = str.charAt(i);
			if (c >= 65 && c <= 90) {//65-90={A-Z},97-122{a=z}
				c += ('a' - 'A');
			}
			if (letters[c] == 0) {
				letters[c]++;
				sb.append(str.charAt(i));
			} else {
				letters[c]--;
			}
		}
		return sb.toString();
	}

}
