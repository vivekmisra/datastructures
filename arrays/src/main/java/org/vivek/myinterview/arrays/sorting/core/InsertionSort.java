/*Copyright (c) Apr 25, 2017 CareerMonk Publications and others.
 * E-Mail           	: info@careermonk.com 
 * Creation Date    	: 2015-01-10 06:15:46 
 * Last modification	: 2006-05-31 
               by		: Narasimha Karumanchi 
 * File Name			: InsertionSort.java
 * Book Title			: Data Structures And Algorithms Made In Java
 * Warranty         	: This software is provided "as is" without any 
 * 							warranty; without even the implied warranty of 
 * 							merchantability or fitness for a particular purpose. 
 * 
 */

package org.vivek.myinterview.arrays.sorting.core;

public class InsertionSort {
	static Integer[] a = new Integer[] { 11, 2, 1, 6, 8, 5, 3, 4 };

	public InsertionSort() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		sort(a);
		printArray(a);
		//sort2(a);
		printArray(a);

	}

	private static void sort(Integer[] a) {
		// Consdier first element as sorted [Left side] and rest as unsorted list
		//start from index 1 as you consider first element as sorted
		for (int i = 1; i < a.length; i++) {// loop thru unsorted list
			for (int j = i; j > 0; j--) {// Loop thru sorted list in reverse
				if (a[j-1] > a[j]) {// in case sorted list(j-1) element is greater than unsorted(j)
					/*
					 * for each j=i,move towards left till j>0 ,checking if element in
					 * left[sorted]greater than right[unsorted],swapping it to right
					 */
					swap(a, j - 1, j);//keep swapping inside loop in place
					printArray( a);
				}
			}
		}

	}

	private static void sort2(Integer[] a) {
		// Consdier first element at index 1 as sorted [Left side] and rest as unsorted
		// list
		for (int i = 1; i < a.length; i++) {// loop thru unsorted list
			int v = a[i];
			// Loop thru sorted list in reverse,whose last element is at index i-1
			for (int j = i - 1; j >= 0 && a[j] > v; j--) {// while Looping thru sorted list,keep checking if elements in
															// sorted listare greater than v,if yes,swap to right
				swap(a, j, j + 1);

			}
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
