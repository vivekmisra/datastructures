package org.vivek.myinterview.arrays.general.problems.slidingwindow.subarray;
/*
 * https://leetcode.com/problems/longest-continuous-increasing-subsequence/
 * Given an unsorted array of integers, find the length of longest continuous increasing subsequence (subarray).

Example 1:
Input: [1,3,5,4,7]
Output: 3
Explanation: The longest continuous increasing subsequence is [1,3,5], its length is 3. 
Even though [1,3,5,7] is also an increasing subsequence, it's not a continuous one where 5 and 7 are separated by 4. 
Example 2:
Input: [2,2,2,2,2]
Output: 1
Explanation: The longest continuous increasing subsequence is [2], its length is 1. 
 */
public class LongestContinuousIncreasingSubsequenceSubArray674 {

	public static void main(String[] args) {
		int[] nums = {1,3,5,4,7};
		int maxLen =  findLengthOfLCIS(nums) ;
		System.out.println("maxLen = "+maxLen );

	}
	
public static int findLengthOfLCIS(int[] nums) {
        
        int len = nums.length;
        int maxLen = 0;
        int hook =0;
         for (int i = 0; i < nums.length; ++i) {
            if(i>0){
                if(nums[i-1]>=nums[i]){
                    hook =i;
                }
             }
            int maxLenSoFar=i-hook+1;
            maxLen = Math.max(maxLenSoFar,maxLen);
        }
        return maxLen;
        
    }

}
