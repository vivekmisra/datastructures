package org.vivek.myinterview.arrays.sorting.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BucketSort {

	public BucketSort() {
		// TODO Auto-generated constructor stub
	}


	 
	 
	   public static void main(String[] args) {
	      int maxVal=5;
	      int [] data= {5,3,0,2,4,1,0,5,2,3,1,4}; 
	 
	      System.out.println("Before: " + Arrays.toString(data));
	      sort(data,maxVal);
	      System.out.println("After:  " + Arrays.toString(data));
	   }

	   public static void sort(int[] a, int maxVal) {
	      int [] bucket=new int[maxVal+1];
	 
	      for (int i=0; i<bucket.length; i++) {
	         bucket[i]=0;
	      }
	 
	      for (int i=0; i<a.length; i++) {
	         bucket[a[i]]++;
	      }
	 
	      int outPos=0;
	      for (int i=0; i<bucket.length; i++) {
	         for (int j=0; j<bucket[i]; j++) {
	            a[outPos++]=i;
	         }
	      }
	   }

}



