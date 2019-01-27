package org.vivek.myinterview.arrays.general.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class CountSmallerOnRight {

	public CountSmallerOnRight() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[] nums = { 5, 2, 6, 1 };
		//int[] nums = { -1, -1 };
		// int[] nums = {};
		List<Integer> list = getSmallerOnRight1(nums);
		for (Integer i : list) {
			System.out.println(i);
		}

	}

	private static List<Integer> getSmallerOnRight1(int[] nums) {
		List<Map<Integer, Integer>> list = new ArrayList<Map<Integer, Integer>>();
		int max = Integer.MIN_VALUE;
		int length = nums.length;
		if (length == 0) {
			return new ArrayList<Integer>();
		}
		for (int i = 0; i < length; i++) {
			Map<Integer, Integer> m = new LinkedHashMap<Integer, Integer>();
			max = Integer.MIN_VALUE;
			if (nums[i] >= max) {
				max = nums[i];
			}
			int counter = 0;
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] < max) {
					m.put(max, ++counter);
				}
			}
			if (m.isEmpty()) {
				m.put(nums[i], 0);
			}

			list.add(m);
		}

		List<Integer> l = new ArrayList<Integer>();
		for (Map<Integer, Integer> m : list) {
			for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
				Integer values = entry.getValue();
				l.add(values);
			}
		}

		if (l.isEmpty()) {
			for (int i = 0; i < nums.length; i++) {
				l.add(0);
			}
		}

		return l;
	}

	

}
