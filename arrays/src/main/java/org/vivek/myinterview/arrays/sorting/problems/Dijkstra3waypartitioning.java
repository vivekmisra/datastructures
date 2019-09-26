package org.vivek.myinterview.arrays.sorting.problems;

import java.util.Arrays;

public class Dijkstra3waypartitioning {
	static class Pair {
		private int x;
		private int y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}
	}

	private static int[] original = { 0, 7, 8, 1, 8, 9, 3, 8, 8, 8, 0, 7, 8, 1, 8, 9, 3, 8, 8, 8 };
	private int length;

	public Dijkstra3waypartitioning(int len) {
		length = len;
		// original = new int[length];

	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static Pair Partition(int[] arr, int start, int end)
	{
		//int mid = start;
		int mid = start;
		int pivot = arr[end];
		//int pivot = 6;
		while (mid <= end) {
			if (arr[mid] < pivot) {
				swap(arr, start, mid);
				++start;
				++mid;
			}
			else if (arr[mid] > pivot) {
				swap(arr, mid, end);
				--end;
			}
			else {
				++mid;
			}
		}

		// arr[start .. mid - 1] contains all occurrences of pivot
		return new Pair(start - 1, mid);
	}


	// Three-way Quicksort routine
	public static void quicksort(int[] arr, int start, int end)
	{
		// base condition for 0 or 1 elements
		if (start >= end) {
			return;
		}

		// handle 2 elements separately as Dutch national flag
		// algorithm will work for 3 or more elements
		if (start - end == 1)
		{
			if (arr[start] < arr[end]) {
				swap(arr, start, end);
			}
			return;
		}

		// rearrange the elements across pivot using Dutch
		// national flag problem algorithm
		Pair pivot = Partition(arr, start, end);

		// recur on sub-array containing elements that are less than pivot
		quicksort(arr, start, pivot.getX());

		// recur on sub-array containing elements that are more than pivot
		quicksort(arr, pivot.getY(), end);
	}

	public void disp() {
		for (int i = 0; i < length; ++i) {
			System.out.print(original[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {

		Dijkstra3waypartitioning qs = new Dijkstra3waypartitioning(20);
		int a[] = { 2, 6, 5, 2, 6, 8, 6, 1, 2, 6 };

		quicksort(a, 0, a.length - 1);

		// print the sorted array
		System.out.println(Arrays.toString(a));

	}

}
