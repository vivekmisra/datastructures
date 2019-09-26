package org.vivek.myinterview.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PasCalTriangle {

	public static void main(String[] args) {
		PasCalTriangle t = new PasCalTriangle();
        t.generate(3);
	}
	
	 public List<List<Integer>> generate(int numRows) {
	        List<List<Integer>> list = new ArrayList<>();
	        generate(list, numRows);
	        return list;
	        
	    }
	    
	    public void generate(List<List<Integer>> list, int numRows) {
	        if (numRows == 1) list.add(Arrays.asList(1));
	        else if (numRows > 1) {
	            generate(list, numRows -1);
	            List<Integer> previousList = list.get(numRows -2);
	            List<Integer> thisList = new ArrayList<>();
	            for (int i = 0; i < previousList.size(); i++) {
	                if (i == 0) thisList.add(1);
	                if (i > 0) thisList.add(previousList.get(i) + previousList.get(i-1));
	                if (i == previousList.size() -1) thisList.add(1);
	            }
	            list.add(thisList);
	        }
	    }
}
