package org.vivek.myinterview.arrays.binarysearch.problems;

public class FindBitonicPoint {
	/*
	 * Given a bitonic sequence of n distinct elements, write a program to find a
	 * given element x in the bitonic sequence in O(log n) time. A Bitonic Sequence
	 * is a sequence of numbers which is first strictly increasing then after a
	 * point strictly decreasing.
	 * 
	 * Examples:
	 * 
	 * Input : arr[] = {-3, 9, 8, 20, 17, 5, 1}; key = 20 Output : Found at index 3
	 * 
	 * Input : arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3}; key = 30 Output : Not Found
	 * 
	 */
	public FindBitonicPoint() {
		// TODO Auto-generated constructor stub
	}

	

	/*static int findBitonicPoint(int arr[], int n, int l, int r) {
		int mid;

		mid = (r + l) / 2;
		if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
			return mid;
		} else {
			if (arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1]) {
				findBitonicPoint(arr, n, mid, r);
			} else {
				if (arr[mid] < arr[mid - 1] && arr[mid] > arr[mid + 1]) {
					findBitonicPoint(arr, n, l, mid);
				}
			}
		}
		return mid;
	}*/

	static int findBitonicPoint(int arr[], int left, int right) {

		if (left <= right) {
			int mid = left + (right - left) / 2;

			// base condition to check if arr[mid]
			// is bitonic point or not
			if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1])
				return mid;

			// We assume that sequence is bitonic. We go to
			// right subarray if middle point is part of
			// increasing subsequence. Else we go to left
			// subarray.
			if ((arr[mid - 1] < arr[mid]) && (arr[mid] < arr[mid + 1])) {
				return findBitonicPoint(arr, mid + 1, right);
			} else if ((arr[mid - 1] > arr[mid]) && (arr[mid] > arr[mid + 1])) {
				return findBitonicPoint(arr, left, mid - 1);
			}
		}

		return -1;
	}

	static int ascendingBinarySearch(int arr[], int low, int high, int key) {
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] == key) {
				return mid;
			}
			if (arr[mid] > key) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}

	// Function for binary search in descending part of array
	static int descendingBinarySearch(int arr[], int low, int high, int key) {
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] == key) {
				return mid;
			}
			if (arr[mid] < key) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}

	// Function to search key in bitonic array
	static int searchBitonic(int arr[], int n, int key, int index) {
		if (key > arr[index]) {
			return -1;
		} else if (key == arr[index]) {
			return index;
		} else {
			int temp = ascendingBinarySearch(arr, 0, index - 1, key);
			if (temp != -1) {
				return temp;
			}

			// Search in right of k
			return descendingBinarySearch(arr, index + 1, n - 1, key);
		}
	}

	// Driver program to test above function
	public static void main(String args[]) {

		int arr1[] = { -8, 1, 2, 3, 4, 5, -2, -3 };// index=5
		int arr2[] = { 8, 10, 20, 80, 100, 200, 400, 500, 3, 2, 1 };// index=7
		int arr3[] = { -3, 9, 8, 20, 17, 5, 1, 3 };// index=3
		// int arr4[] = { 5, 6, 7, 8, 9, 10, 1, 2, 3 };// index=5
		//int arr4[] = { 5, 6, 7, 8, 9, 10, 12, 13, 1, 2, 3 };// index=5

		int arr5[] = { 6, 7, 8, 11, 9, 5, 2, 1 };// index=3
		int arr6[] = { -3, -2, 4, 6, 10, 8, 7, 1 };// index=4
		int key = 1;
		int n, l, r;
		// n = arr.length;
		// l = 0;
		// r = n - 1;

		findBitonicAndSearchKey(arr1, key, arr1.length, 0, arr1.length - 1);
		findBitonicAndSearchKey(arr2, key, arr2.length, 0, arr2.length - 1);
		findBitonicAndSearchKey(arr3, key, arr3.length, 0, arr3.length - 1);

		//findBitonicAndSearchKey(arr4, key, arr4.length, 0, arr4.length - 1);

		findBitonicAndSearchKey(arr5, key, arr5.length, 0, arr5.length - 1);
		findBitonicAndSearchKey(arr6, key, arr6.length, 0, arr6.length - 1);
		int arr[] = {1,2,1,3,5,6,4};
		findBitonicAndSearchKey(arr, 6, arr.length, 0, arr.length - 1);
	}

	private static void findBitonicAndSearchKey(int[] arr, int key, int n, int l, int r) {
		int index;
		index = findBitonicPoint(arr, l, r);
		System.out.println("index1=" + index);

		int x = searchBitonic(arr, n, key, index);

		if (x == -1) {
			System.out.println("Element Not Found");
		} else {
			System.out.println("Element Found at index " + x);
		}
	}
}
