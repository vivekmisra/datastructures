package org.vivek.myinterview.arrays.binarysearch.problems;

/**
 *
 * https://leetcode.com/problems/sqrtx/
 */
public class SquareRootOfNumber {
    public static int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
       //============IMPORTANT:start=================
       
  /*
   * we need to find largest number num scuh that its square <x
   * therefore our range search is (1,x)
   */
        int left = 1, right = x;
      //============IMPORTANT:end=================
        while (true) {
            int mid = left + (right - left)/2;
            System.out.println("boundary range-->[left="+left+",right="+ right+"]");
            System.out.println("mid="+mid +" and midsq ="+ (mid*mid));
            if (mid>x/mid) {//mid*mid >x but we want to find mid*mid<x
            	System.out.println(" midsq ="+ (mid*mid)+" is greater than "+ x);
            	System.out.println(" re-setting right boundary="+ (mid-1));
                right = mid - 1;
            } else {
            	System.out.println("  in else mid="+mid);
            	System.out.println("   mid+1sq ="+ (mid+1*(mid+1)));
                if (mid + 1 > x/(mid + 1)) {
                	System.out.println(" (mid+1)sq ="+ ((mid+1)*(mid+1))+" is greater than "+ x);
                    return mid;
                }
                left = mid + 1;
            }
        }
    }
    static int sqrtByNewton(int x) {
    	/*
    	we need to find largest number scuh that its square <x
    	
    	*/
    	long r =x;
    	while(r*r > x) {
    		r = (r+x/r)/2;
    	}
    	return (int)r;
    	
    }
    public static void main (String[] args){
    	System.out.println(mySqrt(16));
    	System.out.println(sqrtByNewton(17));
    }
}
