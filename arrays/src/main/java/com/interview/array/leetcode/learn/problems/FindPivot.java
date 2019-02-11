package com.interview.array.leetcode.learn.problems;
/*
 * https://leetcode.com/problems/find-pivot-index/
 * Given an array of integers nums, write a method that returns the "pivot" index of this array.

We define the pivot index as the index where the sum of the numbers to the left of the index is equal to the sum of the numbers to the right of the index.

If no such index exists, we should return -1. If there are multiple pivot indexes, you should return the left-most pivot index.

Example 1:

Input: 
nums = [1, 7, 3, 6, 5, 6]
Output: 3
Explanation: 
The sum of the numbers to the left of index 3 (nums[3] = 6) is equal to the sum of numbers to the right of index 3.
Also, 3 is the first index where this occurs.
 */
public class FindPivot {

	public static void main(String[] args) {
		int nums[] = { 1, 7, 3, 6, 5, 6 };
		FindPivot fp = new FindPivot();
		int pivot = fp.pivotIndex(nums);
		System.out.println("pivot=" + pivot);
	}

	public int pivotIndex(int[] nums) {
		int total = 0, sum = 0;
		for (int num : nums) {
			sum = sum + num;
		}

		;
	/*	for (int i = 0; i < nums.length; ++i) {

			System.out.println("----------");

			// sum = sum + nums[i++];
			if (2 * sum == total - nums[i]) {
				return i;
			}
			sum = sum + nums[i];

		}*/
		int leftSum = 0;
		for (int i = 0; i < nums.length; i++) {

			System.out.println("----------");
			System.out.println("Start of loop at i="+i +",sum=" + sum + ",leftSum=" + leftSum + ",nums[" + i + "]=" + nums[i] );
			
			sum = sum - nums[i] ;
			
			System.out.println("After sliding window by 1 index to R.H.S :sum=" + sum + ",leftSum=" + leftSum + ",nums[" + i + "]=" + nums[i] );
			if(sum==leftSum){
				return i;
			}
			
			leftSum = leftSum + nums[i];
			System.out.println("After incrementing left :sum=" + sum + ",leftSum=" + leftSum + ",nums[" + i + "]=" + nums[i] );

		}
		return -1;

	}
}
