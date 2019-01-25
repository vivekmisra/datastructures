package org.vivek.myinterview.arrays.numbers;

import java.util.Arrays;

public class SortedSquares {

	public SortedSquares() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Integer [] A = {-7,-3,2,3,11};
		System.out.println(Arrays.deepToString(sortedSquares( A)));

	}
	
	 public static Integer[] sortedSquares(Integer[] A) {
	        
	       // brute force
		 Integer[] B = new Integer[A.length];
	        for(int i=0;i<A.length;i++){
	            int k1= Math.abs(A[i]*A[i]);
	            A[i] = k1;
	            int k=0;
	            if((i+1)<A.length) {
	            	
	            	B[k] = A[i];
	            	k++;
	            }
	        }
	       // Arrays.sort(A);
	        return B;
	    }

}
