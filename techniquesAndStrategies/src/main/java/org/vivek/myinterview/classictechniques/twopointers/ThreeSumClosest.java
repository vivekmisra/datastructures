package org.vivek.myinterview.classictechniques.twopointers;

import java.util.Arrays;

public class ThreeSumClosest {

	public static void main(String[] args) {
		int[] nums= { -1, 2, 1, -4};
		int target = 1;
		int s1= threeSumClosest( nums,  target);
		System.out.println(s1);

	}
	//formatter:off
	/*
	 * Time Complexity is O(n^2).
	 */
	static int threeSumClosest(int[] nums, int target) {
	    int min = Integer.MAX_VALUE;
		int result = 0;
	 	Arrays.sort(nums);
	 	for (int i = 0; i < nums.length; i++) {
			int j = i + 1;
			int k = nums.length - 1;
			while (j < k) {
				int currentSum = nums[i] + nums[j] + nums[k];
				//maintain a diff
				int diff = Math.abs(currentSum - target);
	 			if(diff == 0) {
					return currentSum;
				}
				if (diff < min) {
					min = diff;
					result = currentSum;
				}
				if (currentSum <= target) {
					j++;
				} else {
					k--;
				}
			}
		}
	 
		return result;
	}

}
