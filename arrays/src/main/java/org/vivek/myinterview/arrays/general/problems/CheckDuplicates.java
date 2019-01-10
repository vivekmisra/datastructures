package org.vivek.myinterview.arrays.general.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CheckDuplicates {

	public CheckDuplicates() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int[] a = new int[] {4,6,8,8,9};
		System.out.println(bruteForceCheckDuplicates(a));
		System.out.println(checkDuplicatesUsingSet(a));
		System.out.println(checkDuplicatesUsingMap(a));
	}
	
	static boolean bruteForceCheckDuplicates(int []a) {
		for(int i = 0 ; i < a.length;i++) {
			for(int j = i+1;j<a.length;j++) {
				if(a[i]==a[j]) {
					return true;
				}
			}
		}
		return false;
	}
	
	static boolean checkDuplicatesUsingSet(int[]a) {
		Set<Integer> s = new HashSet<Integer>();
		for(int i = 0 ; i < a.length;i++) {
			if(s.add(a[i]) == false) {
				return true;
			}
		}
		return false;
	}
	
	static boolean checkDuplicatesUsingMap(int[]a) {
		Map<Integer, Integer> mapOfCOunts = new HashMap<>();
		Integer count = 0;
        // build hash table with count
        for (int e :a) {
            count = mapOfCOunts.get(e);
            if (count == null) {
            	mapOfCOunts.put(e, 1);
            } else {
            	mapOfCOunts.put(e, ++count);
            }
            
        }
      
        for (Map.Entry<Integer, Integer> entry : mapOfCOunts.entrySet()) {
           if(entry.getValue()>1) {
        	   return true;
           }
        }
        return false;
	}

}
