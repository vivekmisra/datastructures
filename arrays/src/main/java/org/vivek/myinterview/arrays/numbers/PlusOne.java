package org.vivek.myinterview.arrays.numbers;

import java.util.Stack;

public class PlusOne {

	public static void main(String[] args) {
		//int[] digits = { 1, 2, 9 };
		int[] digits = { 7, 9,9 };
		int[] arr = plusOne(digits);
		printArray(arr);
		int[] arr1 = plusOne1(digits);
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

	public static int[] plusOne(int[] digits) {
		Stack<Integer> s = new Stack();
		boolean carry = true;
		for(int i=digits.length-1;i>=0;i--){
			int r =  digits[i];
			if(carry){
			   r = r +1 ;
			}
			if (r >= 10) {
				r = r % 10;
				System.out.println("pushing r=" + r + "to stack");
				s.push(r);
				carry = true;
				if(i==0 && r==0){
					s.push(1);
				}
			}else{
				carry = false;
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
	
	
	public static int[] plusOne1(int[] digits) {
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
