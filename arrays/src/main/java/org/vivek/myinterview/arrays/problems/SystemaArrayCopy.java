package org.vivek.myinterview.arrays.problems;

import java.util.Arrays;

public class SystemaArrayCopy {

	public static void main(String[] args) {
		int arr1[] = { 0, 1, 2, 3, 4, 5 };
	      int arr2[] = { 5, 10, 20, 30, 40, 50 };
	    
	      // copies an array from the specified source array
	      System.arraycopy(arr1, 0, arr2, 0, 1);
	      System.out.print("array2 = ");
	      System.out.print(arr2[0] + " ");
	      System.out.print(arr2[1] + " ");
	      System.out.print(arr2[2] + " ");
	      System.out.print(arr2[3] + " ");
	      System.out.print(arr2[4] + " ");
	      System.out.println("*******");
	      Integer a[] = { 0, 0, 0, 0, 0, 0,0,0,0,0 };
	      a=populate(a, 1, 5, 3);
	      System.out.println(Arrays.deepToString(a));
	     /* a=populate(a, 4, 8, 7);
	      System.out.println(Arrays.deepToString(a));*/
	}

	static Integer [] populate ( Integer[] a,int fromIndex,int toIndex,int  k){
		
		 for (int i = 0; i < toIndex; i++)
			   if( a[fromIndex]>0){
	            a[i] =  a[fromIndex]+k;
			   }else{
				   a[i] =  k;
			   }
		return a;
	}
}
