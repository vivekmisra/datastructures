package com.interview.array;

public class Solution {
    
	   public static void main(String[]args){
	        //int[] arrA = { 2, 3, 11, 16, 27, 4, 15, 9, 8 };
	        int[] arrA = { 2,1 };
			 Solution s = new  Solution();
			int k=1;	          
			
			 int x = s.findKthLargest(arrA, k);      
	      System.out.print("The " +k + "th largest element is : " + x);
	   }
	    
	    public int findKthLargest(int[] nums, int k) {
	    	 
	    	int n =0;	
	    	 if(k > nums.length){
	    		 return -1;
	    	 }else{
	    		 n =( nums.length - k) +1;	
	    	 }
	          if (nums.length==1){
	            return   nums[0];
	          }else{  
	            return KthLargest(nums, 0, nums.length - 1,n);
	          }
	    }

	    public  int KthLargest(int a[], int start, int end,int k) {
			int leftCursor=start;
			int rightCursor = end;
			int pivotIndex = start;
			int maxIndex = a.length-1;
		
			while (leftCursor < rightCursor) {
			
				while (a[leftCursor] < a[pivotIndex]) {			
					System.out.println("*** a["+leftCursor+"] <a["+pivotIndex+"]  => "+  (a[leftCursor] < a[pivotIndex]) +" *****");
					leftCursor++;
					System.out.println("*** leftCursor++ =>  a[leftCursor]= "+  a[leftCursor] );
					System.out.println("*** Is a["+leftCursor+"] <a["+pivotIndex+"]  => "+  (a[leftCursor] < a[pivotIndex]) +" *****");
					printArray(a, leftCursor, rightCursor, pivotIndex);		
				}
				while (a[rightCursor] > a[pivotIndex]) {
					System.out.println("*** a["+rightCursor+"] >a["+pivotIndex+"]  => "+  (a[rightCursor] > a[pivotIndex]) +" *****");
					rightCursor--;	
					System.out.println("*** rightCursor-- =>  a[rightCursor]= "+  a[rightCursor] );
					System.out.println("***Is a["+rightCursor+"] >a["+pivotIndex+"]  => "+  (a[rightCursor] > a[pivotIndex]) +" *****");
					printArray(a, leftCursor, rightCursor, pivotIndex);
				}
				System.out.println("Before swapping...");
				printArray(a, leftCursor, rightCursor, pivotIndex);
				swap(a, leftCursor, rightCursor);
				System.out.println("After swapping...");
				printArray(a, leftCursor, rightCursor, pivotIndex);
				System.out.println("*** end*****");
				
			}
		
			
			if (pivotIndex == k){
				return  a[pivotIndex];// if pivot is kth element , return
			}else if (pivotIndex < k){
				
				return KthLargest(a, pivotIndex + 1,end, k);
			}else{
				// if pivot is greater than k, then kth element will be on the right			
				return KthLargest(a, start, pivotIndex - 1, k);		
			}
		}
	    public  void swap(int[] a, int left, int right) {
			int temp = a[left];
			a[left] = a[right];
			a[right] = temp;
		}
	    
	    public void printArray(int[] a) {
			for (int i : a) {
				System.out.print(i + " ");
			}
			System.out.println();
		}

		public void printArray(int[] a, int leftCursor, int rightCursor, int pivot) {
			for (int i : a) {
				System.out.print(i + " ");
			}
			System.out.println();
			if (leftCursor >= 0) {
				System.out.print("leftCursor=" + leftCursor + " ,a[" + leftCursor + "]=" + a[leftCursor]);
			}
			if (rightCursor >= 0) {
				System.out.print(" ,rightCursor=" + rightCursor + " ,a[" + rightCursor + "]=" + a[rightCursor]);
			}
			System.out.println(" ,pivot=" + pivot);
		}
	    
	}
