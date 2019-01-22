package org.vivek.myinterview.priorityqueues.problems;

import java.util.PriorityQueue;

/*
 * 
 * https://leetcode.com/problems/split-array-into-consecutive-subsequences/
 * 
 * You are given an integer array sorted in ascending order (may contain duplicates), 
 * you need to split them into several subsequences, where each subsequences consist of
 *  at least 3 consecutive integers.
 *  Return whether you can make such a split.

Example 1:

Input: [1,2,3,3,4,5]
Output: True
Explanation:
You can split them into two consecutive subsequences : 
1, 2, 3
3, 4, 5

Example 2:

Input: [1,2,3,3,4,4,5,5]
Output: True
Explanation:
You can split them into two consecutive subsequences : 
1, 2, 3, 4, 5
3, 4, 5

Example 3:

Input: [1,2,3,4,4,5]
Output: False

 */
public class SplitArrayIntoConsecutiveSubsequences {

	public SplitArrayIntoConsecutiveSubsequences() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int[] nums1 = { 1, 2, 3, 3, 4, 5 };
		System.out.println(isPossible(nums1));
		int[] nums2 = { 1, 2, 3, 3, 4, 4, 5, 5 };
		System.out.println(isPossible(nums2));

	}

	/*
	 * Let's take [1, 2, 3, 3, 4, 5, 7] as an example
	 * 
	 * [1, 2, 3, 3, 4, 5, 7] 
	 * >> [1] 
	 * >> [1,2] #2 
	 * >> [1,2,3] 
	 * >> [1,2,3] [3] #1 
	 * >>[1,2,3] [3,4] 
	 * >> [3,4,5] #3 
	 * >> [7]
	 * 
	 * After observation, there are 3 cases
	 * 
	 * Case 1 : num == pq.peek().end, we offer a new interval (num, num) to pq => #1
	 * Case 2 : num == pq.peek().end+ 1, we poll a interval prev, offer a new
	 * interval (prev.start, num) => #2 Case 3 : num > p1.peek().end + 1, we keep
	 * abandoning intervals (if the length of the interval to abandon is smaller
	 * than 3, return false) until we could reduce to case 1 or case 2 => #3
	 * 
	 * The order of 3 cases above matters. For easier implementation, Case 3 should
	 * be checked first.
	 * 
	 * In the priority queue, all intervals are sorted by end increasingly, if there
	 * is a tie, we sort them by size increasingly.
	 */ public static boolean isPossible(int[] nums) {
		PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> (a.end == b.end ? a.len - b.len : a.end - b.end));
		for (int i : nums) {
			while (!pq.isEmpty() && (pq.peek().end + 1 < i)) {
				if (pq.poll().len < 3) {
					return false;
				}
			}
			if (pq.isEmpty() || (pq.peek().end == i)) {
				pq.offer(new Interval(i, 1));
			} else {
				Interval interval = pq.poll();
				interval.end = i;
				interval.len += 1;
				pq.offer(interval);
			}
		}
		while (!pq.isEmpty()) {
			if (pq.poll().len < 3) {
				return false;
			}
		}
		return true;
	}
}

class Interval {
	int len;
	int end;

	public Interval(int end, int len) {
		this.end = end;
		this.len = len;
	}
}
