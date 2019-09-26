/**
 * 
 */
package org.vivek.myinterview.arrays.binarysearch.core.template3.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * @author Vivek
 *
 */
/*
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/ 34. Find
 * First and Last Position of Element in Sorted Array Medium
 * 
 * 1975
 * 
 * 97
 * 
 * Favorite
 * 
 * Share Given an array of integers nums sorted in ascending order, find the starting and ending
 * position of a given target value.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * If the target is not found in the array, return [-1, -1].
 * 
 * Example 1:
 * 
 * Input: nums = [5,7,7,8,8,10], target = 8 Output: [3,4] Example 2:
 * 
 * Input: nums = [5,7,7,8,8,10], target = 6 Output: [-1,-1]
 */
public class LC34 {

  public static void main(String[] args) {
    LC34 lc34 = new LC34();
    int[] nums1 = {5, 7, 7, 8, 8, 10};
    int target1 = 8;
    int[] result1 = lc34.searchRange(nums1, target1);
    printOutput(result1);



    int[] nums2 = {5, 7, 7, 8, 8, 10};
    int target2 = 6;
    int[] result2 = lc34.searchRange(nums2, target2);
    printOutput(result2);


  }

  private static void printOutput(int[] result2) {
    StringJoiner joiner = new StringJoiner(", ", "[", "]");
    for (Integer i : result2) {
      joiner.add(i.toString());
    }
    System.out.println(joiner.toString());
  }

  int[] searchRange(int[] nums, int target) {


    int[] result = new int[2];
    result[0] = -1;
    result[1] = -1;
    if (nums == null || nums.length == 0)
      return result;
    result[0] = firstIndex(nums, target);
    result[1] = endIndex(nums, target);
    return result;

  }

  int firstIndex(int[] nums, int target) {
    int s = 0;
    int e = nums.length - 1;
    int result = -1;
    // Loop will result in s and e positions based on condition
    while (s + 1 < e) {
      int m = s + (e - s) / 2;

      if (target == nums[m]) {
        /*
         * Think of moving from right as we want to disqualify every matching value as end index. So
         * keep assigning matching target to e as we want to omit qualifying right half and make last
         * qualifying  index as the start index
         */
        e = m;
      } else if (target > nums[m]) {
        // if target is still greater ,then assign not matching index as start index s
        s = m;
      } else {//target < nums[m]
        // if target is still less, then assign not matching index as end index e
        e = m;
      }

    }
    if (target == nums[e]) {
      result = e;
    }
    /*
     * if value at start index s i.e nums[s] is also target,overwrite result so that we find correct
     * start Index
     */
    if (target == nums[s]) {
      result = s;
    }

    return result;
  }

  int endIndex(int[] nums, int target) {
    int s = 0;
    int e = nums.length - 1;
    int result = -1;
    while (s + 1 < e) {
      int m = s + (e - s) / 2;
      if (target == nums[m]) {
        /*
         * Think of moving from left as we want to disqualify every matching value as start index. So
         * keep assigning matching target to s as we want to omit qualifying left half and make last
         * qualifying  index as the end index
         */
        s = m;
      } else if (target > nums[m]) {
        // if target is still greater ,then assign unmatching index as start index s
        s = m;
      } else {
        // if target is still less, then assign unmatching index as end index e
        e = m;
      }

    }

    if (target == nums[s]) {
      result = s;
    }
    if (target == nums[e]) {
      result = e;
    }

    return result;
  }

}
