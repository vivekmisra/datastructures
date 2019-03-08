package org.vivek.myinterview.arrays.multidim;

public class PatternSearcher{
	
	public static void main(String[] args) {
		int[][] matrix = new int[][]{
			{7,2,8,3,4,5,5,8,6,4},
			{6,7,3,1,1,5,8,6,1,9},
			{8,9,8,8,2,4,2,6,4,3},
			{3,8,3,9,5,0,5,3,2,4},
			{9,5,0,9,5,0,5,8,1,3},
			{3,8,4,3,8,4,5,3,8,4},
			{6,4,7,3,5,3,0,2,9,3},
			{7,0,5,3,1,0,6,6,0,1},
			{0,8,3,4,2,8,2,9,5,6},
			{4,6,0,7,9,2,4,1,3,7}
			};

		int[][] patterns = new int[][] { 
			{ 9, 5, 0 }, 
			{ 3, 8, 4 }, 
			{ 3, 5, 3 } };
		
		System.out.println(count(matrix, patterns));
		
	}

	public static int count(int[][] matrix, int[][] patterns) {
		int result = 0;
		for (int r = 0; r < matrix.length; r++)
			for (int c = 0; c < matrix[r].length; c++)
				for (int[] p : patterns)
					if (matrix[r][c] == p[0])
						result += localCount(matrix, r, c, p);
				

		return result;
	}

	private static boolean isValid(int[][] matrix, int r, int c) {
		return r >= 0 && c >= 0 && r < matrix.length && c < matrix[0].length;
	}

	private static int localCount(int[][] matrix, int r, int c, int[] pattern) {

		Boolean[] UDLR = new Boolean[] { true, true, true, true };
		
		for (int i = 0; i < pattern.length; i++) {
			UDLR[0] &= isValid(matrix, r - i, c) 
						&& matrix[r - i][c] == pattern[i];
			UDLR[1] &= isValid(matrix, r + i, c) 
						&& matrix[r + i][c] == pattern[i];
			UDLR[2] &= isValid(matrix, r, c - i) 
						&& matrix[r][c - i] == pattern[i];
			UDLR[3] &= isValid(matrix, r, c + i) 
						&& matrix[r][c + i] == pattern[i];
		}
		
		int counter = 0;
		for (int i = 0; i < 4; i++)
			if (UDLR[i])
				counter++;

		return counter;

	}
	

}