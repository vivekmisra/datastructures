package org.vivek.myinterview.classictechniques.twopointers;

public class RotateArray {

	public RotateArray() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int[] nums1 = {1,2,3,4,5,6,7};
		int k=3;
		System.out.println("**********rotate********");
		rotate(nums1,k);
		int[] nums2 = {1,2,3,4,5,6,7};
		System.out.println("**********rotateLikeBubbleSort********");
		rotateLikeBubbleSort(nums2,k);
		int[] nums3 = {1,2,3,4,5,6,7};
		System.out.println("**********rotateByCopying********");
		rotateByCopying(nums3,k);
	}
	
	public static void rotate(int[] nums, int k) {
		
		if (nums == null || nums.length==0 || k < 0) {
			throw new IllegalArgumentException("Illegal argument!");
		}
	 
		if(k > nums.length){
			k = k %nums.length;
		}
	 
		//length of first part
		int a = nums.length - k; 
		printArray(nums);
		reverse(nums, 0, a-1);
		reverse(nums, a, nums.length-1);
		reverse(nums, 0, nums.length-1);
		printArray(nums);
	}
	 
	public static void reverse(int[] arr, int left, int right){
		if(arr == null || arr.length == 1) 
			return;
	   
		while(left < right){
			swap(arr,left,right);
			left++;
			right--;
		}	
	}
	
	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	public static void rotateByCopying(int[] nums, int k) {
	    if(k > nums.length) 
	        k=k%nums.length;
	    printArray(nums);
	    int[] result = new int[nums.length];
	 
	    for(int i=0; i < k; i++){
	        result[i] = nums[nums.length-k+i];
	    }
	 
	    int j=0;
	    for(int i=k; i<nums.length; i++){
	        result[i] = nums[j];
	        j++;
	    }
	 
	    System.arraycopy( result, 0, nums, 0, nums.length );
	    printArray(nums);
	}
	
	public static void rotateLikeBubbleSort(int[] nums, int k) {
		if (nums == null || k < 0) {
		    throw new IllegalArgumentException("Illegal argument!");
		}
		printArray(nums);
		for (int i = 0; i < k; i++) {
			for (int j = nums.length - 1; j > 0; j--) {
				swap(nums,j,j-1);
			}
		}
		printArray(nums);
	}
	private static void printArray(int[] anArray) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < anArray.length; i++) {
			if (i > 0) {
				sb.append(", ");
			}
			sb.append(anArray[i]);
		}
		System.out.println(sb.toString());
	}

}
