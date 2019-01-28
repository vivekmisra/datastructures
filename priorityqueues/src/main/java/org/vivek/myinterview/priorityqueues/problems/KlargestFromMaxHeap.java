package org.vivek.myinterview.priorityqueues.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KlargestFromMaxHeap {

	List<Integer> peekTopK(int[] arr, int k) {
		List<Integer> result = new ArrayList<>();
		PriorityQueue<Integer> candidates = new PriorityQueue<Integer>((a, b) -> (b - a));
		if (k > 0)
			result.add(arr[0]);
		k = k - 1;
		int i = 0;
		int left = 0;
		int right = 0;
		while (k-- > 0) {
			left = 2 * i + 1;
			right = 2 * i + 2;
			if (left < arr.length) {
				candidates.add(arr[left]);
			}
			if (right < arr.length) {
				candidates.add(arr[right]);
			}
			result.add(candidates.poll());
			i++;
		}
		return result;
	}
}
