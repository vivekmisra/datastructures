package org.vivek.myinterview.classictechniques.twopointers.array.rotation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayRotationUtils {

	public static void main(String[] args) {
		List<Integer> a = new ArrayList();
		a.add(3);
		a.add(6);
		a.add(2);
		a.add(8);
		int[] nums = a.stream().mapToInt(i -> i).toArray();
		int[] a1 = Arrays.copyOf(nums, nums.length);
		List<Integer> rotate = new ArrayList();
		rotate.add(1);
		rotate.add(2);
		rotate.add(3);
		rotate.add(4);
		List<Integer> l = getMaxElementIndexes(a, rotate);
		System.out.println("Final result:");
		for (int i : l) {
			System.out.print(i + ",");
		}
		int [] rot = {1,2,3,4,5,6,7};
		 a1 = Arrays.copyOf(rot, rot.length);
		System.out.println();
		System.out.println("RIGHT:");
		bruteRightrotate( rot, 2);
		printArray(rot);
		printArray(a1);
		int[] n1 = rightRotationByK(a1, 1);
		System.out.println("right rotaton by 1:");
		printArray(n1);
		int[] n2 = rightRotationByK(a1, 2);
		System.out.println("right rotaton by 2:");
		printArray(n2);
		int[] n3 = rightRotationByK(a1, 3);
		System.out.println("right rotaton by 3:");
		printArray(n3);
		int[] n4 = rightRotationByK(a1, 4);
		System.out.println("right rotaton by 4:");
		printArray(n4);
		/*System.out.println("LEFT:");
		printArray(a1);
		int[] n5 = leftRotationByK(a1, 1);
		System.out.println("right rotaton by 1:");
		printArray(n5);
		int[] n6 = leftRotationByK(a1, 2);
		System.out.println("right rotaton by 2:");
		printArray(n6);
		int[] n7 = leftRotationByK(a1, 3);
		System.out.println("right rotaton by 3:");
		printArray(n3);
		int[] n8 = leftRotationByK(a1, 4);
		System.out.println("right rotaton by 4:");
		printArray(n8);*/
		
		System.out.println("###############LEFT ROTATE ###########");
		
		 int k = 1; 
        int[]n9= leftRotate(a1,  k); 
        System.out.println("left rotaton by 1:");
    	printArray(n9);
    	
    	
         k = 2; 
         leftRotate(a1,  k);
         int[]n10= leftRotate(a1,  k); 
         System.out.println("left rotaton by 2:");
     	printArray(n10);


         k = 3; 
         leftRotate(a1,  k);
         int[]n11= leftRotate(a1,  k); 
         System.out.println("left rotaton by 3:");
      	printArray(n11);
         

         k = 4; 
         int[]n12= leftRotate(a1,  k); 
         leftRotate(a1, k); 
         System.out.println("left rotaton by 4:");
         printArray(n12);
	}

	private static String printArray(int[] anArray) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < anArray.length; i++) {
			if (i > 0) {
				sb.append(", ");
			}
			sb.append(anArray[i]);
		}
		System.out.println(sb.toString());
		return sb.toString();
	}

	public static List<Integer> getMaxElementIndexes(List<Integer> a, List<Integer> rotate) {
		// Write your code here

		int[] nums = a.stream().mapToInt(i -> i).toArray();
		int[] a1 = Arrays.copyOf(nums, nums.length);
		int[] a2 = Arrays.copyOf(nums, nums.length);
		int[] rotationArray = rotate.stream().mapToInt(i -> i).toArray();

		List<Integer> result = rotate(nums, rotationArray);

		return result;

	}

	static List<Integer> rotate(int[] nums, int[] rotationArray) {
		List<Integer> result = new ArrayList<Integer>();

		for (int i = 0; i < rotationArray.length; i++) {
			int k = rotationArray[i];
			if (k > nums.length) {
				k = k % nums.length;
			}
			System.out.println("k= :" + k);
			int numsLength = nums.length;
			System.out.println("Before--:");
			printArray(nums);
			System.out.println("");
			int rotationFactor = numsLength - k;
			// on every iteration make deep copy
			int[] a = Arrays.copyOf(nums, nums.length);

			rotateByK(a, rotationFactor);
			System.out.println("After:" + k + " rotation -");
			printArray(a);
			System.out.println("");
			int maxIndex = findIndexOfMax(a);
			System.out.println("max index---" + maxIndex);

			result.add(maxIndex);
		}

		return result;

	}

	public static void rotateByK(int[] nums, int k) {
		int[] rotated = new int[nums.length];
		if (nums == null || nums.length == 0 || k < 0) {
			throw new IllegalArgumentException("Illegal argument!");
		}

		if (k > nums.length) {
			k = k % nums.length;
		}

		// length of first part
		int a = nums.length - k;
		// printArray(nums);
		reverse(nums, 0, a - 1);
		reverse(nums, a, nums.length - 1);
		reverse(nums, 0, nums.length - 1);
		// printArray(nums);
	}

	private static int findIndexOfMax(int[] nums) {
		int max = nums[0];
		int index = 0;

		for (int i = 0; i < nums.length; i++) {
			if (max < nums[i]) {
				max = nums[i];
				index = i;
			}
		}
		return index;
	}

	static void reverse(int[] nums, int left, int right) {
		if (nums == null || nums.length == 1)
			return;
		while (left < right) {
			swap(nums, left, right);
			left++;
			right--;
		}

	}

	static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;

	}
	
	public static void bruteRightrotate(int[] nums, int k) {
        int temp, previous;
        for (int i = 0; i < k; i++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }

	public static int[] rightRotationByK(int[] nums, int k) {
		int[] rotatedA = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			// rotated index needs to "wrap" around end of array
			int indx = (i + k) % nums.length;
			int rotatedIndex = indx;
			rotatedA[rotatedIndex] = nums[i];
		}
		return rotatedA;
	}

	public static int[] leftRotationByK(int[] nums, int k) {
		int[] rotatedA = new int[nums.length];
		int len = nums.length;
		/*
		 * To get the starting point of rotated array
		 */
		int mod = k % len;

		// Prints the rotated array from
		// start position
		for (int i = 0; i < len; ++i) {
			/*
			 * System.out.print(nums[(i + mod) % len] + " ");
			 */
			rotatedA[i] = nums[(i + mod) % len];
		}
		System.out.println();
		return rotatedA;
	}

	static  int[]  leftRotate(int nums[], int k) {
		/*
		 * To get the starting point of rotated array
		 */
		int n = nums.length;
		int mod = k % n;
		int[] rotatedA = new int[nums.length];

		// Prints the rotated array from
		// start position
		for (int i = 0; i < n; ++i) {
			//System.out.print(nums[(i + mod) % n] + " ");
			rotatedA[i]= nums[(i + mod) % n];
		}

		return rotatedA;
	}

}
