package org.vivek.myinterview.arrays.multidim;

import java.util.HashMap;
import java.util.Map;

public class CountConsecutive1inMatrix {

	public static void main(String[] args) {
		int m[][] = { { 0, 1, 1, 0, 1 }, { 1, 1, 0, 1, 0 }, { 0, 1, 1, 1, 0 }, { 1, 1, 1, 1, 0 }, { 1, 1, 1, 1, 1 },
				{ 0, 0, 0, 0, 0 } };
		
		printCounsequitive1s( m) ;
	}
	

	private static void printCounsequitive1s(int[][] m) {
		int rows = m.length;
		int cols = m[0].length;
		int[] counts = new int[2];// ASCII Characters counter

		int rowCounter = 0;
		int colCounter = 0;
		int consecutiveRowCounter = 0;
		int totalperrow = 0;
		int maxConsecutiveRowCounter = 0;
		Map<Integer, Integer> rowMap = new HashMap<Integer, Integer>();
		Map<Integer, Integer> colMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.print(m[i][j] + " ");
				maxConsecutiveRowCounter = populateRowMap(m, i, j, rowMap, maxConsecutiveRowCounter);
				if (i == 0) {
					colMap = popukateColMap(m, i, j, colMap);
				}
			}
			consecutiveRowCounter = 0;
			maxConsecutiveRowCounter = 0;
			rowCounter = 0;
			System.out.println();
		}
		rowMap.forEach((k, v) -> System.out.println("rowItem : " + k + " Count : " + v));
		colMap.forEach((k, v) -> System.out.println("colItem : " + k + " Count : " + v));
	}

	private static int populateRowMap(int[][] m, int i, int j, Map<Integer, Integer> rowMap,
			int maxConsecutiveRowCounter) {
		int totalperrow;
		int currValue = m[i][j];
		int rowCounter = 0;
		// int maxConsecutiveRowCounter = 0;
		// rowMap = new HashMap<Integer, Integer>();
		if (currValue == 1) {
			rowCounter++;
			totalperrow = rowCounter % currValue;
			if (totalperrow == 0) {

				maxConsecutiveRowCounter = maxConsecutiveRowCounter + 1;
				if (rowMap.containsKey(i)) {

					int val = rowMap.get(i);
					if (val < maxConsecutiveRowCounter) {
						rowMap.put(i, maxConsecutiveRowCounter);
					} else {

						rowMap.put(i, rowMap.get(i));
					}
				} else {
					rowMap.put(i, maxConsecutiveRowCounter);
				}

			}

		} else {
			/*
			 * System.out.println("rowMap:"+ rowMap.size()); rowMap.entrySet().forEach(entry
			 * -> { System.out.println("Key : " + entry.getKey() + " Value : " +
			 * entry.getValue()); });
			 */
			if (rowMap.containsKey(i)) {

				int val = rowMap.get(i);

				if (val >= 2) {
					rowMap.put(i, val);
					maxConsecutiveRowCounter = 0;// maintain
				}

			} else {
				maxConsecutiveRowCounter = 0;// reset
				rowMap.put(i, maxConsecutiveRowCounter);
			}

		}
		return maxConsecutiveRowCounter;
	}

	private static Map<Integer, Integer> popukateColMap(int[][] m, int i, int j, Map<Integer, Integer> colMap) {
		int totalperCol;

		int rowCounter = 0;
		int cols = m[0].length;
		int rows = m.length;
		int consecutiveColCounter = 0;
		int colValue = m[j][i];
		int maxConsecutiveColCounter = 0;

		while (j < cols && i < rows) {

			colValue = m[i][j];
			if (colValue == 1) {
				rowCounter++;

				totalperCol = rowCounter % colValue;
				if (totalperCol == 0) {
					consecutiveColCounter = consecutiveColCounter + 1;
					if (consecutiveColCounter >= 2) {
						maxConsecutiveColCounter = consecutiveColCounter;
					}
					colMap.put(j, maxConsecutiveColCounter);

				} else {
					colMap.put(j, 0);
					break;
				}
				i++;

			} else {
				consecutiveColCounter = 0;
				// colMap.put(j,consecutiveColCounter);
				i++;
			}

		}
		return colMap;

	}


}
