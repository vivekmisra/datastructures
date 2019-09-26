/**
 * 
 */
package org.vivek.myinterview.arrays.binarysearch.core.template3.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringJoiner;

/**
 * @author Vivek
 *
 */
/*
 * 
 * 658. Find K Closest Elements https://leetcode.com/problems/find-k-closest-elements/
 * 
 * Medium
 * 
 * 804
 * 
 * 168
 * 
 * Favorite
 * 
 * Share Given a sorted array, two integers k and x, find the k closest elements to x in the array.
 * The result should also be sorted in ascending order. If there is a tie, the smaller elements are
 * always preferred.
 * 
 * Example 1: Input: [1,2,3,4,5], k=4, x=3 Output: [1,2,3,4] Example 2: Input: [1,2,3,4,5], k=4,
 * x=-1 Output: [1,2,3,4] Note: The value k is positive and will always be smaller than the length
 * of the sorted array. Length of the given array is positive and will not exceed 104 Absolute value
 * of elements in the array and x will not exceed 104 658. Find K Closest Elements Medium
 * 
 * 804
 * 
 * 168
 * 
 * Favorite
 * 
 * Share Given a sorted array, two integers k and x, find the k closest elements to x in the array.
 * The result should also be sorted in ascending order. If there is a tie, the smaller elements are
 * always preferred.
 * 
 * Example 1: Input: [1,2,3,4,5], k=4, x=3 Output: [1,2,3,4] Example 2: Input: [1,2,3,4,5], k=4,
 * x=-1 Output: [1,2,3,4] Input: [-3,-2,0,1,2,3,4,5], k=4, x=-1 Output: [-3, -2, 0, 1] Note: The
 * value k is positive and will always be smaller than the length of the sorted array. Length of the
 * given array is positive and will not exceed 104 Absolute value of elements in the array and x
 * will not exceed 104
 */
public class LC658 {

  /**
   * @param args
   */
  public static void main(String[] args) {
    LC658 lc658 = new LC658();
    int[] nums1 = {1, 2, 3, 4, 5};
    int k = 4;
    int x = 3;
    List<Integer> result1 = lc658.findCloseskElementsUsingMinHeap(nums1, k, x);
    printOutput(result1);
    int[] nums2 = {1, 2, 3, 4, 5};
    k = 4;
    x = -1;
    List<Integer> result2 = lc658.findCloseskElementsUsingMinHeap(nums2, k, x);
    printOutput(result2);
    int[] nums3 = {-3, -2, 0, 1, 2, 3, 4, 5};
    List<Integer> result3 = lc658.findCloseskElementsUsingMinHeap(nums3, k, x);
    printOutput(result3);
    result3 = lc658.findClosestKElementsUingBinarySearch(nums3, k, x);
    printOutput(result3);

  }

  public List<Integer> findClosestKElementsUingBinarySearch(int[] nums, int k, int target) {
    List<Integer> res = new ArrayList<>();
    if (k < 1) {
      return res;
    }
    int n = nums.length;
    int s = 0;
    int e = n - 1;
    int m;
    while (s + 1 < e) {
      m = s + (e - s) / 2;
      if (target == nums[m]) {
        /*
         * Think of moving from left as we want to disqualify every matching value as start index. So
         * keep assigning matching target to s as we want to omit qualifying left half and make last
         * qualifying  index as the end index
         */
        s = m;
      } else if (target > nums[m]) {
        s = m;
      } else {
        e = m;
      }
    }
    int dsm = Math.abs(nums[s] - target);
    int dme = Math.abs(nums[e] - target);
    if (dsm <= dme) {
      m = s;
    } else {
      m = e;
    }
    s = m - 1;
    e = m + 1;
    res.add(nums[m]);
    --k;
    while (k > 0) {
      if (e >= n || s >= 0 && e < n && dsm <= dme) {
        res.add(nums[s--]);
      } else {
        res.add(nums[e++]);
      }
      --k;
    }
    Collections.sort(res);
    return res;
  }

  public List<Integer> findCloseskElementsUsingMinHeap(int[] arr, int k, int x) {
    PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
      @Override
      public int compare(Integer b, Integer a) {
        return Math.abs(a - x) == Math.abs(b - x) ? a - b : Math.abs(a - x) - Math.abs(b - x);
      }
    });
    for (int num : arr) {
      pq.add(num);
      if (pq.size() > k)
        pq.poll();
    }
    List<Integer> res = new ArrayList<>(pq);
    Collections.sort(res);
    return res;
  }

  private static void printOutput(List<Integer> result) {
    StringJoiner joiner = new StringJoiner(", ", "[", "]");
    for (Integer i : result) {
      joiner.add(i.toString());
    }
    System.out.println(joiner.toString());
  }

}
