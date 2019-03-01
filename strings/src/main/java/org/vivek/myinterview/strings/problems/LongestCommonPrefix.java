package org.vivek.myinterview.strings.problems;

public class LongestCommonPrefix {

	public LongestCommonPrefix() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		String[] strs = {"leets","leetcode","leet","leeds"};
		LongestCommonPrefix lcp = new LongestCommonPrefix();
		String s =lcp.longestCommonPrefix2(strs);
		System.out.println(s);
	}
	
	
	 public String longestCommonPrefix1(String[] strs) {
		    if (strs.length == 0) return "";
		    String prefix = strs[0];
		    for (int i = 1; i < strs.length; i++)
		        while (strs[i].indexOf(prefix) != 0) {
		            prefix = prefix.substring(0, prefix.length() - 1);
		            if (prefix.isEmpty()) return "";
		        }        
		    return prefix;
		}
	public String longestCommonPrefix2(String[] strs) {
	    if (strs == null || strs.length == 0) return "";
	    for (int i = 0; i < strs[0].length() ; i++){
	        char c = strs[0].charAt(i);
	        for (int j = 1; j < strs.length; j ++) {
	            if (i == strs[j].length() || strs[j].charAt(i) != c)
	                return strs[0].substring(0, i);             
	        }
	    }
	    return strs[0];
	}
	
	public String longestCommonPrefix3(String[] strs) {
	    if(strs==null || strs.length==0){
	        return "";
	    }
	    if(strs.length==1) 
	        return strs[0];
	    int minLen = strs.length+1;
	    for(String str: strs){
	        if(minLen > str.length()){
	            minLen = str.length();
	        }
	    }
	    for(int i=0; i<minLen; i++){
	        for(int j=0; j<strs.length-1; j++){
	            String s1 = strs[j];
	            String s2 = strs[j+1];
	            if(s1.charAt(i)!=s2.charAt(i)){
	                return s1.substring(0, i);
	            }
	        }
	    }
	    return strs[0].substring(0, minLen);
	}

}
