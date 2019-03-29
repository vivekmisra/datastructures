package org.vivek.myinterview.arrays.general.problems.slidingwindow.subarray.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CountAllDisntctElementsSubarraySizeK {

	public static void findDistinctCount(List<Integer> list, int k)
	{
		// loop through the list
		for (int i = 0; i < list.size() - (k-1); i++)
		{
			Set<Integer> distinct = new HashSet<>();
			distinct.addAll(list.subList(i, i + k));

			System.out.println("The count of distinct elements in the sub-array ["
							+ i + ", " + (i + k - 1) + "] is " + distinct.size());
		}
	}
	//O(N) using sliding window
	public static Map<Interval,Integer> findDistinctCount(int[] A, int k)
	{
		
		Map<Interval,Integer> rangeMap = new HashMap<>();
		// map to store frequency of elements in current window of size k
		Map<Integer, Integer> freq = new HashMap<>();

		// maintains count of distinct elements in every sub-array of size k
		int distinct = 0;

		// loop through the array
		for (int i = 0; i < A.length; i++)
		{
			// ignore first k elements
			if (i >= k)
			{
				// Remove first element from the sub-array by reducing its
				// frequency in the map
				freq.putIfAbsent(A[i-k], 0);
				freq.put(A[i-k], freq.get(A[i-k]) - 1);

				// reduce distinct count if we're left with 0
				if (freq.get(A[i-k]) == 0) {
					distinct--;
				}
			}

			// add current element to the sub-array by incrementing its
			// count in the map
			freq.putIfAbsent(A[i], 0);
			freq.put(A[i], freq.get(A[i]) + 1);

			// increment distinct count by 1 if element occurs for the first
			// time in current window
			if (freq.get(A[i]) == 1) {
				distinct++;
			}

			// print count of distinct elements in current sub-array
			if (i >= k-1) {
				/*System.out.println("The count of distinct elements in the sub-array [" +
							 (i - k + 1) + ", " + i + "]" + " is " + distinct);*/
				Interval interval = new Interval((i - k + 1),i);
				 rangeMap.put(interval,  distinct);
			}
		}
		return rangeMap;
	}
	
	static class Interval{
		int low;
		int high;
		Interval (int low,int high){
			this.low = low;
			this.high = high;
		}
		public int getLow() {
			return low;
		}
		public void setLow(int low) {
			this.low = low;
		}
		public int getHigh() {
			return high;
		}
		public void setHigh(int high) {
			this.high = high;
		}
		@Override
		public String toString() {
			return "Interval [low=" + low + ", high=" + high + "]";
		}
		
	}


	// main function
	public static void main(String[] args)
	{
		int [] nums = {2, 1, 2, 3, 2, 1, 4, 5};
		List<Integer> input = Arrays.asList( 2, 1, 2, 3, 2, 1, 4, 5 );
		int k = 5;

		findDistinctCount(nums, k);
		printArray(nums);
		
		Map<Interval,Integer> rangeMap= findDistinctCount(nums,  k);
		rangeMap.forEach((K,V)->System.out.println("Item : " + K + " Count : " + V));
	}
	
	private static String printArray(int[] anArray) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < anArray.length; i++) {
			if (i > 0) {
				sb.append(", ");
			}
			sb.append(anArray[i]);
		}
		System.out.println(sb.toString());
		return sb.toString();
	}


}
