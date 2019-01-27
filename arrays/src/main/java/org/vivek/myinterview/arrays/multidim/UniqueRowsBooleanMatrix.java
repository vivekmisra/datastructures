package org.vivek.myinterview.arrays.multidim;

import java.util.HashSet;

public class UniqueRowsBooleanMatrix {
	public static void printArray(int arr[][], int rows, int cols) {

		HashSet<String> set = new HashSet<String>();

		for (int i = 0; i < rows; i++) {
			String s = "";

			for (int j = 0; j < cols; j++)
				s += String.valueOf(arr[i][j]);

			if (!set.contains(s)) {
				set.add(s);
				System.out.println(s);

			}
		}
	}

	// Driver code
	public static void main(String[] args) {

		int arr[][] = { 
				{ 0, 1, 0, 0, 1 }, 
				{ 1, 0, 1, 1, 0 }, 
				{ 0, 1, 0, 0, 1 }, 
				{ 1, 1, 1, 0, 0 } };
       
		int rows = arr.length;
		int cols = arr[0].length;
		printArray(arr, rows, cols);
	}
}