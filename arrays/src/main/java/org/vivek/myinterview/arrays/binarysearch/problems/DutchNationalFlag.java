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
	
	
	public static void sort(int[] A, int pivot) {
		int left = 0;// tracks 0
		int mid = 0;// tracks 1

		int right = A.length - 1;// tracks 2
		while (mid <= right) {
			if (A[mid] < pivot) {// current element is 0 or 1
				if (A[mid] < 1) {// current element is 0
					swap(A, left, mid);
					++left;
					++mid;
				} else {// current element is 1
					++mid;
				}
			} else if (pivot <= A[mid]) {// current element is 2 or morea
				swap(A, mid, right);
				--right;
			}
		}

	}
	public static void threeWayPartition(int[] A, int pivot)
	{
		int left = 0;// tracks 0
		int mid = A[0];// tracks 1
	
		int right = A.length - 1;// tracks 2
		while (mid <= right) {
			int diff = pivot-A[mid];
			if(diff==0) {
				++mid;
			}
			else if (diff >0) {// current element is 0 as pivot value is 1
			   //move itto left and continue towards right
				swap(A, left, mid);
				++left;
				++mid;
			} else if (diff <0) {// current element is 2 as pivot value is 1
				//move itto right and continue towards left
				swap(A, mid, right);
				--right;
			} else {// current element is 1 as it is equal tp pivot--do nothing just skip and move
				++mid;
			}
		}
	}
	public static void sort2(int[] A,int pivot) {
        int n = A.length;
        if (n < 2) return;
        int lt = 0;
        int gt = n - 1;
        int i = 0;
        while (i <= gt) {
            //  #1 is the pivot
            if (A[i] < pivot) swap(A, i++, lt++);
            else if (A[i] > pivot) swap(A, i, gt--);
            else i++;
        }
    }
	public static void swap(int[] a, int left, int right) {
		//System.out.println("Inside swap(, left:" + left + ", right:" + right);
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
		System.out.println("***************");
		int[] A1 = { 0,2,1,3,4,1,0,2,2,1 };//o/p 0011123422
		sort2(A1,2);
		for (int i = 0; i < A1.length; i++) {
			System.out.print("   " + A1[i]);
		}
	}
}
