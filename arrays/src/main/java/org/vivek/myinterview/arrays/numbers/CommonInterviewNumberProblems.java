package org.vivek.myinterview.arrays.numbers;

import java.util.Arrays;

public class CommonInterviewNumberProblems {

	public static void main(String[] args) {
		int [] nums1 = {5,10,12,50,60,70,100,150,780,1000,54545};
		for(int i : nums1) {
			int  divisor =1;
			while (i / divisor >= 10) {
				divisor =divisor* 10;
			}
		
		 System.out.println("divisor for " + i + " ,is="+ divisor);
		}
		
		 System.out.println("54545 is plaindrome number? " + isPalindrome(54545));
		 
		int[] nums2 = { 1, 232, 54545, 999991 }; 
	}
//formatter:off
/*
 * 
	Perfect Number
	https://www.geeksforgeeks.org/perfect-number/
	A number is a perfect number if is equal to sum of its proper divisors, that is, sum of its positive divisors excluding the number itself. Write a function to check if a given number is perfect or not.
	
	Examples:
	
	Input: n = 15
	Output: false
	Divisors of 15 are 1, 3 and 5. Sum of 
	divisors is 9 which is not equal to 15.
	
	Input: n = 6
	Output: true
	Divisors of 6 are 1, 2 and 3. Sum of 
	divisors is 6.
	
	
	A Simple Solution is to go through every number from 1 to n-1 and check if it is a divisor. 
	Maintain sum of all divisors. If sum becomes equal to n, then return true, else return false.
	boolean isPerfectNumber(int n){
         
        int temp = 0;
        for(int i=1;i<=n/2;i++){
            if(n%i == 0){
                temp += i;
            }
        }
        if(temp == n){
            System.out.println("It is a perfect number");
            return true;
        } else {
            System.out.println("It is not a perfect number");
            return false;
        }
    }
	
	An Efficient Solution is to go through numbers till square root of n. 
		If a number ‘i’ divides n, then add both ‘i’ and n/i to sum.
	
	Below is the implementation of efficient solution.
	Time Complexity: √n
 */
	static boolean isPerfect(int n) {
		// To store sum of divisors
		int sum = 1;

		// Find all divisors and add them
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				if (i * i != n)
					sum = sum + i + n / i;
				else
					sum = sum + i;
			}
		}
		// If sum of divisors is equal to
		// n, then n is a perfect number
		if (sum == n && n != 1)
			return true;

		return false;
	}
	
	/*
	 * To find the leading digit [first from left],find the appropriate divisor
	 * starting with default 1 and then multiple of 10to extract the leading digit .
	 * Once you find the appropriate divisor,divide number by that appropriate
	 * divisor.
	 */
	 
	static int findLeadingDigit(int n) {
		int divisor = 1;
		while (n / divisor >= 10) {
			divisor =divisor* 10;
		}
		 int leading = n / divisor; 
		return leading;

	}

	/*
	 * To find the traling digit,Find the remainder by dividing number by 10 to
	 * extract the leading digit [first from left]
	 * 
	 */
	static int findTrailingDigit(int n) {
		 int remainder = n % 10; 
		return remainder;

	}
	 
	
	/*Function to check if n is palindrome 
	 * */
	 
    static boolean isPalindrome(int n) 
    { 
        
        // extract the leading digit 
    	int  divisor =1;
		while (n / divisor >= 10) {
			divisor =divisor* 10;
		}
	//eg, For n= 54545, d=10000 
      
        while (n != 0) { 
            
        	 int leading = n / divisor;
        	 //eg  For n= 54545,leading =54545/10000=5(quotient)
        	 int trailing = n % 10; 
        	//eg  For n= 54545,trailing =54545%10000=5(remainder)
            // If first and last digits are 
            // not same then return false 
            if (leading != trailing) 
                return false; 
      
            // Removing the leading and trailing 
            // digits from the number 
           
            n = (n % divisor) / 10; //=5454/10=454
      
            // Reducing divisor by a factor 
            // of 2 as 2 digits are dropped 
            divisor = divisor / 100; 
        } 
        return true; 
    } 
    
    // Function to find the largest palindromic number 
    static int largestPalindrome(int []A, int n) 
    { 
      
        // Sort the array 
        Arrays.sort(A); 
      
        for (int i = n - 1; i >= 0; --i) { 
      
            // If number is palindrome 
            if (isPalindrome(A[i])) 
                return A[i]; 
        } 
      
        // If no palindromic number found 
        return -1; 
    } 

}
