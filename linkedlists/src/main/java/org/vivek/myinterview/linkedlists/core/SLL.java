/*Copyright (c) Dec 21, 2014 CareerMonk Publications and others.
 * E-Mail           	: info@careermonk.com 
 * Creation Date    	: 2015-01-10 06:15:46 
 * Last modification	: 2006-05-31 
               by		: Narasimha Karumanchi 
 * File Name			: LinkedList.java
 * Book Title			: Data Structures And Algorithms Made In Java
 * Warranty         	: This software is provided "as is" without any 
 * 							warranty; without even the implied warranty of 
 * 							merchantability or fitness for a particular purpose. 
 * 
 */

package org.vivek.myinterview.linkedlists.core;

public class SLL {
	// This class has a default constructor:
	public SLL() {
		length = 0;
	}

	// This is the only field of the class. It holds the head of the list
	SLLNode head;

	// Length of the linked list
	private int length = 0;

	// Return the first node in the list
	public synchronized SLLNode getHead() {
		return head;
	}

	// purge
	public void purge() {
		this.head = null;

	}

	// Insert a node at the beginning of the list
	public synchronized void insertAtBegin(SLLNode node) {
		node.setNext(head);
		head = node;
		length++;
	}

	// Insert a node at the beginning of the list
	public synchronized void insertAtBegin(int data) {
		SLLNode temp = new SLLNode(data);
		temp.next = head;
		head = temp;
		length++;
	}

	// Insert a node at the end of the list
	public synchronized void insertAtEnd(SLLNode node) {
		if (head == null) {
			head = node;
			// the list is now one value longer
			length += 1;
		} else {
			SLLNode p, q;
			for (p = head; (q = p.getNext()) != null; p = q)
				;
			p.setNext(node);
			length++;
		}
	}

	public void insertAtEnd(int data) {
		// if the list is empty, make it be the only element
		if (head == null) {
			head = new SLLNode(data);
			// the list is now one value longer
			length += 1;
		}
		// if adding at the front of the list...
		else if (head == null) {
			SLLNode temp = new SLLNode(data);
			temp.next = head;
			head = temp;
			// the list is now one value longer
			length += 1;
		}
		// else find the correct position and insert
		else {
			SLLNode temp = head;
			while (temp != null) {
				if (temp.next == null) {
					SLLNode n = new SLLNode(data);
					temp.next = n;
					// the list is now one value longer
					length += 1;
					break;
				}
				temp = temp.getNext();
			}
		}
	}

	// Add a new value to the list at a given position.
	// All values at that position to the end move over to make room.
	public void insert(int data, int position) {
		// fix the position
		if (position < 0) {
			position = 0;
		}
		if (position > length) {
			position = length;
		}

		// if the list is empty, make it be the only element
		if (head == null) {
			head = new SLLNode(data);

		}
		// if adding at the front of the list...
		else if (position == 0) {
			SLLNode temp = new SLLNode(data);
			temp.next = head;
			head = temp;
		}
		// else find the correct position and insert
		else {
			SLLNode temp = head;
			for (int i = 1; i < position; i += 1) {
				temp = temp.getNext();
			}
			SLLNode newNode = new SLLNode(data);
			newNode.next = temp.next;
			temp.setNext(newNode);
		}
		// the list is now one value longer
		length += 1;
	}

	// Remove and return the node at the head of the list
	public synchronized SLLNode removeFromBegin() {
		SLLNode node = head;
		if (node != null) {
			head = node.getNext();
			node.setNext(null);
		}
		return node;
	}

	// Remove and return the node at the end of the list
	public synchronized SLLNode getLast() {
		if (head == null)
			return null;
		if (head.getNext() == null) {
			return head;
		}
		SLLNode p = head.getNext();
		while (p.getNext() != null) {
			p = p.getNext();
		}
		return p;
	}

