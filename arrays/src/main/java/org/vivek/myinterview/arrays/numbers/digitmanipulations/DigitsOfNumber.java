package org.vivek.myinterview.arrays.numbers.digitmanipulations;

public class DigitsOfNumber {

	public DigitsOfNumber() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int n = 5678;
		int number = (int) Math.pow(10, 3);
		int numberOfDigits = (int) (Math.log10(n) + 1);
		System.out.println("n =" + n);
		int r3 = n % 5000;

		System.out.println("   r3 =" + r3);
		int lastDigitOfNumber = getLastDigit(n);
		int last2DigitsOfNumber = getLast2Digits(n);
		int last3DigitsOfNumber = getLast3Digits(n);
		int lastnDigitsOfNumber = getLastNDigits(n, 3);
		System.out.println("lastnDigitsOfNumber =" + lastnDigitsOfNumber);
		System.out.println("getFirstDigit =" + getFirstDigit(n));
		System.out.println("getFirstDigit2 =" + getFirstDigit2(n));
	}

	static int getLastDigit(int n) {
		int r = n % 10;
		return r;
	}

	static int getLast2Digits(int n) {
		int r = n % 100;
		return r;
	}

	static int getLast3Digits(int n) {
		int r = n % 1000;
		return r;
	}

	static int getLastNDigits(int n, int N) {
		int r = 0;
		// Find total number of digits - 1 ,here total number of digits
		// =(int)(Math.log10(n))+1
		int maxDivsorValue = (int) (Math.log10(n));// when u take log and cast to int ,it will give floor value eg.
													// 3.75419 will be 3 [log(5678)=3.75419]
		if (N <= maxDivsorValue) {
			int divisor = (int) Math.pow(10, N);//10**3=1000
			r = n % divisor;//eg 5678 %1000  =>remainder is 678 <--last 3 digits of 5678
		}
		return r;
	}

	static int getFirstDigit(int n) {
		while (n / 10 > 0) {
			n = n / 10;
		}
		return n;
	}

	static int getFirstDigit2(int n) {
		int r = 0;
		// Find total number of digits - 1 ,total number of digits
		// =(int)(Math.log10(n))+1
		int N = (int) (Math.log10(n));// when u take log and cast to int ,it will give floor value eg. 3.75419 will be
										// 3 [log(5678)=3.75419]
		int divisor = (int) Math.pow(10, N);/// 10*3 = 1000
		n = n / divisor;// 5678/1000 =5 as it is cast to int decimal r ignored
		return n;
	}

}
