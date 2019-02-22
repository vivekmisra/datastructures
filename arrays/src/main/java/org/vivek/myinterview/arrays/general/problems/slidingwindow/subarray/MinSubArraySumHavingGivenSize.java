package org.vivek.myinterview.arrays.general.problems.slidingwindow.subarray;

public class MinSubArraySumHavingGivenSize {

	public static void main(String[] args) {
		MinSubArraySumHavingGivenSize ms = new MinSubArraySumHavingGivenSize();
		int nums[] = {2,3,1,2,4,3};
		ms.findSubarray(nums,4);

	}
	
	void findSubarray(int arr[], int k)
	{
		int n = arr.length;
		// stores sum of element in current window
		int window_sum = 0;

		// stores sum of minimum sum sub-array found so far
		int min_window =Integer.MAX_VALUE;

		// stores ending index of minimum sum sub-array found so far
		int last = 0;

		for (int i = 0; i < n; i++)
		{
			// add current element to the window
			window_sum += arr[i];

			// if window size is more than equal to k
			if (i + 1 >= k)
			{
				// update minimum sum window
				if (min_window > window_sum)
				{
					min_window = window_sum;
					last = i;
				}

				// remove leftmost element from the window
				window_sum -= arr[i + 1 - k];
			}
		}

		System.out.println("Minimum sum sub-array is ("+ (last-k+1) +","+ last+")");
	}

}
