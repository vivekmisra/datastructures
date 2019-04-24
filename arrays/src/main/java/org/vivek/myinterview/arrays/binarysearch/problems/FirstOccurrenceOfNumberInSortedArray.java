package org.vivek.myinterview.arrays.binarysearch.problems;

/**
 * http://www.geeksforgeeks.org/check-for-majority-element-in-a-sorted-array/
 */
public class FirstOccurrenceOfNumberInSortedArray {

	public int firstOccurrence(int a[], int x) {
		int l = 0;
		int r = a.length - 1;
/*
 *   if( ( mid == 0 || x > arr[mid-1]) && arr[mid] == x) 
            return mid; 
 */
		while (l <= r) {
			int middle = (l + r) / 2;
			if (x == a[middle] && (middle == 0 || x > a[middle - 1])) {
				return middle;
			} else if (x > a[middle]) {
				l = middle + 1;
			} else {
				r = middle - 1;
			}
		}
		return -1;
	}

	public static void findFirstAndLast(int arr[], int x) {
		int n = arr.length;
		int first = -1, last = -1;
		for (int i = 0; i < n; i++) {
			if (x != arr[i])
				continue;
			if (first == -1)
				first = i;
			last = i;
		}
		if (first != -1) {
			System.out.println("First Occurrence = " + first);
			System.out.println("Last Occurrence = " + last);
		} else
			System.out.println("Not Found");
	}

	public static void main(String args[]) {
		FirstOccurrenceOfNumberInSortedArray fos = new FirstOccurrenceOfNumberInSortedArray();
		int input[] = { 1, 2, 2, 2, 2, 2, 5, 7, 7 };
		System.out.println(fos.firstOccurrence(input, 6));
		System.out.println(fos.firstOccurrence(input, 2));
		fos.findFirstAndLast(input, 2);
		int[] nums = { 1, 2, 2, 2, 2, 3, 4, 7, 8, 8 };
		System.out.println(fos.firstOccurrence(nums, 8));
	}

}
