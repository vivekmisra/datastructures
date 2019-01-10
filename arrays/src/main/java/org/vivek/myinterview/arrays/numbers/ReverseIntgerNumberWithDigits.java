package org.vivek.myinterview.arrays.numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReverseIntgerNumberWithDigits {

	public ReverseIntgerNumberWithDigits() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("678/100=" + 678/100);
		System.out.println(" reverseNumber(" + 678 + ")" + Arrays.deepToString(reverseNumber(678)));
		System.out.println(" getArrayOfDigitsWithoutChangingOrder(" + 678 + ")" + Arrays.deepToString(getArrayOfDigitsWithoutChangingOrder(678)));
		System.out.println(" getIntegerNumberWithDigits(" + Arrays.deepToString(getArrayOfDigitsWithoutChangingOrder(678)) + ")=" + getIntegerNumberWithDigits(getArrayOfDigitsWithoutChangingOrder(678)));
	}

	static Object[] reverseNumber(int n) {
		/*
		 * use % 10 to get the last digit and then divide your int by 10 to get to the
		 * next one. this will leave you with ArrayList containing your digits in
		 * reverse order. You can easily revert it if it's required and convert it to
		 * int[].
		 */
		List<Integer> values = new ArrayList<Integer>();
		while (n > 0) {
			values.add(n % 10);//add last digit eg.678  add 8
			n /= 10; //now strip last digit==? 678 becomes 67 as 678/10=67
		}
		Object[] arr = (Object[]) values.toArray();
		return arr;
	}
	
	public static Integer[] getArrayOfDigitsWithoutChangingOrder(int num) {
	    List<Integer> digits = new ArrayList<Integer>();
	    collectDigits(num, digits);
	    return digits.toArray(new Integer[]{});
	}

	private static void collectDigits(int num, List<Integer> digits) {
	    if(num / 10 > 0) {
	        collectDigits(num / 10, digits);
	    }
	    digits.add(num % 10);
	}
	
	public static int getIntegerNumberWithDigits(Integer[] arr) {
		int num = 0;
		for (int a : arr) {
		  num = 10*num + a;
		}
		return num;
	}

}
