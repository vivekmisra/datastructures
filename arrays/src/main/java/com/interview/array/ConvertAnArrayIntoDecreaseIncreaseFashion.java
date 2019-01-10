package com.interview.array;

import java.util.Arrays;


/**
 * Convert an unsorted array into an array such that
 * a < b > c < d > e < f and so on
 */
public class ConvertAnArrayIntoDecreaseIncreaseFashion {

    public void convert(Integer arr[]){
        int k = 0;
        if(arr.length % 2 ==0){
            k = arr.length/2 ;
        }else{
            k = arr.length/2+1;
        }
        KthElementInArray kthElement = new KthElementInArray();
        kthElement.kthElement(arr, k);
        
        int high = k;
        int low = 1;
        while(low < high && high < arr.length){
            swap(arr,low,high);
            high++;
            low += 2;
        }
        
    }
    
    /**
     * Sort the array first.
     * Then swap every adjacent element to get final result
     * @param arr
     */
    public void convert1(Integer arr[]){
    	 System.out.println("Before sort:"+Arrays.deepToString(arr));
        Arrays.sort(arr);
        System.out.println("After sort:"+Arrays.deepToString(arr));
        for(int i=1; i < arr.length; i+=2){
            if(i+1 < arr.length){
                swap(arr, i, i+1);
            }
        }
    }
    
    private void swap(Integer arr[],int low,int high){
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
    }
    
    public static void main(String args[]){
        ConvertAnArrayIntoDecreaseIncreaseFashion can = new ConvertAnArrayIntoDecreaseIncreaseFashion();
       Integer arr[] = {0,6,9,13,10,-1,8,2,4,14,-5};
        can.convert(arr);
        for(int i=0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        Integer arr1[] = {0,6,9,13,10,-1,8,2,4,14,-5};
        can.convert1(arr1);
        for(int i=0; i < arr1.length; i++){
            System.out.print(arr1[i] + " ");
        }
    }

}
