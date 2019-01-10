package com.interview.array;

public class PrintDiagonal {

	public PrintDiagonal() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  String str = "agbdba";
		  int[][] T = initializeArray(str);
		  int rows = T.length;
		  int cols = T[0].length; 
	       print2DArray(T);
	       print2DArrayValues(T);
	       
	       printDR( T,  rows, cols);
	}

	private static int[][] initializeArray(String str) {
		char[] charArray = str.toCharArray();
		  int T[][] = new int[charArray.length][charArray.length];
		
	        for(int i=0; i < charArray.length; i++){
	            T[i][i] = 1;
	        }
		return T;
	}
	
	 public static void printDR(int[][] T, int rows, int cols){
		 
		
		/* for(int i=rows-1; i>=0; i--){
		        int tmpRow = i;
		        int tmpCol= 0;
		        while(tmpRow<rows){
		        	 System.out.print("T["+tmpRow+"]["+tmpCol+"]" +" ");
		            tmpCol++;
		            tmpRow++;
		        }
		    }*/
		    for(int i=1; i<cols; i++){
		        int tmpCol = i;
		        int tmpRow = 0;
		        while(tmpCol<cols){
		        	 System.out.print("T["+tmpRow+"]["+tmpCol+"]" +" ");
		            tmpCol++;
		            tmpRow++;
		        }
		    }

		 
		/* for(int c=0; c < cols; c++){
	            for(int i=0, j=c; i< rows && j>=0;i++,j--){
	                System.out.print(T[i][j] +" ");
	             }
	             System.out.println();
	        }

	        for(int r =1; r < rows; r++){
	            for(int i =r, j= cols -1; i<rows && j>=0; i++,j--){
	                System.out.print(T[i][j] + " ");
	            }
	            System.out.println();
	        }*/
	 }
	
	private static void print2DArray( int[][] array) {
		int dim = array.length;
		for( int i = 0 ; i < dim ; i++ ) {
		    for( int j = 0 ; j < dim ; j++ ) {
		        System.out.print("array["+i+"]["+j+"]" + " " );
		    }
		    System.out.println();
		}
		System.out.println( "============================" );
	}
	
	private static void print2DArrayValues( int[][] array) {
		int dim = array.length;
		for( int i = 0 ; i < dim ; i++ ) {
		    for( int j = 0 ; j < dim ; j++ ) {
		        System.out.print(array[i][j] + " " );
		    }
		    System.out.println();
		}
		System.out.println( "============================" );
	}

}
