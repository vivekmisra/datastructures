package org.vivek.myinterview.linkedlists.core;



public class SLLNode {	
	public Integer data;
	public SLLNode next;
	
	
	// Creates an empty node.
	public SLLNode() {
		this.data = null;
		this.next = null;
	}

	// Creates a single node storing the specified data.
	public SLLNode(Integer data) {
		this(data, null);
	}

	//constructor to represent any node in a Linked List
	public SLLNode(Integer data, SLLNode next) {
		this.data = data;
		this.next = next;
	}	
	
	
	// Returns the node that follows this one.
	public SLLNode getNext() {
		return next;
	}

	// Sets the node that follows this one.
	public void setNext(SLLNode next) {
		this.next =next;
	}

	// Returns the data stored in this node.
	public Integer getData() {
		return data;
	}

	// Sets the data stored in this node.
	public void setData(Integer data) {
		this.data = data;
	}

	// Sets the data stored in this node.
	public String toString() {
		return Integer.toString(data);
	}
	
	public void printLinkedList() {
		SLLNode head = this;
		while (head != null) {
			if(head.next!=null){
				System.out.print(head.data + "->");
			}else{
				System.out.print(head.data + "->NULL");
			}
			head = head.next;
		}
		System.out.println();
	}
	
	
}

