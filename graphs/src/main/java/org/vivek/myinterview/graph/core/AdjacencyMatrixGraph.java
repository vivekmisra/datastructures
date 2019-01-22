package org.vivek.myinterview.graph.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class AdjacencyMatrixGraph {

	public static void main(String[] args) {
		int number_of_nodes = 4;

		// int adjacency_matrix[][] = fillMatrix(number_of_nodes);
		// print2DArray(adjacency_matrix);
		AdjacencyMatrixGraph alg = new AdjacencyMatrixGraph();
		Graph g = alg.new Graph(number_of_nodes, true);

		g.addVertex(0, 'A');
		g.addVertex(1, 'B');
		g.addVertex(2, 'C');
		g.addVertex(3, 'D');
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 1);
		int adjacency_matrix[][] = g.getAdjMatrix();
		print2DArray(adjacency_matrix);
		// g.dfs(adjacency_matrix,0);
		g.bfs(adjacency_matrix, 0);
		// int source = 1;
		// dfs(adjacency_matrix, source);
	}

	private static int[][] fillMatrix(int n) {
		int[][] arr = new int[4][4];
		arr[0][0] = 0;
		arr[0][1] = 1;
		arr[0][2] = 1;
		arr[0][3] = 0;

		arr[1][0] = 0;
		arr[1][1] = 0;
		arr[1][2] = 0;
		arr[1][3] = 0;

		arr[2][0] = 1;
		arr[2][1] = 0;
		arr[2][2] = 0;
		arr[2][3] = 1;

		arr[3][0] = 0;
		arr[3][1] = 1;
		arr[3][2] = 0;
		arr[3][3] = 0;
		return arr;
	}

	private static void print2DArray(int[][] array) {
		System.out.println("----------Printing 2D array----------");
		int rows = array.length;
		int cols = array[0].length;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				// System.out.print("T[" + i + "][" + j + "]" + " ");
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("--------------------");
	}
	class Vertex {
		int id;
		char label;
		boolean visited = false;

		Vertex() {

		}

		Vertex(int id, boolean visited, char label) {
			super();
			this.id = id;
			this.label = label;
			this.visited = visited;
		}

		/**
		 * @return the id
		 */
		public int getId() {
			return id;
		}

		/**
		 * @param id
		 *            the id to set
		 */
		public void setId(int id) {
			this.id = id;
		}

		/**
		 * @return the label
		 */
		public char getLabel() {
			return label;
		}

		/**
		 * @param label
		 *            the label to set
		 */
		public void setLabel(char label) {
			this.label = label;
		}

	}

	class Graph {
		private int numVertices = 0;
		private int numEdges;
		private Vertex[] vertexArray;
		private int adjMatrix[][];
		boolean isDirected = false;

		/**
		 * @return the vertexArray
		 */
		public Vertex[] getVertexArray() {
			return vertexArray;
		}

		public Graph(int numVertices, boolean isDirected) {
			this.numVertices = numVertices;
			this.isDirected = isDirected;
			/*
			 * char[] alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray(); for (char c =
			 * 'A'; c <= 'Z'; c++) { alphabets[c - 'A'] = c; }
			 */
			initVertexArray(numVertices);
			initAdjMatrix(numVertices);
		}

		private void initVertexArray(int numVertices) {
			vertexArray = new Vertex[numVertices];
		}

		private void initAdjMatrix(int numVertices) {
			adjMatrix = new int[numVertices][numVertices];
			for (int i = 0; i < numVertices; i++) {
				for (int j = 0; j < numVertices; j++) {
					adjMatrix[i][j] = 0;
				}
			}
		}

		public void addVertex(int id, char label) {
			vertexArray[id] = new Vertex(id, false, label);

		}

		public void removeVertex() throws Exception {
			int numV = getNumVertices();
			if (numV == 0) {
				throw new Exception();
			}
			int size = getSize();
			if (size < 0.5 * numV) {
				size = (int) 0.5 * size;
				int[][] newAdjMatrix = new int[size][size];
				for (int i = 0; i < size; i++) {
					for (int j = 0; j < size; j++) {
						newAdjMatrix[i][j] = adjMatrix[i][j];
					}
				}
				adjMatrix = newAdjMatrix;
			}

		}

		public int getInDegree(int v) throws Exception {
			int numV = getNumVertices();
			if (v >= numV) {
				throw new Exception();
			}
			// Count the number of in-degrees
			int count = 0;
			for (int i = 0; i < getNumVertices(); i++) {
				if (adjMatrix[i][v] != 0) {
					count++;
				}
			}
			return count;
		}

		public int getOutDegree(int v) throws Exception {
			int numV = getNumVertices();
			if (v >= numV) {
				throw new Exception();
			}
			// Count the number of in-degrees
			int count = 0;
			for (int i = 0; i < getNumVertices(); i++) {
				if (adjMatrix[v][i] != 0) {
					count++;
				}
			}
			return count;
		}

		public List<Integer> getDegreeSeq() throws Exception {
			List<Integer> degreeSeq = new ArrayList<Integer>();
			int degrees = 0;
			for (int i = 0; i < getNumVertices(); i++) {
				degrees = getInDegree(i) + getOutDegree(i);
				degreeSeq.add(degrees);
			}
			Collections.sort(degreeSeq);
			Collections.reverse(degreeSeq);
			return degreeSeq;
		}

		public List<Integer> getNeighbors(int v) throws Exception {
			int numV = getNumVertices();
			if (v >= numV) {
				throw new Exception();
			}
			List<Integer> neighbors = new ArrayList<Integer>();
			for (int i = 0; i < getNumVertices(); i++) {
				if (adjMatrix[v][i] != 0) {
					neighbors.add(i);
				}
			}
			return neighbors;
		}

		public void displayVertex(char i) {
			System.out.println(i);
		}

		public void addEdge(int start, int end) {
			adjMatrix[start][end] = 1;
			if (!isDirected) {
				adjMatrix[end][start] = 1;
			}
			setNumEdges(getNumEdges() + 1);
		}

		public void removeEdge(int start, int end) {
			adjMatrix[start][end] = 0;
			if (!isDirected) {
				adjMatrix[end][start] = 0;

			}
			setNumEdges(getNumEdges() - 1);
		}

		public boolean isEdge(int start, int end) {
			return (start == 1 && end == 1);
		}

		/**
		 * @return the numEdges
		 */
		public int getNumEdges() {
			return numEdges;
		}

		/**
		 * @param numEdges
		 *            the numEdges to set
		 */
		public void setNumEdges(int numEdges) {
			this.numEdges = numEdges;
		}

		/**
		 * @return the numVertices
		 */
		public int getNumVertices() {
			return numVertices;
		}

		/**
		 * @return the adjMatrix
		 */
		public int[][] getAdjMatrix() {
			return adjMatrix;
		}

		/**
		 * @param numVertices
		 *            the numVertices to set
		 */
		public void setNumVertices(int numVertices) {
			this.numVertices = numVertices;
		}

		public int getSize() {
			return adjMatrix.length;
		}

		public String toString() {
			StringBuilder s = new StringBuilder();
			for (int i = 0; i < numVertices; i++) {
				s.append(i + ": ");
				for (int j : adjMatrix[i]) {
					s.append(((j == 1) ? 1 : 0) + " ");
				}
				s.append("\n");
			}
			return s.toString();
		}

		public void dfs(int adjacency_matrix[][], int sourceId) {
			Stack stack = new Stack<Integer>();
			if (sourceId != 0) {
				vertexArray[sourceId].visited = true;
				displayVertex(vertexArray[sourceId].label);
				stack.push(sourceId);
			} else {
				vertexArray[0].visited = true;
				displayVertex(vertexArray[0].label);
				stack.push(0);
			}
			int number_of_nodes = adjacency_matrix.length - 1;
			int p = (Integer) stack.peek();
			while (!stack.isEmpty()) {
				p = (Integer) stack.peek();
				int v = getAdjacentVertex(adjacency_matrix, (Integer) stack.peek());
				if (v == -1) {
					v = (Integer) stack.pop();
					System.out.print("pop:");
					displayVertex(vertexArray[v].label);
				} else {
					vertexArray[v].visited = true;
					displayVertex(vertexArray[v].label);
					stack.push(v);
				}
			}

			for (int j = 0; j < number_of_nodes; j++) {
				vertexArray[j].visited = false;

			}

		}

		public void bfs(int adjacency_matrix[][], int sourceId) {
			Queue q = new LinkedList<Integer>();
			if (sourceId != 0) {
				vertexArray[sourceId].visited = true;
				System.out.print("Enqueue start vertex in q:");
				displayVertex(vertexArray[sourceId].label);
				q.add(sourceId);
			} else {
				vertexArray[0].visited = true;
				System.out.print("Enqueue start vertex in q:");
				displayVertex(vertexArray[0].label);
				q.add(0);
			}
			int number_of_nodes = adjacency_matrix.length - 1;

			int v2;
			while (!q.isEmpty()) {
				int v1 = (Integer) q.poll();
				System.out.print("Polled from q:");
				displayVertex(vertexArray[v1].label);
				// if (!getAdjacentVertexes(adjacency_matrix, v1).isEmpty()) {
				for (int i = 0; i < getAdjacentVertexes(adjacency_matrix, v1).size(); i++) {

					v2 = getAdjacentVertex(adjacency_matrix, v1);
					if (v2 != -1) {
						vertexArray[v2].visited = true;
						System.out.print("Enqueue  in q:");
						displayVertex(vertexArray[v2].label);

						q.add(v2);
					}

				}
			}
			// }

			for (int j = 0; j < number_of_nodes; j++) {
				vertexArray[j].visited = false;

			}

		}

		int getAdjacentVertex(int adjacency_matrix[][], int v) {
			for (int j = 0; j < numVertices; j++) {
				if (adjacency_matrix[v][j] == 1 && vertexArray[j].visited == false) {
					return j;
				}
			}
			return -1;
		}

		// find neighbors of node using adjacency matrix
		// if adjacency_matrix[i][j]==1, then nodes at index i and index j are connected
		public List<Integer> getAdjacentVertexes(int adjacency_matrix[][], int x) {
			int nodeIndex = -1;

			List<Integer> neighbours = new ArrayList<Integer>();
			nodeIndex = findIndex(getVertexArray(), x);

			if (nodeIndex != -1) {
				for (int j = 0; j < adjacency_matrix[nodeIndex].length; j++) {
					if (adjacency_matrix[nodeIndex][j] == 1) {
						neighbours.add(nodeIndex);
					}
				}
			}
			return neighbours;
		}

		public int findIndex(Vertex[] vertexs, int t) {

			// if array is Null
			if (vertexs == null) {
				return -1;
			}

			// find length of array
			int len = vertexs.length;
			int i = 0;

			// traverse in the array
			while (i < len) {

				// if the i-th element is t
				// then return the index
				if (vertexs[i].id == t) {
					return i;
				} else {
					if ((i + 1) < len) {
						i = i + 1;
					}
				}
			}
			return -1;
		}
	}

	

}