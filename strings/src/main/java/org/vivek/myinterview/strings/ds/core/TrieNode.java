package org.vivek.myinterview.strings.ds.core;

import java.util.Arrays;

public class TrieNode {
	public TrieNode[] children;
	public boolean isEndWord; // will be true if the node represents the end of word
	// Function to get the index of a character 't'
		public  int getIndex(char t) {
			return t - 'a';
		}

	/**
	 * @return the children
	 */
	public TrieNode[] getChildren() {
		return children;
	}
	
	/**
	 * @return the children
	 */
	public TrieNode getChildAtIndex(int index) {
		TrieNode[] tarray = getChildren();
		return tarray[index];
	}
	
	public TrieNode addTrieNodeAtIndex( int index) {
		TrieNode[] tarray = getChildren();
		tarray[index]   = new TrieNode();
	   
	    return tarray[index];
	}
	   
	public TrieNode addTrieNode() {
		   
		 TrieNode t   = new TrieNode();
	   
	    return t;
	}


	/**
	 * @param children the children to set
	 */
	public void setChildren(TrieNode[] children) {
		this.children = children;
	}

	/**
	 * @return the isEndWord
	 */
	public boolean isEndWord() {
		return isEndWord;
	}

	/**
	 * @param isEndWord the isEndWord to set
	 */
	public void setEndWord(boolean isEndWord) {
		this.isEndWord = isEndWord;
	}

	public TrieNode() {
		this.isEndWord = false;
		this.children = new TrieNode[26]; // Total # of English Alphabets = 26
	}

	// Function to mark the currentNode as Leaf
	public void markAsLeaf() {
		this.isEndWord = true;
	}

	// Function to unMark the currentNode as Leaf
	public void unMarkAsLeaf() {
		this.isEndWord = false;
	}

	public static void main(String args[]) {
		TrieNode root = new TrieNode();
		
		System.out.println("Children: " + root.children[0]);
		System.out.println("isEndWord: " + root.isEndWord);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TrieNode [children=" + Arrays.toString(children) + ", isEndWord=" + isEndWord + "]";
	}
	
}
