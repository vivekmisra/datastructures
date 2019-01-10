/*Copyright (c) Apr 27, 2017 CareerMonk Publications and others.
 * E-Mail           	: info@careermonk.com 
 * Creation Date    	: 2015-01-10 06:15:46 
 * Last modification	: 2006-05-31 
               by		: Narasimha Karumanchi 
 * File Name			: KthSmallest.java
 * Book Title			: Data Structures And Algorithms Made In Java
 * Warranty         	: This software is provided "as is" without any 
 * 							warranty; without even the implied warranty of 
 * 							merchantability or fitness for a particular purpose. 
 * 
 */

package org.vivek.myinterview.arrays.sorting.problems;



public class KthSmallestUsingSelectionSort {

	public KthSmallestUsingSelectionSort() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] a = new Integer[] { 11, 2,7, 6, 8, 5,9, 4 };

		System.out.println("kth smallest for k=2 is =" + findKthSmallest(a, a.length, 2));
	}
	/*
	 * Time complexity is O(n*k)
	 */

	static int findKthSmallest(Integer a[], int n, int k) {
		// Sort the given array
		System.out.println("Before partial sort till:"+ k +" th ");
		printArray(a);
		partialSort(a, k);
		System.out.println("After partial sort:");
		printArray(a);
		// Return k'th element in the sorted array
		return a[k - 1];
	}

	public static void partialSort(Integer[] a, int k) {
		int minIndex = 0;

		for (int i = 0; i < k; i++) {
			minIndex = i;// default minimum to index i
			
			for (int j = i + 1; j < a.length; j++) {// loop thru index over
													// right
				if (a[j] < a[minIndex]) {// if value a[j] is less than value
											// a[minIndex],than a[j] is new min
					minIndex = j;
					
				}
			}
			swap(a, minIndex, i);

		}

	}

	public static void swap(Integer[] a, int left, int right) {
		int temp = a[left];
		a[left] = a[right];
		a[right] = temp;
	}

	public static void printArray(Integer[] a) {
		for (int i : a) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

}
