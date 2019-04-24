/*Copyright (c) Dec 21, 2014 CareerMonk Publications and others.
 * E-Mail           	: info@careermonk.com 
 * Creation Date    	: 2015-01-10 06:15:46 
 * Last modification	: 2006-05-31 
               by		: Narasimha Karumanchi 
 * Book Title			: Data Structures And Algorithms Made In Java
 * Warranty         	: This software is provided "as is" without any 
 * 							warranty; without even the implied warranty of 
 * 							merchantability or fitness for a particular purpose. 
 * 
 */

package org.vivek.myinterview.arrays.binarysearch.problems;


public class SearchInSorted2DMatrix {
	  public static void main(String[] args) throws Exception
	    {
	        int[][] matrix =
	                {
	                        {1,3,5,7,9} ,     //1, 3, 5, 7, 9
	                        {2,4,6,8,10},     //2, 4, 6, 8, 10
	                        {11,13,15,17,19}, //11, 15, 17, 18, 19
	                        {12,14,16,18,20}, //13, 20, 21, 22, 23
	                        {21,22,23,24,25}  //14, 25, 26, 27, 28
	                };

	        System.out.println(new SearchInSorted2DMatrix().searchMatrix1(matrix, 11));
	        System.out.println(new SearchInSorted2DMatrix().searchMatrix2(matrix, 11));
	    }
	private boolean searchMatrix1(int[][] matrix, int target)
	    {
	        if(matrix.length == 0) return false;
	        int R = matrix.length;
	        int C = matrix[0].length;
	        int r = 0, c = C - 1;
	        while(r < R && c >= 0)
	        {
	            if(matrix[r][c] == target) return true;
	            else if(target < matrix[r][c]) --c;
	            else if(target > matrix[r][c]) r++;
	        }
	        return false;
	    }
    public boolean searchMatrix2(int[][] A, int target) {
        int length = A.length;
        int width = A[0].length;
        int start = 0; 
        int end = width * length - 1;
        while(start <= end){
            int mid = (start + end) / 2;
            int x = mid / width;
            int y = mid % width;
            if(A[x][y] == target)
                return true;
            else if(A[x][y] > target)
                end = mid - 1;
            else 
                start = mid + 1;
        }
        return false;
    }
}
