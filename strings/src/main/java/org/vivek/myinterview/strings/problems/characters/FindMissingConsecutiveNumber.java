package org.vivek.myinterview.strings.problems.characters;

public class FindMissingConsecutiveNumber {

	public FindMissingConsecutiveNumber() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		//char s = findMissingNumberNConsecutiveCharacters("4111222333",3);
		char s = findMissingNumberNConsecutiveCharacters("11122233344455666",3);
		System.out.println(s);

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
