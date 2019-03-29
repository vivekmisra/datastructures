package org.vivek.myinterview.strings.problems;

public class Subsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public boolean isSubsequence(String s, String t) {
	    if (s.length() == 0) return true;
	    int lastIndex = 0;
	    for (char c : s.toCharArray()) {
	        int newIndex = t.substring(lastIndex).indexOf(c);
	        if (newIndex == -1) {
	            return false;
	        }
	        lastIndex += newIndex + 1;
	    }
	    return true;
	}

}
