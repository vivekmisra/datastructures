package org.vivek.myinterview.arrays.multidim.dfs;

/**
 * Date 03/10/2016
 * @author Tushar Roy
 *
 * Given a 2D matrix find longest increasing path length in this matrix.
 *
 * Time complexity is O(n*m)
 * Space complexity is O(n*m)
 *Given an integer matrix, find the length of the longest increasing path.

From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

Example 1:

Input: nums = 
[
  [9,9,4],
  [6,6,8],
  [2,1,1]
] 
Output: 4 
Explanation: The longest increasing path is [1, 2, 6, 9].
Example 2:

Input: nums = 
[
  [3,4,5],
  [3,2,6],
  [2,2,1]
] 
Output: 4 
Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
 * Reference
 * https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
 */
public class LongestIncreasingPath {

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int[][] distance = new int[matrix.length][matrix[0].length];
        int max = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int r = dfs(matrix, i, j, distance, Integer.MIN_VALUE);
                if (r > max) {
                    max = r;
                }
            }
        }
        return max;
    }

    int dfs(int[][] matrix, int i, int j, int[][] distance, int prev) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[i].length) {
            return 0;
        }

        if (matrix[i][j] <= prev) {
            return 0;
        }

        if (distance[i][j] != 0) {
            return distance[i][j];
        }

        int v1 = dfs(matrix, i - 1, j, distance, matrix[i][j]);
        int v2 = dfs(matrix, i, j - 1, distance, matrix[i][j]);
        int v3 = dfs(matrix, i + 1, j, distance, matrix[i][j]);
        int v4 = dfs(matrix, i, j + 1, distance, matrix[i][j]);
        distance[i][j] = 1 + Math.max(Math.max(v1, v2), Math.max(v3, v4));
        return distance[i][j];
    }

    public static void main(String args[]) {
        LongestIncreasingPath lip = new LongestIncreasingPath();
        int[][] input = {{9, 9, 4},{6, 6, 8},{2, 1, 1}};
        int[][] input1 = {{3, 4, 5}, {3, 2, 6}, {2, 2, 1}};
        System.out.println(lip.longestIncreasingPath(input));
    }
}
