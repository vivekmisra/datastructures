package org.vivek.myinterview.arrays.general.problems.subarrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DegreeOfArray2 {

	public static void main(String[] args) {
		DegreeOfArray2 d = new DegreeOfArray2();
		int[] arr = {1,2,2,3,1,4,2};
		int l=d.findShortestSubArray(arr);
		System.out.println(l);
	}
	
	 public int findShortestSubArray(int[] nums) {
	        
	      //find element with max-m freq in original array
		        //find firstoccurencre index & last occurence index of that element
		        //length of subarray = lastoccurecne -firstoccurence +1
		        Map<Integer,Integer> freqmap = new HashMap<Integer,Integer>();
		        Map<Integer,Range> indxmap = new HashMap<Integer,Range>();
		        int freq =1;
		        for(int i =0;i<nums.length;i++){
		        	  if(freqmap.containsKey(nums[i])){
		                freqmap.put(nums[i],freqmap.get(nums[i])+1);
		                Range r =  indxmap.get(nums[i]);
		                r.setEnd(i);
		                indxmap.put(nums[i],r);
		            }else{
		             freqmap.put(nums[i],freq);
		              indxmap.put(nums[i], new Range(i,i));
		            }
		        }
		        int min = Integer.MAX_VALUE;
		        int len = 0;
		        int degree = Collections.max(freqmap.values());
		       
		       Map<Integer,Integer> maxMap = new HashMap<Integer,Integer>();
		        for (Map.Entry<Integer, Integer> entry : freqmap.entrySet()) {
		             if(entry.getValue()==degree){
		            	 Range r = indxmap.get(entry.getKey());
		            	 len = r.getEnd()-r.getStart()+1;
		            	 if(len<min){
		            		 min = len;
		            	 }
		            	
		             }
		        }
	          return min;
		    }
		    
		    class Range{
		        int start;
		        int end;
		        Range(int start,int end){
		            this.start = start;
		            this.end = end ;
		        }
		        public int getStart(){
		            return this.start;
		        }
		        public int getEnd(){
		            return this.end;
		        }
		        
				public void setStart(int start) {
					this.start = start;
				}
				public void setEnd(int end) {
					this.end = end;
				}
				@Override
				public String toString() {
					return "Range [start=" + start + ", end=" + end + "]";
				}
		        
		    }
	    
}
