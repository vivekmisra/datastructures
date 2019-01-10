package org.vivek.myinterview.strings.problems;

import java.util.ArrayList;
import java.util.List;

public class StringPermutationByRotation {

    private static void swap(char arr[],int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] =temp;
    }
    
    private static void printArray(char str[]){
        for(int i=0; i< str.length; i++){
            System.out.print(str[i]);
        }
        System.out.print("\n");
    }
    
    public static List<char[]>  generatePermutations(String str) {
		List<char[]> results = new ArrayList<char[]>();
        permute(str.toCharArray(),0,results);
        return results;
	}
    
    private static void permute(char[] str,int pos,List<char[]>results){
        if(pos >= str.length){
        	results.add(str.clone());
        }
        for(int i=pos; i < str.length; i++){
            swap(str,pos,i);
            permute(str,pos+1,results);
            swap(str,pos,i);
        }
    }
  
    public static void main(String args[]){
        String str = "123";
        List<char[]>  results= generatePermutations(str);
        for(char[] result: results) {
        	printArray(result);
        }
        
    }
}


