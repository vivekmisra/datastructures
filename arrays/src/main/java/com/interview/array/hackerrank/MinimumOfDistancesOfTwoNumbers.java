package com.interview.array.hackerrank;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.hackerrank.com/challenges/minimum-distances/
 * 
 * We define the distance between two array values as the number of indices
 * between the two values. Given , find the minimum distance between any pair of
 * equal elements in the array. If no such value exists, print
 * 
 * .
 * 
 * For example, if int []a={3,2,1,2,3} ;
 *  
 * there are two matching pairs of values: 3&2. The indices of
 * the 3's are 0and 4, so their distance is 4. The indices of the 2's are 1 and 4, 
 * so their distance is 2.
 * 
 * .
 * 
 * Function Description
 * 
 * Complete the minimumDistances function in the editor below. It should return
 * the minimum distance between any two matching elements.
 * 
 * minimumDistances has the following parameter(s):
 * 
 * a: an array of integers
 * 
 * Input Format
 * 
 * The first line contains an integer , the size of array . The second line
 * contains space-separated integers
 * 
 * .
 * 
 * Constraints
 * 
 * Output Format
 * 
 * Print a single integer denoting the minimum in . If no such value exists,
 * print .
 * 
 * and are both , so . and are both , so . The answer is .
 */
public class MinimumOfDistancesOfTwoNumbers {

	static int minimumOfDistances(int[] a) {
		Map<Integer, Integer> hm = new HashMap<>();
		int minDist = Integer.MAX_VALUE;

		for (int i = 0; i < a.length; i++) {

			if (hm.containsKey(a[i])) {
				int x = hm.get(a[i]);
				int dist = i - x;
				minDist = Math.min(minDist, dist);
				System.out.println(a[i] + " x=" + x + ", i=" + i + " ,dist=" + dist + ", min=(" + dist + "," + minDist
						+ ")=" + minDist);
			} else {
				hm.put(a[i], i);
			}
		}
		if (minDist == Integer.MAX_VALUE) {
			minDist = -1;
		}

		return minDist;
	}

	public static void main(String args[]) {
		MinimumOfDistancesOfTwoNumbers mdb = new MinimumOfDistancesOfTwoNumbers();
		// int input[] = {6,4,1,5,6,9,10,4,6,6};
		int input[] = { 7, 1, 3, 4, 1, 7 };
		System.out.println(mdb.minimumOfDistances(input));

	}
}
