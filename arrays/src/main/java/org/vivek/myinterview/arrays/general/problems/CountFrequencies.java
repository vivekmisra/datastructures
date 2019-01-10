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

	void printfrequency(int arr[], int n) {
		// Subtract 1 from every element so that the elements
		// become in range from 0 to n-1
		for (int j = 0; j < n; j++)
			arr[j] = arr[j] - 1;

		// Use every element arr[i] as index and add 'n' to
		// element present at arr[i]%n to keep track of count of
		// occurrences of arr[i]
		for (int i = 0; i < n; i++){
			int k = arr[i] % n;
			System.out.println("k="+ k);;
			arr[k] = arr[k] + n;
			
		}

		// To print counts, simply print the number of times n
		// was added at index corresponding to every element
		for (int i = 0; i < n; i++)
			System.out.println(i + 1 + "->" + arr[i] / n);
	}
	
	 public static void countfreq(){
	        HashMap<Integer,Integer> h = new HashMap<Integer,Integer>();
	        int arr[] = new int[]{2,2,3,3,5,6,7,9,9,0};
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
		countfreq();
		/*CountFrequencies count = new CountFrequencies();
		System.out.println("************");
		int arr[] = { 2, 3, 3, 2, 4 };
		printArray(arr);
		count.printfrequency(arr, arr.length);
		count.findCounts(arr, arr.length);
		System.out.println("************");
		int arr1[] = { 1 };
		printArray(arr1);
		count.findCounts(arr1, arr1.length);
		System.out.println("************");
		int arr2[] = { 1, 3, 5, 7, 9, 1, 3, 5, 7, 9, 1 };
		printArray(arr2);
		count.findCounts(arr2, arr2.length);
		System.out.println("************");

		int arr3[] = { 4, 4, 4, 4 };
		printArray(arr3);
		count.findCounts(arr3, arr3.length);
		System.out.println("************");

		int arr4[] = { 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3 };
		printArray(arr4);
		count.findCounts(arr4, arr4.length);
		System.out.println("************");
		int arr5[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
		printArray(arr5);
		count.findCounts(arr5, arr5.length);
		System.out.println("************");
		int arr6[] = { 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		printArray(arr5);
		count.findCounts(arr6, arr6.length);
		System.out.println("************");*/
	}

	public static void printArray(int[] a) {
		for (int i : a) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
