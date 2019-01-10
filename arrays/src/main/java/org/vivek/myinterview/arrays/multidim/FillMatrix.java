package org.vivek.myinterview.arrays.multidim;

import java.util.Arrays;

public class FillMatrix {

	public FillMatrix() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		int[][] arr = fillMatrix();
		
		
		
		print2DArray(arr);

	}

	private static int[][] fillMatrix() {
		int[][] arr = new int[4][4];
		arr[0][0]=0;
		arr[0][1]=1;
		arr[0][2]=0;
		arr[0][3]=1;
		
		arr[1][0]=0;
		arr[1][1]=0;
		arr[1][2]=1;
		arr[1][3]=0;
		
		arr[2][0]=0;
		arr[2][1]=1;
		arr[2][2]=0;
		arr[2][3]=1;
		
		arr[3][0]=0;
		arr[3][1]=0;
		arr[3][2]=0;
		arr[3][3]=1;
		return arr;
	}
	
	private static void print2DArray(int[][] array) {
		System.out.println("----------Printing 2D array----------");
		int rows = array.length;
		int cols = array[0].length;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				//System.out.print("T[" + i + "][" + j + "]" + " ");
				System.out.print(array[i][j]+ " " );
			}
			System.out.println();
		}
		System.out.println("--------------------");
	}

}
