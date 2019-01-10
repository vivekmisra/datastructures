package org.vivek.myinterview.arrays.binarysearch.problems;

import java.util.Arrays;

/**
 * http://www.geeksforgeeks.org/check-for-majority-element-in-a-sorted-array/
 */
public class OccurrenceOfNumberInSortedArray {

	public int firstOccurrenceIterative(int arr[], int data) {
		int low = 0;
		int high = arr.length - 1;
     
        
		while (low <= high) {
			int middle =low+ ( high-low) / 2;
			 /* Check if arr[mid] is the first occurrence of x. 
            arr[mid] is first occurrence if x is one of the following 
            is true: 
            (i)  mid == low and arr[mid] == data //base
            (ii) data >arr[mid-1] i.e exists in right half and arr[mid] == data 
        */
			if (((arr[middle] == data) && (middle == low)) || ((arr[middle] == data) && (data>arr[middle - 1]))) {
				return middle;
				//FIRST (preference)look in left half
			} else if ( data<=arr[middle] ) {
				high = middle - 1;
				//NEXT (preference)look in right half
			} else {
				low = middle + 1;
			}
		}
		return -1;
	}
	
	public int firstOccurrenceRecursive(int arr[], int data,int low,int high) {
		
		   if(high < low)
	        	return -1;
	
			int middle =low+ ( high-low) / 2;
			 /* Check if arr[mid] is the first occurrence of x. 
            arr[mid] is first occurrence if x is one of the following 
            is true: 
            (i)  mid == low and arr[mid] == data // base condition : middle index is already low i.e we found match on left half
            (ii) data >arr[mid-1] and arr[mid] == data //  we found match on right half
        */
			if (((arr[middle] == data) && (middle == low)) || ((arr[middle] == data) && (data>arr[middle - 1]))) {
				return middle;
			//FIRST (preference)look in left half
			} else if ( data<=arr[middle] ){
				high = middle - 1;
				return firstOccurrenceRecursive(arr,data,low,middle - 1);
				//NEXT (preference)look in right half
			}else   {
				low = middle + 1;
				return firstOccurrenceRecursive(arr,data,middle + 1,high);
			} 
		
	}
	public int lastOccurrenceIterative(int arr[], int data) {
		int low = 0;
		int high = arr.length - 1;
     
        
		while (low <= high) {
			int middle = (low + high) / 2;
			 /* Check if arr[mid] is the first occurrence of x. 
            arr[mid] is first occurrence if x is one of the following 
            is true: 
            (i)  mid == high and arr[mid] == data  // base condition : middle index is already last i.e we found match on right half
            (ii) data <arr[mid+1] i.e exists in right half and arr[mid] == data   // we found match and its index is on left half less than middle+1
        */
			if ((arr[middle] == data && middle == high) || (arr[middle] == data && data<arr[middle + 1])) {
				return middle;
			//FIRST (preference)look in right half
			} else if ( data>=arr[middle] ) {
				low = middle + 1;
			///If not in right half, look in left half
			} else {
				high = middle - 1;
			}
		}
		return -1;
	}
	
	public int lastOccurrenceRecursive(int arr[], int data,int low,int high) {
		
		   if(high < low)
	        	return -1;
	
			int middle =low+ ( high-low) / 2;
			 /* Check if arr[mid] is the first occurrence of x. 
            arr[mid] is first occurrence if x is one of the following 
            is true: 
            (i)  mid == 0 and arr[mid] == data 
            (ii) data >arr[mid-1] and arr[mid] == data 
        */
			if ((arr[middle] == data && middle == high) || (arr[middle] == data && data<arr[middle + 1])) {
				return middle;
			
			} else if ( data>=arr[middle] ) {
				low = middle + 1;
				return lastOccurrenceRecursive(arr,data,middle + 1,high);
			} else {
				high = middle - 1;
				return lastOccurrenceRecursive(arr,data,low,middle - 1);
			}
		
	}

	public static void main(String args[]) {
		OccurrenceOfNumberInSortedArray fos = new OccurrenceOfNumberInSortedArray();
		int arr1[] = { 1, 2, 2, 2, 2, 3, 5, 7, 7 };
		int arr2[] = {1, 2, 3, 3, 3, 3, 10};
		int arr3[] = {1, 1, 2,3,4, 4, 4, 6, 6};
		 printArray(arr1);
		int l1 =fos.lastOccurrenceIterative(arr1, 2);
		    l1= fos.lastOccurrenceRecursive(arr1, 2,0,arr1.length-1);
		int f1= fos.firstOccurrenceIterative(arr1, 2);
		    f1 = fos.firstOccurrenceRecursive(arr1, 2,0,arr1.length-1);
		    System.out.println("Last occurence of 2 :"+ l1);
			System.out.println("First occurence of 2 :"+ f1);
		    int c1 = l1-f1+1;
		    System.out.println("count of 2 :"+ c1);
		printArray(arr2);
		int l2= fos.lastOccurrenceIterative(arr2, 3);
	        l2= fos.lastOccurrenceRecursive(arr2, 3,0,arr2.length-1);
		int f2=fos.firstOccurrenceIterative(arr2, 3);
		f2= fos.firstOccurrenceRecursive(arr2, 3,0,arr2.length-1);
		System.out.println("Last occurence of 3 :"+ l2);
		System.out.println("First occurence of 3 :"+ f2);
		int c2 = l2-f2+1;
	    System.out.println("count of 3 :"+ c2);
		
		printArray(arr3);
		int l3= fos.lastOccurrenceIterative(arr3, 4);
		l3= fos.lastOccurrenceRecursive(arr3, 4,0,arr3.length-1);
		int f3=fos.firstOccurrenceIterative(arr3, 4);
		f3=fos.firstOccurrenceRecursive(arr3, 4,0,arr3.length-1);
		System.out.println("Last occurence of 4 :"+ l3);
		System.out.println("First occurence of 4 :"+ f3);
		int c3 = l3-f3+1;
	    System.out.println("count of 4 :"+ c3);
		
		


	}

	public static void printArray(int[] a) {
		//System.out.println("Printing array"+ a+":");
		for (int i : a) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
