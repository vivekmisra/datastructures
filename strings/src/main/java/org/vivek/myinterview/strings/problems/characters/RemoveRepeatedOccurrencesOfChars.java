package org.vivek.myinterview.strings.problems.characters;

import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class RemoveRepeatedOccurrencesOfChars {

	public RemoveRepeatedOccurrencesOfChars() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aaabcccdddkhhh";
		int l = s.length(); // Finding the length of the word

		System.out.println("ORIGINAL s=" + s);
		// String strippedString1 = stripByRegex(s);
		// System.out.println("strippedString1=" + strippedString1 );
		// String strippedString2 = stripBySubString(s);
		// System.out.println("strippedString2=" + strippedString2);
		// String strippedString3 = stripByStringBuilder(s);
		// System.out.println("strippedString3=" + strippedString3);
		//System.out.println("strippedString4=" + stripNConsecutiveCharacters("GooGle", 2));
		//3,1,2,2,2,1,1,1,2,2,3,1,1,2,2,2,1,1,1,2,3
		//System.out.println("strippedString4=" + checkNConsecutiveCharacters("Google"));
		int[] nums = {3,1,2,2,2,1,1,1,2,2,3,1,1,2,2,2,1,1,1,2,3};
		Set set = new HashSet();
		for(int i : nums) {
			set.add(i);
		}
		int[] foo = removeDuplicates(nums);
		//System.out.println("strippedString4=" + stripConsecutive(nums));
		
		
	}
	// s = strip(s);

	private static String stripBySubString(String s) {
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == s.charAt(i - 1)) {
				s = s.substring(0, i - 1) + s.substring(i + 1);
				i = 0;
			}
		}

		return s;
	}

	private static String stripByStringBuilder(String s) {
		StringBuilder sb = new StringBuilder(s);
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == s.charAt(i - 1)) {
				sb = sb.delete(i - 1, i + 1);
				s = sb.toString();
				i = 0;
			}
		}

		return sb.toString();
	}

	private static int[] stripConsecutive(int [] nums ) {
	//	int prunedList = new ArrayList<Integer>();
		
		int acsciiCounter = 0;
		int consecutiveRepeatedCharactersCounter = 0;
		for (int i = 0; i < nums.length; i++) {
			
			int currCharAscii= 48+ nums[i];
		
			
			acsciiCounter = currCharAscii + acsciiCounter;
			int totalAscii = acsciiCounter % currCharAscii;
			if (totalAscii == 0) {
				consecutiveRepeatedCharactersCounter = consecutiveRepeatedCharactersCounter + 1;
				if (consecutiveRepeatedCharactersCounter == 2) {
					nums[i] = nums[++i];
					acsciiCounter = 0;
					consecutiveRepeatedCharactersCounter = 0;
				}
			} else {
				acsciiCounter = currCharAscii;
				consecutiveRepeatedCharactersCounter = 1;
			}
		}
	
		return nums;
		//System.out.println("Stripped "+N+" consecutive character string=" + s);
		
	}
	public static int[] removeDuplicates(int[] nums) {
		int len = nums.length;
		int acsciiCounter = 0;
		int consecutiveRepeatedCharactersCounter = 0;
		if (len == 0)
			return null;
		List<Integer> list = new ArrayList<Integer>();
		int i = 0, j = 1;
		list.add(nums[0]);
		while (j < len) {
            int currCharAscii= 48+ nums[i];
		
			
			acsciiCounter = currCharAscii + acsciiCounter;
			int totalAscii = acsciiCounter % currCharAscii;
			if (totalAscii == 0) {
				
				consecutiveRepeatedCharactersCounter = consecutiveRepeatedCharactersCounter + 1;
				if (nums[i] != nums[j] && consecutiveRepeatedCharactersCounter==1) {
					i++;
					nums[i] = nums[j];
					
					list.add(nums[i]);
				}else 	 
				if (consecutiveRepeatedCharactersCounter == 2) {
					
			                
					acsciiCounter = 0;
					consecutiveRepeatedCharactersCounter = 0;
				}
			} else {
				acsciiCounter = currCharAscii;
				consecutiveRepeatedCharactersCounter = 1;
				/*if (nums[i] != nums[j]) {
					i++;
					nums[i] = nums[j];
					
					list.add(nums[i]);
				}*/
			}
			j++;
			//If not same,copy nums[j] to nums[i]and increment index
			//This way nums[i] ,nums[i+1] ...etx will be distinct numbers
			
		}
	 
		if (list.isEmpty())
			return null;
		int[] prunednums = new int[list.size()];
		for (int k = 0; k < list.size(); k++) {
			prunednums[k] = list.get(k);
		}
		return prunednums;
	}
	
	private static String stripNConsecutiveCharacters(String s) {
		StringBuilder sb = new StringBuilder(s);
		//System.out.println("Orignal string=" + s);
		int acsciiCounter = 0;
		int consecutiveRepeatedCharactersCounter = 0;
		for (int i = 0; i < s.length(); i++) {
			char currChar = s.charAt(i);
			int currCharAscii = (int) currChar;
			acsciiCounter = currCharAscii + acsciiCounter;
			int totalAscii = acsciiCounter % currCharAscii;
			if (totalAscii == 0) {
				consecutiveRepeatedCharactersCounter = consecutiveRepeatedCharactersCounter + 1;
				if (consecutiveRepeatedCharactersCounter >1) {
					int startIndex = i - 1 + 1;
					sb = sb.delete(startIndex, i + 1);
					s = sb.toString();
					i = -1;
					acsciiCounter = 0;
					consecutiveRepeatedCharactersCounter = 0;
				}
			} else {
				acsciiCounter = currCharAscii;
				consecutiveRepeatedCharactersCounter = 1;
			}
		}
		String result = sb.toString();
		if(result.length()==0) {
			return "Empty String";
		}else {
			return sb.toString();
		}
		//System.out.println("Stripped "+N+" consecutive character string=" + s);
		
	}
	
	static boolean checkNConsecutiveCharacters(String s) {
		int acsciiCounter = 0;
		int consecutiveRepeatedCharactersCounter = 0;
		for (int i = 0; i < s.length(); i++) {
			char currChar = s.charAt(i);
			int ascii = (int) currChar;
			acsciiCounter = ascii + acsciiCounter;
			int totalAscii = acsciiCounter % currChar;
			if (totalAscii == 0) {
				consecutiveRepeatedCharactersCounter = consecutiveRepeatedCharactersCounter + 1;
				if (consecutiveRepeatedCharactersCounter >1) {
				return true;
				}
			} else {
				acsciiCounter = ascii;
				consecutiveRepeatedCharactersCounter = 1;
			}
		}
		return false;
	}

	private static String stripByRegex(String s) {
		while (true) {
			// Used for loop termination
			int len = s.length();

			// "(.)" is a capturing group that captures any character
			// "\\1" is a backreference that will match the character captured by the first
			// capturing group (i.e. the one captured by "(.)")
			s = s.replaceAll("(.)\\1", "");

			// If no changes were made to string, break loop
			if (s.length() == len) {
				break;
			}
		}
		return s;
	}

	private static String stripContinuosChars(String s) {
		s = s + " "; // Adding a space at the end of the word
		int l = s.length(); // Finding the length of the word
		String ans = ""; // Variable to store the final result
		char ch1, ch2;
		int[] counts = new int[256]; // maximum value of an ASCII character
		System.out.println("s=" + s);
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < l - 1; i++) {

			ch1 = s.charAt(i); // Extracting the first character
			ch2 = s.charAt(i + 1); // Extracting the next character
			// Adding the first extracted character to the result if the current and the
			// next characters are different
			System.out.println("ch1=" + ch1);
			System.out.println("ch2=" + ch2);
			System.out.println("counts[" + ch1 + "]=" + counts[ch1]);
			System.out.println("org ans=" + s);
			System.out.println("updated ans=" + sb.toString());
			if ((ch1 != ch2)) {
				counts[ch1]++;
				String current = sb.toString();
				int ind = current.indexOf(ch1);
				if (counts[ch1] > 1 && ind >= 0) {
					System.out.println("current ans=" + current);
					current = current.replaceAll(String.valueOf(ch1), current);
					sb.append(current);
					System.out.println("updated ans=" + sb.toString());
				} else {
					sb.append(ch1);
					System.out.println("updated ans=" + sb.toString());
				}
				System.out.println("counts[" + ch1 + "]=" + counts[ch1]);
			} else {
				counts[ch1] = counts[ch1] + 2;
				System.out.println("counts[" + ch1 + "]=" + counts[ch1]);
				i = i + 1;
			}
		}
		return sb.toString();
	}

	private static String stripContinuosChars2(String s) {
		String pattern = "(\\w){2}";
		s = s.replaceFirst(pattern, "aa");
		System.out.println("after Nows =" + s);

		return s;
	}

}
