package org.vivek.myinterview.arrays.numbers;

import java.util.Stack;

public class PlusOne {

	public static void main(String[] args) {
		//int[] digits = { 1, 2, 9 };
		int[] digits = { 3, 5,2 };
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
		  int unitDigit =0;
		  int tensDigit =0;
		 
		for(int i=numOfDigits-1;i>=0;i--){
			int r =  digits[i];
			 int numOfDigitsOfK = (int) Math.log10(k)+1;
			if(numOfDigitsOfK>=2){
				int n =k;
				tensDigit =k/ 10;
				unitDigit = k% 10;
				k= unitDigit;
			}
			
			if(add){
			   r = r +k ;
			}
			if (r >= 10) {
				int n= r;
				tensDigit =n/ 10;
				r = r % 10;
				System.out.println("pushing r=" + r + "to stack");
				s.push(r);
				if(numOfDigitsOfK>=2||tensDigit>0){
					k= tensDigit;
					 tensDigit=0;
				}
				add = true;
				if(i==0 && r==0){
					s.push(1);
				}
			}else{
				if(tensDigit>0){
					k= tensDigit;
				    add = true;
				    tensDigit=0;
				}else{
				add = false;
				}
				
				s.push(r);
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
