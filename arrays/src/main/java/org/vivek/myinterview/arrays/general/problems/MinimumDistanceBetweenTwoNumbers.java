package org.vivek.myinterview.arrays.general.problems;

import java.util.HashMap;
import java.util.Map;
/*
 * /**
 * http://www.geeksforgeeks.org/find-the-minimum-distance-between-two-numbers/
 */
 

public class MinimumDistanceBetweenTwoNumbers {

	int min = Integer.MAX_VALUE;
	public int minDistance(int input[], int x, int y) {
		int prev = -1;
		int prevFound = -1;
		
		for (int i = 0; i < input.length; i++) {
			if (input[i] == x) {
				if (prevFound == -1) {
					prevFound = x;
					prev = i;
				} else if (prevFound == x) {
					prev = i;
				} else {
					min = min > i - prev ? i - prev : min;
					prev = i;
					prevFound = x;
				}
			} else if (input[i] == y) {
				if (prevFound == -1) {
					prevFound = y;
					prev = i;
				} else if (prevFound == y) {
					prev = i;
				} else {
					min = min > i - prev ? i - prev : min;
					prevFound = y;
					prev = i;
				}
			}
		}
		return min;
	}

	public int minDistance2(int input[], int x, int y) {
		int diff = 0;
		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
		for (int i = 0; i < input.length; i++) {
			if (input[i] == x) {
				m.put(x, i);
			} else if (input[i] == y) {
				m.put(y, i);
			}
			if (m.containsKey(x) && (m.containsKey(y))) {
				diff = Math.abs(m.get(x) - m.get(y));
				min = Math.min(min, diff);
			}
			if (min == Integer.MAX_VALUE){
				min = -1;
			}
		}
		return min;
	}

	public static void main(String args[]) {
		MinimumDistanceBetweenTwoNumbers mdb = new MinimumDistanceBetweenTwoNumbers();
		// int input[] = {6,4,1,5,6,9,10,4,6,6};
		int input[] = { 3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3 };
		System.out.println("Minimum distance between 3 and 6 is:"+mdb.minDistance(input, 3, 6));
		System.out.println("Minimum distance between 3 and 6 is:"+mdb.minDistance2(input, 3, 6));
		int[] input2 ={2, 5, 3, 5, 4, 4, 2, 3};
		System.out.println("Minimum distance between 3 and 2 is:"+mdb.minDistance2(input2, 3, 2));
		
	}
}
