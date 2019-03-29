package org.vivek.myinterview.arrays.general.problems.subarrays;
//@formatter:off
/*
 * https://leetcode.com/problems/maximum-subarray/
 * Given an integer array nums, find the contiguous subarray
 *  (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

 */
//@formatter:on
public class SubArrayWithMaximumSum53 {

	public static void main(String[] args) {
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray1( nums));

	}
	/*
	 * algorithm that operates on arrays: it starts at the left end (element A[1])
	 * and scans through to the right end (element A[n]), keeping track of the
	 * maximum sum subvector seen so far. The maximum is initially A[0]. Suppose
	 * we've solved the problem for A[1 .. i - 1]; how can we extend that to A[1 ..
	 * i]? The maximum sum in the first I elements is either the maximum sum in the
	 * first i - 1 elements (which we'll call MaxSoFar), or it is that of a
	 * subvector that ends in position i (which we'll call MaxEndingHere).
	 * 
	 * MaxEnd ingHere is either A[i] plus the previous MaxEndingHere, or just A[i],
	 * whichever is larger.
	 */

	public static int maxSubArray1(int[] nums) {
		int maxSoFar = nums[0], maxEndingHere = nums[0];
		for (int i = 1; i < nums.length; ++i) {
			System.out.println("nums["+i+"]="+ nums[i]);
			maxEndingHere = maxEndingHere + nums[i];
			maxEndingHere = Math.max(maxEndingHere, nums[i]);
			maxSoFar = Math.max(maxSoFar, maxEndingHere);
		}
		return maxSoFar;
	}

	public int maxSubArray2(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;

		// First, we need to keep track of current minimum subarray sum we've seen so
		// far
		int currMin = 0;
		// Second, we need to keep track of current sum of subarray so far
		int currSum = 0;
		// everytime we find currSum - currMin > maxSum, we will update maxSum
		int maxSum = Integer.MIN_VALUE;

		// iterate through input nums array
		for (int num : nums) {
			// get sum of current subarray [0 ... num]
			currSum += num;
			// check to see if we need to update maxSum
			if (currSum - currMin > maxSum)
				maxSum = currSum - currMin;
			// update current min
			currMin = Math.min(currMin, currSum);
		}
		return maxSum;
	}

}
