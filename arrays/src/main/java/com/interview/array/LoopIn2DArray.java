package com.interview.array;

public class LoopIn2DArray {

	public LoopIn2DArray() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "agbdba";
		   int dim = 5;
		    char ch = 'A';
		    String[][] array = new String[dim][];
		    for( int i = 0 ; i < dim ; i++ ) {
		        array[i] = new String[dim];
		        for( int j = 0 ; j < dim ; j++, ch++ ) {
		            array[i][j] = "" + ch;
		        }
		    }
		    
		    
		    
		    print2DArray(dim, ch, array);
		    System.out.println( "============================" );
		  //  bottomHalfOf2DArray(array);
		    System.out.println( "====== upperTraingleOf2DArray==========" );
		    upperTraingleOf2DArray( array);
		    int T[][] = new int[array.length][array.length];
		    System.out.println( "====== traverseDiagnonallyOf2DArray==========" );
		    traverseDiagnonallyOf2DArray(T);
		    System.out.println( "====== END traverseDiagnonallyOf2DArray==========" );
		    System.out.println( "====== upperTraingleOf2DArray2==========" );
		    upperTraingleOf2DArray2( array);
		    System.out.println( "=======lowerTraingleOf2DArray=========" );
		    lowerTraingleOf2DArray(array);
		   // bottomHalfBelowDiagonalOf2DArray(array);
		    //topHalfOf2DArray2(dim, array);
		    System.out.println( "============================" );
		  //  topHalfDiagonalOf2DArray(dim, array);
		    System.out.println( "============================" );
		    //bottomHalfOf2DArray(dim, array);

	}
	
	private static void bottomHalfOf2DArray( String[][] array) {
		int dim = array.length;
		for( int k = 0 ; k < dim ; k++ ) {
	        for( int j = 0 ; j <= k ; j++ ) {
	            int i = k - j;
	          
	         
	            System.out.print(" array["+i+"]["+j+"]" + " " );
	           
	        }
	        System.out.println();
	    }
	}
	
	private static void traverseDiagnonallyOf2DArray(int [][] array) {
		int dim = array.length;
		 for( int k = 0 ; k < dim ; k++ ) {
		        for( int j = 0 ; j <= k ; j++ ) {
		            int i = k - j;
		            System.out.print( "array["+i+"]["+j+"]" + " " );
		        }
		        System.out.println();
		    }
		 
		 System.out.print( "****************************");
		 System.out.println();
		  for( int k = dim - 2 ; k >= 0 ; k-- ) {
		        for( int j = 0 ; j <=k ; j++ ) {
		            int i = k - j;
		            System.out.print( "array["+(dim - j - 1)+"]["+(dim - i - 1)+"]" + " " );
		        }
		        System.out.println();
		    }
	}
	
	private static void upperTraingleOf2DArray(String[][] array) {
		int dim = array.length;
		for (int i = 0; i < dim; i++) {

			for (int j = 0; j < dim; j++) {

				if (i < j) {

					System.out.print(" array[" + i + "][" + j + "]"+ "  ");

				} else {

					System.out.print("              ");

				}

			}
			System.out.println("");
		}
	}
	
	
	private static void upperTraingleOf2DArray2(String[][] array) {
		int dim = array.length;
		for(int l = 2; l <= dim; l++){
            for(int i = 0; i < dim-l + 1; i++){
                int j = i + l - 1;
                if (i < j) {
            	System.out.print(" array[" + i + "][" + j + "]"+ "  ");
                }else {

					System.out.print("              ");

				}
            }
            System.out.println("");
        }
	}
	
	
	private static void lowerTraingleOf2DArray(String[][] array) {
		int dim = array.length;
		for (int i = 0; i < dim; i++) {
			for (int j = 0; j <= dim; j++) {

				if (i > j) {

					System.out.print(" array[" + i + "][" + j + "]" + " ");
				} else {

					System.out.print("           ");

				}

			}
			System.out.println("");
		}
	}
	
	
	
	
	private static void bottomHalfBelowDiagonalOf2DArray( String[][] array) {
		int dim = array.length;
		for( int k = 0 ; k < dim ; k++ ) {
	        for( int j = dim ; j <= k ; j-- ) {
	            int i = k - j-1;
	            System.out.print( array[i][j] + " " );
	        }
	        System.out.println();
	    }
	}


	private static void bottomHalfOf2DArray(int dim, String[][] array) {
		for( int k = dim - 2 ; k >= 0 ; k-- ) {
			  
		    for( int j = 0 ; j <= k ; j++ ) {
		        int i = k - j;
		      System.out.println("k="+k+",j="+j + ",i= "+i);
		        System.out.print( array[dim - j - 1][dim - i - 1] + " " );
		    }
		    System.out.println();
		   
		}
	}
	
	
	private static void topHalfOf2DArray2(int dim, String[][] str) {
		 for(int l = 1; l <= str.length; l++){
	            for(int i = 0; i < str.length-l + 1; i++){
	                int j = i + l - 1;
	                //System.out.println("l="+l+",i="+i + ".j= "+j);
	                System.out.println( str[i][j]);
	            }
	            System.out.println();
	        }
	}


	private static void topHalfDiagonalOf2DArray(int dim, String[][] array) {
		for( int k = 0 ; k < dim ; k++ ) {
		    for( int j = 0 ; j <= k ; j++ ) {
		        int i = k - j;
		        System.out.print( array[i][j] + " " );
		    }
		    System.out.println();
		}
	}

	private static void print2DArray(int dim, char ch, String[][] array) {
		for( int i = 0 ; i < dim ; i++ ) {
		    for( int j = 0 ; j < dim ; j++, ch++ ) {
		        System.out.print( array[i][j] + " " );
		    }
		    System.out.println();
		}
		System.out.println( "============================" );
	}

}
