package org.vivek.myinterview.strings.problems.common.anagrams;

public class MakeAnagrams {

	public static void main(String[] args) {
		/*String s1 = "cde";
		String s2 = "abc";
		int deleteCountRequired= makingAnagrams(s1, s2);
		System.out.println("deleteCountRequired= "+deleteCountRequired);*/
		String s1="cdecc";
		String s2="xyxaecaa";
		 int deleteCountRequired= makingAnagrams(s1, s2);//anagram should me made of'c' ,'e',delete 3 from s1 & 6 from s2.total=9
		System.out.println("deleteCountRequired= "+deleteCountRequired);

	}
	
	 static int makingAnagrams(String s1, String s2) {
	        int cArr[]=new int[26];
	        for(int i=0;i<s1.length();i++){
	        	s1 = s1.toLowerCase();
	            cArr[s1.charAt(i)-'a']++;//by calculating distance from 'a' we are assuming characters are letters & this also allows to have space of 26
	        }
	        for(int i=0;i<s2.length();i++){
	        	s2 = s2.toLowerCase();
	            cArr[s2.charAt(i)-'a']--;//decrement,if count in previous lop is 1,it will be 0 now 
	            //idea is to make anything any other character with count!=0  qualified to be deleted( if their count >0 or <0)
	        }
	         int count=0;
	         for(int i=0;i<26;i++){
	             count+=Math.abs(cArr[i]);
	         }
	        System.out.println(count);
	        return count;
	    }

}
