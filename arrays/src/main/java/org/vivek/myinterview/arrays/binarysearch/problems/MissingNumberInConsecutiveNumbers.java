package org.vivek.myinterview.arrays.binarysearch.problems;

/**
 * Find missing number in consecutive numbers.
 */
public class MissingNumberInConsecutiveNumbers {

    public Integer findMissing(int arr[]){
    
        int lowNum = arr[0];
        int low = 0;
        int high = arr.length -1;
        int middle = (low + high)/2;
        while(low <= high){
            middle = (low + high)/2;
            if(arr[middle] == (middle+1 + lowNum) && middle-1 >=0 && arr[middle-1] == (middle + lowNum-1)){
                return middle + lowNum;
            }
            else if((middle + lowNum) == arr[middle]){
                low = middle+1;
            }else {
                high = middle-1;
            }
        }
        return null;
    }
    
    public static void main(String args[]){
        int arr[] = {3,4,5,6,7,8,9,10,11,12};
        int arr1[] = {-6,-4,-3,-2,-1,0,1,2,3};
        MissingNumberInConsecutiveNumbers mn = new MissingNumberInConsecutiveNumbers();
        System.out.println(mn.findMissing(arr1));
    }
}
