package org.vivek.myinterview.classictechniques.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

	public ThreeSum() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int [] nums = { 1, 4, 5, 6, 8 ,10 }; 
	    int sum = 17; 
	    List<List<Integer>> result =threeSumToTarget( nums, sum);
	}
	public static List<List<Integer>>  threeSumToTarget(int[] nums,int target) {
		List<Integer> l = new ArrayList<Integer>();
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		//for (int i = 0; i < nums.length; i++) {
			int i =0;
		    int j = i + 1;
			int k = j+1;
			boolean flag= i<nums.length-1&&  j < nums.length-1 &&  k < nums.length -1;
			while (flag) {
				int sum = nums[i] + nums[j] + nums[k];
  				int diff = Math.abs(sum - target);
	           
				if(diff == 0) {
					l.add(i);
					l.add(j);
					l.add(k);
					result.add(l);
				}
				
				if (diff < target) {
					k++;
					
				}else if (diff < target && j <nums.length-1&& k>=nums.length-1) {
					j++;
					
				}else if (diff < target && i <nums.length-1 && k>=nums.length-1 && j>=nums.length-1) {
					i++;
					
				}
				if (diff > target &&  k>=0) {
					k--;
				}else if (diff > target && k ==0 &&  j>=0 &&i>=0) {
					j--;
				}else if (diff > target && k ==0 && j==0 && i>0) {
					i--;
				}
			}
			return result;
		}
	 
		
		
	
	public static List<List<Integer>> threeSumToZero(int[] nums) {
	    List<List<Integer>> result = new ArrayList<List<Integer>>();
	 
	    if(nums == null || nums.length<3)
	        return result;
	 
	    Arrays.sort(nums);
	 
	    for(int i=0; i<nums.length-2; i++){
	        if(i==0 || nums[i] > nums[i-1]){
	            int j=i+1;
	            int k=nums.length-1;
	 
	            while(j<k){
	                if(nums[i]+nums[j]+nums[k]==0){
	                    List<Integer> l = new ArrayList<Integer>();
	                    l.add(nums[i]);
	                    l.add(nums[j]);
	                    l.add(nums[k]);
	                    result.add(l);
	 
	                    j++;
	                    k--;
	 
	                    //handle duplicate here
	                    while(j<k && nums[j]==nums[j-1])
	                        j++;
	                    while(j<k && nums[k]==nums[k+1])
	                        k--;
	 
	                }else if(nums[i]+nums[j]+nums[k]<0){
	                    j++;
	                }else{
	                    k--;
	                }
	            }
	        }
	 
	    }
	 
	    return result;
	}
}
