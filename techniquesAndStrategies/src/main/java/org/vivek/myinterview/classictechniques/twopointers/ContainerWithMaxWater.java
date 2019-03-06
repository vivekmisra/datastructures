package org.vivek.myinterview.classictechniques.twopointers;

/*https://leetcode.com/problems/container-with-most-water/
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at 
 * coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line
 *  i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, 
 *  such that the container contains the most water.

Note: You may not slant the container and n is at least 2.
 * Input: [1,8,6,2,5,4,8,3,7]
Output: 49
 */
public class ContainerWithMaxWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxArea(int[] arrayOfHeights) {
		if (arrayOfHeights == null || arrayOfHeights.length < 2) {
			return 0;
		}

		int max = 0;
		int left = 0;
		int right = arrayOfHeights.length - 1;

		while (left < right) {
			
			max = Math.max(max, (right - left) * Math.min(arrayOfHeights[left], arrayOfHeights[right]));
			if (arrayOfHeights[left] < arrayOfHeights[right])
				left++;
			else
				right--;
		}

		return max;
	}

}
