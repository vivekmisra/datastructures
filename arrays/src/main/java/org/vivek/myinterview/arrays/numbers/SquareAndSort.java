package org.vivek.myinterview.arrays.numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SquareAndSort {

	public static void main(String[] args) {
		 // creating Arrays of Integer type 
        Integer a[] = new Integer[] { 10, 40, 20, 40 }; 

        // getting the list view of Array 
        List<Integer> list = Arrays.asList(a); 
        List<Integer> result = squareAndSort(list);
        System.out.println("Sorted list size="+ result.size());
        for(Integer i : result) {
        	System.out.println(i);
        }
	}
	
	public static List<Integer> squareAndSort(List<Integer> l){
		
		 List<Integer> result = new ArrayList<>();
		    for (Integer i : l) {
		        System.out.println(i + "\t" + (int)Math.pow(i, 2));
		        result.add((int)Math.pow(i, 2));
		    }
		    Collections.sort(result);
		return result;
		
	}

}
