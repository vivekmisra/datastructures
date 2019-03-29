package org.vivek.myinterview.classictechniques.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

	public ThreeSum() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int[] nums = { 1, 4, 5, 6, 8, 10 };
		int target = 17;
		List<List<Integer>> triplets = threeSum(nums, target);
		for (List<Integer> triplet : triplets) {
			System.out.println(Arrays.deepToString(triplet.toArray()));
		}
	}

	public static List<List<Integer>> threeSum(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (nums == null || nums.length < 3)
			return result;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			if (i == 0 || nums[i] > nums[i - 1]) {
				int iSum = nums[i];
				int iStep = i + 1;
				twoSumHelper(nums, target, result, iStep, iSum);
			}
		}
		return result;
	}

	private static void twoSumHelper(int[] nums, int target, List<List<Integer>> triplets, int iStep, int iSum) {
		int requiredSum = target - iSum;
		int left = iStep;
		int right = nums.length - 1;
		while (left < right) {
			target = requiredSum;
			int sum = nums[left] + nums[right];
			System.out.println("Current sum s :" + sum + ", and target is :" + target);
			if (nums[left] + nums[right] < target) {
				left++;
			} else if (nums[left] + nums[right] > target) {
				right--;
			} else if (nums[left] + nums[right] == target) {
				List<Integer> l = new ArrayList<Integer>();
				l.add(iSum);
				l.add(nums[left]);
				l.add(nums[right]);
				triplets.add(l);
				left++;
				right--;
				// handle duplicate here
				while (left < right && nums[left] == nums[left - 1]) {
						left++;
				}
				
				while (left < right && nums[right] == nums[right + 1]) {
					right--;
				}
			}
		}
	}

	public static int[] twoSumSorted(int[] nums, int target) {
		List<List<Integer>> tuples = new ArrayList<List<Integer>>();
		int[] result = new int[2];
		int left = 0;
		int right = nums.length - 1;

		while (left < right) {
			if (nums[left] + nums[right] > target) {
				right--;
			} else if (nums[left] + nums[right] < target) {
				left++;
			} else {
				List<Integer> l = new ArrayList<Integer>();

				l.add(nums[left]);
				l.add(nums[right]);
				tuples.add(l);
				left++;
				right--;
				while (left < right && nums[left] == nums[left - 1])
					left++;
				while (left < right && nums[right] == nums[right + 1])
					right--;
			}

		}
		return result;
	}

}
