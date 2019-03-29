package org.vivek.myinterview.classictechniques.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveDuplicatesFromSortedArray {
	static int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };

	public RemoveDuplicatesFromSortedArray() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		System.out.println("Before removeDuplicates :");
		int[] nums = { 0, 1, 2, 2,2, 3, 3, 4 };
		int[] nums1 = Arrays.copyOf(nums, nums.length);
		printArray(nums1);
		int[] prunednums = removeDuplicates(nums1);
		System.out.println("After removeDuplicates :");
		printArray(prunednums);
		
		
		nums1 = Arrays.copyOf(nums, nums.length);
		printArray(nums1);
		 prunednums = removeDuplicates1(nums1);
		System.out.println("After removeDuplicates :");
		printArray(prunednums);
		
		System.out.println(" removeDuplicates in generic way:");
		//int[] nums = { 0, 1, 2, 2,2, 3, 3, 4 };
		System.out.println("   no duplicated allowed:");
		nums1 = Arrays.copyOf(nums, nums.length);
		printArray(nums1);
		int len = removeDuplicates(nums1, 1);
		printArray(nums1, len);
		
		System.out.println("   1 duplicate allowed:");
		nums1 = Arrays.copyOf(nums, nums.length);
		printArray(nums1);
		len = removeDuplicates(nums1, 2);
		printArray(nums1, len);

		int []arr = { 1, 5, 8, 4, 7, 6, 5, 3, 1 };
		printArray(arr);
		int[] pointerValues = twopointersFromRightClimbing(arr);
		printArray(pointerValues);
	}
	
	public static int[] removeDuplicates(int[] nums) {
		int len = nums.length;
		if (len == 0)
			return null;
		List<Integer> list = new ArrayList<Integer>();
		int i = 0, j = 1;
		list.add(nums[0]);
		while (j < len) {
			if (nums[i] != nums[j]) {
				i++;
				nums[i] = nums[j];
				list.add(nums[i]);
			}	 
	                j++;
		}
	 
		if (list.isEmpty())
			return null;
		int[] prunednums = new int[list.size()];
		for (int k = 0; k < list.size(); k++) {
			prunednums[k] = list.get(k);
		}
		return prunednums;
	}

	public static int[] removeDuplicates1(int[] nums) {
		int len = nums.length;
		if (len == 0)
			return null;
		List<Integer> list = new ArrayList<Integer>();
		int i = 1, j = 1;
		list.add(nums[0]);
		while (j < len) {
			 //check if the element at the position current index - 1(previous) is the same as new arriving element
			//            if same then skip 
			//            if not,copy current at current index &move forward
			  if(nums[i-1]!=nums[j]) {
	            	nums[i]=nums[j];
	            	list.add(nums[i]);
	            	i++;
	          }
			 ++j;
		}
		if (list.isEmpty())
			return null;
		int[] prunednums = new int[list.size()];
		for (int k = 0; k < list.size(); k++) {
			prunednums[k] = list.get(k);
		}
		return prunednums;
	}

	// generic
	static int removeDuplicates(int nums[], int k) {
		/*
		 * approach is to remain first k elements as it is . Now start from k'th index
		 * and check if the element at the position current index - k is the same as new
		 * arriving element then skip this element and continue with next element . here
		 * the condition nums[i-k]!=nums[j] is very important  because we
		 * have to look k steps backward in new updated array.
		 */
		int len = nums.length;
		if (len < k)
			return len; // if array size is less than k then return the same
		int i=k,j=k;
       while( j<len) {
            if(nums[i-k]!=nums[j]) {
            	nums[i]=nums[j];
            	i++;
            }
            ++j;
        }
        return i;
	}

	private static void printArray(int[] anArray, int length) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			if (i > 0) {
				sb.append(", ");
			}
			sb.append(anArray[i]);
		}
		System.out.println(sb.toString());
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
