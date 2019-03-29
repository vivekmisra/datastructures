package org.vivek.myinterview.arrays.numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
	
	public static void main(String[] args){
		int [] nums = {1,2,3};
		List<List<Integer>> lists =subsets( nums);
	
		for(List<Integer> list :lists){
			System.out.print("[");
			list.forEach(item->System.out.print(item+","));
			System.out.println("],");
		}
		
	}
	
	 public static  List<List<Integer>> subsets(int[] nums) {
	        List<List<Integer>> results = new ArrayList<>();
	        
	        if (nums == null || nums.length == 0) {
	            return results;
	        }
	        
	        Arrays.sort(nums);
	        
	        List<Integer> subset = new ArrayList<>();
	        toFindAllSubsets(nums, results, subset, 0);                
	        
	        return results;
	    }
	    
	    private static void toFindAllSubsets(int[] nums, List<List<Integer>> results, List<Integer> subset, int startIndex) {
	        results.add(new ArrayList<>(subset));
	        
	        for (int i = startIndex; i < nums.length; i++) {
	            subset.add(nums[i]);
	            toFindAllSubsets(nums, results, subset, i + 1);
	            subset.remove(subset.size() - 1);            
	        }        
	    }
}
