package org.vivek.myinterview.arrays.binarysearch.problems;

/**
 * @author Tushar Roy
 * Date 01/17/2107
 * A peak element is an element that is greater than its neighbors. Find index of peak element in the array.
 *
 * Space complexity is O(1)
 * Time complexity is O(n)
 *
 * https://leetcode.com/problems/find-peak-element/
 */
public class PeakElement {

    public int findPeakElement(int[] nums) {
    	  int l = 0;
          int r = nums.length - 1;
          int mid = 0;
          int midLeft = Integer.MIN_VALUE;
          int midRight = Integer.MIN_VALUE;
          while (l <= r) {
              mid = l+(r-l)/2;
             
              if (mid > 0) {
                  midLeft = nums[mid - 1];
              }
             
              if (mid < nums.length - 1) {
                  midRight = nums[mid + 1];
              }
              if (midLeft <nums[mid] && nums[mid] > midRight) {
                  return mid;
              } else if (midLeft > midRight) {
                  r = mid - 1;
              } else {
                  l = mid + 1;
              }
          }
          return mid;
    }

    public static void main(String args[]){
        int arr[] = {10,5,15,2,23,90,67};
        PeakElement pe = new PeakElement();
        System.out.println(pe.findPeakElement(arr));
        int arr1[] = {10,20,30,40,50};
        System.out.println(pe.findPeakElement(arr1));
        int arr2[] = {100,90,80,70,60};
        System.out.println(pe.findPeakElement(arr2));
                
    }
}
