package org.vivek.myinterview.strings.problems.characters;

public class FindMissingConsecutiveNumber {

	public FindMissingConsecutiveNumber() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		//char s = findMissingNumberNConsecutiveCharacters("4111222333",3);
		char s = findMissingNumberNConsecutiveCharacters("11122233344455666",3);
		System.out.println(s);
		int [] nums = { 10,10,10,47,47,47,70,70,70,897,897,1,1,1};
		int N =3;
		int n = findMissingNumberNConsecutive(nums,N);
       System.out.println("Missing number is="+ n);
	}
	
	private static int findMissingNumberNConsecutive(int[] nums, int N) {
		char[] charArray = new char[nums.length] ;
		convertIntToCharArray(nums, charArray);
		String s = new String(charArray);
		StringBuilder sb = new StringBuilder(s);
		//System.out.println("Orignal string=" + s);
		char missingNumber =0;
		int acsciiCounter = 0;
		int consecutiveRepeatedCharactersCounter = 0;
		
		for (int i = 0; i < s.length(); i++) {
			char currChar = s.charAt(i);
			int ascii = (int) currChar;
			acsciiCounter = ascii + acsciiCounter;
			int totalAscii = acsciiCounter % currChar;
			if (totalAscii == 0) {
				consecutiveRepeatedCharactersCounter = consecutiveRepeatedCharactersCounter + 1;				
				if (consecutiveRepeatedCharactersCounter == N) {
					int startIndex = i - N + 1;
					sb = sb.delete(startIndex, i + 1);
					s = sb.toString();
					i = -1;
					acsciiCounter = 0;
					consecutiveRepeatedCharactersCounter = 0;
				}
			} else {
				int preascii = acsciiCounter -ascii;
				 int missingNumberAscciCode = preascii/consecutiveRepeatedCharactersCounter;
				 missingNumber = (char)missingNumberAscciCode;
				break;
			}	
		
		}
		return (int)missingNumber;
	}

	public static void convertIntToCharArray(int[] array, char[] charArray) {
	    int length = array.length;
	    for (int i = 0; i < length; i++) {
	        // this converts a integer into a character
	        charArray[i] = (char) array[i];
	    }
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
	
	private static char findMissingNumberNConsecutiveCharacters(String s, int N) {
		StringBuilder sb = new StringBuilder(s);
		//System.out.println("Orignal string=" + s);
		char missingNumber =0;
		int acsciiCounter = 0;
		int consecutiveRepeatedCharactersCounter = 0;
		
		for (int i = 0; i < s.length(); i++) {
			char currChar = s.charAt(i);
			int ascii = (int) currChar;
			acsciiCounter = ascii + acsciiCounter;
			int totalAscii = acsciiCounter % currChar;
			if (totalAscii == 0) {
				consecutiveRepeatedCharactersCounter = consecutiveRepeatedCharactersCounter + 1;				
				if (consecutiveRepeatedCharactersCounter == N) {
					int startIndex = i - N + 1;
					sb = sb.delete(startIndex, i + 1);
					s = sb.toString();
					i = -1;
					acsciiCounter = 0;
					consecutiveRepeatedCharactersCounter = 0;
				}
			} else {
				int preascii = acsciiCounter -ascii;
				 int missingNumberAscciCode = preascii/consecutiveRepeatedCharactersCounter;
				 missingNumber = (char)missingNumberAscciCode;
				break;
			}	
		
		}
		return missingNumber;
		
		//System.out.println("Stripped "+N+" consecutive character string=" + s);
		
	}

}
