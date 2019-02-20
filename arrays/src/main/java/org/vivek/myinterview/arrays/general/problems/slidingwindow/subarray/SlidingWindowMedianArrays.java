package org.vivek.myinterview.arrays.general.problems.slidingwindow.subarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
 * https://leetcode.com/problems/sliding-window-median/submissions/
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

Examples: 
[2,3,4] , the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Your job is to output the median array for each window in the original array.

For example,
Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

Window position                Median
---------------               -----
[1  3  -1] -3  5  3  6  7       1
 1 [3  -1  -3] 5  3  6  7       -1
 1  3 [-1  -3  5] 3  6  7       -1
 1  3  -1 [-3  5  3] 6  7       3
 1  3  -1  -3 [5  3  6] 7       5
 1  3  -1  -3  5 [3  6  7]      6
Therefore, return the median sliding window as [1,-1,-1,3,5,6].
 */
public class SlidingWindowMedianArrays {
	private static String printArray(double[] anArray) {
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
	public static void main(String[] args) {
		int [] nums = {1,3,-1,-3,5,3,6,7};
		//test();
		SlidingWindowMedianArrays sw = new SlidingWindowMedianArrays();
		double[] medians = sw.medianSlidingWindow(nums, 5);
		printArray(medians);
	}
	private static void test() {
		Integer x=8;
		Integer[] nums={2,5,7,8,9};
		Integer i =0;
    	while (i<nums.length && nums[i] <x){
    	//as soon as it equals x,come out
    		i++;
    	}
    	Integer[] nums1 = new Integer[nums.length-1];
    	while(i<nums.length-1){
    		nums[i] = nums[i+1];
    		nums1[i]=nums[i];
    		i++;
    	}
    	System.out.println(Arrays.deepToString(nums1));
	}
	 public double[] medianSlidingWindow(int[] nums, int k) {
	        if(nums == null || nums.length < 1 || k < 1) return null;
	        int len = nums.length;
	        double[] res = new double[len-k+1];
			int sorted[] = new int[k];
			//populated sliding window of k elements
	        for(int i=0;i<k;i++){
	        	sorted[i] = nums[i];
	        }
	        //sort the window
	        Arrays.sort(sorted);;
	        for(int i=k;i<=len ;++i){
	        	res[i-k]= sorted[k/2]*0.5 + sorted[(k-1)/2]*0.5;
	        	if(i==len)break;
	        	remove(sorted,nums[i-k]);
	        	insert(sorted,nums[i]);
	        }
	        return res;
	  	 }
	    void insert(int[] sorted,int x){
	    	int i = sorted.length -2;
	    	while (i>=0 && sorted[i] >x){
	    		sorted [i+1] = sorted[i];
	    		i--;
	    	}
	    	
	    	sorted[i+1]=x;
	    	
	    }
	    void remove(int[] sorted,int x){
	    	int i =0;
	    	while (i<sorted.length && sorted[i] <x){
	    	//as soon as it equals x,come out
	    		i++;
	    	}
	    	while(i<sorted.length-1){
	    		sorted[i] = sorted[i+1];
	    		i++;
	    	}
	    	
	    }
	    class SortedArray{
	        
	        List<Integer> array;
	        
	        SortedArray(){
	            array = new ArrayList<Integer>();
	        }
	        
	        void add(int val){
	            int i = array.size()-1;
	            while(i>=0&&array.get(i)>val) i--;
	            array.add(i+1, val);
	        }
	        
	        void delete(int val){
	            array.remove((Integer)val);
	        }
	        
	        int get(int val){
	            return array.get(val);
	        }
	    }
	

}
