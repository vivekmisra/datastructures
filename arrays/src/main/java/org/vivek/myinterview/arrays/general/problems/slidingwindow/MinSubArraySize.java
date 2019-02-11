package org.vivek.myinterview.arrays.general.problems.slidingwindow;

/*
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

Example: 

Input: s = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: the subarray [4,3] has the minimal length under the problem constraint.
 */
public class MinSubArraySize {

	public static void main(String[] args) {
		MinSubArraySize ms = new MinSubArraySize();
		int [] nums = {2,3,1,2,4,3};
		int minSize=ms.minSubArrayLen(7, nums);
		System.out.println("minSize="+minSize);

	}

	public int minSubArrayLen(int s, int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;

		int i = 0;
		int j = 0;
		int sum = 0;

		int minLen = Integer.MAX_VALUE;
		Range r = new Range(0,0);
		while(i<nums.length ){
			if(r.getStart()!=-1){
			  r.setStart(i);
			}
			sum =sum+ nums[j];
			if (sum >= s) {
				r.setEnd(i);
				int len = r.getEnd()-r.getStart()+1;
				minLen = Math.min(minLen, len);
				if(r.getStart()<r.getEnd()&r.getEnd()<nums.length){
					r.setStart(r.getStart()+1);
					r.setEnd(0);
					i=r.getStart();
				}
			}
			i++;
		}

		while (j < nums.length) {
			if (sum < s) {
				sum =sum+ nums[j];
				j++;
			} else {
				minLen = Math.min(minLen, j - i);
				if (i == j - 1)
					return 1;

				sum -= nums[i];
				i++;
			}
		}

		while (sum >= s) {
			minLen = Math.min(minLen, j - i);

			sum -= nums[i++];
		}

		return minLen == Integer.MAX_VALUE ? 0 : minLen;
	}
	
	 class Range{
	        int start;
	        int end;
	        Range(int start,int end){
	            this.start = start;
	            this.end = end ;
	        }
	        public int getStart(){
	            return this.start;
	        }
	        public int getEnd(){
	            return this.end;
	        }
	        
			public void setStart(int start) {
				this.start = start;
			}
			public void setEnd(int end) {
				this.end = end;
			}
			@Override
			public String toString() {
				return "Range [start=" + start + ", end=" + end + "]";
			}
	        
	    }

}
