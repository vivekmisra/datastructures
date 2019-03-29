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
        int low = 0;
        int high = nums.length - 1;
        int middle = 0;
        int midLeft = Integer.MIN_VALUE;
        int midRight = Integer.MIN_VALUE;
        while (low <= high) {
            middle = low+(high-low)/2;
           
            if (middle > 0) {
                midLeft = nums[middle - 1];
            }
           
            if (middle < nums.length - 1) {
                midRight = nums[middle + 1];
            }
            if (midLeft <nums[middle] && nums[middle] > midRight) {
                return middle;
            } else if (midLeft > midRight) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return middle;
    }
    

    public static void main(String args[]){
        int arr[] = {10,5,15,2,23,90,67};
        PeakElement pe = new PeakElement();
        System.out.println(pe.findPeakElement(arr));
        int arr1[] = {10,20,30,40,50};
        System.out.println(pe.findPeakElement(arr1));
        int arr2[] = {100,90,80,70,60};
        System.out.println(pe.findPeakElement(arr2));
        int arr3[] ={-3, 9, 8, 20, 17, 5, 1};
        System.out.println(pe.findPeakElement(arr3));
        int arr4[] ={1,2,1,3,5,6,7};
        System.out.println(pe.findPeakElement(arr4));
                
    }
}
