package org.vivek.myinterview.classictechniques.twopointers;

public class NextPermutation {

	public NextPermutation() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		NextPermutation n = new NextPermutation();
		//int [] nums = {2,3,4,7,5,1};
		int [] nums = {2,3,5,1,4,7};
		for(int i=0;i<3;i++) {
		 n.nextPermutation(nums);
		 printArray(nums);
		}

	}

	public void nextPermutation(int[] nums) {
		int i = nums.length - 2;
		while (i >= 0 && nums[i + 1] <= nums[i]) {
			i--;
		}
		if (i >= 0) {
			int j = nums.length - 1;
			System.out.println("nums["+j+"]= "+nums[j]);
			while (j >= 0 && nums[j] <= nums[i]) {
				j--;
			}
			swap(nums, i, j);
		}
		reverse(nums, i + 1);
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

	private void reverse(int[] nums, int start) {
		int i = start, j = nums.length - 1;
		while (i < j) {
			swap(nums, i, j);
			i++;
			j--;
		}
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

}
