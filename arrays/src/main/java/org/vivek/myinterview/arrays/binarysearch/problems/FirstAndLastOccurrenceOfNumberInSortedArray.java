package org.vivek.myinterview.arrays.binarysearch.problems;

/**
 * http://www.geeksforgeeks.org/check-for-majority-element-in-a-sorted-array/
 */
public class FirstAndLastOccurrenceOfNumberInSortedArray {

	// brute
	public static void findFirstAndLast(int arr[], int x) {
		int n = arr.length;
		int first = -1, last = -1;
		for (int i = 0; i < n; i++) {
			if (x != arr[i])
				continue;
			if (first == -1)
				first = i;
			last = i;
		}
		if (first != -1) {
			System.out.println("First Occurrence = " + first);
			System.out.println("Last Occurrence = " + last);
		} else
			System.out.println("Not Found");
	}

	public int firstOccurrenceIterative(int a[], int x) {
		int l = 0;
		int r = a.length - 1;

		//@formatter:off
		while (l <= r) {
			 int mid = l + (r - l)/2; 
			 /* 
			  * Check if a[mid] is the first occurrence of x. 
               a[mid] is last occurrence of x
              iff one of the following is true: 
              // base condition : first index[0] is already first i.e we found match on left half
            (i)  mid == 0 and a[mid] == x 
             // we found match and its index is on lef thalf jsut greater than  middle-1 
            (ii) x >a[mid-1] i.e exists in left half and a[mid] == x  
        */
			if (( mid ==0) || (a[mid] == x && x>a[mid - 1])) {
				return mid;
			 //FIRST (preference)look at leftmost least  value in right half
			} else if ( x>a[mid] ) {
				l = mid + 1;
			///If not in right half, look in left half
			} else {
				r = mid - 1;
			}
		}
		return l;
	}
	
	public int firstOccurrenceRecursive(int a[], int x,int l ,int r) {
		/* 
		  * Check if a[mid] is the first occurrence of x. 
         a[mid] is last occurrence of x
        iff one of the following is true: 
        // base condition : first index[0] is already first i.e we found match on left half
      (i)  mid == 0 and a[mid] == x 
       // we found match and its index is on lef thalf jsut greater than  middle-1 
      (ii) x >a[mid-1] i.e exists in left half and a[mid] == x  
  */
		   
		 if (r >= l) 
		    { 
		        int mid = l + (r - l)/2; 
		        if (( mid == 0 || x > a[mid-1]) && a[mid] == x) {
		            return mid; 
		            //FIRST (preference)look at leftmost  value in right half
		        }else if  (x > a[mid]){
		        	l = mid+1;
		            return firstOccurrenceRecursive(a, x,l, r); 
		        }else  {
		        	r =  mid-1;
		            return firstOccurrenceRecursive(a, x,l, r); 
		        }
		    } 
		    return -1; 
	}
	
	

	public int lastOccurrenceIterative(int a[], int x) {
		int l = 0;
		int r = a.length - 1;
     
        //@formatter:off
		while (l <= r) {
			 int mid = l + (r - l)/2; 
			 /* 
			  * Check if a[mid] is the first occurrence of x. 
               a[mid] is first occurrence of x
              iff one of the following is true: 
              // base condition : middle index is already last i.e we found match on right half
            (i)  mid == r and a[mid] == x 
             // we found match and its index is on left half less than middle+1 
            (ii) x <a[mid+1] i.e exists in right half and arr[mid] == x  
        */
			if ((mid == a.length - 1) || (a[mid] == x && x<a[mid + 1])) {
				return mid;
				 //FIRST (preference)look at rightmost  value in left half
			} else if ( x<a[mid] ) {
				r = mid - 1;				
			///If not rightmost value in left half, look in right half
			} else {
				l = mid + 1;
			}
		}
		return r;
	}
	
	public int lastOccurrenceRecursive(int a[], int x,int l,int r) {
		 /* Check if arr[mid] is the last occurrence of x. 
        arr[mid] is last occurrence if x is one of the following 
        is true: 
        (i)  mid == a.length - 1(last index) and arr[mid] == x 
        (ii) x <a[mid+1] i.e exists in right half and a[mid] == x  
    */
		 
		 if (r >= l) 
		    { 
		        int mid = l + (r - l)/2; 
		        if (( mid == a.length-1 || x < a[mid+1]) && a[mid] == x) {
		            return mid;
		          //FIRST (preference)look at rightmost  value in left half
		        }else if (x < a[mid]) {
		        	r =  mid-1;
		            return lastOccurrenceRecursive(a, x,l, r); 
		        }else {
		        	l = mid+1;
		            return lastOccurrenceRecursive(a, x,l, r); 
		        }
		    } 
		    return -1; 
		
	}
	
	int last(int a[],  int x,int l, int r) 
	{ 
	    if (r >= l) 
	    { 
	        int mid = l + (r - l)/2; 
	        if (( mid == a.length-1 || x < a[mid+1]) && a[mid] == x) {
	            return mid; 
	        }else if (x < a[mid]) {
	        	r =  mid-1;
	            return last(a,  x,l, r); 
	        }else {
	        	l = mid+1;
	            return last(a,  x,l, r); 
	        }
	    } 
	    return -1; 
	} 

	public static void main(String args[]) {
		FirstAndLastOccurrenceOfNumberInSortedArray fos = new FirstAndLastOccurrenceOfNumberInSortedArray();
		int arr1[] = { 1, 2, 2, 2, 2, 3, 5, 7, 7 };
		int arr2[] = {1, 2, 3, 3, 3, 3, 10};
		int arr3[] = {1, 1, 2,3,4, 4, 4, 6, 6};
		System.out.println(fos.firstOccurrenceIterative(arr1, 2));
		System.out.println(fos.firstOccurrenceRecursive(arr1, 2,0,arr1.length-1));
		System.out.println(fos.firstOccurrenceIterative(arr2, 3));
		System.out.println(fos.firstOccurrenceRecursive(arr2, 3,0,arr2.length-1));
		System.out.println(fos.firstOccurrenceIterative(arr3, 4));
		System.out.println(fos.firstOccurrenceRecursive(arr3, 4,0,arr3.length-1));
		System.out.println("********************");;
		System.out.println(fos.lastOccurrenceIterative(arr1, 2));
		System.out.println(fos.lastOccurrenceRecursive(arr1, 2,0,arr1.length-1));
		System.out.println(fos.lastOccurrenceIterative(arr2, 3));
		System.out.println(fos.lastOccurrenceRecursive(arr2, 3,0,arr2.length-1));
		System.out.println(fos.lastOccurrenceIterative(arr3, 4));
		System.out.println(fos.lastOccurrenceRecursive(arr3, 4,0,arr3.length-1));


	}

}
