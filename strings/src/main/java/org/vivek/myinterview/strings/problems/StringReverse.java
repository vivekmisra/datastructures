package org.vivek.myinterview.strings.problems;

public class StringReverse {

	public StringReverse() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * reverse("Hello")
				(reverse("ello")) + "H"
				 ((reverse("llo")) + "e") + "H"
					(((reverse("lo")) + "l") + "e") + "H"
					 ((((reverse("o")) + "l") + "l") + "e") + "H"
					     (((("o") + "l") + "l") + "e") + "H"
					==>"olleH"
	 */
	public static String reverse(String str) {
	    if ((null == str) || (str.length() <= 1)) {
	        return str;
	    }
	    return reverse(str.substring(1)) + str.charAt(0);
	}
	public static void main(String[] args) {
		System.out.println(reverse("Hello"));

	}

}
