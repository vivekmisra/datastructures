package org.vivek.myinterview.strings.problems.common.anagrams;

import java.util.Arrays;

public class AnagramsFromAString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       String s = "aaabbb";
       int k = anagram( s);
       System.out.println("k="+k);
	}
	
	 // Complete the anagram function below.
    static int anagram(String s) {
         if((s == null) ||s.isEmpty()){
                return -1;
            }
            if(s.length()==1){
                return 1;
            }
           if (s.length()%2 !=0){
               return -1;
           }else{
               int sLength = s.length();
               String s1 = s.substring(0,sLength/2);
               String s2 = s.substring(sLength/2 );
               char[] charArray1 = s1.toCharArray();
               char[] charArray2 = s2.toCharArray();
               Arrays.sort(charArray1);
               Arrays.sort(charArray2);
               if (Arrays.equals(charArray1,charArray2)){
                   return 0;
               }else{
                 return makingAnagrams(s1,s2);
               }
           }


    }
    
    static int anagram2(String s){
    	 int len = s.length(), count = 0;
         if (len%2!=0){
             System.out.println(-1);
            return -1;
         }
         String s1 = s.substring(0,len/2);
         String s2 = s.substring(len/2,len);
         char[] s1Chars = s1.toCharArray();
         for (char c : s1Chars){
             int index = s2.indexOf(c);//find c in s2
             if (index == -1){//not there
                 count++;
             } else {
                 s2 = s2.substring(0,index)+s2.substring(index+1);
             }
         }
         System.out.println(count);
         return count;
     
    }
    
    static int makingAnagrams(String s1, String s2) {
     
        int count =0;
        char[] s1Chars = s1.toCharArray();
        for (char c : s1Chars){
            int index = s2.indexOf(c);
            if (index == -1){
                count++;
            } else {
                s2 = s2.substring(0,index)+s2.substring(index+1);
            }
        }
        return count;
    }

}
