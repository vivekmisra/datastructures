/*Copyright (c) Apr 25, 2017 CareerMonk Publications and others.
 * E-Mail           	: info@careermonk.com 
 * Creation Date    	: 2015-01-10 06:15:46 
 * Last modification	: 2006-05-31 
               by		: Narasimha Karumanchi 
 * File Name			: SelectionSort.java
 * Book Title			: Data Structures And Algorithms Made In Java
 * Warranty         	: This software is provided "as is" without any 
 * 							warranty; without even the implied warranty of 
 * 							merchantability or fitness for a particular purpose. 
 * 
 */

package org.vivek.myinterview.arrays.sorting.core;

public class SelectionSort {
	static Integer[] a = new Integer[] { 11, 2, 1, 6, 8, 5, 3, 4 };

	public SelectionSort() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		sort(a);
		printArray(a);
		System.out.println(" 3rd smallest element,k=3 is=" + kthSmallest(a, a.length, 3));
		System.out.println(" 3rd largest element,k=3 is=" + kthLargest(a, a.length, 3));
	}

	static int kthSmallest(Integer a[], int n, int k) {
		// Sort the given array
		int min = 0;
		int count = 0;
		int kthSmallestElement = 0;
		for (int i = 0; i < a.length; i++) {
			min = i;// default minimum to index i
			for (int j = i + 1; j < a.length; j++) {// loop thru index over right
				if (a[j] < a[min]) {// if value a[j] is less than value a[min] (on left),than a[j](on right) is new min
					min = j;

				}
			}
			//by here we got the lowest number on right in min index
			swap(a, min, i);//swap minimum with current(whic is to the left)
			++count;// next i , counter to keep track of next index
			if (k == count) {//if next index is equal to kth, value of a[currentindex] is kth as array indexing start from 0
				kthSmallestElement = a[i];//dont need to go further,stop and get value
				break;
			}
		}
		return kthSmallestElement;

	}

	static int kthLargest(Integer a[], int n, int k) {
		// Sort the given array
		int min = 0;
		int count = 0;
		int kthLargestElement = 0;
		for (int i = 0; i < a.length; i++) {
			min = i;// default minimum to index i
			for (int j = i + 1; j < a.length; j++) {// loop thru index over right
				if (a[j] < a[min]) {// if value a[j] is less than value a[min],than a[j] is new min
					min = j;

				}
			}
			swap(a, min, i);
			++count;
			if ((a.length - k + 1) == count) {
				kthLargestElement = a[i];
				break;
			}
		}
		return kthLargestElement;

		// Return k'th element in the sorted array

	}

	public static void sort(Integer[] a) {
		int min = 0;
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			min = i;// default minimum to index i
			for (int j = i + 1; j < a.length; j++) {// loop thru index over right from next i i.e, j= i+1
				if (a[j] < a[min]) {// if value a[j] is less than value a[min],than a[j] is new min
					min = j;

				}
			}
			//by here we got the lowest number on right in min index
			swap(a, min, i);//once u get final min from inner loop(which check looks in advance),swap it with current i
			 printArray(a);
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
