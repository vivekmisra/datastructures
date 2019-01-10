/*Copyright (c) Dec 21, 2014 CareerMonk Publications and others.
 * E-Mail           	: info@careermonk.com 
 * Creation Date    	: 2015-01-10 06:15:46 
 * Last modification	: 2006-05-31 
               by		: Narasimha Karumanchi 
 * Book Title			: Data Structures And Algorithms Made In Java
 * Warranty         	: This software is provided "as is" without any 
 * 							warranty; without even the implied warranty of 
 * 							merchantability or fitness for a particular purpose. 
 * 
 */

package org.vivek.myinterview.arrays.general.problems;

public class MissingNumberFromTwiceRepetitions {

	static int getMissingNumberByXOR(int a[]) {
		int n = a.length;
		int x1 = a[0];
		int x2 = 1;

		/*
		 * For xor of all the elements in array
		 */
		for (int i = 1; i < n; i++) {
			System.out.println("first:xor of "+ a[i]+"and"+ x1 );
			x1 = x1 ^ a[i];
			System.out.println("="+x1);
		}

		/*
		 * For xor of all the elements from 1 to n+1
		 */
		for (int i = 2; i <= n + 1; i++) {
			System.out.println("second:xor of "+ i+"and"+ x2 );
			x2 = x2 ^ i;
			System.out.println("="+x2);
		}
		System.out.println("final:xor of "+ x1+"and"+ x2 );
		return (x1 ^ x2);
	}
	
	static int getMissingNumberByXOR1(int a[]) {
		int n = a.length;
		int x1 = a[0];
		int x2 = 1;

		/*
		 * For xor of all the elements in array
		 */
		for (int i = 0; i < n; i++) {
			System.out.println("first:xor of "+ a[i]+"and"+ x1 );
			x1 = x1 ^ a[i];
			System.out.println("="+x1);
		}

		/*
		 * For xor of all the elements from 1 to n+1
		 */
		for (int i = 1; i <= n; i++) {
			System.out.println("second:xor of "+ i+"and"+ x2 );
			x2 = x2 ^ i;
			System.out.println("="+x2);
		}
		System.out.println("final:xor of "+ x1+"and"+ x2 );
		return (x1 ^ x2);
	}

	public static int getMissingNumberByBrute(int[] a) {
		boolean found = false;
		int missing = 0;
		int n = a.length;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (a[j] == i) {
					missing = 0;
					// come out & check next i
					break;

				} else {
					missing = i;// keep track
					// exhaust all array values
					continue;

				}

			}
			if (missing != 0) {
				return missing;
			}

		}
		return missing;
	}

	public static void main(String[] args) {
		int A[] = { 1, 2, 4, 6, 3, 7, 8 };
		//int A[] = { 1, 1, 1, 6, 7, 7, 8,8 };
		//int A[] = { 1, 2, 4, 5,6, 7, 8 };
		//int missingno = getMissingNumberByBrute(A);
	    // System.out.println("missingno =" + missingno);
		int missingno2 = getMissingNumberByXOR(A);
		System.out.println("missingno2 =" + missingno2);
	}
}
