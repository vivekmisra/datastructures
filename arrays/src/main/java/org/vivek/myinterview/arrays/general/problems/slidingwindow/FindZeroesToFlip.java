package org.vivek.myinterview.arrays.general.problems.slidingwindow;

public class FindZeroesToFlip {

	 
	public static void main(String[] args) {
		int arr[] = new int[]{1, 0, 0, 1, 1, 0, 1, 0, 1, 1}; 
		 findZeroes(arr,2);
	}


	
	
	// m is maximum of number zeroes allowed to flip 
	static void findZeroes(int []arr,int m) 
	{ 
		// Left and right indexes of current window 
		int wL = 0, wR = 0; 
	
		// Left index and size of the widest window 
		int bestL = 0, bestWindow = 0; 
	
		// Count of zeroes in current window 
		int zeroCount = 0; 
	
		// While right boundary of current window doesn't cross 
		// right end 
		while (wR < arr.length) 
		{ 
			// If zero count of current window is less than m, 
			// widen the window toward right 
			if (zeroCount <= m) 
			{ 
				if (arr[wR] == 0) 
				zeroCount++; 
				wR++; 
			} 
	
			// If zero count of current window is more than m, 
			// reduce the window from left 
			if (zeroCount > m) 
			{ 
				if (arr[wL] == 0) 
				zeroCount--; 
				wL++; 
			} 
	
			// Update widest window if this window size is more 
			if ((wR-wL > bestWindow) && (zeroCount<=m)) 
			{ 
				bestWindow = wR-wL; 
				bestL = wL; 
			} 
		} 
	
		// Print positions of zeroes in the widest window 
		for (int i=0; i<bestWindow; i++) 
		{ 
			if (arr[bestL+i] == 0) 
			System.out.print(bestL+i + " "); 
		} 
	} 
	
} 
