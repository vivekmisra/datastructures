package org.vivek.myinterview.arrays.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CheckSubZero {

	public CheckSubZero() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int[] arr = new int[] { 6, 4, -7, 3, 12, 9 };
		// int[] arr = new int[] { 1, 2, 3, 4, -9, 6, 7, -8, 1, 9 };
		int[] arr = { 0, 1, -1, 0 };
		// findSubZero1(arr);
		subArraySumsZero(arr);

	}

	public static boolean findSubZero(int[] arr) {
		HashMap<Integer, String> hMap = new HashMap<>();
		int sum = 0;
		// Write - Your - Code
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
			System.out.println("sum=" + sum);
			sb.append(arr[i]);
			if (i + 1 <= arr.length) {
				sb.append(",");
			}

			if (sum == 0) {

				hMap.put(new Integer(sum), sb.toString());

			}
		}

		if (hMap.containsKey(0)) {
			return true;
		}
		return false;
	}

	public static boolean findSubZero1(int[] arr) {

		// Use HashMap to store Sum as key and index i as value till sum has been
		// calculated.
		// Traverse the array and return true if either
		// arr[i] == 0 or sum == 0 or HashMap already contains the sum
		// If you completely traverse the array and havent found any of the above three
		// conditions then simply return false.
		HashMap<Integer, Integer> hMap = new HashMap<>();

		int sum = 0;

		// Traverse through the given array
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			System.out.println("sum=" + sum);
			if (arr[i] == 0 || sum == 0 || hMap.get(sum) != null) {
				System.out.println("sum>>=" + sum);
				return true;
			}

			hMap.put(sum, i);
		}

		return false;
	}

	private static void subArraySumsZero(int[] seed) {
		// int[] seed = new int[] { 1, 2, 3, 4, -9, 6, 7, -8, 1, 9 };
		int currSum = 0;
		List<ArrayList<Integer>> lsum = new ArrayList<ArrayList<Integer>>();
		StringBuffer sb = new StringBuffer();
		HashMap<Integer, Integer> sumMap = new HashMap<Integer, Integer>();
		ArrayList<Integer> l0 = new ArrayList<Integer>();
		ArrayList<Integer> l1 = null;
		for (int i = 0; i < seed.length; i++) {
			currSum += seed[i];
			if (currSum == 0) {
				sumMap.put(currSum, i);
				sb.append("{  0 , " + i + " }");
				
				if (0 == seed[i]) {
					l0 = new ArrayList<Integer>();
					
					lsum.add(l0);
					if(currSum == 0) {
						l0 = new ArrayList<Integer>();
						for (int k = 0; k <= i; k++) {
							l0.add(seed[k]);

						}
						lsum.add(l0);
					}
				}else  {
				l0 = new ArrayList<Integer>();
				for (int k = 0; k <= i; k++) {
					l0.add(seed[k]);

				}
				lsum.add(l0);
				}
				if ((i + 1) < seed.length) {
					sb.append(",");
				}
			} else if (sumMap.get(currSum) != null) {
				if (sumMap.containsKey(currSum)) {

					sb.append("{" + (sumMap.get(currSum) + 1) + " , " + i + " }");
					if ((i + 1) < seed.length) {
						sb.append(",");
					}
					int index = (sumMap.get(currSum) + 1);
					l1 = new ArrayList<Integer>();
					for (int k = index; k <= i; k++) {
						l1.add(seed[k]);
					}
					lsum.add(l1);
					sumMap.put(currSum, i);
				}

			} else {
				// dump new entry
				sumMap.put(currSum, i);
			}

		}
		System.out.println("ARRAY IS: " + Arrays.toString(seed));
		System.out.println("SUBARRAY SET WITH ZERO SUM: " + lsum.toString());
		System.out.println("SUBARRAY SET OF INDICES WITH ZERO SUM IS: " + sb.toString());
		System.out.println("HASH MAP HAS: " + sumMap);
	}
}
