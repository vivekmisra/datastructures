package org.vivek.myinterview.graph.core;

import java.util.LinkedList;
import java.util.Queue;



public class AdjacencyListGraph {

	public AdjacencyListGraph() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		AdjacencyListGraph alg = new AdjacencyListGraph();
		Graph g = alg.new Graph(6);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(3, 4);
		g.addEdge(2, 3);
		g.addEdge(4, 0);
		g.addEdge(4, 1);
		g.addEdge(4, 5);
		g.BFS(0);

	}

	class Node {
		int data;
		char label;
		
		boolean visited = false;
		Node nextElement;
		/*public Node() {
			this.data = null;
			this.nextElement = null;
		}

		// Creates a single node storing the specified data.
		public Node(Integer data) {
			this(data, null);
		}

		//constructor to represent any node in a Linked List
		public Node(Integer data, Node next) {
			this.data = data;
			this.nextElement = next;
		}	*/
	}

	class adjList {
		private Node head;

		// Constructor - Initializing Head Node
		adjList() {
			head = new Node();
		}

		public Node getHead() {
			return head;
		}

		// Function inserts a value/new Node as the first Element of list
		public void insertAtHead(int value) {
			Node newNode = new Node();
			newNode.data = value;
			newNode.nextElement = head.nextElement; // Linking newNode to head's nextNode
			head.nextElement = newNode;
			

			System.out.println(value + " Inserted !");
			printList();
		}

		// Helper Function that checks if List is empty or not
		public boolean isEmpty() {

			if (head.nextElement == null)
				return true;
			return false;
		}

		// Helper Function to printList
		public boolean printList() {

			if (isEmpty()) {
				System.out.println("List is Empty");
				return false;
			}

			Node temp = head.nextElement;
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
		class Graph {
			int V;
			adjList[] array;
			
			

			public Graph(int V) {
				this.V = V;
				array = new adjList[V]; // linked lists = number of Nodes in Graph

				for (int i = 0; i < V; i++) {
					array[i] = new adjList();
					// array[i].head = null;
				}
			}

			public void addEdge(int src, int dest) {

				// As we are implementing a directed graph so (1,0) is not equal to (0,1)
				array[src].insertAtHead(dest);
				// If we were to implement an undirected graph i.e (1,0) == (0,1)
				// Then we will create an edge from destination towards source as well
				// i.e array[destination].insertAtHead(source);
			}

			public void BFS(int startVertex) {
				boolean[] visited = new boolean[V];
				Queue<Integer> q = new LinkedList<Integer>();

				q.add(startVertex);
				System.out.print(" " + startVertex);
				
				while (!q.isEmpty()) {
					int n = q.poll();
					visited[n] = true;
					Node head = array[n].getHead();
					while (head != null) {
						if (visited[head.data] == false) {
							q.add(head.data);
							System.out.print(" " + head.data);
							visited[head.data] = true;
						}
						head = head.nextElement;
					}
				}
			}
		

	}
}
