package org.vivek.myinterview.arrays.binarysearch.problems;

import java.util.HashSet;

/**
 * http://www.geeksforgeeks.org/check-for-majority-element-in-a-sorted-array/
 */
public class FirstOccurrenceOfNumberInSortedArray {

    public int firstOccurrence(int nums[], int data){
        int low = 0;
        int high = nums.length-1;
        
        while(low <= high){
            int middle = (low + high)/2;
            if(nums[middle] == data && (middle == 0 || data >nums[middle-1] )){
                return middle;
            }else if(data>nums[middle]){
                low = middle+1;
            }else{
                high = middle-1;
            }
        }
        return -1;
    }
    
 // This function prints the first repeating element in arr[]
 	static void printFirstRepeating(int arr[]) {
 		// Initialize index of first repeating element
 		int min = -1;

 		// Creates an empty hashset
 		HashSet<Integer> set = new HashSet<>();

 		// Traverse the input array from right to left
 		//for (int i = arr.length - 1; i >= 0; i--) {
 			int i = arr.length - 1;
 		
 		while( i >= 0) {
 			// If element is already in hash set, update min
 			if (set.contains(arr[i])) {
 				min = i;
 			}else {// Else add element to hash set
 				set.add(arr[i]);
 			}
 			i--;
 		}

 		// Print the result
 		if (min != -1)
 			System.out.println("The first repeating element is " + arr[min]);
 		else
 			System.out.println("There are no repeating elements");
 	}
    
    public static void main(String args[]){
        FirstOccurrenceOfNumberInSortedArray fos = new FirstOccurrenceOfNumberInSortedArray();
        int input[] = {1,2,2,2,2,2,5,7,7};
        System.out.println(fos.firstOccurrence(input, 7));
        printFirstRepeating(input);
    }
    
}
