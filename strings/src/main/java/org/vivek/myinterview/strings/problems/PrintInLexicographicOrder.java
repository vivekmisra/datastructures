package org.vivek.myinterview.strings.problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PrintInLexicographicOrder {

	public PrintInLexicographicOrder() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		//array of strings to list
        List<String> stringList = (List) Arrays.asList( new String[]{"ABCDEF", "AA", "BEF", "A", "AABB"} );
        //put list  in set
        Set<String> stringSet = new HashSet<>( stringList );
        String s[] = stringSet.toArray( new String[stringSet.size()] );
        for (int i = 0; i < s.length; i++) {
            for (int j = i + 1; j < s.length; j++) {
                if (s[i].compareTo( s[j] ) > 0) {
                    swap(s, i, j);
                
                }
            }
        }
        System.out.println("LEXICOGRAPHIC ORDER: -> "+ Arrays.toString( s ) );
    }

	private static void swap(String[] s, int i, int j) {
		String temp = s[j];
		s[j] = s[i];
		s[i] = temp;
	}
	
	

}
