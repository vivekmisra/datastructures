package org.vivek.myinterview.arrays.general.problems.subarrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DegreeOfArray {

	public static void main(String[] args) {
		DegreeOfArray d = new DegreeOfArray();
		int[] arr = {1,2,2,3,1,4,2};
		int l=d.findShortestSubArray(arr);
		System.out.println(l);
	}
	
	 public int findShortestSubArray(int[] nums) {	      
	       Map<Integer,DegreeDetails> freqmap = new HashMap<Integer,DegreeDetails>();
	      Set<DegreeDetails> setOfDegreeDetails = new HashSet<>();
	       if(nums.length==0){
	    	   return -1;
	       }
	       
	       if(nums.length==1){
	    	   return 1;
	       }
	        for(int i =0;i<nums.length;i++){
	        	if(freqmap.containsKey(nums[i])){
	                DegreeDetails d =  freqmap.get(nums[i]);
	                d.setEnd(i);
	                d.setDegree(d.getDegree()+1);
	                freqmap.put(nums[i],d);
	                setOfDegreeDetails.add(d);
	            }else{
	             freqmap.put(nums[i],new DegreeDetails(nums[i],i,i,1));
	             
	            }
	        }
	         
	       DegreeDetails degree = Collections.max(setOfDegreeDetails);	     
	       int  len = degree.getEnd()-degree.getStart()+1;
          return len;
	    }
	    
	    class DegreeDetails implements Comparable<DegreeDetails> {
	    	int num;
	        int start;
	        int end;
	        int degree;
	        
	      
	        DegreeDetails(int num,int start,int end,int degree){
	        	this.num = num;
	            this.start = start;
	            this.end = end ;
	            this.degree =degree;
	        }
	        public int getNum() {
				return num;
			}
			public void setNum(int num) {
				this.num = num;
			}
			public int getDegree() {
				return degree;
			}
			public void setDegree(int degree) {
				this.degree = degree;
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
				return "DegreeDetails [num=" + num + ", start=" + start + ", end=" + end + ", degree=" + degree + "]";
			}
			@Override
			public int compareTo(DegreeDetails other) {
				if (this.degree == other.degree) {
	                return (-1)*(this.end - this.start) - (other.end - other.start);
	            }
	            return this.degree - other.degree;
	        
			}
	    }
	    
}
