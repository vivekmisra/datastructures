package org.vivek.myinterview.arrays.general.problems.slidingwindow.subarray;

public class FindMinSubArraySumGivenSizeK {

	public static void main(String[] args) {
		FindMinSubArraySumGivenSizeK ms = new FindMinSubArraySumGivenSizeK();
		int nums[] = { 2, 3, 1, 2, 4, 3 };
		ms.findSubarray(nums, 4);

	}

	void findSubarray(int nums[], int k) {
		int n = nums.length;
		// stores sum of element in current window
		int currSum = 0;

		// stores sum of minimum sum sub-array found so far
		int min_window = Integer.MAX_VALUE;

		// stores ending index of minimum sum sub-array found so far
		int last = 0;
        int i =0;
		//for (int i = 0; i < n; i++) {
        while(i<n) {
			// add current element to the window
			currSum = currSum + nums[i];

			// if window size is more than equal to k
			if (i + 1 >= k) {
				// update minimum sum window
				if (min_window > currSum) {
					min_window = currSum;
					last = i;
				}

				// remove leftmost element from the window
				currSum = currSum - nums[i + 1 - k];
			}
			i++;
		}

		System.out.println("Minimum sum sub-array is (" + (last - k + 1) + "," + last + ")");
	}

}
