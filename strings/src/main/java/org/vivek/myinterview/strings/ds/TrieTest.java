package org.vivek.myinterview.strings.ds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.vivek.myinterview.strings.ds.core.MyTrie;
import org.vivek.myinterview.strings.ds.core.TrieNode;

public class TrieTest {
	public static MyTrie t = new MyTrie();

	public TrieTest() {
		
	}

	// Function to search given key in Trie
	public static int findPos(TrieNode root, String word) {

		int pos = -1;
		if (word == null)
			return pos; // Null Key

		word = word.toLowerCase();
		TrieNode currentNode = root;
		int index = 0;
		int wordChar = 0;

		// Iterate the Trie over each character of key till key exhausts
		// find index of each character
		// assign currentNode at this index
		// If currentNode at this index is null at any point then
		// we stop and return false else continue by resetting currentNode
		// at each next index
		// We will return true only if we reach leafNode and have traversed the
		// Trie based on the length of the key

		for (wordChar = 0; wordChar < word.length(); wordChar++) {
			index = t.getIndex(word.charAt(wordChar));
			if (currentNode.isEndWord()) {
				pos = wordChar;
			}
			if (currentNode.getChildren() != null) {
				// continue & assign currentNode to this child
				currentNode.setChildren(currentNode.getChildren());
			} else {
				return pos;
			}
		}
		if (currentNode != null && currentNode.isEndWord()) {
			return wordChar;
		}

		return -1;
	}

	public static boolean isFormationPossible(TrieNode root, String word) {

		// Search for word in Trie and record it's position upto the mark where it
		// matched
		int pos_prefix = findPos(root, word);

		// Match not found
		if (pos_prefix == -1) {
			return false;
		}

		// If the word is partially matched in Trie, then search for the remaining word
		// from pos_prefix to the length of given String "word"

		String remaining_word = word.substring(pos_prefix, word.length());

		// Search for the remaining word's Position in Trie
		int rest_word_pos = findPos(root, remaining_word);

		// Word length is possible and given word can be generated from the dictionary
		// by combining
		// two words from it
		if ((pos_prefix + rest_word_pos) == word.length()) {
			return true;
		}

		return false;
	}

	public static int totalWords(TrieNode root) {
		int totalCount = 0;

		// Leaf denotes end of a word
		if (root.isEndWord) {
			totalCount++;
		}

		for (int i = 0; i < 26; i++) {
			if (root.getChildren() != null) {
				root.setChildren(root.getChildren());
				totalCount += totalWords(root);
			}
		}
		return totalCount;
	}
	
	// Recursive Function to generate all words
		public static void extractWords(TrieNode root, ArrayList<String> result, int wordCharIndex, char[] word) {

			// Leaf denotes end of a word
			if (root.isEndWord) {
				// extract the current word stored using indices less than the 'wordCharIndex'
				// in the character array
				String temp = "";
				for (int x = 0; x < wordCharIndex; x++) {
					temp += Character.toString(word[x]);
				}
				result.add(temp + ",");
			} 
				// Loop thru all 26 alphabets
				for (int i = 0; i < 26; i++) {
					// check if any word out of 26 alphabet starts with & has subsequent letters &
					// then at each alphabet try to extract word till end of word flag
					if (root.children[i] != null) {
						// Non-null child, so add that index to the character array
						word[wordCharIndex] = (char) (i + 'a');
						extractWords(root.children[i], result, wordCharIndex + 1, word);
					}
				}
			
		}

		public static ArrayList<String> findWords(TrieNode root) {
			ArrayList<String> result = new ArrayList<String>();
			char[] chararr = new char[20];
			extractWords(root, result, 0, chararr);
			return result;
		}

	public static void main(String[] args) {
		// Input keys (use only 'a' through 'z' and lower case)
				String words[] = { "the", "a", "there", "answer", "any", "by", "bye", "bed","room", "their", "abc" };
				String output[] = { "Not present in trie", "Present in trie" };
				MyTrie t = new MyTrie();

				System.out.println("Keys: " + Arrays.toString(words));

				// Construct trie

				int i;
				for (i = 0; i < words.length; i++) {
					t.insert(words[i]);
				}
				 t.search("be");

				
				 // Search for different keys
				 if (t.search("the") == true)
				  System.out.println("the --- " + output[1]); else
				 System.out.println("the --- " + output[0]);
				  
				  if (t.search("these") == true) System.out.println("these --- " + output[1]);
				  else System.out.println("these --- " + output[0]);
				  
				  if (t.search("abc") == true) System.out.println("abc --- " + output[1]); else
				  System.out.println("abc --- " + output[0]);
				  
				
				 

				List<String> l = findWords(t.getRoot());
				System.out.println("Words in trie");

				for (String s : l) {
					System.out.print(s);
				}
				
				/*int pos= findPos(t.root,"bed");
				System.out.println("findPos:"+pos);
				
				boolean flag= isFormationPossible(words,"bedroom");
				System.out.println("flag="+flag);;*/
	}

}
