package org.vivek.myinterview.arrays.hashing;

public class CountFrequenciesUsingHash {

	public static void main(String[] args) {
		 int nums[] = { 10, 20, 20, 10, 10, 20, 5, 20 }; 
		    int n = nums.length; 
		    countFreq(nums, n); 
		 

	}

	private static void countFreq(int[] nums, int n) {
		int [] count = new int[n];
		for(int i = 0 ; i < n ; i ++) {
			 count[nums[i]]++; 
		}
		 for (int x : count) {
			 System.out.println(x);
		 }
		        
	}

}
