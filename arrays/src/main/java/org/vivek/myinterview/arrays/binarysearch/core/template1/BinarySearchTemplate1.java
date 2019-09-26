/**
 * 
 */
package org.vivek.myinterview.arrays.binarysearch.core.template1;

import org.vivek.myinterview.arrays.binarysearch.core.BinarySearch;

/**
 * @author Vivek
 *
 */
public class BinarySearchTemplate1 {

  /**
   * @param args
   */
  public static void main(String[] args) {
    BinarySearchTemplate1 bSearch = new  BinarySearchTemplate1();
    final int arr1[] = {1, 2, 4, 5, 7, 8};
    System.out.println(searchIterativeTemplate1(arr1, -1));
    System.out.println(searchIterativeTemplate1(arr1, 1));
    System.out.println(searchIterativeTemplate1(arr1, 8));
    System.out.println(searchIterativeTemplate1(arr1, 2));
  }

  
  /**
   * Template #1 is used to search for an element or condition 
   * which can be determined by accessing a single index in the array.
   * @param nums
   * @param target
   * @return
   */
   static int searchIterativeTemplate1(int[] nums, int target) {
      if (nums == null || nums.length == 0)
        return -1;

      int left = 0, right = nums.length - 1;
      while (left <= right) {
        // Prevent (left + right) overflow
        int mid = left + (right - left) / 2;
        //match the required condition by accessing a single index in the array
        if (nums[mid] == target) {
          return mid;
        } else if (target>nums[mid]) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }

      // End Condition: left > right
      return -1;
    }
    
    public static int searchRecursive(int[] nums, int target, int left, int right) {

      int mid = left + (right - left) / 2;
      // End Condition: left > right
      if (right < left) {
          return -1;
      }
    
      if (target==nums[mid]) {
          return mid;
      } else if (target < nums[mid]) {
           right = mid-1;
          // left unchanged
          return searchRecursive(nums, target, left,right);
      } else if (target > nums[mid]) {
           left = mid +1;
          // right unchanged
          return searchRecursive(nums, target,left, right);
      }
      return mid;


  }

}
