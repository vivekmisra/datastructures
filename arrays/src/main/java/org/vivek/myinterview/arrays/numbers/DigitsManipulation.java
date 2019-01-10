package org.vivek.myinterview.arrays.numbers;

import java.util.Arrays;

public class DigitsManipulation {

	public DigitsManipulation() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		/*
		 * d)n(q - r
		 * 
		 * d.q+r =n
		 * 
		 * n%d=r n/d=q (for integer division ,r is ignored in java ) Integer division
		 * rounds toward 0. That is, the quotient produced for operands n and d that are
		 * integers after binary numeric promotion (§5.6.2) is an integer value q whose
		 * magnitude is as large as possible while satisfying |d · q| ≤ |n|.
		 * 
		 */
		int a = 5 % 3; // 2
		int b = 5 / 3; // 1
		System.out.println("5%3 produces " + a + " (note that 5/3 produces " + b + ")");

		int c = 5 % (-3); // 2
		int d = 5 / (-3); // -1
		System.out.println("5%(-3) produces " + c + " (note that 5/(-3) produces " + d + ")");

		int e = (-5) % 3; // -2
		int f = (-5) / 3; // -1
		System.out.println("(-5)%3 produces " + e + " (note that (-5)/3 produces " + f + ")");

		int g = (-5) % (-3); // -2
		int h = (-5) / (-3); // 1
		System.out.println("(-5)%(-3) produces " + g + " (note that (-5)/(-3) produces " + h + ")");

		int n = 567;
		System.out.println("last digit of " + n + "is =" + getLastDigit(n));
		System.out.println("last 2 digits of " + n + "is =" + getLast2Digits(n));

		System.out.println("number of  digits of " + n + "is =" + repeatedDivision(n));

		System.out.println("getFirstDigit( " + n + ") is =" + getFirstDigit(n));
		
		System.out.println("findProduct( " + 1234 + ") is =" + findProduct(new int[] {1,2,3,4}));
		
	}

	static int getLastDigit(int n) {
		int r = n % 10;
		return r;
	}

	static int getLast2Digits(int n) {
		int r = n % 100;
		return r;
	}

	static int getFirstDigit(int n) {
		while (n / 10 > 0) {
			n = n / 10;
		}
		return n;
	}

	public static int repeatedDivision(long number) {
		int count = 0;
		while (number > 0) {
			count += 1;
			number = (number / 10);
		}
		return count;
	}
	
	static Integer[] getDigitsArray(int n) {
		NumberOfDigits noOfDigits = new NumberOfDigits();
		int length = noOfDigits.divideAndConquer(n);
		Integer[] digits = new Integer[length];
		int i = length - 1;
		while (i >= 0) {
			digits[i] = n % 10;
			n = n / 10;
			i--;
		}
		return digits;
	}
	
	public static int[] findProduct(int arr[]) {
		int[] product = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			int pr = 1;
			for (int j = arr.length - 1; j >= 0; j--) {
				if (arr[j] != arr[i]) {
					pr = arr[j] * pr;
				}
			}
			product[i] = pr;

		}
	    
	    System.out.println(" product ="+ Arrays.toString(product));
	    return product; 
	   } 
	
	static Integer getNumberFromDigitsArray( Integer[] digits) {
		int num = 0;
		for (int digit : digits) {
		  num = 10*num + digit;
		}
		return num;
	}
	
	

}
