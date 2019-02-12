package org.vivek.myinterview.arrays.general.problems.slidingwindow;

/*
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

Example: 

Input: s = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: the subarray [4,3] has the minimal length under the problem constraint.
 */
public class MinSubArraySizeSum {

	public static void main(String[] args) {
		MinSubArraySizeSum ms = new MinSubArraySizeSum();
		 int[] nums = { 2, 3, 1, 2, 4, 3 };int k =7;
		//int[] nums = { 1, 1 };int k = 3;
		int minSize = ms.minSubArrayLen(k, nums);
		System.out.println("minSize=" + minSize);
		minSize = ms.minSubArrayLen2(k, nums);
		System.out.println("minSize=" + minSize);

	}

	public int minSubArrayLen2(int s, int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			if (nums[0] >= s) {
				return 1;
			} else {
				return -1;
			}
		}
		// stores the current window sum
		int windowSum = 0;

		// stores the result
		int len = Integer.MAX_VALUE;

		// stores window's starting index
		int left = 0;

		// maintain a sliding window [left..right]
		for (int right = 0; right < nums.length; right++) {

			// include current element in the window
			windowSum += nums[right];

			// (to handle negative numbers in the array)
			// if window's sum becomes negative, discard the window
			if (windowSum <= 0) { // Kadane's algorithm

				left = right;
				windowSum = 0;
			}

			// window becomes unstable if its sum becomes more than k

			while (windowSum >= s && left <= right) {

				// update the result if current window's length is less
				// than minimum found so far
				len = Integer.min(len, right - left + 1);

				// remove elements from the window's left side till window
				// becomes stable again
				windowSum -= nums[left];
				left++;
			}
		}
		if (s < len) {
			return 0;
		}
		// return result
		return len;
	}

	public int minSubArrayLen(int s, int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;

		int i = 0;
		int j = 0;
		int sum = 0;

		int minLen = Integer.MAX_VALUE;

		while (j < nums.length) {
			if (sum < s) {
				sum = sum +nums[j];
				j++;
			} else {
				minLen = Math.min(minLen, j - i);
				if (i == j - 1)
					return 1;

				sum = sum- nums[i];
				i++;
			}
		}

		while (sum >= s) {
			minLen = Math.min(minLen, j - i);

			sum = sum- nums[i++];
		}
        if(minLen == Integer.MAX_VALUE) {
        	return 0;
        }else {
        	return minLen;
        }
		//return minLen == Integer.MAX_VALUE ? 0 : minLen;
	}

}
