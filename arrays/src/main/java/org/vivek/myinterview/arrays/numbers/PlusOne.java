package org.vivek.myinterview.arrays.numbers;

import java.util.Stack;

public class PlusOne {

	public static void main(String[] args) {
		//int[] digits = { 1, 2, 9 };
		int[] digits = { 3, 5,9 };
		int[] arr = plus(digits,9);
		printArray(arr);
		int[] arr1 = plusOne(digits);
		printArray(arr1);

	}
	
	private static String printArray(int[] anArray) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < anArray.length; i++) {
			if (i > 0) {
				sb.append(", ");
			}
			sb.append(anArray[i]);
		}
		System.out.println(sb.toString());
		return sb.toString();
	}

	public static int[] plus(int[] digits,int k) {
		Stack<Integer> s = new Stack();
		boolean add = true;
		  int numOfDigits = digits.length;
		  int tensDigit =0;
		  int onesplaceOfk = 0;
		  int remainingDigitsOfK =0;
		  int placeValueSum =0;
		  int carry =0;
		for(int i=numOfDigits-1;i>=0;i--){
			int digit =  digits[i];
			 int numOfDigitsOfK = (int) Math.log10(k)+1;
			if(numOfDigitsOfK>=2){
				int n =k;
				remainingDigitsOfK =k/ 10;
				onesplaceOfk=k% 10;
				//k= unitDigit;
				k=onesplaceOfk;
			}
			
			if(add && k>0){
				placeValueSum = digit +k ;
				k=0;//reset
			}else{
				placeValueSum = digit +carry ;
			}
			if (placeValueSum >= 10) {
				int n= digit;
				carry =placeValueSum/ 10;
				int onesPlaceOfSum = placeValueSum % 10;
			System.out.println("pushing onesPlaceOfSum=" + onesPlaceOfSum + "to stack");
				s.push(onesPlaceOfSum);
				if(numOfDigitsOfK>=2||tensDigit>0){
					k= remainingDigitsOfK;
					// tensDigit=0;
				}
				add = true;
				if(i==0 && onesPlaceOfSum==0){
					//just push 1 as number is single digit
					s.push(1);
				}
			}else{
				carry=0;
				if(tensDigit>0){
					k= tensDigit;
				    add = true;
				    tensDigit=0;
				}else{
				add = false;
				}
				
				s.push(placeValueSum);
			}
		}
		int[] arr = new int[s.size()];
		int i = 0;
		while (!s.empty()) {
			arr[i] = s.pop();
			i++;
		}
		return arr;
	}
	
	
	public static int[] plusOne(int[] digits) {
	    int carry = 1;
	    for (int i = digits.length-1; i>= 0; i--) {
	        digits[i] += carry;
	        if (digits[i] <= 9) // early return 
	            return digits;
	        digits[i] = 0;
	    }
	    int[] ret = new int[digits.length+1];
	    ret[0] = 1;
	    return ret;
	}
}
