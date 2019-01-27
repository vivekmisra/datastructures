/*Copyright (c) May 26, 2017 CareerMonk Publications and others.
 * E-Mail           	: info@careermonk.com 
 * Creation Date    	: 2015-01-10 06:15:46 
 * Last modification	: 2006-05-31 
               by		: Narasimha Karumanchi 
 * File Name			: CountFrequencies.java
 * Book Title			: Data Structures And Algorithms Made In Java
 * Warranty         	: This software is provided "as is" without any 
 * 							warranty; without even the implied warranty of 
 * 							merchantability or fitness for a particular purpose. 
 * 
 */

package org.vivek.myinterview.arrays.general.problems;

import java.util.HashMap;

public class CountFrequencies {
	// Function to find counts of all elements present in
	// arr[0..n-1]. The array elements must be range from
	// 1 to n
	void findCounts(int arr[], int n) {
		// Traverse all array elements
		int i = 0;
		while (i < n) {
			// If this element is already processed,
			// then nothing to do
			if (arr[i] <= 0) {
				i++;
				continue;
			}

			// Find index corresponding to this element
			// For example, index for 5 is 4
			int elementIndex = arr[i] - 1;
			System.out.println("elementIndex =" + elementIndex);
			// If the elementIndex has an element that is not
			// processed yet, then first store that element
			// to arr[i] so that we don't loose anything.
			if (arr[elementIndex] > 0) {
				arr[i] = arr[elementIndex];

				// After storing arr[elementIndex], change it
				// to store initial count of 'arr[i]'
				arr[elementIndex] = -1;
			} else {
				// If this is NOT first occurrence of arr[i],
				// then increment its count.
				arr[elementIndex]--;

				// And initialize arr[i] as 0 means the element
				// 'i+1' is not seen so far
				arr[i] = 0;
				i++;
			}
		}

		System.out.println("Below are counts of all elements");
		for (int j = 0; j < n; j++)
			System.out.println(j + 1 + "->" + Math.abs(arr[j]));
	}

	static void printfrequency(int arr[]) {
		// Subtract 1 from every element so that the elements
		// become in range from 0 to n-1
		int n = arr.length-1;
		printArray( arr);
		for (int j = 0; j < n; j++) {
			System.out.print(" arr[j]="+ arr[j]+"--->");
			arr[j] = arr[j] - 1;
			System.out.println("arr[j]="+ arr[j]);
		}
		printArray( arr);
		// Use every element arr[i] as index and add 'n' to
		// element present at arr[i]%n to keep track of count of
		// occurrences of arr[i]
		for (int i = 0; i < n; i++){
			System.out.println();;
			int k = arr[i] % n;
			System.out.println("i="+i+",arr[i]%n="+ arr[i]+"%"+n+"="+ k);;
			arr[k] = arr[k] + n;
			System.out.println(" after :arr["+k+"]+"+n+"="+ arr[k]);;
			
		}
		
		/**
		 * a[i]-1
		 * if number is repeated then 
		 * 1sr occurence value a[i]=(a[i] + n )
		 * 2nd  a[i] = previous + n ==> a[i]+n + n
		 * 3rd ...
		 * then u divide by n so u will get factor of n which will denote number of repetition
		 */
		printArray( arr);
		// To print counts, simply print the number of times n
		// was added at index corresponding to every element
		for (int i = 0; i < n; i++)
			System.out.println(i + 1 + "->" + arr[i] / n);
	}
	
	 public static void countfreq(int arr[]){
	        HashMap<Integer,Integer> h = new HashMap<Integer,Integer>();
	       
	        for(int i=0; i<arr.length; i++){
	            if(h.containsKey(arr[i])){
	                h.put(arr[i], h.get(arr[i]) + 1);
	            } else {
	                h.put(arr[i], 1);
	            }
	        }
	        System.out.println(h);
	    }

	// Driver program to test above functions
	public static void main(String[] args) {
		 int arr1[] = new int[]{2,2,3,3,5,6,7,9,9,0};
		 printArray(arr1);
		printfrequency(arr1);
		countfreq(arr1);
		CountFrequencies count = new CountFrequencies();
		System.out.println("************");
		
		int arr2[] = { 2, 3, 3, 2, 4 };
		printArray(arr2);
	    printfrequency(arr2);
		count.findCounts(arr2, arr2.length);		
		System.out.println("************");
		
		
		int arr3[] = { 1 };
		printArray(arr3);
		count.findCounts(arr3, arr3.length);
		System.out.println("************");
		
		int arr4[] = { 1, 3, 5, 7, 9, 1, 3, 5, 7, 9, 1 };
		printArray(arr4);
		count.findCounts(arr4, arr4.length);
		System.out.println("************");

		int arr5[] = { 4, 4, 4, 4 };
		printArray(arr5);
		count.findCounts(arr5, arr5.length);
		System.out.println("************");

		int arr6[] = { 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3 };
		printArray(arr6);
		count.findCounts(arr6, arr6.length);
		System.out.println("************");
		
		int arr7[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
		printArray(arr7);
		count.findCounts(arr7, arr7.length);
		System.out.println("************");
		
		int arr8[] = { 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		printArray(arr8);
		count.findCounts(arr8, arr8.length);
		System.out.println("************");
	}

	public static void printArray(int[] a) {
		for (int i : a) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
