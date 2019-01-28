package org.vivek.myinterview.arrays.multidim.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



/**
 * https://leetcode.com/problems/number-of-islands-ii/
 * A 2d grid map of m rows and n columns is initially filled with water. We may perform an addLand operation which turns the water at position (row, col) into a land. Given a list of positions to operate, count the number of islands after each addLand operation. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example:

Input: m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]]
Output: [1,1,2,3]
Explanation:

Initially, the 2d grid grid is filled with water. (Assume 0 represents water and 1 represents land).

0 0 0
0 0 0
0 0 0
Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land.

1 0 0
0 0 0   Number of islands = 1
0 0 0
Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land.

1 1 0
0 0 0   Number of islands = 1
0 0 0
Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land.

1 1 0
0 0 1   Number of islands = 2
0 0 0
Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land.

1 1 0
0 0 1   Number of islands = 3
0 1 0
 */
public class NumberOfIsland2 {

	
		  void dfs(int[][] grid, int r, int c, boolean[][] visited) {
		    int nr = grid.length;
		    int nc = grid[0].length;

		    if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0' || visited[r][c]) {
		      return;
		    }

		    visited[r][c] = true;
		    dfs(grid, r - 1, c, visited);
		    dfs(grid, r + 1, c, visited);
		    dfs(grid, r, c - 1, visited);
		    dfs(grid, r, c + 1, visited);
		  }

		  public int numIslands(int[][] grid) {
		    if (grid == null || grid.length == 0) {
		      return 0;
		    }

		    int nr = grid.length;
		    int nc = grid[0].length;
		    boolean[][] visited = new boolean[nr][nc];
		    for (boolean[] row : visited) {
		      Arrays.fill(row, false);
		    }
		    int num_islands = 0;
		    for (int r = 0; r < nr; ++r) {
		      for (int c = 0; c < nc; ++c) {
		        if (grid[r][c] == '1' && !visited[r][c]) {
		          ++num_islands;
		          dfs(grid, r, c, visited);
		        }
		      }
		    }

		    return num_islands;
		  }

		  public List<Integer> numIslands2(int m, int n, int[][] positions) {
		    List<Integer> ans = new ArrayList<>();
		    int[][] grid = new int[m][n];
		    for (int[] row : grid) {
		      Arrays.fill(row,0);
		    }
		    for (int[] pos : positions) {
		      grid[pos[0]][pos[1]] = 1;
		      ans.add(numIslands(grid));
		    }
		    return ans;
		  }
		  
		  public static void main(String args[]) {
               //[[0,0], [0,1], [1,2], [2,1]]
			  int[][] input = {{0, 1}, {1, 2}, {2, 1}, {1, 0}, {0, 2}, {0, 0}, {1, 1}};
				NumberOfIsland2 island = new NumberOfIsland2();
				List<Integer> counts = island.numIslands2(6,2,input);
				counts.forEach(item->System.out.println(item));
		
			}
		}
