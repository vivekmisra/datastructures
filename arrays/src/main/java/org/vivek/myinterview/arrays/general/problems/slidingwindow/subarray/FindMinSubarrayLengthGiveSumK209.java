package org.vivek.myinterview.arrays.general.problems.slidingwindow.subarray;
/*
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

Example: 

Input: s = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: the subarray [4,3] has the minimal length under the problem constraint.
 */
public class FindMinSubarrayLengthGiveSumK209 {

	public static void main(String[] args) {
		int[] nums= { 2,3,1,2,4,3};
		int s = 7;
		int minLenSubArray = minSubArrayLen( s, nums);
		System.out.println("minLenSubArray="+minLenSubArray);
		 minLenSubArray = minSubArrayLen2( s, nums);
		System.out.println("minLenSubArray="+minLenSubArray);

	}
	public static int minSubArrayLen(int s, int[] nums) {
	    if(nums==null||nums.length==0)
	        return 0;
	    int i=0; 
	    int j=0;
	    int sum=0;	 
	    int minLen = Integer.MAX_VALUE;	 
	    while(j<nums.length){
	        if(sum<s){
	            sum += nums[j];
	            j++;        
	        }else{
	            minLen = Math.min(minLen, j-i);
	            if(i==j-1)
	                return 1;
	 
	            sum -=nums[i];
	            i++;
	        }
	    }	
	    //we will have value of i and j as they are declared outside while loop
	    //if still currentSum >s then we will narrow it down
	    while(sum>=s){
	        minLen = Math.min(minLen, j-i);
	 
	        sum -=nums[i];
	        i++;
	    }
	 
	    return minLen==Integer.MAX_VALUE? 0: minLen;
	}
	public static int minSubArrayLen2(int s, int[] nums) {
	    if(nums==null||nums.length==0)
	        return 0;
	    int n = nums.length;
	    int min = Integer.MAX_VALUE;
	    int i = 0;
	    int currentSum = 0;
	    for (int j = 0; j < n; j++) {
	        currentSum = currentSum+ nums[j];
	        while (currentSum >= s) {//as soon as it crosses/equals s. find min length
	            min = Math.min(min, j + 1 - i);//length is j-i+1
	            currentSum = currentSum-nums[i];//start narrowing window by subtracting ith place and incerementing i
	            i++;
	        }
	    }
	    return (min != Integer.MAX_VALUE) ? min : 0;
	}

}
