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

public class BinarySearchRotatedIterative {
    public static boolean search(int[] A, int data) {
        int left = 0;
        int right = A.length - 1;
        
        while(left <= right){
        	
            // Avoid overflow
            int mid = left + (right - left) / 2;
            printArray(A,data,left,mid,right);
            if(A[mid] == data)
                return true;
            
            // the bottom half is sorted;
            if(A[left] < A[mid]){
            	System.out.print(" --> Searching data = "+ data + " where  A[left] is A["+left+"]=" + A[left] +"< A[mid] is A["+mid+"]=" + A[mid] );
                if(A[left] <= data && data < A[mid]){
                    right = mid - 1;
                    System.out.println(" -->right = mid-1 = "+ right);
                }else{
                    left = mid + 1;
                }
            }
            
            // the upper half is sorted;
            else if(A[left] > A[mid]){
            	System.out.print(" --> Searching data = "+ data + " where  A[left] is A["+left+"]=" + A[left] +"> A[mid] is A["+mid+"]=" + A[mid] );
                if(A[mid] < data && data <= A[right]){
                    left = mid + 1;
                    System.out.println(" --> left = mid+1 = "+ left);
                }else{
                    right = mid - 1;
                }
            }else{
                // skip duplicate one, A[start] == A[mid];
                left++;
            }
        }
        return false;
    }
    
    
    public static void main(String[] args){
    	// int[] A = new int[] { 2, 4, 1, 6, 8, 5, 3, 7 };
    	 int[] A = new int[] { 9, 4, 1, 6, 8, 5, 3, 7 };
    	  System.out.println(" search(A,7)="+ search(A,7));
    	//  System.out.println(" searchSimple(A,7)="+ searchSimple(A,7));
    }
    public static void printArray(int[] a,int data, int left,int mid,int right) {
    	System.out.println();
    	for (int i : a) {
			System.out.print(i + " ");
			
		}
		System.out.print(" -->data is "+ data + " and  A[left] is A["+left+"]=" + a[left] +" , A[mid] is A["+mid+"]=" + a[mid] +" ,A[right] is A["+right+"]=" + a[right]+" ");
		System.out.println();
	}
}
