package org.vivek.myinterview.graph.core.impl;



class Node {
	int data;
	Node nextElement;
}

class linkedList {
	private Node headNode;

	// Constructor - Initializing Head Node
	linkedList() {
		headNode = new Node();
	}

	public Node getHead() {
		return headNode;
	}

	// Function inserts a value/new Node as the first Element of list
	public void insertAtHead(int value) {
		Node newNode = new Node();
		newNode.data = value;
		newNode.nextElement = headNode.nextElement; // Linking newNode to head's nextNode
		headNode.nextElement = newNode;

		System.out.println(value + " Inserted !");
		printList();
	}

	// Helper Function that checks if List is empty or not
	public boolean isEmpty() {

		if (headNode.nextElement == null)
			return true;
		return false;
	}

	// Helper Function to printList
	public boolean printList() {

		if (isEmpty()) {
			System.out.println("List is Empty");
			return false;
		}

		Node temp = headNode.nextElement;
		System.out.print("List : ");

		while (temp.nextElement != null) {
			System.out.print(temp.data + "->");
			temp = temp.nextElement;
		}

		System.out.println(temp.data + "->null");
		return true;

	}

	/*
	 * public static void main(String args[]) { linkedList list = new linkedList();
	 * list.printList(); for (int i = 1; i <= 10; i++) { list.insertAtHead(i); }
	 * 
	 * }
	 */

}

public class GraphAsArray {

	public GraphAsArray(int v) {
		// Total number of vertex
		vertices = v;
		// definining array with size equal to the number of vertices
		array = new linkedList[vertices];
		// Creating new List for each vertex/index of array
		for (int i = 0; i < vertices; i++) {
			array[i] = new linkedList();
		}
	}

	// Function to add an Edge from source to destination
	public void addEdge(int source, int destination) {
		// As we are implementing a directed graph so (1,0) is not equal to (0,1)
		array[source].insertAtHead(destination);
		// If we were to implement an undirected graph i.e (1,0) == (0,1)
		// Then we will create an edge from destination towards source as well
		// i.e array[destination].insertAtHead(source);
	}

	public void printGraph() {
		System.out.println(">>Adjacency List of Directed Graph<<");
		for (int i = 0; i < vertices; i++) {
			System.out.print("|" + i + "| => ");
			Node temp = array[i].getHead().nextElement;
			while (temp != null) {
				System.out.print("[" + temp.data + "] -> ");
				temp = temp.nextElement;
			}
			System.out.println("null");
		}
	}

	public static void main(String args[]) {
		GraphAsArray g = new GraphAsArray(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 3);
		g.printGraph();
	}

	int vertices;
	linkedList[] array;

}