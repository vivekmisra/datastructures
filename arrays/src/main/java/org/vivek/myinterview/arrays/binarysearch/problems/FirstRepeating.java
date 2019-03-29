package org.vivek.myinterview.arrays.binarysearch.problems;

import java.util.HashSet;

public class FirstRepeating {
//@formatter:off
/*https://www.geeksforgeeks.org/find-first-repeating-element-array-integers/
 * We can Use Sorting to solve the problem in O(nLogn) time. Following are detailed steps.
1) Copy the given array to an auxiliary array temp[].
2) Sort the temp array using a O(nLogn) time sorting algorithm.
3) Scan the input array from left to right. For every element, 
count its occurrences in temp[] using binary search. As soon as we find an element
 that occurs more than once, we return the element. This step can be done in O(nLogn) time.

We can Use Hashing to solve this in O(n) time on average. 
The idea is to traverse the given array from right to left 
and update the minimum index whenever we find an element
 that has been visited on right side. 
 */
	// This function prints the first repeating element in arr[]
	static void printFirstRepeating(int arr[]) {
		// Initialize index of first repeating element
		int min = -1;

		// Creates an empty hashset
		HashSet<Integer> set = new HashSet<>();

		// Traverse the input array from right to left
		//for (int i = arr.length - 1; i >= 0; i--) {
			int i = arr.length - 1;
		
		while( i >= 0) {
			// If element is already in hash set, update min
			if (set.contains(arr[i])) {
				min = i;
			}else {// Else add element to hash set
				set.add(arr[i]);
			}
			i--;
		}

		// Print the result
		if (min != -1)
			System.out.println("The first repeating element is " + arr[min]);
		else
			System.out.println("There are no repeating elements");
	}

	// Driver method to test above method
	public static void main(String[] args) throws java.lang.Exception {
		//int arr[] = { 10, 5, 3, 4, 3, 5, 6 };
		int arr[] = { 3,2,1,2,3 };
		printFirstRepeating(arr);
	}
}
