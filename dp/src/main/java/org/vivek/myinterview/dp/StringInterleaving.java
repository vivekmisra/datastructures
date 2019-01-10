package org.vivek.myinterview.dp;

import java.util.Arrays;

public class StringInterleaving {

	public StringInterleaving() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		/* String str1 = "XXYM";
        String str2 = "XXZT";
        String str3 = "XXXZXYTM";
        */
        String str1 = "aab";
         String str2 ="axy";
         String str3 = "aaxaby";
         /*String str1 ="B";
         String str2 = "e";
         String  str3 = "Be";*/
         StringInterleaving strInter = new StringInterleaving();
        //strInter.print2dArray();
        System.out.println(strInter.isInterleaved(str1.toCharArray(), str2.toCharArray(), str3.toCharArray()));        
      

	}
	
	public void print2dArray(){
       // boolean T[][] = new boolean[str1.length +1][str2.length +1];
        int[][]T = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 }, { 17, 18, 19, 20 } };

        int totalCols = T[0].length; // Total columns 			
        int totalRows = T.length; // Total rows
    	int[] rowArr = new int[totalRows-1];
    	printMatrix(T);
        for(int i=0; i <  totalRows; i++){
        	   for(int j=0; j < T[i].length; j++){
        	 if(i == 0 && j == 0){
        		 System.out.println(" (i,j)=(0,0)==>T[i][j] =="+T[i][j] );
             }  else if(i == 0){
            	 System.out.println(" (i,j)=(0,j)==>T[i][j] =="+T[i][j] );
             } else if(j == 0){
            	 System.out.println(" (i,j)=(i,0)==>T[i][j] =="+T[i][j] );
             }
        	 rowArr[j] = T[i][j];
            }
        	  // System.out.println("Row#"+i+"="+Arrays.toString(rowArr));
        }
    
	}
	
	private void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + "   ");
			}
			System.out.println();
		}
	}
	
	
	 public boolean isInterleaved(char str1[], char str2[], char str3[]){
	        boolean T[][] = new boolean[str1.length +1][str2.length +1];
	        int totalCols = T[0].length; // Total columns 			
	        int totalRows = T.length; // Total rows
	    
	        if(str1.length + str2.length != str3.length){
	            return false;
	        }
	        int[] rowArr = new int[totalRows-1];
	        for(int i=0; i <  totalRows; i++){
	            for(int j=0; j < T[i].length; j++){
	                int l = i + j -1;
	                if(i == 0 && j == 0){
	                    T[i][j] = true;
	                    System.out.println(" (i,j)=("+i+","+j+")==>T[i][j] =="+T[i][j] );
	                }
	                else if(i == 0){	                	
	                	//first row
	                    if(str3[l] == str1[j-1]){
	                        T[i][j] = T[i][j-1];//get left cell value
	                        System.out.println(" (i,j)=("+i+","+j+")==>T[i][j] =="+T[i][j] );
	                    }
	                }
	                else if(j == 0){
	                	//first column
	                    if(str3[l]==str2[i-1]){
	                        T[i][j] = T[i-1][j];//get top cell value
	                        System.out.println(" (i,j)=("+i+","+j+")==>T[i][j] =="+T[i][j] );
	                    }
	                }
	                else{
	                	
	                	
	                   T[i][j] = (str2[i-1] == str3[l] ? T[i-1][j] : false) || (str1[j-1] == str3[l] ? T[i][j-1] : false);
	                   System.out.println(" (i,j)=("+i+","+j+")==>T[i][j] =="+T[i][j] );
	                }
	               // System.out.println("Row#"+i+"="+Arrays.toString(rowArr));
	            }
	        }
	        return T[str1.length][str2.length];
	    }

}
