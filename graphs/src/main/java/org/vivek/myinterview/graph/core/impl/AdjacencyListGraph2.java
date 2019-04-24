package org.vivek.myinterview.graph.core.impl;

import java.util.LinkedList;

public class AdjacencyListGraph2 {

	public AdjacencyListGraph2() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		AdjacencyListGraph2 adjList = new AdjacencyListGraph2();
		Graph graph = adjList.new Graph(6);
		/*
		 * graph.addEdge(0, 1); graph.addEdge(0, 4); graph.addEdge(1, 2);
		 * graph.addEdge(1, 3); graph.addEdge(1, 4); graph.addEdge(2, 3);
		 * graph.addEdge(3, 4);
		 */

		/*graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(3, 1);
		graph.printGraph();*/
		
		  graph.addEdge(0, 1);
	        graph.addEdge(0, 2);
	        graph.addEdge(1, 2);
	        graph.addEdge(1, 3);
	        graph.addEdge(3, 4);
	        graph.addEdge(2, 3);
	        graph.addEdge(4, 0);
	        graph.addEdge(4, 1);
	graph.addEdge(4, 5);
		 boolean [] visited = new boolean[6];
		graph.dfs(0, visited);
		boolean result = graph.isCycle();
		System.out.println("is Cycle present: " + result);
	}

	class Graph {
		int vertices;
		LinkedList<Integer>[] adjList;

		Graph(int vertices) {
			this.vertices = vertices;
			adjList = new LinkedList[vertices];
			for (int i = 0; i < vertices; i++) {
				adjList[i] = new LinkedList<>();
			}
		}

		public void addEdge(int source, int destination) {
			adjList[source].addFirst(destination);
		}

		public void printGraph() {
			for (int i = 0; i < vertices; i++) {
				if (adjList[i].size() > 0) {
					System.out.print("Vertex " + i + " is connected to: ");
					for (int j = 0; j < adjList[i].size(); j++) {
						System.out.print(adjList[i].get(j) + " ");
					}
					System.out.println();
				}
			}
		}

		public void DFSRecursion(int startVertex) {
			boolean[] visited = new boolean[vertices];
			dfs(startVertex, visited);
		}

		public void dfs(int start, boolean[] visited) {
			visited[start] = true;
			System.out.print(start + " ");
			for (int i = 0; i < adjList[start].size(); i++) {
				int destination = adjList[start].get(i);
				if (!visited[destination])
					dfs(destination, visited);
			}
		}
		public boolean isCycle() {
			boolean visited[] = new boolean[vertices];
			boolean recursiveArr[] = new boolean[vertices];

			// do DFS from each node
			for (int i = 0; i < vertices; i++) {
				if (isCycleUtil(i, visited, recursiveArr))
					return true;
			}
			return false;
		}

		public boolean isCycleUtil(int vertex, boolean[] visited, boolean[] recursiveArr) {
			visited[vertex] = true;
			recursiveArr[vertex] = true;

			// recursive call to all the adjacent vertices
			for (int i = 0; i < adjList[vertex].size(); i++) {
				// if not already visited
				int adjVertex = adjList[vertex].get(i);
				if (!visited[adjVertex] && isCycleUtil(adjVertex, visited, recursiveArr)) {
					return true;
				} else if (recursiveArr[adjVertex])
					return true;
			}
			// if reached here means cycle has not found in DFS from this vertex
			// reset
			recursiveArr[vertex] = false;
			return false;
		}
	}

}
