package org.vivek.myinterview.arrays.problems;

import java.util.ArrayList;
import java.util.List;

public class FindMountain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 2,1,4,7,3,2,5 };
		// Traverse all even elements
		int k = arr.length - 1;
		
		boolean flag= isMountain(arr, k);

	}

	private static boolean isMountain(int[] arr, int k) {
		boolean isMountain= false;
		int leftPeak=0,rightPeak=0;
		int leftPeakCounter =0;
		int rightPeakCounter =0;
		for (int i = 0; i < arr.length; i++) {
			// If next element is larger
			
			leftPeak = getLeftPeak(arr, leftPeak, i,leftPeakCounter);
			rightPeak = getRightPeak(arr, k, rightPeak,rightPeakCounter);
			if(leftPeak==rightPeak&& leftPeak>0 && rightPeak>0) {
				isMountain=  true;
				int mountainValue= leftPeakCounter+rightPeakCounter+1;
			    break;
			}
			k--;
		}
		return isMountain;
	}

	private static int getRightPeak(int[] arr, int k, int rightPeak, int rightPeakCounter) {
		if ((k - 2) > 0) {
			
			if (arr[k - 1] > arr[k]) {
				int currenthigh = k-1;
				int nextHiger = k-2;
				 int p2= findPeak(arr,nextHiger,currenthigh);
				 rightPeakCounter=rightPeakCounter+2;
				 if(p2>rightPeak) {
						rightPeak=p2;
						
					}
				
			}
		}
		return rightPeak;
	}

	private static int getLeftPeak(int[] arr, int leftPeak, int i, int leftPeakCounter) {
		if ((i + 2) < arr.length) {
			
			if (arr[i + 1] > arr[i]) {
				
				int currenthigh = (i+1);
				int nextHiger = (i+2);
				int p1= findPeak(arr,nextHiger,currenthigh);
				leftPeakCounter = leftPeakCounter+2;
				if(p1>leftPeak) {
					leftPeak=p1;
					
				}
			}
		}
		return leftPeak;
	}

	private static  int  findPeak(int[] arr,int nextHigher,int currenthigh) {
		int peak =0;      
		if(arr[nextHigher]>arr[currenthigh]) {
			 peak= arr[nextHigher];
		}else {
			 peak= arr[currenthigh];
		}
		    	   return peak;
			

		
		
	}

}
