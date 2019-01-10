package org.vivek.myinterview.arrays.numbers.digitmanipulations;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ReverseNumber {

	public ReverseNumber() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(5678+"==>reversed==>"+reverse(5678));
		System.out.println(123456789 +"==>reversed==>"+reverseRecursive(123456789,0));
	}

	static int reverse(int n) {
		List<Integer> l = new ArrayList<Integer>();
		while (n > 0) {
			int lastDigit = n % 10;//R-->L and get last digit 
			l.add(lastDigit);
			n = n / 10;// get digits from L-->R ,strip last digit and reassign
		}
		int reversenum = 0;
		for (int a : l) {
			reversenum = 10 * reversenum + a;
		}
		return reversenum;
	}
	
	static long reverseRecursive(long n,long rev) {
		
		if (n <= 0) {
			return rev;
		}
		
		long numberOfDigits = (long) (Math.log10(n) );
		long lastDigit = n % 10;//R-->L and get last digit 
		long placeValueOfNumber = (long) Math.pow(10, numberOfDigits);//10**3=1000
		rev = rev+ lastDigit*placeValueOfNumber;//eg 5678 ==>  8*1000=8000 added to previous number's lastdigit*placeValueOfNumber(rev,default=0)
		n = n / 10;// get digits from L-->R ,strip last digit and reassign, eg 5678 ==> 567
		return reverseRecursive(n,rev);//eg reverseRecursive(567,8000)
		
		}
	
      static long permute(long permuted,long n) {
		
		if (n <= 0) {
			return permuted;
		}
		
		long numberOfDigits = (long) (Math.log10(n) );
		long lastDigit = n % 10;//R-->L and get last digit 
		long placeValueOfNumber = (long) Math.pow(10, numberOfDigits);//10**3=1000
		permuted = permuted+ lastDigit*placeValueOfNumber;//eg 5678 ==>  8*1000=8000 added to previous number's lastdigit*placeValueOfNumber(rev,default=0)
		n = n / 10;// get digits from L-->R ,strip last digit and reassign, eg 5678 ==> 567
		return reverseRecursive(permuted,n);//eg reverseRecursive(567,8000)
		
		}

}
