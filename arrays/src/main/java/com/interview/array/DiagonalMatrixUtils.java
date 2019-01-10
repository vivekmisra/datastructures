package com.interview.array;

import java.util.Scanner;

public class DiagonalMatrixUtils {

	public DiagonalMatrixUtils() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "agbdba";
		int[][] T = initializeArray();
		int rows = T.length;
		int cols = T[0].length;
		print2DArray(T);
		print2DArrayValues(T, rows, cols);
		int primarySum = printAndSumPrimaryDiagonal(T, rows, cols);
		int secondarySum = printAndSumSecondaryDiagonal(T, rows, cols);
		int diff = diffOfDiagonalSums(primarySum, secondarySum);
		printLowerHalf2DArray(T);
		printUpperHalf2DArray(T);

	}

	private static int diffOfDiagonalSums(int primarySum, int secondarySum) {

		int diff = Math.abs(primarySum - secondarySum);
		System.out.println("diff = " + diff);
		return diff;

	}

	private static int[][] initializeArray() {
		System.out.println("Enter the size of square matrix");

		// Scanner in = new Scanner(System.in);
		int n = 4;
		int T[][] = new int[n][n];
		for (int a_i = 0; a_i < n; a_i++) {
			for (int a_j = 0; a_j < n; a_j++) {
				T[a_i][a_j] = 4;
			}
		}
		return T;
	}

	private static void print2DArray(int[][] array) {
		System.out.println("----------Printing 2D array----------");
		int rows = array.length;
		int cols = array[0].length;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.print("T[" + i + "][" + j + "]" + " ");
				// System.out.print(array[i][j]+ " " );
			}
			System.out.println();
		}
		System.out.println("--------------------");
	}

	private static void print2DArrayValues(int[][] array, int rows, int cols) {
		System.out.println("----------Printing 2D array values----------");
		int dim = array.length;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.print(array[i][j]);
				System.out.print("\t");
			}
			System.out.println();
		}
		System.out.println("--------------------");
	}

	public static int printAndSumPrimaryDiagonal(int[][] T, int rows, int cols) {
		System.out.println("----------PrimaryDiagonal Sum where i=j----------");
		int sum = 0;
		System.out.print("PrimaryDiagonal Sum=");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j <= cols; j++) {
				if (i == j) {

					System.out.print("T[" + i + "][" + j + "]" + " ");
					if (i < rows - 1) {
						System.out.print("+");
					}
					sum = sum + T[i][j];
				}
			}
		}
		System.out.println("\n----------PrimaryDiagonal Sum =" + sum);
		return sum;
	}

	public static int printAndSumSecondaryDiagonal(int[][] T, int rows, int cols) {
		System.out.println("----------SecondaryDiagonal Sum where (i+j)==(rows-1)----------");
		int sum = 0;
		System.out.print("SecondaryDiagonal Sum=");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j <= cols; j++) {
				if (i + j == rows - 1) {
					System.out.print("T[" + i + "][" + j + "]" + " ");
					if (i < rows - 1) {
						System.out.print("+");
					}
					sum = sum + T[i][j];
				}
			}
		}
		System.out.println("\n----------SecondaryDiagonal Sum =" + sum);
		return sum;
	}

	private static void printLowerHalf2DArray(int[][] array) {
		System.out.println("----------Printing LowerHalf2DArray ----------");
		int rows = array.length;
		int cols = array[0].length;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (i == j || i > j) {

					System.out.print("T[" + i + "][" + j + "]" + " ");
				}else {
					System.out.print("*");
					System.out.print("\t");
				}
			}
			System.out.println();
		}
		System.out.println("--------------------");
	}

	private static void printUpperHalf2DArray(int[][] array) {
		System.out.println("----------Printing UpperHalf2DArray ----------");
		int rows = array.length;
		int cols = array[0].length;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {

				if (i == j || (i<j)) {

					System.out.print("T[" + i + "][" + j + "]" + " ");
				}else {
					System.out.print("*");
					System.out.print("\t");
				}
			}
			System.out.println();
		}
		System.out.println("--------------------");
	}

}
