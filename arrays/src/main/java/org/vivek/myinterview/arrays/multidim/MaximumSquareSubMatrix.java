package org.vivek.myinterview.arrays.multidim;

import java.util.HashMap;
import java.util.Map;

public class MaximumSquareSubMatrix {

	public static void main(String[] args) {
		int M[][] = { { 0, 1, 1, 0, 1 }, { 1, 1, 0, 1, 0 }, { 0, 1, 1, 1, 0 }, { 1, 1, 1, 1, 0 }, { 1, 1, 1, 1, 1 },
				{ 0, 0, 0, 0, 0 } };

		printMaxSubSquare(M);

	}

	private static void printMaxSubSquare(int[][] m) {
		int rows = m.length;
		int cols = m[0].length;
		int[] counts = new int[2];// ASCII Characters counter

		int rowCounter = 0;
		int colCounter = 0;
		int consecutiveRowCounter = 0;
		int totalperrow = 0;
		Map<Integer, Integer> rowMap = new HashMap<Integer, Integer>();
		Map<Integer, Integer> colMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.print(m[i][j] + " ");
				consecutiveRowCounter=popukateRowMap(m, rowCounter, consecutiveRowCounter, rowMap, i, j);
			}
			consecutiveRowCounter = 0;
			rowCounter = 0;
			System.out.println();
		}
		rowMap.forEach((k, v) -> System.out.println("Item : " + k + " Count : " + v));
	}

	private static int  popukateRowMap(int[][] m, int rowCounter, int consecutiveRowCounter,
			Map<Integer, Integer> rowMap, int i, int j) {
		int totalperrow;
		int currValue = m[i][j];
		
		if (i > 0 && j > 0 && currValue == 1) {
			int prevValue= m[i][j-1];
			if( currValue==prevValue){
				rowCounter++;
			}
			
			totalperrow = rowCounter % currValue;
			if (totalperrow == 0) {
				consecutiveRowCounter = consecutiveRowCounter + 1;
				rowMap.put(i, consecutiveRowCounter);

			}
		}else{
			if (consecutiveRowCounter<2)
			consecutiveRowCounter = 0;
			

		}
		return consecutiveRowCounter;
	}
	private static int  popukateColMap(int[][] m, int rowCounter, int consecutiveRowCounter,
			Map<Integer, Integer> rowMap, int i, int j) {
		int totalperrow;
		int currValue = m[i][j];
		if (i > 0 && j > 0 && currValue == 1) {
			int prevValue= m[i][j-1];
			if( currValue==prevValue){
				rowCounter++;
			}
			totalperrow = rowCounter % currValue;
			if (totalperrow == 0) {
				consecutiveRowCounter = consecutiveRowCounter + 1;
				rowMap.put(i, consecutiveRowCounter);

			}
		}else{
			if (consecutiveRowCounter<2)
			consecutiveRowCounter = 0;
			

		}
		return consecutiveRowCounter;
	}
   
}
