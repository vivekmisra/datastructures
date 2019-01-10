package org.vivek.myinterview.strings.ds;

import java.util.Arrays;

import org.vivek.myinterview.strings.ds.core.MyTrie;
import org.vivek.myinterview.strings.ds.core.TrieNode;

public class TrieDemo{  
	  private TrieNode root; //Root Node
	  
	  //Constructor
	  TrieDemo(){
	    root = new TrieNode();
	  }
	  //Function to get the index of a character 'x'
	  private int getIndex(char x)
	  {
	    return x - 'a';  // the index is based on the position of character in alphabets
	  }
	  
	  //Function to insert a key in the Trie
	  public void insert(String key)
	  {
	    if(key == null) //Null keys are not allowed
	    {     
	      System.out.println("Null Key can not be Inserted!");
	      return;
	    }
	    key = key.toLowerCase(); //Keys are stored in lowercase
	    TrieNode currentNode = this.root;
	    int index = 0; //to store character index
	    
	    //Iterate the Trie with given character index,
	    //If it is null, then simply create a TrieNode and go down a level
	    for (int level = 0; level < key.length(); level++)
	    {
	       index = getIndex(key.charAt(level));
	       if(currentNode.children[index] == null)
	       {
	         currentNode.children[index] = new TrieNode();
	       }
	       currentNode = currentNode.children[index];
	    } 
	    //Mark the end character as leaf node
	    currentNode.markAsLeaf(); 
	  }
	  
	  public static void main(String args[]){
	    // Input keys (use only 'a' through 'z' and lower case)
	    String keys[] = {"the", "a", null,  "there", "answer", "any",
	                     "by", "bye", "their","abc"};
	    String output[] = {"Not present in trie", "Present in trie"};
	    TrieDemo t = new TrieDemo();
	    
	    System.out.println("Keys to insert: "+ Arrays.toString(keys) + "\n");
	        
	    // Construct trie       
	    int i;
	    for (i = 0; i < keys.length ; i++)
	    {
	      t.insert(keys[i]);
	      System.out.println("\""+ keys[i]+ "\"" + "Inserted.");
	    }
	  }
	}


class dictWord{
	 
	//Helper Function to find the position of given (prefix) word in Trie (upto the mark where it matches)
	private static int findPos(TrieNode root, String word)
	{
	  int pos = -1; 
	  int level = 0;
	  TrieNode currentNode = root;  
	  
	  for (level = 0; level < word.length(); level++)
	  {    
	    int index = word.charAt(level) - 'a';   
	    if (currentNode.isEndWord == true)
	      pos = level;
	    if (currentNode.children[index] == null)
	      return pos;
	    currentNode = currentNode.children[index];
	  }
	  
	  //Return the level/position if currentNode is leaf and not null
	  if (currentNode != null && currentNode.isEndWord)
	    return level;
	  
	  return -1;
	}

	public static boolean isFormationPossible(String[] dict,String word)
	{
	  //Create Trie and insert dictionary elements in it
	  MyTrie trie = new MyTrie();
	  
	  for(int x = 0; x < dict.length; x++){
	    trie.insert(dict[x]);
	  }
	  
	  //Search for word in Trie and record it's position upto the mark where it matched
	  int pos_prefix = findPos(trie.getRoot(),word);
	  
	  //Match not found
	  if(pos_prefix == -1){
	  	return false;
	  }
	  
	  //If the word is partially matched in Trie, then search for the remaining word
	  //from pos_prefix to the length of given String "word"
	  
	  String remaining_word = word.substring(pos_prefix,word.length());
	  
	  //Search for the remaining word's Position in Trie
	  int rest_word_pos = findPos(trie.getRoot(),remaining_word);
	  
	  //Word length is possible and given word can be generated from the dictionary by combining
	  //two words from it
	  if((pos_prefix + rest_word_pos) == word.length()){
	  	return true;
	  }

	  return false;
	 }
}