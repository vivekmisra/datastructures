package org.vivek.myinterview.strings.problems.characters;

public class RemoveAlternativeDuplicate {

	public static String removeAlternateDuplicates(String str) {
		StringBuffer sb = new StringBuffer();
		int charachters[] = new int[256];
		char c;
		for (int i = 0; i < str.length(); i++) {
		    c = str.charAt(i);
		    if (c >= 65 && c <= 90) {
			c = ('a' - 'A');
		    }
		    if (charachters[c] == 0) {
			charachters[c]++;
			sb.append(str.charAt(i));
		    } else {
			charachters[c]--;
		    }
		}
		return sb.toString();
	    }
	    public static void main(String[] args) {
		String str = "Today is the day";
		System.out.println(removeAlternateDuplicates(str));
	    }
}
