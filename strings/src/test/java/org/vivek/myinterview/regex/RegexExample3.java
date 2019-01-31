package org.vivek.myinterview.regex;

import java.util.regex.Pattern;

public class RegexExample3 {
	
	public static void main(String args[]){  
		System.out.println(Pattern.matches("^The end$", "The end"));//Any character except a, b, or c (negation)
		System.out.println(Pattern.matches("[amn]", "am"));//true (among a or m or n)  
		System.out.println(Pattern.matches("[amn]", "ammmna"));//false (m and a comes more than once)  
		}

}
