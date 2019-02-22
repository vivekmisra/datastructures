package org.vivek.myinterview.arrays.general.problems.slidingwindow.subarray;

public class CountSubArraysHavingGivenSum {

	public static void main(String[] args) {
		// int[] nums = {1,1,1};int k=2;
		int[] nums = { 28, 54, 7, -70, 22, 65, -6 };
		int k = 100;
		CountSubArraysHavingGivenSum cs = new CountSubArraysHavingGivenSum();
		int count = cs.findSubarray(nums, k);
		System.out.println("Subarrays count havin sum =" + k + " is " + count);

	}

	public static int findSubarray(int[] nums, int k) {
		int count = 0;
		if (nums == null || nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			if (nums[0] == k) {

				return 1;
			} else {
				return 0;
			}
		} else {

			if (nums.length > 1) {
				// maintains sum of current window
				int windowSum = 0;

				// maintain a window [low, high-1]
				int low = 0, high = 0;

				// consider every sub-array starting from low index
				for (low = 0; low < nums.length; low++) {
					// if current window's sum is less than the given sum,
					// then add elements to current window from right
					while (windowSum < k && high < nums.length) {
						System.out.println("previous sum=" + windowSum + ", current ele=" + nums[high]);
						windowSum = windowSum + nums[high];
						System.out.println("accumuated sum=" + windowSum);

						if (high < nums.length - 1) {
							high++;
						}else{
							break;
						}

					}
					if (high == nums.length - 1) {
						while (windowSum < k && low < high) {
							System.out.println("previous sum=" + windowSum + ", current ele=" + nums[high]);
							windowSum = windowSum + nums[high];
							System.out.println("accumuated sum=" + windowSum);

							if (low == high) {
								break;
							}
							low++;
						}
						windowSum -= nums[low];

					}
				}
				// if current window's sum is equal to the given sum k
				if (windowSum == k) {
					System.out.printf("Subarray found [%d-%d]\n", low, high - 1);
					count++;
				}

				// At this point the current window's sum is more than the
				// given sum
				// remove current element (leftmost element) from the window
				windowSum -= nums[low];

			}

		}
		return count;

	}
}
