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

package org.vivek.myinterview.arrays.binarysearch.problems;

public class DutchNationalFlag {
	public static int[] dutchNationalFlag(int[] A) {
		int left = 0;// tracks 0
		int mid = 0;// tracks 1
		int pivot = 1;// pivot
		int right = A.length - 1;// tracks 2
		while (mid <= right) {
			if (pivot >A[mid]) {// current element is 0 as pivot value is 1
			   //move itto left and continue towards right
				swap(A, left, mid);
				++left;
				++mid;
			} else if (pivot <A[mid]) {// current element is 2 as pivot value is 1
				//move itto right and continue towards left
				swap(A, mid, right);
				--right;
			} else {// current element is 1 as it is equal tp pivot--do nothing just skip and move
				++mid;
			}
		}
		return A;
	}

	public static void swap(int[] a, int left, int right) {
		System.out.println("Inside swap(, left:" + left + ", right:" + right);
		int temp = a[left];
		a[left] = a[right];
		a[right] = temp;
	}

	public static void main(String[] args) {
		int[] A = { 2, 1, 0, 2, 2, 1, 1, 0, 0, 0 };
		A = dutchNationalFlag(A);
		for (int i = 0; i < A.length; i++) {
			System.out.print("   " + A[i]);
		}
	}
}
