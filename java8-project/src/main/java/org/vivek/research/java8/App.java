package org.vivek.research.java8;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App {
	static int[] arr = null;

	public static void main(String[] args) {
		// System.out.println("Hello World!");
		int[] arr = new int[] { 1, 2, 3, 4, 5 };
		arr= rotLeft1(arr, 4);
		//arr = rotLeft(arr, 4);
		printArray(arr);
	}

	static int[] rotLeft(int[] a, int d) {
		if (d == 0) {
			return a;
		}
		int k = a.length - 1;
		int temp = a[0];
		for (int i = 1; i <= a.length - 1; i++) {
			a[i - 1] = a[i];

		}
		a[k] = temp;
		d = d - 1;
		return rotLeft(a, d);
	}

	static int[] rotLeft1(int[] a, int d) {
		int n = a.length;

	    // Create new array for rotated elements:
	    int[] rotated = new int[n]; 

	    // Copy segments of shifted elements to rotated array:
	    System.arraycopy(a, d, rotated, 0, n - d);
	    System.arraycopy(a, 0, rotated, n - d, d);

	    return rotated;
	}

	static void printArray(int[] arr) {
		System.out.print("[");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			if (i + 1 < arr.length) {
				System.out.print(",");
			}
		}
		System.out.print("]");
	}

}
