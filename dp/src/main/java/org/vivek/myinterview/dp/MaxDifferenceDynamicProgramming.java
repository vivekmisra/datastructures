package org.vivek.myinterview.dp;

public class MaxDifferenceDynamicProgramming {

	public static int maxDifference(int [] A){
        int size = A.length;
        int maxDiff = -1;
        int max_so_far = A[size-1]; //assign the last element
        //reverse index loop
        for (int i = size - 2 ; i >0 ; i--) {
        	if(A[i] > max_so_far){
        		max_so_far = A[i];//new  max_so_far
        	}else if (A[i] < max_so_far){
        		  int currentDiff =max_so_far-A[i];
        		  //new maxDiff is the maximum of currentDiff and older maxDiff
        		  maxDiff = Math.max(maxDiff, currentDiff);
        	}
            
        }
        return maxDiff;
    }

    public static void main(String[] args) {
        int [] A = { 12, 5, 1, 7, 3, 9, 5};
        System.out.println("Maximum Difference between two elements A[i] and A[j] and where j > i: " + maxDifference(A));
    }

}
