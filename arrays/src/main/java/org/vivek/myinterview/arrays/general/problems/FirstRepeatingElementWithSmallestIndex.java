package org.vivek.myinterview.arrays.general.problems;

import java.util.HashSet;

/*
 * 
Find the first repeating element in an array of integers

Given an array of integers, find the first repeating element in it. We need to find the element that occurs more than once and whose index of first occurrence is smallest.

Examples:

Input:  arr[] = {10, 5, 3, 4, 3, 5, 6}
Output: 5 [5 is the first element that repeats]

Input:  arr[] = {6, 10, 5, 4, 9, 120, 4, 6, 10}
Output: 6 [6 is the first element that repeats]

 */
public class FirstRepeatingElementWithSmallestIndex {

	public FirstRepeatingElementWithSmallestIndex() {
		// TODO Auto-generated constructor stub
	}

	// This function prints the first repeating element in arr[]
	static int findFirstRepeating(int arr[]) {
		// Initialize index of first repeating element
		int min = -1;

		// Creates an empty hashset
		HashSet<Integer> set = new HashSet<>();

		// Traverse the input array from right to left
		for (int i = arr.length - 1; i >= 0; i--) {
			// If element is already in hash set, update min
			if (set.contains(arr[i]))
				min = i;

			else // Else add element to hash set
				set.add(arr[i]);
		}

		// Print the result
		if (min != -1)
			System.out.println("The first repeating element is " + arr[min]);
		else
			System.out.println("There are no repeating elements");
		return arr[min];
	}

	// Driver method to test above method
	public static void main(String[] args) throws java.lang.Exception {
		int arr[] = { 3, 2, 1, 2, 2, 3 };
		System.out.println(findFirstRepeating(arr));
	}
}
