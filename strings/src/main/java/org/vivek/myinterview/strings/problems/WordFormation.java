package org.vivek.myinterview.strings.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class WordFormation {
	/*
	You are running a classroom and suspect that some of your students are passing around the answers to multiple choice questions disguised as random strings.

	Given a list of words and a string, find which word in the list is scrambled up inside the string, if any. There will be at most one matching word. The letters don't need to be contiguous.

	Example:
	words = ['cat', 'dog', 'bird', 'car', 'baby']
	string1 = 'tcabnihjs' -> cat
	string2 = 'tbcanihjs' -> cat
	string3 = 'baykkjl' -> None
	string4 = 'bbabylkkj' -> baby
	*/
	 public static void main(String[] argv) {
		    String[] words = new String[] { "cat", "dog", "bird", "car", "baby" };
		    String string1 = "tcabnihjs";
		    String string2 = "tbcanihjs";
		    String string3 = "baykkjl";
		    String string4 = "bbabylkkj";
		  
		    String[] scrambledWords = {string1,string2,string3,string4 };
		    mapScrambledToDictWords(scrambledWords,words).forEach((k, v) -> System.out.println((k + "->" + v)));
		  }

		  static Map<String,String> mapScrambledToDictWords(String[] scrambledWords,String[] dicts){
		    List<String> dictList = Arrays.asList(dicts);
		    Map<String,String> validDictMap = new LinkedHashMap<>();
		    for(String scrambledWord : scrambledWords){
		          for(String dictWord : dictList){
		                if( isWordFormationPiossible(scrambledWord,dictWord)  ){
		                  validDictMap.put(scrambledWord,dictWord);
		                  break;
		                } else {
		                	validDictMap.put(scrambledWord,"None");
		                }
		        
		           }
		          
		    }
		    return validDictMap;
		    
		    
		  }
		  static boolean isWordFormationPiossible(String scrambled,String word){
			  //System.out.println("scrambledWord is->" + scrambled +" , dictword="+word);
		    if(word.length()>scrambled.length()){
		      return false;
		    }
		    int[] validWordDictFreqTable = new int[26] ;//assume valid word dictionary contains only letters
		    
		    for(int i = 0 ; i < word.length();i++){
		    	char ch = word.charAt(i);
		    	validWordDictFreqTable[ch-'a']++;
		    }
		   
		     for(int j = 0 ; j <scrambled.length();j++){
		    	  char ch = scrambled.charAt(j);
		    	//  System.out.println("inserting in freqTable2="+ch);
		          if( validWordDictFreqTable[ch-'a']>0) {//if scrambled word character present in valid word dict
		        	  validWordDictFreqTable[ch-'a']--;//decrement matching character's freq occurence in validword frequency table
		          }	  
		      }
		  //    System.out.println("---Done inserting in freqTable2");
		      
		    
		    return containsWord(validWordDictFreqTable,word);
		  }

		private static boolean containsWord( int[] validWordDictFreqTable,String word) {
			for(int j = 0 ; j <word.length();j++){
				  char ch = word.charAt(j);
		    	//  System.out.println("freq of "+ch+ " is="+freqTable1[ch-'a']) ;
		    	  if(validWordDictFreqTable[ch-'a']!=0) {//every char frequency should now be zero
		    	    return false;
		    	  }
		      }
			return true;
		}
		    
		  
}
