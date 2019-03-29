package org.vivek.myinterview.arrays.general.problems.permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayPermutationRotation {

    public static void main(String args[]){
       int[] arr = new int[] { 1,2,3};
       /* List<int[]> results= generatePermutations(arr);
        for(int[] result: results) {
        	printArray(result);
        }*/
        System.out.println("**************************");
        List<List<Integer>> resultLst=  permute(arr);
        for(List<Integer> result:  resultLst) {
        	System.out.println(result);
        }
    }
  
	private static List<int[]>  generatePermutations(int[] arr) {
		List<int[]> results = new ArrayList<int[]>();
        permute(arr,0,results);
        return results;
	}
	public  static void  permute(int[] arr,int pos, List<int[]> results){
        if(pos == arr.length){
           // printArray(str);
           results.add(arr.clone());
        }
        for(int i=pos; i < arr.length; i++){
            swap(arr,pos,i);
            permute(arr,pos+1,results);
            swap(arr,pos,i);
        }
    }
	private static void swap(int arr[],int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] =temp;
    }
	private static void printArray(int arr[]){
        for(int i=0; i< arr.length; i++){
            System.out.print(arr[i]);
        }
        System.out.print("\n");
    }
	
	public static List<List<Integer>> permute(int[] arr) {
		List<List<Integer>> list = new ArrayList<>();
		permuteHelper(list, new ArrayList<>(), arr);
		return list;
	}
 
	private static void permuteHelper(List<List<Integer>> list, List<Integer> resultList, int [] arr){
 
		// Base case
		if(resultList.size() == arr.length){
			list.add(new ArrayList<>(resultList));
		} 
		else{
			for(int i = 0; i < arr.length; i++){ 
 
				if(resultList.contains(arr[i])) 
				{
					// If element already exists in the list then skip
					continue; 
				}
				// Choose element
				resultList.add(arr[i]);
				// Explore
				permuteHelper(list, resultList, arr);
				// Unchoose element
				resultList.remove(resultList.size() - 1);
			}
		}
	} 
}
