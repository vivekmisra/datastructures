/**
 * 
 */
package org.vivek.myinterview.arrays.sorting.problems;

/**
 * @author Vivek
 *
 */
/*
 * 912. Sort an Array Medium
 * 
 * 151
 * 
 * 132
 * 
 * Favorite
 * 
 * Share Given an array of integers nums, sort the array in ascending order.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: [5,2,3,1] Output: [1,2,3,5] Example 2:
 * 
 * Input: [5,1,1,2,0,0] Output: [0,0,1,1,2,5]
 * 
 * 
 * Note:
 * 
 * 1 <= A.length <= 10000 -50000 <= A[i] <= 50000
 */
public class LC912 {

  /**
   * @param args
   */
  public static void main(String[] args) {
    LC912 lc912 = new LC912();
    int [] nums = {5,2,3,1};
    nums =lc912.sortArray(nums);
    printArray(nums);

  }
  private static String printArray(int[] anArray) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < anArray.length; i++) {
        if (i > 0) {
            sb.append(", ");
        }
        sb.append(anArray[i]);
    }
    System.out.println(sb.toString());
    return sb.toString();
}

  public int[] sortArray(int[] nums) {
    if (nums == null) {
      return null;
    }
    int numsLength = nums.length;
    int mid = numsLength / 2;
    if (numsLength < 2) {
      return nums;
    }
    int[] left = new int[mid];
    int[] right = new int[numsLength - mid];
    // populate left
    for (int l = 0; l < mid; l++) {
      left[l] = nums[l];
    }
    // populate right
    // right array index starts from mid
    for (int i = mid; i < numsLength; i++) {
      right[i - mid] = nums[i];
    }
    // sort left
    sortArray(left);
    // sort right
    sortArray(right);
    merge(nums, left, right);
    return nums;

  }

  void merge(int[] nums, int[] left, int[] right) {
    int numsLength = nums.length;
    int leftLength = left.length;
    int rightLength = right.length;
    int i = 0, j = 0, k = 0;
    while (i < leftLength && j < rightLength) {
      if (left[i] <= right[j]) {
        nums[k++] = left[i++];
      } else {
        nums[k++] = right[j++];
      }
    }
    while (i < leftLength) {
      nums[k++] = left[i++];
    }

    while (j < rightLength) {
      nums[k++] = right[j++];
    }
  }

}
