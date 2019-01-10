package org.vivek.myinterview.arrays.numbers;

public class RoundingInteger {

	public  RoundingInteger() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		 RoundingInteger ri = new  RoundingInteger();
		 int num =3917;
		 NumberOfDigits noOfDigits = new NumberOfDigits();
		 System.out.println("Number of digits in "+ num+"="+noOfDigits.divideAndConquer(num));
		System.out.println("rounding"+ num+"-->"+ri.roundAbove(num));
		System.out.println("rounding below"+ num+"-->"+ri.roundBelow(num));

	}
	
	
	int roundAbove(int num ) {
		int rounded = ((num + 99) / 100 ) * 100;
		return rounded;
	}
	
	int roundBelow(int num ) {
		int rounded =0;
		if(num>100) {
		 rounded = ((num- 99) / 100 ) * 100+100;
		}
		return rounded;
	}

}
