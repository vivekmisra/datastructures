package org.vivek.myinterview.priorityqueues.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/*
 * https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
 * You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.

Define a pair (u,v) which consists of one element from the first array and one element from the second array.

Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.

Example 1:

Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
Output: [[1,2],[1,4],[1,6]] 
Explanation: The first 3 pairs are returned from the sequence: 
             [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]

Example 2:

Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
Output: [1,1],[1,1]
Explanation: The first 2 pairs are returned from the sequence: 
             [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]

Example 3:

Input: nums1 = [1,2], nums2 = [3], k = 3
Output: [1,3],[2,3]
Explanation: All possible pairs are returned from the sequence: [1,3],[2,3]

*/

public class KPairsWithSmallestSums {

	public KPairsWithSmallestSums() {

	}

	public static void main(String[] args) {
		//int[] nums1 = { 1, 7, 11 };
		//int[] nums2 = { 2, 4, 6 };
		//int k = 3;
		int[] nums1 = {1,1,2};
		int[] nums2 = {1,2,3} ;
		int k = 2;
		int m = nums1.length, n = nums2.length;
		printArray(nums1);
		printArray(nums2);
		System.out.println();
		for (int j = 0; j <= n - 1; j++) {
			System.out.println("j= "+j+", nums1[0]="+nums1[0]+", nums2[j]="+nums2[j]);
		}
		
		List<int[]> l = kSmallestPairs(nums1, nums2, k);
		System.out.print("[");
		for (int[] arr : l) {
			printArray(arr);
		}
		System.out.print("]");
	}

	private static void printArray(int[] anArray) {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = 0; i < anArray.length; i++) {
			if (i > 0) {
				sb.append(", ");
			}
			sb.append(anArray[i]);
		}
		sb.append("]");
		System.out.print(sb.toString());
	}

	public static List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		//1-create the result container
		List<int[]> res = new ArrayList<int[]>();
		if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0 || k <= 0)
			return res;
		 //3-construct PQ with comparator implemented
		PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>();
		int m = nums1.length, n = nums2.length;

		//4-insert in PQ ,apply filter if any 
		for (int j = 0; j <= n - 1; j++) {
			
			int x =0;
			int y= j;
			int sum = nums1[x] + nums2[y];
			Tuple t = new Tuple(x, y, sum);
			System.out.println("Added :"+ t);
			pq.offer(t);
		}
		
		//5-poll PQ in result container,apply filter if any 
		for (int i = 0; i < Math.min(k, m * n); i++) {
			Tuple t = pq.poll();
			System.out.println("Polled :"+ t);
			res.add(new int[] { nums1[t.x], nums2[t.y] });
			if (t.x == m - 1) {
				continue;
			}
			
			int x =t.x + 1;
			int y= t.y;
			int sum = nums1[x] + nums2[y];
			 t = new Tuple(x, y, sum);
			pq.offer(t);
			System.out.println("Added :"+ t);
		}
		return res;
	}
}
//2-create a ds container to store inputs
class Tuple implements Comparable<Tuple> {
	int x, y, sum;

	public Tuple(int x, int y, int val) {
		this.x = x;
		this.y = y;
		this.sum = val;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Tuple [x=" + x + ", y=" + y + ", sum=" + sum + "]";
	}

	@Override
	public int compareTo(Tuple that) {
		return this.sum - that.sum;
	}
}
