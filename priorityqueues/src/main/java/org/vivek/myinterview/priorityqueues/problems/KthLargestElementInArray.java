package org.vivek.myinterview.priorityqueues.problems;

import java.util.PriorityQueue;

public class KthLargestElementInArray {

	public static void main(String[] args) {
		int [] nums = {3,1,6,5,2,4};
		int k=2;
		int kthlargest = findKthLargest( nums, k);
		System.out.println(kthlargest);

	}
	public static int findKthLargest(int[] nums, int k) {
	    PriorityQueue<Integer> q = new PriorityQueue<Integer>(k);
	    for(int i: nums){
	        q.offer(i);
	        int size = q.size();
	        if(size>k){
	            q.poll();
	        }
	    }
	 
	    return q.peek();
	}

}
