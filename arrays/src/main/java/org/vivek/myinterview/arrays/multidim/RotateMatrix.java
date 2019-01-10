package org.vivek.myinterview.arrays.multidim;

import java.util.Arrays;

public class RotateMatrix {

	public RotateMatrix() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		System.out.println(Arrays.deepToString(fillMatrix( 4)));
		int[][] a= rotateMatrix(fillMatrix( 4), 4);
		System.out.println(Arrays.deepToString(a));

	}
	public static int[][]  rotateMatrix(int[][] matrix, int n){

	      /* Temporary variable used to swap  */
	      int temp;

	      /* Number of rings */
	      for (int i = 0; i  <  n/2; i++){
	        /* Rotation of each ring */
	        for (int j = i; j  <  n-i-1; j++){

	                /* Save the temp */
	                temp=matrix[i][j];

	                /* Swap corner element leftward */
	                matrix[i][j]=matrix[j][n-i-1];

	                /* Swap corner element upward */
	                matrix[j][n-i-1]=matrix[n-i-1][n-j-1];

	                /* Swap corner element rightward */
	                matrix[n-i-1][n-j-1]=matrix[n-j-1][i];

	                /* Place the temp */
	                matrix[n-j-1][i]=temp;
	        }
	      }
        return matrix;
	}
	
	private static int[][] fillMatrix(int n) {
		int[][] arr = new int[4][4];
		arr[0][0] = 1;
		arr[0][1] = 2;
		arr[0][2] = 3;
		arr[0][3] = 4;

		arr[1][0] = 5;
		arr[1][1] = 6;
		arr[1][2] = 7;
		arr[1][3] = 8;

		arr[2][0] = 9;
		arr[2][1] = 10;
		arr[2][2] = 11;
		arr[2][3] = 12;

		arr[3][0] = 13;
		arr[3][1] = 14;
		arr[3][2] = 15;
		arr[3][3] = 16;
		return arr;
	}

}
