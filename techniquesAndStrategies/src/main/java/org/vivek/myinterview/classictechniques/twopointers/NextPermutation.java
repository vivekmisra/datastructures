package org.vivek.myinterview.classictechniques.twopointers;

public class NextPermutation {

	public NextPermutation() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		NextPermutation n = new NextPermutation();
		// int [] nums = {2,3,4,7,5,1};
		 int [] nums = {2,3,5,1,4,7};
		//int[] nums = { 5, 1, 1 };
		for (int i = 0; i <9; i++) {
			n.nextPermutation(nums);
			printArray(nums);
		}
		/*
		 * 2, 3, 5, 1, 7, 4 
		 * 2, 3, 5, 4, 1, 7
		 * 2, 3, 5, 4, 7, 1 
		 * 2, 3, 5, 7, 1, 4
		 * 2, 3, 5, 7, 4, 1 
		 * 2, 3, 7, 1, 4, 5 
		 * 2, 3, 7, 1, 5, 4 
		 * 2, 3, 7, 4, 1, 5
		 * 
		 * 2, 3, 5, 1, 7, 4 2, 3, 5, 1, 4, 7 2, 3, 5, 1, 7, 4 2, 3, 5, 1, 4, 7
		 * 2, 3, 5, 1, 7, 4 2, 3, 5, 1, 4, 7 2, 3, 5, 1, 7, 4 2, 3, 5, 1, 4, 7
		 * 
		 */
		// }

	}

	public void nextPermutation1(int[] nums) {
		int i = nums.length - 2;
		while (i >= 0 && nums[i + 1] <= nums[i]) {
			i--;
		}
		if (i >= 0) {
			int j = nums.length - 1;
			while (j >= 0 && nums[j] <= nums[i]) {
				j--;
			}
			swap(nums, i, j);
		}
		reverse(nums, i + 1);
	}

	public void nextPermutation(int[] array) {
		/*ondensed mathematical description:

    Find largest index i such that array[i − 1] < array[i].
    (If no such i exists, then this is already the last permutation.)

    Find largest index j such that j ≥ i and array[j] > array[i − 1].

    Swap array[j] and array[i − 1].

    Reverse the suffix starting at array[i].
*/
		// Find longest non-increasing suffix
		int i = array.length - 1;
		while (i > 0 && array[i - 1] >= array[i]) {
			i--;
		}
		// Now i is the head index of the suffix

		// Are we at the last permutation already?
		if (i > 0) {
			// return false;

			// Let array[i - 1] be the pivot
			// Find rightmost element that exceeds the pivot
			int j = array.length - 1;
			while (array[j] <= array[i - 1]) {
				j--;
			}
			// Now the value array[j] will become the new pivot
			// Assertion: j >= i

			// Swap the pivot at (i-j) with j
			
			swap(array,(i-1),j);
		}
		// Reverse the suffix
		int j = array.length - 1;
		while (i < j) {
			/*int temp = array[i];
			array[i] = array[j];
			array[j] = temp;*/
			swap(array,i,j);
			i++;
			j--;
		}

		// Successfully computed the next permutation
		// return true;
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
