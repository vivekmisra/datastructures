package org.vivek.myinterview.arrays.numbers;

public class NumberOfBitsOfANumber {

	public NumberOfBitsOfANumber() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int intNum = 1567;
		System.out.println(getNumberOfBits(intNum));
		long longNum = 1567L;
		System.out.println(getNumberOfBits(longNum ));

	}
	
	  private static int getNumberOfBits(final int number) {
	        return Integer.SIZE - Integer.numberOfLeadingZeros(number);
	    }

	    private static int getNumberOfBits(final long number) {
	        return Long.SIZE - Long.numberOfLeadingZeros(number);
	}

}
