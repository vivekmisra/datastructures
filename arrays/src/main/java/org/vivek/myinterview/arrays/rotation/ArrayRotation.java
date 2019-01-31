package org.vivek.myinterview.arrays.rotation;

public class ArrayRotation {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
		leftRotate(arr, 2, 7);
		printArray(arr, 7);

	}

	// Java program to rotate an array by
	// d elements

	/*
	 * METHOD 1 (Using temp array)
	 * 
	 * Input arr[] = [1, 2, 3, 4, 5, 6, 7], d = 2, n =7 
	 * 1) Store d elements in a temp array 
	 * temp[] = [1, 2] 
	 * 2) Shift rest of the arr[] 
	 * arr[] = [3, 4, 5, 6, 7,6, 7]
	 *  3) Store back the d elements arr[] = [3, 4, 5, 6, 7, 1, 2] 
	 *  Time
	 * complexity : O(n) Auxiliary Space : O(d)
	 * 
	 * METHOD 2 
	 * (Rotate one by one)

		leftRotate(arr[], d, n)
		start
  			For i = 0 to i < d
    			Left rotate all elements of arr[] by one
		end
	 */

	/* Function to left rotate arr[] of size n by d */
	static void leftRotate(int arr[], int d, int n) {
		for (int i = 0; i < d; i++)
			leftRotatebyOne(arr, n);
	}

	static void leftRotatebyOne(int arr[], int n) {
		int i, temp;
		temp = arr[0];
		for (i = 0; i < n - 1; i++)
			arr[i] = arr[i + 1];
		arr[i] = temp;
	}

	/* utility function to print an array */
	static void printArray(int arr[], int n) {
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	}

}
