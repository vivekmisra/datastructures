package org.vivek.myinterview.strings.ds;

import java.util.Arrays;

import org.vivek.myinterview.strings.ds.core.MyTrie;
import org.vivek.myinterview.strings.ds.core.TrieNode;

public class TrieDemo {
	private TrieNode root; // Root Node

	// Constructor
	TrieDemo() {
		root = new TrieNode();
	}

	// Function to get the index of a character 'x'
	private static int getIndex(char x) {
		return x - 'a'; // the index is based on the position of character in alphabets
	}

	// Function to insert a key in the Trie
	public void insert(String key) {
		if (key == null) // Null keys are not allowed
		{
			System.out.println("Null Key can not be Inserted!");
			return;
		}
		key = key.toLowerCase(); // Keys are stored in lowercase
		TrieNode currentNode = this.root;
		int index = 0; // to store character index

		// Iterate the Trie with given character index,
		// If it is null, then simply create a TrieNode and go down a level
		for (int level = 0; level < key.length(); level++) {
			index = getIndex(key.charAt(level));
			if (currentNode.children[index] == null) {
				currentNode.children[index] = new TrieNode();
			}
			currentNode = currentNode.children[index];
		}
		// Mark the end character as leaf node :
		// a)after inserting new nodes(characters) for the key
		// b)if the key [word] is already present in the prefix
		currentNode.markAsLeaf();
	}

	public boolean search(String key) {
		if (key == null)
			return false;
		key = key.toLowerCase();
		int index = 0;
		TrieNode currentNode = this.root;
		for (int level = 0; level < key.length(); level++) {
			index = getIndex(key.charAt(level));
			if (currentNode.children[index] == null) {
				return false;
			}
			currentNode = currentNode.children[index];
		}
		if (currentNode != null && currentNode.isEndWord == true) {
			// found
			return true;
		}
		return false;
	}

	public static void main(String args[]) {
		// Input keys (use only 'a' through 'z' and lower case)
		String keys[] = { "the", "a", null, "there", "answer", "any", "by", "bye", "their", "abc" };
		String output[] = { "Not present in trie", "Present in trie" };
		TrieDemo t = new TrieDemo();

		System.out.println("Keys to insert: " + Arrays.toString(keys) + "\n");

		// Construct trie
		int i;
		for (i = 0; i < keys.length; i++) {
			t.insert(keys[i]);
			System.out.println("\"" + keys[i] + "\"" + "Inserted.");
		}
		if (t.search("the") == true) {
			System.out.println("the --- " + output[1]);
		} else {
			System.out.println("the --- " + output[0]);
		}

		if (t.search("these") == true) {
			System.out.println("these --- " + output[1]);
		} else {
			System.out.println("these --- " + output[0]);
		}

		if (t.search("abc") == true) {
			System.out.println("abc --- " + output[1]);
		} else {
			System.out.println("abc --- " + output[0]);
		}

		int rest_word_pos = findPos(t.root, "these");
		System.out.println("rest_word_pos " + rest_word_pos);
	}

	// static class dictWord {

	// Helper Function to find the position of given (prefix) word in Trie (upto the
	// mark where it matches if prefix exists in trie )
	private static int findPos(TrieNode root, String word) {
		int pos = -1;
		int level = 0;
		TrieNode currentNode = root;

		for (level = 0; level < word.length(); level++) {
			int index = getIndex(word.charAt(level));
			;
			if (currentNode.isEndWord == true)
				pos = level;
			if (currentNode.children[index] == null) {
				/*
				 * Supose ["the","there",etc ]is present in Trie and "these" is searched At "e"
				 * isEndPoint=true and this is point after which start differing after "e"
				 * ,there is no node child "s" then this pos is the the positon upto which
				 * prefic "the" of "these" is matched note:In a search impl ,you return false
				 * from here
				 */
				return pos;
			}
			currentNode = currentNode.children[index];
		}

		// Return the level/position if currentNode is leaf and not null
		if (currentNode != null && currentNode.isEndWord)
			return level;

		return -1;
	}

	public static boolean isFormationPossible(String[] dict, String word) {
		// Create Trie and insert dictionary elements in it
		if (word.length() < 2 || dict.length < 2) {
			return false;
		}

		// Create Trie and insert dictionary elements in it
		MyTrie trie = new MyTrie();

		for (int i = 0; i < dict.length; i++) {
			trie.insert(dict[i]);
		}

		for (int i = 0; i < word.length(); i++) {
			// Slice the word into two strings in each iteration
			String first = word.substring(0, i);
			String second = word.substring(i, word.length());

			// If both substrings are present in the trie, the condition is fulfilled
			if (trie.search(first) && trie.search(second)) {
				return true;
			}
		}

		return false;
	}
}
