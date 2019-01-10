package org.vivek.myinterview.arrays.general.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class RemoveDuplicatesUnorderedArray {

	public RemoveDuplicatesUnorderedArray() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int[] a = new int[] { 4, 6, 8, 8, 9 };
		printArray(a);
		int[] filteredArray = removeDuplicates(a);
		printArray(filteredArray);
		List<Integer> inputList  = Arrays.stream( a ).boxed().collect( Collectors.toList() );
		System.out.println("***removeDuplicatesUsingSet****");
		List<Integer> l = removeDuplicatesUsingSet(inputList);
		l.forEach(item->System.out.print(item+","));
	}

	static int[] removeDuplicates(int[] a) {
		int newLength = a.length;
		// find length w/o duplicates:
		for (int i = 1; i < a.length; i++) {
			for (int j = 0; j < i; j++) {
				if (a[i] == a[j]) { // if duplicate founded then decrease length by 1
					newLength--;
					break;
				}
			}
		}

		int[] newArray = new int[newLength]; // create new array with new length
		newArray[0] = a[0]; // 1st element goes to new array
		int inx = 1; // index for 2nd element of new array
		boolean isDuplicate;
        //loop over old array again 
		for (int i = 1; i < a.length; i++) {
			isDuplicate = false;
			for (int j = 0; j < i; j++) {
				if (a[i] == a[j]) { // if duplicate founded then change boolean variable and break
					isDuplicate = true;
					break;
				}
			}
			if (!isDuplicate) { // if it's not duplicate then put it to new array
				newArray[inx] = a[i];
				inx++;
			}
		}
		return newArray;
	}

	static List<Integer> removeDuplicatesUsingSet(List<Integer> list) {
		Set<Integer> tempSet = new HashSet<Integer>();
		List<Integer> distinctList = new ArrayList<Integer>();
		for (Integer i : list) {
			if (tempSet.add(i)) {//filter by set
				distinctList.add(i);
			}
		}
		return distinctList;
	}

	public static void printArray(int[] a) {
		System.out.println("*******");
		for (int i : a) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
