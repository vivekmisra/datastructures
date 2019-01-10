package org.vivek.myinterview.arrays.binarysearch.problems;

/**
 * http://www.geeksforgeeks.org/check-for-majority-element-in-a-sorted-array/
 */
public class FirstOccurrenceOfNumberInSortedArray {

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

	public static void main(String args[]) {
		FirstOccurrenceOfNumberInSortedArray fos = new FirstOccurrenceOfNumberInSortedArray();
		int arr1[] = { 1, 2, 2, 2, 2, 3, 5, 7, 7 };
		int arr2[] = {1, 2, 3, 3, 3, 3, 10};
		int arr3[] = {1, 1, 2,3,4, 4, 4, 6, 6};
		System.out.println(fos.firstOccurrenceIterative(arr1, 2));
		System.out.println(fos.firstOccurrenceRecursive(arr1, 2,0,arr1.length-1));
		System.out.println(fos.firstOccurrenceIterative(arr2, 3));
		System.out.println(fos.firstOccurrenceRecursive(arr2, 3,0,arr2.length-1));
		System.out.println(fos.firstOccurrenceIterative(arr3, 4));
		System.out.println(fos.firstOccurrenceRecursive(arr3, 4,0,arr3.length-1));


	}

}
