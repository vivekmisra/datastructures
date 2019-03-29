package org.vivek.myinterview.arrays.general.problems.slidingwindow;
/*
 * https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/
 * Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.

Note:
The sum of the entire nums array is guaranteed to fit within the 32-bit signed integer range.

Example 1:

Input: nums = [1, -1, 5, -2, 3], k = 3
Output: 4 
Explanation: The subarray [1, -1, 5, -2] sums to 3 and is the longest.
Example 2:

Input: nums = [-2, -1, 2, 1], k = 1
Output: 2 
Explanation: The subarray [-1, 2] sums to 1 and is the longest.
 */
public class MaxSumSubArrayWithWindowK {

	public MaxSumSubArrayWithWindowK() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int arr[] = {100, 200, 100,300, 400,500,2,600};
		System.out.println(bruteforce_maxSum(arr,5));
		System.out.println(maxSum(arr,5));
		int [] nums = {1, -1, 5, -2, 3};
		int k=3;
		System.out.println(maxSum(nums,3));


	}

	private static int bruteforce_maxSum(int[] arr, int k) {
		int n= arr.length;
		int max_sum=0;
	
		for(int i = 0; i < n-k+1; i++){    
		    int current_sum = 0;
		     
		    for(int j = 0; j < k; j++){        
		        current_sum = current_sum + arr[i+j];         
		    }
		    max_sum = Math.max(current_sum, max_sum);    // pick maximum sum 
		}
		return max_sum;
	}
	
	private static int maxSum(int[] nums, int k) {
		int max_sum = Integer.MIN_VALUE, window_sum = 0; 
		int n= nums.length;
	
		/* calculate sum of 1st window */
		for (int i = 0; i < k; i++)  window_sum += nums[i]; 
		/* slide window from start to end in array. */
		 
		for (int i = k; i < n; i++){ 
		    window_sum += nums[i] - nums[i-k];    // saving re-computation
		    max_sum = Math.max(max_sum, window_sum);
		}
		return max_sum;
	}
	
	public int[] bruteMaxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) return new int[0];
        
        int [] output = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++) {
            int max = Integer.MIN_VALUE;
            for(int j = i; j < i + k; j++) 
                max = Math.max(max, nums[j]);
            output[i] = max;
        }
        return output;
    }

}
