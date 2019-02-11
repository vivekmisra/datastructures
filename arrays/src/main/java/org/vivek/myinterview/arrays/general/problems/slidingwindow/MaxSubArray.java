package org.vivek.myinterview.arrays.general.problems.slidingwindow;

import java.util.HashMap;
/*
 * https://leetcode.com/problems/maximum-subarray/
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */
public class MaxSubArray {

	public static void main(String[] args) {
		int [] nums ={1,1,1};
		MaxSubArray ms = new MaxSubArray();
		int counts= ms.subarraySum(nums, 2);
		System.out.println("counts of subarray="+ counts);
	    counts= ms.subarraySum2(nums, 2);
		System.out.println("counts of subarray="+ counts);

	}
	   public int subarraySum(int[] nums, int k) {
	        int count = 0, sum = 0;
	        HashMap < Integer, Integer > map = new HashMap < > ();
	        map.put(0, 1);
	        for (int i = 0; i < nums.length; i++) {
	            sum =sum + nums[i];
	            if (map.containsKey(sum - k)){
	                count =count+ map.get(sum - k);
	            }
	            map.put(sum, map.getOrDefault(sum, 0) + 1);
	        }
	        return count;
	    }
	   public int subarraySum2(int[] nums, int k) {
	        int count = 0;
	        int[] sum = new int[nums.length + 1];
	        sum[0] = 0;
	        for (int i = 1; i <= nums.length; i++){
	            sum[i] = sum[i - 1] + nums[i - 1];
	        }
	        for (int start = 0; start < nums.length; start++) {
	            for (int end = start + 1; end <= nums.length; end++) {
	                if (sum[end] - sum[start] == k)
	                    count++;
	            }
	        }
	        return count;
	    }

}
