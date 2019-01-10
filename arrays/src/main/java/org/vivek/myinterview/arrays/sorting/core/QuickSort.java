/*Copyright (c) Apr 24, 2017 CareerMonk Publications and others.
 * E-Mail           	: info@careermonk.com 
 * Creation Date    	: 2015-01-10 06:15:46 
 * Last modification	: 2006-05-31 
               by		: Narasimha Karumanchi 
 * File Name			: QuickSort.java
 * Book Title			: Data Structures And Algorithms Made In Java
 * Warranty         	: This software is provided "as is" without any 
 * 							warranty; without even the implied warranty of 
 * 							merchantability or fitness for a particular purpose. 
 * 
 */

package org.vivek.myinterview.arrays.sorting.core;

import java.util.Arrays;

public class QuickSort {

	//static Integer[] a = new Integer[] { 11, 2, 1, 6, 8, 5, 3, 4 };
	//static Integer[] a = new Integer[] { 3,1,4,5,9,2,6,8,7};
	static Integer[] a = new Integer[] { 2, 4, 1, 6, 8, 5, 3, 7 };


	public QuickSort() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sort(a);
		printArray(a);
	}

	public static void sort(Integer[] inputArr) {

		if (a == null || a.length == 0) {
			return;
		}
		int length = a.length;
		quickSort(a,0, length - 1);
	}

	private static void quickSort(Integer[] a,int start, int end) {
		// If both cursor scanned the complete array quicksort exits
		if (start >= end) {
			return;
		}
		System.out.println("***quickSort("+start +","+  end+")*****");
		
		int partitionIndex = partition(a, start, end);
		System.out.println("***After partition quickSort("+start +","+  partitionIndex+")*****");
		quickSort(a,start, partitionIndex );
		System.out.println("***After first quickSort("+(partitionIndex + 1) +","+  end+")*****");
		quickSort(a,partitionIndex + 1, end);

	}

	public static int partition(Integer a[], int leftCursor, int rightCursor) {
		int pivot = a[leftCursor];
	
		System.out.println("*** partition(a[]="+Arrays.deepToString(a)+","+leftCursor +","+ rightCursor+")*****");
		System.out.println("*** start*****leftCursor: "+leftCursor+",rightCursor :"+rightCursor);
		while (leftCursor < rightCursor) {
			System.out.println("***Continue WHILE leftCursor: "+leftCursor+"< rightCursor :"+rightCursor+"*****");
			System.out.println("  a:"+Arrays.deepToString(a));
			System.out.println("  leftCursor:"+leftCursor);
			System.out.println("  rightCursor:"+rightCursor);
			System.out.println("  pivot:"+pivot);
			//printArray(a, leftCursor, rightCursor, pivot);
			System.out.println("  *** check a[leftCursor] < pivot => "+  a[leftCursor] +"<" + pivot+" *****"+ (a[leftCursor] < pivot));
			while (a[leftCursor] < pivot) {
				System.out.println("    *** Continue WHILE a[leftCursor] < pivot => "+  a[leftCursor] +"<" + pivot+" *****");
				leftCursor++;
				System.out.println("    *** leftCursor++ => "+leftCursor+", a[leftCursor]= "+  a[leftCursor] );
				System.out.println("    *** Is a[leftCursor] < pivot => "+  (a[leftCursor] < pivot) +" *****");
				System.out.println("    a:"+Arrays.deepToString(a));
				System.out.println("    leftCursor:"+leftCursor);
				System.out.println("    rightCursor:"+rightCursor);
				System.out.println("    pivot:"+pivot);
			}
			System.out.println("  *** check a[rightCursor] > pivot => "+  a[rightCursor] +">" + pivot+" *****"+(a[rightCursor] > pivot));
			while (a[rightCursor] > pivot) {
				System.out.println("    ***Continue WHILE a[rightCursor] > pivot => "+  a[rightCursor] +">" + pivot+" *****");
				
				rightCursor--;
				System.out.println("    *** rightCursor-- => "+rightCursor+", a[rightCursor]= "+  a[rightCursor] );
				System.out.println("    *** Is a[rightCursor] >pivot => "+  (a[rightCursor] > pivot) +" *****");
				System.out.println("    *** leftCursor++ => "+leftCursor+", a[leftCursor]= "+  a[leftCursor] );
				System.out.println("    *** Is a[leftCursor] < pivot => "+  (a[leftCursor] < pivot) +" *****");
				System.out.println("    a:"+Arrays.deepToString(a));
				System.out.println("    leftCursor:"+leftCursor);
				System.out.println("    rightCursor:"+rightCursor);
				System.out.println("    pivot:"+pivot);
			}
			System.out.println("  Before swapping...");
			System.out.println("  a:"+Arrays.deepToString(a));
			System.out.println("  leftCursor:"+leftCursor);
			System.out.println("  rightCursor:"+rightCursor);
			System.out.println("  pivot:"+pivot);
			swap(a, leftCursor, rightCursor);
			System.out.println("  After swapping...");
			System.out.println("  a:"+Arrays.deepToString(a));
			System.out.println("  leftCursor:"+leftCursor);
			System.out.println("  rightCursor:"+rightCursor);
			System.out.println("  pivot:"+pivot);
			
		}
		System.out.println("***END  WHILE leftCursor < rightCursor*****");
		System.out.println("***Returning partitionIndex for this quicksort=" + leftCursor + "*****");
		return leftCursor;
	}

	// This method is used to swap the values between the two given index
	public static void swap(Integer[] a, int left, int right) {
		System.out.println("  Inside swap("+Arrays.deepToString(a)+", left:"+left+", right:"+right);
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

	public static void printArray(Integer[] a, int leftCursor, int rightCursor, int pivot) {
		System.out.print("a:[");
		for (int i : a) {
			System.out.print(i + " ");
		}
		System.out.print("],");
		if (leftCursor >= 0) {
			System.out.print("leftCursor=" + leftCursor + " ,a[" + leftCursor + "]=" + a[leftCursor]);
		}
		if (rightCursor >= 0) {
			System.out.print(" ,rightCursor=" + rightCursor + " ,a[" + rightCursor + "]=" + a[rightCursor]);
		}
		System.out.println(" ,pivot=" + pivot);
	}
}
