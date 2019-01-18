package org.vivek.myinterview.arrays.problems;

import java.util.Arrays;

public class ArrayReordering {

	// Function to move all zeros present in the array to the end
	public static void reorder(int[] arr) {
		// k stores index of next available position
		int k = 0;

		// do for each element
		for (int i=0;i<arr.length;i++) {
			// if current element is non-zero, put the element at
			// next free position in the array
			if (arr[i] != 0) {
				arr[k++] = arr[i];
			}
		}

		// move all 0's to the end of the array (remaining indices)
		for (int i = k; i < arr.length; i++) {
			arr[i] = 0;
		}
	}
	
	static int[] reverse(int[] arr) {
		System.out.print("[");
		for (int i= arr.length-1;i>=0;i--) {
			System.out.print(arr[i]);
			System.out.print(" ");
			
			
		}
		System.out.println("]");
		
		return arr;
	}

	// Move all zeros present in the array to the end
	public static void main(String[] args) {
		int[] arr = { 6, 0, 8, 2, 3, 0, 4, 0, 1 };
		printArray(arr);
		//arr=reverse(arr);
		reorder(arr);
		printArray(arr);
	}

	static void printArray(int[] arr) {
		System.out.print("[");
		for (int i = 0; i < arr.length; i++) {

			System.out.print(arr[i]);
			if (i + 1 < arr.length) {
				System.out.print(",");
			}
		}
		System.out.println("]");
	}
}