	// Remove and return the node at the end of the list
	public synchronized SLLNode removeFromEnd() {
		if (head == null)
			return null;
		SLLNode p = head, q = null, next = head.getNext();
		if (next == null) {
			head = null;
			// reduce the length of the list
			length -= 1;
			return p;
		}
		while ((next = p.getNext()) != null) {
			q = p;
			p = next;
		}
		q.setNext(null);
		// reduce the length of the list
		length -= 1;
		return p;
	}

	// Remove a node matching the specified node from the list.
	// Use equals() instead of == to test for a matched node.
	public synchronized void removeMatched(SLLNode node) {
		if (head == null)
			return;
		if (node.equals(head)) {
			head = head.getNext();
			// reduce the length of the list
			length -= 1;
			return;
		}
		SLLNode p = head, q = null;
		while ((q = p.getNext()) != null) {
			if (node.equals(q)) {
				p.setNext(q.getNext());
				// reduce the length of the list
				length -= 1;
				return;
			}
			p = q;
		}
	}

	// Remove the value at a given position.
	// If the position is less than 0, remove the value at position 0.
	// If the position is greater than 0, remove the value at the last position.
	public void remove(int position) {
		// fix position
		if (position < 0) {
			position = 0;
		}

		if (position >= length) {
			position = length - 1;
		}

		// if nothing in the list, do nothing
		if (head == null)
			return;

		// if removing the head element...
		if (position == 0) {
			head = head.getNext();
		}
		// else advance to the correct position and remove
		else {
			SLLNode temp = head;
			for (int i = 1; i < position; i += 1) {
				temp = temp.getNext();
			}
			temp.setNext(temp.getNext().getNext());
		}
		// reduce the length of the list
		length -= 1;
	}

	// Return a string representation of this collection, in the form
	// ["str1","str2",...].
	public String toString() {
		String result = "[";
		if (head == null) {
			return result + "]";
		}
		result = result + head.getData();
		SLLNode temp = head.getNext();
		while (temp != null) {
			result = result + "," + temp.getData();
			temp = temp.getNext();
		}
		return result + "]";
	}

	// Return the current length of the list.
	public int length() {
		return length;
	}

	// ##############################START:SEARCHING#############################################//
	// Find the position of the first value that is equal to a given value.
	// The equals method us used to determine equality.
	public int findFirstPositionByData(int data) {
		// go looking for the data
		SLLNode temp = head;
		int pos = 0;
		while (temp != null) {
			if (temp.getData() == data) {
				// return the position if found
				return pos;
			}
			pos += 1;// DONT FORGET THIS
			temp = temp.getNext();
		}
		// else return -1
		return Integer.MIN_VALUE;
	}

	public SLLNode findFirstNodeByData(Integer data) {
		SLLNode node = getHead();// runner
		while (node != null) {
			if (node.data.equals(data)) {

				return node;
			}
			node = node.next;
		}
		return null;
	}

	// ##############################END:SEARCHING#############################################//
	// Size of the list.
	public boolean isEmpty() {
		return length == 0;
	}

	// Remove everything from the list.
	public void clearList() {
		head = null;
		length = 0;
	}

	public void printLinkedList(SLLNode head) {

		while (head != null) {
			if (head.next != null) {
				System.out.print(head.data + "->");
			} else {
				System.out.print(head.data + "->NULL");
			}
			head = head.next;
		}
		System.out.println();
	}

	public static void main(String args[]) {
		SLL l = new SLL();

		SLLNode head = null;
		l.insert(1, 0);
		l.insert(2, 0);
		l.insert(3, 0);
		l.insert(4, 0);
		l.insert(5, 0);
		l.insert(6, 0);

		l.printLinkedList(head);
		l.printLinkedList(l.getHead());
		System.out.println("First Position with data =5 :" + l.findFirstPositionByData(5));
		System.out.println("First Node with data =5 :" + l.findFirstNodeByData(5));
		System.out.println("Inserted  data =9 at end ");
		l.insertAtEnd(9);
		System.out.println("Inserted  data =0 at beginning ");
		l.insertAtBegin(0);
		System.out.println("Inserted  data =12 at postion 2 ");
		l.insert(12, 2);
		l.printLinkedList(l.getHead());
	}
}