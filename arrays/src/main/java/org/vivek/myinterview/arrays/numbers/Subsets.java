package org.vivek.myinterview.arrays.numbers;

import java.util.ArrayList;
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
	
	 public static List<List<Integer>> subsets(int[] nums) {
	        List<List<Integer>> powerSet = new ArrayList<List<Integer>>( nums.length );
	        powerSet.add( new ArrayList<Integer>() );
	        
	        for( int num: nums ){
	        	System.out.println("Processing:"+num);;
			    for( int i=0, j=powerSet.size(); i<j; i++ ) {
	                List<Integer> withNum = new ArrayList<Integer>( powerSet.get(i) );
	                withNum.add( num );
	                powerSet.add( withNum );
	            }
	        }
	        
	        return powerSet;
	    }

}
