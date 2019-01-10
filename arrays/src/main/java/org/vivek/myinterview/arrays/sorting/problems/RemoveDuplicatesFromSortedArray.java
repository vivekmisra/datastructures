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

package org.vivek.myinterview.arrays.sorting.problems;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {

	// static Integer[] a = new Integer[] { 2, 4, 1, 6, 2, 5, 5, 7 };
	public static int removeDuplicates(Integer[] A) {
		int len = A.length;
		int i = 0;
		if (len <= 1)
			return len;
		for (int j = 1; j < len; j++) {
			if (A[j] != A[i])
				A[++i] = A[j];
		}
		return i + 1;
	}

	static int removeDuplicates(Integer arr[], int n) {
		if (n == 0 || n == 1)
			return n;

		// To store index of next unique element
		int j = 0;

		// Doing same as done in Method 1
		// Just maintaining another updated index i.e. j
		for (int i = 0; i < n - 1; i++)
			if (arr[i] != arr[i + 1])
				arr[j++] = arr[i];

		arr[j++] = arr[n - 1];

		return j;
	}

	public static void main(String[] args) {
		Integer a[] = { 1, 2, 2, 3, 4, 4, 4, 5, 5 };
		int x = removeDuplicates(a);
		a = Arrays.copyOf(a, x);
		System.out.println(Arrays.deepToString(a));
		Integer arr[] = { 1, 2, 2, 3, 4, 4, 4, 5, 5 };
		int n = a.length;
		n = removeDuplicates(arr, arr.length);
		a = Arrays.copyOf(arr, n);
		System.out.println(Arrays.deepToString(arr));
		// Print updated array
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	}
}
