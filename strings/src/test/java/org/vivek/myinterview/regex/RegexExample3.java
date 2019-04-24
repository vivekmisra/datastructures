package org.vivek.myinterview.regex;

import java.util.regex.Pattern;

public class RegexExample3 {
	
	public static void main(String args[]){  
		System.out.println(Pattern.matches("^The end$", "The end"));//Any character except a, b, or c (negation)
		System.out.println(Pattern.matches("[amn]", "am"));//true (among a or m or n)  
		System.out.println(Pattern.matches("[amn]", "ammmna"));//false (m and a comes more than once)
		String abbr ="i12iz4n";
		int p2=0;
		while(p2<abbr.length()) {
			StringBuffer sb = new StringBuffer();
			char curr = abbr.charAt(p2);
			
			while(p2<abbr.length()&& abbr.charAt(p2)>'0' &&abbr.charAt(p2)<'9') {
				sb.append(abbr.charAt(p2));
				
			}
			p2++;
			System.out.println(sb.toString());
		}
			
	}
		

}
