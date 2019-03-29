package org.vivek.myinterview.classictechniques.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

	public FourSum() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		//int[] nums1 = { 1, 0, -1, 0, -2, 2 };

		int[] nums1 = {-3,-2,-1,0,0,1,2,3};
				
		int target = 0;
		List<List<Integer>> results = fourSum(nums1, target);
		for (List<Integer> result : results) {
			System.out.println(Arrays.deepToString(result.toArray()));
		}
	}
	
	
	public static List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		if (nums == null || nums.length < 4)
			return results;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 3; i++) {
			if (i != 0 && nums[i] == nums[i - 1])
				continue;
			int iSum = nums[i];
			int iStep = i + 1;
			threeSumHelper(nums, target, results, iStep, iSum);
		}
		return results;
	}

	private static void threeSumHelper(int[] nums, int target, List<List<Integer>> results,  int iStep,int iSum) {
		for (int j = iStep; j < nums.length - 2; j++) {
			if (j != iStep && nums[j] == nums[j - 1])
				continue;
			int jSum = nums[j];
			int jStep = j + 1;
			twoSumHelper(nums, target, results,jStep,iSum, jSum);
		}

	}

	private static void twoSumHelper(int[] nums, int target, List<List<Integer>> results,int jStep, int iSum, int jSum) {
		int requiredSum = target - jSum - iSum;		
		int left = jStep;
		int right = nums.length - 1;
		while (left < right) {
			int sum = nums[left] + nums[right];
			target = requiredSum;
			System.out.println("Current sum s :" + sum + ", and target is :" + target);
			if (nums[left] + nums[right] < target) {
				left++;
			} else if (nums[left] + nums[right] > target) {
				right--;
			} else if (nums[left] + nums[right] == target) {
				List<Integer> l = new ArrayList<Integer>();
				l.add(jSum);
				l.add(iSum);
				l.add(nums[left]);
				l.add(nums[right]);
				results.add(l);
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
}
