package org.vivek.myinterview.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RotatedMaxIndices {

	public static void main(String[] args) {
		List<Integer> a = new ArrayList();
		a.add(3);
		a.add(6);
		a.add(2);
		a.add(8);
		List<Integer> rotate =new ArrayList();
		rotate.add(1);
		rotate.add(2);
		rotate.add(3);
		rotate.add(4);
		List<Integer> l = getMaxElementIndexes( a,  rotate) ;
		System.out.println("Final result:");
		for(int i : l){
			System.out.print(i+",");
		}
	}
	
	private static String printArray(int[] anArray) {
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
	
	public static List<Integer> getMaxElementIndexes(List<Integer> a, List<Integer> rotate) {
	    // Write your code here
	              int [] nums  = new int[a.size()];
	              int [] rotationArray = new int[rotate.size()];
	              //int[] array = list.stream().mapToInt(i->i).toArray();
	             for(int i =0;i<a.size();i++){
	                 nums[i] = a.get(i); 
	              }
	             
	              for(int i =0;i<rotate.size();i++){
	                 rotationArray[i] = rotate.get(i);
	              }
	            List<Integer> result=  rotate(nums , rotationArray);
				return result;
	             
	    }
	    
	    
	    static  List<Integer> rotate(int [] nums , int [] rotationArray ){
	    	List<Integer> result = new ArrayList<Integer>();
	    	 
	           for(int i = 0 ; i <rotationArray.length;i++){
	               int k = rotationArray[i];
	             if (k > nums.length){
	                 k = k % nums.length;
	             }
	             System.out.println("k= :"+k);
	             int numsLength = nums.length;
	             System.out.println("Before--:");
	             printArray(nums);
	             System.out.println("");
	             int rotationFactor = numsLength-k;
	             //on every iteration make deep copy 
	             int [] a = Arrays.copyOf(nums, nums.length);
	             
	             rotateByK(a,rotationFactor);
	             System.out.println("After:" + k + " rotation -");
	             printArray(a);
	             System.out.println("");
	            int maxIndex = findIndexOfMax(a);
	            System.out.println("max index---" +maxIndex  );
	             
	     		result.add(maxIndex);
	           }
	           
	           return result;
	           
	       }

		
		
		public static void rotateByK(int[] nums, int k) {
			int [] rotated = new int[nums.length] ;
			if (nums == null || nums.length==0 || k < 0) {
				throw new IllegalArgumentException("Illegal argument!");
			}
		 
			if(k > nums.length){
				k = k %nums.length;
			}
		 
			//length of first part
			int a = nums.length - k; 
			//printArray(nums);
			reverse(nums, 0, a-1);
			reverse(nums, a, nums.length-1);
			reverse(nums, 0, nums.length-1);
			//printArray(nums);
		}
	       
	       
	      private static int findIndexOfMax(int[] nums) {
	    	   int max = nums[0];
	    		int index = 0;

	    		for (int i = 0; i < nums.length; i++) 
	    		{
	    			if (max < nums[i]) 
	    			{
	    				max = nums[i];
	    				index = i;
	    			}
	    		}
			return index;
		}


		static void  reverse(int [] nums,int left,int right){
	          if(nums==null || nums.length==1)
	        	  return;
	          while(left<right){
	              swap(nums,left,right);
	              left++;
	              right--;
	          }
	           
	       }
	       
	       static void swap(int[] nums , int i , int j){
	           int temp = nums[i];
	           nums[i] = nums[j];
	           nums[j] = temp;
	           
	       }


}
