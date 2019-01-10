/*Copyright (c) Apr 25, 2017 CareerMonk Publications and others.
 * E-Mail           	: info@careermonk.com 
 * Creation Date    	: 2015-01-10 06:15:46 
 * Last modification	: 2006-05-31 
               by		: Narasimha Karumanchi 
 * File Name			: BubbleSort.java
 * Book Title			: Data Structures And Algorithms Made In Java
 * Warranty         	: This software is provided "as is" without any 
 * 							warranty; without even the implied warranty of 
 * 							merchantability or fitness for a particular purpose. 
 * 
 */

package org.vivek.myinterview.arrays.sorting.core;

public class BubbleSort {
	static Integer[] a = new Integer[] { 11, 2, 1, 6, 8, 5, 3, 4 };

	public BubbleSort() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		sort(a);
		printArray(a);

	}

	/*
	 * Bubble sort is by using a flag in a while loop to determine if the given
	 * list is sorted or not. Each loop will bubble up the largest
	 * value(smallest value for descending order) of the remaining unsorted
	 * elements to the correct position. Bubble up means the swap of two values,
	 * when looping through each element in the list, if the value of the
	 * current position is larger than the value of the next position, swap them
	 * and set the swapped flag to true, so that the next outer while loop will
	 * loop through list again to do the next round of bubbling. Each inner loop
	 * will bubble up one value to the correct position, thus the number of
	 * inner loops will decrease by 1 in the next iteration.
	 */
	private static void sort(Integer[] a) {
		int alength = a.length;
		boolean swapped = true;
		while (swapped) {
			swapped = false;
			// looping through the list and swap the current position and the
			// next position as needed
			for (int i = 0; i < alength - 1; i++) {
				// swap if the value of the current position is larger than the
				// value of the next position
				// change > to < for descending order
				if (a[i] > a[i + 1]) {
					swap(a, i, i + 1);
					swapped = true;
				}

			}
			// After one whole iteration of the inner for loop, the last element
			// should be in the correct position, thus we don't look at again in
			// the next iteration.
			// Hence we decrease loopcounter by 1, so the number of inner for loop will
			// decrease by 1 in the next iteration.
			alength--;

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
