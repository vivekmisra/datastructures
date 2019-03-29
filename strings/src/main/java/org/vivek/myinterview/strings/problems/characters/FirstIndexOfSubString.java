package org.vivek.myinterview.strings.problems.characters;

public class FirstIndexOfSubString {

	public static void main(String[] args) {
	String input="internnet";
	String pattern ="net";
	System.out.println(findIndex(input, pattern));
	}

	public static int findIndex(String input, String pattern) {
		int result = -1;
		if (input == null || pattern == null)
			return result;
		int inputLength = input.length();
		int patternLength = pattern.length();

		if (inputLength < patternLength)
			return result;
		for (int i = 0; i < inputLength; i++) {
			char cur = input.charAt(i);
			if (cur == pattern.charAt(0)) {
				if (i + patternLength <= inputLength) {
					if ((input.substring(i, patternLength + i).equals(pattern)))
						return i;
				} else
					return result;

			}
		}
		return result;
	}

}
