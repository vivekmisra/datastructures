package org.vivek.myinterview.classictechniques.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TwoSum {

	public TwoSum() {
		// TODO Auto-generated constructor stub

	}

	public static void main(String[] args) {
		int[] nums1 = { 2, 7, 11, 15 };
		int target1 = 9;
		printArray(nums1);
		System.out.print("target=" + target1);
		System.out.println();
		List<List<Integer>> results = twoSumSorted(nums1, target1);
		for (List<Integer> result : results) {
			System.out.println(Arrays.deepToString(result.toArray()));
		}
		System.out.println("***********unsorted array*******");
		int[] nums2 = { 3, 2, 4 };
		int target2 = 6;
		printArray(nums2);
		System.out.println("target=" + target2);
		System.out.println();
		int[] indxnums = twoSumUnSorted(nums2, target2);
		printArray(indxnums);
		indxnums = twoSumUnSortedBrute(nums2, target2);
		printArray(indxnums);
	}

	public static int[] twoSumSorted1(int[] nums, int target) {
		int[] result = new int[2];
		int left = 0;
		int right = nums.length - 1;

		for (int i = 0; i < nums.length; i++) {
			if (nums[left] + nums[right] > target) {
				right--;
			} else if (nums[left] + nums[right] < target) {
				left++;
			} else {
				result[0] = left;
				result[1] = right;
				break;
			}
		}
		return result;
	}

	public static List<List<Integer>> twoSumSorted(int[] nums, int target) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		int[] resultsIndices = new int[2];
		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			int currentSum = nums[left] + nums[right];
			if (currentSum > target) {
				right--;
			} else if (currentSum < target) {
				left++;
			} else {
				List<Integer> l = new ArrayList<Integer>();
				l.add(nums[left]);
				l.add(nums[right]);
				results.add(l);
				left++;
				right--;
				// skip duplicates if any
				while (left < right && nums[left] == nums[left - 1]) {
					left++;
				}
				while (left < right && nums[right] == nums[right + 1]) {
					right--;
				}
			}
		}
		return results;
	}

	private static int[] twoSumUnSorted(int[] nums, int target) {
		if (nums == null || nums.length < 2)
			return new int[] { 0, 0 };

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				return new int[] { map.get(nums[i]), i };
			} else {
				int key = target - nums[i];
				// this key should
				// represent next/another element in
				// array{3,2,4} with target=6
				// =>map{(3,0),(4,1),(2,3)}===>finds key=4 at previous index 1 as key in 3rd
				// itr(i=2) ===>new int []{1,2}
				map.put(key, i);
			}
		}

		return new int[] { 0, 0 };
	}

	private static int[] twoSumUnSortedBrute(int[] nums, int target) {
		int[] result = new int[2];
		if (nums == null || nums.length < 2) {
			return new int[] { 0, 0 };
		}

		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					result[0] = i;
					result[1] = j;
					break;
				}
			}
		}

		return result;
	}

	private static void printArray(int[] anArray) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < anArray.length; i++) {
			if (i > 0) {
				sb.append(", ");
			}
			sb.append(anArray[i]);
		}
		System.out.println(sb.toString());
	}

}
