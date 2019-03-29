package org.vivek.myinterview.arrays.general.problems.slidingwindow;
/**
 * 
 https://leetcode.com/problems/maximum-average-subarray-i/
 Given an array consisting of n integers, find the contiguous subarray of given length k that has the maximum average value. And you need to output the maximum average value.

Example 1:

Input: [1,12,-5,-6,50,3], k = 4
Output: 12.75
Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
 

Note:

1 <= k <= n <= 30,000.
Elements of the given array will be in the range [-10,000, 10,000].

*/
public class MaxAverageSubArrayWithWindowK643 {

	public static void main(String[] args) {
		MaxAverageSubArrayWithWindowK643 fa = new MaxAverageSubArrayWithWindowK643();
		int nums[] = {1,12,-5,-6,50,3};
				
		double avg = fa.findMaxAverage(nums, 4);
		System.out.println("Max avg in subarray of length k="+ avg);

	}
	
	 public double findMaxAverage(int[] nums, int k) {
		 double max_sum = Integer.MIN_VALUE, window_sum = 0; 
	        for(int i=0;i<k;i++){
	            window_sum+=nums[i];
	        }
	       
	        for(int i=k;i<nums.length;i++){
	            window_sum=window_sum + nums[i]-nums[i-k];
	            max_sum=Math.max(max_sum,window_sum);
	        }
	        return max_sum/k;
	    }

}
