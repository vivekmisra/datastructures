package org.vivek.myinterview.strings.problems.characters;

public class CountACharOccurencesInAString {

	public CountACharOccurencesInAString() {

	}

	public static void main(String[] args) {			
		System.out.println(countRun( "Add dog", 'D' ) ); //should return 0
		System.out.println(countRun( "Hope you're happy", 'p' )); //should return 1
		 System.out.println(countRun( "CCCCCcccC", 'C' )); //should return 5
		 System.out.println(countRun2( "1010001", '0' )); //should return 5
	}

	public static int countRun(String s, char c) {
		int counter = 0;
		boolean foundOne = false;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == c) {
				counter += 1;
				foundOne = true;
			} else {
				if (foundOne)
					break;
			}
		}

		return counter;
	}
	
	public static int countMaxConseqiutiveRun(String s, char c) {
		int counter = 0;
		boolean foundOne = false;
		int max =0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == c) {
				counter += 1;
				if(counter>max) {
					max = counter;
				}
				
			} else {
				max=0;
				counter=0;
			}
		}

		return max;
	}
	    
	
	public static int countRun2(String s, char c) {
		int[] counts = new int[256];
		int count = 0;
		char currChar;
		int max =0;
		for (int i = 0; i < s.length(); i++) {
			currChar = s.charAt(i);
			if (currChar == c) {// match
				counts[c]++;
			} else if (Character.isSpaceChar(currChar)) {
				counts[c] = 0;// reset counter for c
			} else {// no match
				if (counts[c] > max) {// return accumulated counts if you have
					max = counts[c];
					counts[c] = 0;
					
				}
			}
		}
		return max;
	}

}
