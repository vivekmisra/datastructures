package org.vivek.myinterview.arrays.numbers;

public class BinaryString {

	public BinaryString() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int x=0b101;
		int y=0b110;
		int z=x+y;

		System.out.println(x + "+" + y + "=" + z);
		//5+6=11

		/*
		* If you want to output in binary format, use Integer.toBinaryString()
		*/

		System.out.println(Integer.toBinaryString(x) + "+" + Integer.toBinaryString(y)
		         + "=" + Integer.toBinaryString(z));

	}

}
