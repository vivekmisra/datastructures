package org.vivek.myinterview.strings.problems;

public class Decode {

	public static void main(String[] args) {
		int decoded =numDecodings("226");
		System.out.println(decoded);

	}
	
	public static int numDecodings(String s) {
		 if (s.length() == 0) return 0;
	        
	        int pprev = 0;
	        int prev = 1;
	        int curr = 0;
	        
	        for (int i = 0; i < s.length(); i++){
	            
	            if (i > 0 && (s.charAt(i-1) == '1' || (s.charAt(i-1) == '2' && (s.charAt(i) - '0' <= 6)))){
	                if (s.charAt(i) != '0'){
	                    curr = pprev + prev;
	                } else {
	                    curr = pprev;
	                }
	            } else if (s.charAt(i) == '0'){
	                return 0;
	            } else {
	                curr = prev;
	            }
	            pprev = prev;
	            prev = curr;
	        }
	        
	        return curr;
	    }

}
