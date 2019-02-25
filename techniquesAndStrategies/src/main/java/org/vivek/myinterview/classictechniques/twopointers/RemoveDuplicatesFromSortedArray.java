package org.vivek.myinterview.classictechniques.twopointers;

import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicatesFromSortedArray {
	static int[] duplicatenums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };

	public RemoveDuplicatesFromSortedArray() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		System.out.println("Before removeDuplicates :");
		printArray(duplicatenums);
		int[] prunednums = removeDuplicates(duplicatenums);
		System.out.println("After removeDuplicates :");
		printArray(prunednums);

		int[] nums = { 1, 5, 8, 4, 7, 6, 5, 3, 1 };
		printArray(nums);
		int[] pointerValues = twopointersFromRightClimbing(nums);
		printArray(pointerValues);
	}

	public static int[] removeDuplicates(int[] nums) {
		if (nums.length == 0)
			return null;
		List<Integer> list = new ArrayList<Integer>();

		int i = 0;
		for (int j = 1; j < nums.length; j++) {
			if (nums[j] != nums[i]) {
				i++;
				nums[i] = nums[j];
				list.add(nums[i]);
			}
		}

		if (list.isEmpty())
			return null;
		int[] prunednums = new int[list.size()];
		for (int k = 0; k < list.size(); k++) {
			prunednums[k] = list.get(k);
		}
		return prunednums;
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

	public static int[] twopointersFromRightClimbing(int[] nums) {
		int[] twoPoiunterValues = new int[2];
		int i = nums.length - 2;
		i = climbToPeakAndStopAtFirstDownHill(nums, i);
		twoPoiunterValues[0] = nums[i];
		int j = climbUpOnlyTillYouArelessThanHim(nums, i);
		twoPoiunterValues[1] = nums[j];
		return twoPoiunterValues;

	}

	private static int climbUpOnlyTillYouArelessThanHim(int[] nums, int i) {
		int j = nums.length - 1;
		if (i >= 0) {

			System.out.println("next climbingLoop:Begin with Pointer j at index :" + j + " and i wating at index=" + i);
			while (j >= 0 && nums[j] <= nums[i]) {
				// till I am less than or same height as that guy at i
				// Because of while loop it will give immediate next uphill point greater than i
				System.out.println("nums[" + (j) + "] <= nums[" + i + "]==>" + nums[j] + "<= " + nums[i]);
				j--;
				System.out.println("next climbingLoop: Pointer j at index :" + j + " and i wating at index=" + i);
			}

		}
		return j;
	}

	private static int climbToPeakAndStopAtFirstDownHill(int[] nums, int i) {
		System.out.println("climbingLoop:Begin with Pointer i at index :" + i);
		while (i >= 0 && nums[i + 1] <= nums[i]) {
			// till I am less than or same as peak(as it from reverse pointer)
			// Because of while loop it will give immediate next downhill point
			System.out.println("climbingLoop:Before:Pointer i at index:" + i + " and (i+1) at index " + (i + 1));
			System.out.println(
					"climbingLoop:nums[" + (i + 1) + "] <= nums[" + i + "]==>" + nums[i + 1] + "<= " + nums[i]);

			i--;
			System.out.println("climbingLoop:After:Pointer i at:" + i);
		}
		System.out.println("climbingLoop:Final Pointer i at peak index!:" + i + " with value= " + nums[i]);
		return i;
	}

}
