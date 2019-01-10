package org.vivek.myinterview.strings.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringPermutations {

	public static void main(String args[]) {
		String str = "abc";
		System.out.println("***********GENERIC PERMUTAION************");
		int count =0;
		List<char[]> l=StringPermutationByRotation.generatePermutations(str);
		for(char[] s : l) {
			count++;
			System.out.println(s);
		}
		System.out.println("***********TOTAL:"+ count + " USING GENERIC PERMUTAION************");
		count =0;
		System.out.println("**********PERMUTAION BY STRING************");
		List<String> permutatedStringList = generatePermutations(str);
		for(String s : permutatedStringList) {
			count++;
			System.out.println(s);
		}
		System.out.println("***********TOTAL:"+ count + " PERMUTAION BY STRING************");
		System.out.println("**********unique PERMUTAION BY STRING************");
		count =0;
		Set<String> permutatedStringSet = generateUniquePermutations("foo");
		for(String s : permutatedStringSet) {
			count++;
			System.out.println(s);
		}
		System.out.println("***********TOTAL:"+ count + "unique PERMUTAION BY STRING************");
		/*Set<String> set = generatePerm("AABC");
		for (String s : set) {
			System.err.println(s);
		}*/
	}

	
	
	/*
	 * A method exposed to client to calculate permutation of String in Java.
	 */
	public static List<String> generatePermutations(String input) {
		String prefix="";
		String suffix =input;
		List<String> permutatedList = new ArrayList<String>();
		permutation(prefix, suffix,permutatedList);
		return permutatedList;
	}

	/*
	 * Recursive method which actually prints all permutations of given String, but
	 * since we are passing an empty String as current permutation to start with, I
	 * have made this method private and didn't exposed it to client.
	 *     _______
	 *    |       |
	 * | \/ |   |  "a"  |
	 * |    |   |  "b"  |
	 * |__ _|   |__"c"_ |
	 * prefix     suffix
	 * permutation("", "abc",permutatedList);
	 * if((suffix.isEmpty()) {
	 *   //add prefix to collection
	 * }else{
	 *   prefix="" suffix="abc"       
	 *   Loop: suffix="abc" 
	 *       
	 *         i=0:prefix+suffix.chatAt(i),suffix.subString(0,i)+suffix.subString(i+1,suffix.length());
	 *            ("a","bc")
	 *                  |
	 *                  prefix="a" suffix="bc"
	 *                  Loop:suffix="bc"   
	 *                      i=0:prefix+suffix.chatAt(i),suffix.subString(0,i)+suffix.subString(i+1,suffix.length());
	 *                      ("ab","c")
	 *                             |
	 *                              prefix="ab" suffix="c"
	 *                              Loop:suffix="c"
	 *                                  i=0:prefix+suffix.chatAt(i),suffix.subString(0,i)+suffix.subString(i+1,suffix.length());
	 *                                  ("abc","")
	 *           
	 *                  
	 *                    i=1:prefix+suffix.chatAt(i),suffix.subString(0,i)+suffix.subString(i+1,suffix.length());
	 *                    ("ac","b")
	 *                           |
	 *                           prefix="ac" suffix="b"
	 *                           Loop:suffix="b"
	 *                               i=0:prefix+suffix.chatAt(i),suffix.subString(0,i)+suffix.subString(i+1,suffix.length());
	 *                               ("acb","")
	 
	 *            
	 *        i=1:
	 *          ("b","ac")
	 *                |
	 *                prefix="b" suffix="ac"
	 *                Loop: suffix"ac"  
	 *                 
	 *                    i=0:prefix+suffix.chatAt(i),suffix.subString(0,i)+suffix.subString(i+1,suffix.length());
	 *                     ("ba","c")
	 *                             |
	 *                             prefix="ba" suffix="c"
	 *                             Loop:suffix="c"
	 *                                 i=0:prefix+suffix.chatAt(i),suffix.subString(0,i)+suffix.subString(i+1,suffix.length());
	 *                                 ("bac","")
	 
	 *                    
	 *                    i=1:prefix+suffix.chatAt(i),suffix.subString(0,i)+suffix.subString(i+1,suffix.length());  
	 *                     ("bc","a")
	 *                            |
	 *                            prefix="bc" suffix="a"
	 *                            Loop:suffix="a" 
	 *                                i=0:prefix+suffix.chatAt(i),suffix.subString(0,i)+suffix.subString(i+1,suffix.length());  
	 *                                ("bca","")       
	
	 *          
	 *        i=2:
	 *          ("c","ab") 
	 *                |
	 *               prefix="c" suffix="ab"
	 *               Loop: suffix="ab"
	 *                    i=0:prefix+suffix.chatAt(i),suffix.subString(0,i)+suffix.subString(i+1,suffix.length());
	 *                      ("ca","b")
	 *                             |
	 *                               prefix="ca" suffix="b"
	 *                               Loop:suffix="b"
	 *                                   i=0:prefix+suffix.chatAt(i),suffix.subString(0,i)+suffix.subString(i+1,suffix.length()); 
	 *                                   ("cab","")
	 *                    
	 *                    
	 *                    i=1:prefix+suffix.chatAt(i),suffix.subString(0,i)+suffix.subString(i+1,suffix.length());
	 *                       ("cb","a")
	 *                              |
	 *                               prefix="cb" suffix="a"
	 *                               Loop:suffix="a"
	 *                                   i=0:prefix+suffix.chatAt(i),suffix.subString(0,i)+suffix.subString(i+1,suffix.length()); 
	 *                                   ("cba","")
	 *     
	 * 
	 */
	private static void permutation(String prefix, String suffix, List<String> permutatedList) {
		if (suffix.isEmpty()) {
			permutatedList.add(prefix);
		} else {
			for (int i = 0; i < suffix.length(); i++) {
				permutation(prefix+ suffix.charAt(i), suffix.substring(0,i)+suffix.substring(i + 1, suffix.length()),permutatedList);
			}
		}

	}
	
	
	
	
	public static Set<String> generateUniquePermutations(String input) {
		String prefix="";
		String suffix =input;
		Set<String> permutatedList = new HashSet<String>();
		uniquePermutation(prefix, suffix,permutatedList);
		return permutatedList;
	}
	private static void uniquePermutation(String prefix, String suffix, Set<String> permutatedList) {
		if (suffix.isEmpty()) {
			permutatedList.add(prefix);
		} else {
			for (int i = 0; i < suffix.length(); i++) {
				uniquePermutation(prefix+ suffix.charAt(i), suffix.substring(0,i)+suffix.substring(i + 1, suffix.length()),permutatedList);
			}
		}

	}

	public static Set<String> generateUniquePerm(String input) {
		Set<String> set = new HashSet<String>();
		if (input == "")
			return set;

		Character a = input.charAt(0);

		if (input.length() > 1) {
			input = input.substring(1);

			Set<String> permSet = generateUniquePerm(input);

			for (String x : permSet) {
				for (int i = 0; i <= x.length(); i++) {
					set.add(x.substring(0, i) + a + x.substring(i));
				}
			}
		} else {
			set.add(a + "");
		}
		return set;
	}
}
