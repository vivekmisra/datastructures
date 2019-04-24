package org.vivek.myinterview.arrays.general.problems;

import java.util.ArrayList;
import java.util.List;

public class FndDisappearedNumbers {

	public static void main(String[] args) {
		int[] nums= {4,3,2,7,8,2,3,1};
		List<Integer>list =findDisappearedNumbers(nums);
		list.forEach(System.out::print);
	}
	 public static List<Integer> findDisappearedNumbers(int[] nums) {
	        
	        int len = nums.length;
	        int[] extra = new int[len];
	        
	        for(int n : nums) {
	        	System.out.println("n="+n+",n-1="+(n-1)+", extra[n-1]="+ ", extra["+(n-1)+"]="+extra[n-1]);
	        	//here you are mapping the number value with key -(nums[
	            extra[n-1]++;
	            System.out.println("after extra[n-1]= extra["+(n-1)+"]="+extra[n-1]);
	            System.out.println();
	        }
	        
	        List<Integer> result = new ArrayList<>();
	        for(int i=0; i<extra.length; i++) {
	            if(extra[i] == 0) {
	                result.add(i+1);
	            }
	        }
	        return result;
	    }

}
