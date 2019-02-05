package org.vivek.myinterview.strings.problems.characters;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MakeStringOfAlternatiingCharacters {

	public static void main(String[] args) {
		String s = "beabeefeab";
		String str = s.replaceAll("[^ba]","");//match everything except a|b|ab and replace then with blank
		//above regex will match e[1] e[4] e[5] f[6] e[7] from string str, [i] representing index i and replacing these with "" will return babab
		System.out.println(str);
		int k=makeAndFindMaxLengthOfAlternatingCharactersinString(s);
		System.out.println("makeAndFindMaxLengthOfAlternatingCharactersinString="+k);

	} 
	/*static int makeAndFindMaxLengthOfAlternatingCharactersinString(String s) {
		 Set<Character> h = new HashSet<Character>();;
		
		for(int i=0;i <s.length();i++){
			
			char c1 = s.charAt(i);
			h.add(c1);
			if((i+1) <s.length()){
				char c2 = s.charAt(i+1);
				if (c1==c2){//consqutive
					
				}
				
			}
		}
		// Set<Character> h = findDistinctCharacters(h);
		return 0;


    }*/
	static int makeAndFindMaxLengthOfAlternatingCharactersinString(String s){
	    Set<Character> distinctCharactersSet = new HashSet<Character>();

	    for (int i = 0; i < s.length(); i++) {
	        distinctCharactersSet.add(s.charAt(i));
	    }

	    Character[] distinctCharArray = distinctCharactersSet.toArray(new Character[distinctCharactersSet.size()]);
	    int max = 0;

	    for (int j = 0; j < distinctCharArray.length - 1; j++) {
	        for (int k = j + 1; k < distinctCharArray.length; k++) {
	            String pattern = "([^" + distinctCharArray[j] + distinctCharArray[k] + "])";
	            String trimmedStr = s.replaceAll(pattern, "");
	            System.out.println("s.replaceAll("+pattern+",/"+")");
	            System.out.println("trimmedStr = "+trimmedStr);
	            if (isTwoCharacter(trimmedStr) && trimmedStr.length() > max) {
	            	System.out.println(" valid trimmedStr => "+trimmedStr);
	                max = trimmedStr.length();
	            }
	        }
	    }
	    return max;
	}

	static boolean isTwoCharacter(String s) {
	    for (int i = 0; i < s.length() - 1; i++) {
	        if (s.charAt(i) == s.charAt(i+1)) {
	            return false;
	        }
	    }
	    return true;
	}

}
