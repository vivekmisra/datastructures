package org.vivek.myinterview.arrays.sorting.problems;

import java.util.Arrays;

/**
 * Convert an unsorted array into an array such that
 * a < b > c < d > e < f and so on
 */
public class ConvertAnArrayIntotoSawToothWaveFashion {

	public ConvertAnArrayIntotoSawToothWaveFashion() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Integer arr[] = { 0, 6, 9, 13, 10, -1, 8, 2, 4, 14, -5 };
		convertToSawToothWaveFashion(arr);
		Integer arr2[] = { 0, 6, 9, 13, 10, -1, 8, 2, 4, 14, -5 };
		convertToSawToothWaveFashionWithoutSorting(arr2);
	}

	private static void swap(Integer arr[], int low, int high) {
		int temp = arr[low];
		arr[low] = arr[high];
		arr[high] = temp;
	}
	
	/**
     * Sort the array first.
     * Leave the fist element,then swap every adjacent element to get final result
     * @param A
     */
	public static void convertToSawToothWaveFashion(Integer arr[]) {
		System.out.println("convertToSawToothWaveFashion:Before convert :"+ Arrays.deepToString(arr));
		Arrays.sort(arr);
		System.out.println("Before convert after sort :"+ Arrays.deepToString(arr));
		for (int i = 1; i < arr.length; i += 2) {
			if (i + 1 < arr.length) {
				swap(arr, i, i + 1);
			}
		}
		System.out.println("convertToSawToothWaveFashion:After convert :"+ Arrays.deepToString(arr));
	}
	
	
	
	/**
     * Sort the array first.
     * Leave the fist element,then swap every adjacent element to get final result
     * @param A
     */
	public static void convertToSawToothWaveFashionWithoutSorting(Integer arr[]) {
		System.out.println("convertToSawToothWaveFashionWithoutSorting:Before convert :"+ Arrays.deepToString(arr));
        // Traverse all even elements		 
        for (int i = 0; i < arr.length; i+=2){
            // If current even element is smaller than previous
            if (i>0 && arr[i-1] > arr[i] ) {
                swap(arr, i, i-1);
            }
           
           
            // If current even element is smaller than next
            if (i<arr.length-1 && arr[i] < arr[i+1] ) {
            	 System.out.println("convertToSawToothWaveFashionWithoutSorting:Before convert after swap:a[i+1] =" +arr[i+1] + "arr[i]="+arr[i]+ "arr="+Arrays.deepToString(arr));
                swap(arr, i, i+1);
            }
        }
        System.out.println("convertToSawToothWaveFashionWithoutSorting:After convert :"+ Arrays.deepToString(arr));
	}

}
