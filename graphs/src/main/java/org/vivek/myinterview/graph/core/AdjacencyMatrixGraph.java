package org.vivek.myinterview.graph.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import org.vivek.myinterview.graph.core.DepthFirstSearchExample.Node;

public class AdjacencyMatrixGraph {
	static ArrayList<Vertex> nodes = new ArrayList<>();

	public static void main(String[] args) {
		int number_of_nodes = 4;
		System.out.println("nodes:"+ nodes);
		// int adjacency_matrix[][] = fillMatrix(number_of_nodes);
		// print2DArray(adjacency_matrix);
		AdjacencyMatrixGraph alg = new AdjacencyMatrixGraph();
		Graph g = constructGraph(number_of_nodes, alg);
		int adjacency_matrix[][] = g.getAdjMatrix();
		print2DArray(adjacency_matrix);
		System.out.println("DFS:");
		// g.dfs(adjacency_matrix,0);
		g.dfs(adjacency_matrix, nodes.get(0));
		System.out.println();
		clearVisitedFlags();
		Graph g2 = constructGraph(number_of_nodes, alg);
		
		System.out.println("DFS RECURSIVE:");
		g2.dfsRecursive(adjacency_matrix, nodes.get(0));
		System.out.println();
		clearVisitedFlags();
		AdjacencyMatrixGraph alg2 = new AdjacencyMatrixGraph();
		g = constructGraph(number_of_nodes, alg2);
		System.out.println("BFS:");
		g.bfs(adjacency_matrix, nodes.get(0));
		clearVisitedFlags();
	}

	private static Graph constructGraph(int number_of_nodes, AdjacencyMatrixGraph alg) {
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
		return g;
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

		@Override
		public String toString() {
			return "Vertex [id=" + id + ", label=" + label + ", visited=" + visited + "]";
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
			 * char[] alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
			 * for (char c = 'A'; c <= 'Z'; c++) { alphabets[c - 'A'] = c; }
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
			Vertex v = new Vertex(id, false, label);
			nodes.add(v);
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
			System.out.print(i);
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
			Stack<Integer> stack = new Stack<Integer>();
			if (sourceId != 0) {
				vertexArray[sourceId].visited = true;
				System.out.print("push:(");
				displayVertex(vertexArray[sourceId].label);
				System.out.print(")-->");
				stack.push(sourceId);
			} else {
				vertexArray[0].visited = true;
				System.out.print("push:(");
				displayVertex(vertexArray[0].label);
				System.out.print(")-->");
				stack.push(0);
			}
			int number_of_nodes = adjacency_matrix.length - 1;
			while (!stack.isEmpty()) {
				int currentVertexId = (Integer) stack.peek();
				int adjacentVertexId = getUnvisitedAdjacentVertexId(adjacency_matrix, currentVertexId);
				if (adjacentVertexId == -1) {// already visited
					adjacentVertexId = (Integer) stack.pop();

					System.out.print("(pop:");
					displayVertex(vertexArray[adjacentVertexId].label);
					System.out.print(")--->");
				} else {// never visited
					vertexArray[adjacentVertexId].visited = true;// mark as
																	// visited
					System.out.print("push:(");
					displayVertex(vertexArray[adjacentVertexId].label);
					System.out.print(")-->");
					stack.push(adjacentVertexId);
				}
			}

			for (int j = 0; j < number_of_nodes; j++) {
				vertexArray[j].visited = false;

			}

		}

		// Recursive DFS
		public  void dfsRecursive(int adjacency_matrix[][],Vertex node)
		{

			System.out.print(node + " ");
			List<Vertex> neighbours=getAdjacentVertexes(adjacency_matrix,node.id);
	       node.visited=true;
			for (int i = 0; i < neighbours.size(); i++) {
				Vertex n=neighbours.get(i);
				if(n!=null && !n.visited)
				{
					dfsRecursive(adjacency_matrix,n);
				}
			}
		}
		public void dfs(int adjacency_matrix[][], Vertex v) {
			Stack<Vertex> stack = new Stack<Vertex>();
			if (v.getId() != 0) {
				v.visited = true;
				System.out.print("push(");
				System.out.print(v);
				System.out.print(")-->");
				stack.push(v);
			} else {
				v.visited = true;
				System.out.print("push(");
				System.out.print(v);
				System.out.print(")-->");
				stack.push(v);
			}
			while (!stack.isEmpty()) {
				Vertex currentVertex = (Vertex) stack.peek();
				int adjacentVertexId = getUnvisitedAdjacentVertexId(adjacency_matrix, currentVertex);
				if (adjacentVertexId == -1) {// already visited
					Vertex adjacentVertex = (Vertex) stack.pop();
					System.out.print("pop(:");
					System.out.print(adjacentVertex);
					System.out.print(")--->");
				} else {// never visited
					Vertex adjacentVertex = nodes.get(adjacentVertexId);
					adjacentVertex.visited = true;// mark as visited
					System.out.print("push(");
					System.out.print(adjacentVertex);
					System.out.print(")-->");
					stack.push(adjacentVertex);
				}
			}

		}

		public void bfs(int adjacency_matrix[][], Vertex v) {
			Queue<Vertex> q = new LinkedList<Vertex>();
			if (v.getId() != 0) {
				v.visited = true;
				System.out.print("Add(");
				System.out.print(v);
				System.out.print(")-->");
				q.add(v);
			} else {
				v.visited = true;
				System.out.print("Add(");
				System.out.print(v);
				System.out.print(")-->");
				q.add(v);
			}
			int number_of_nodes = adjacency_matrix.length - 1;
			while (!q.isEmpty()) {
				Vertex currentVertex = (Vertex) q.poll();
				int currentVertexId = currentVertex.getId();
				System.out.print("(Poll:");
				System.out.print(currentVertex);
				System.out.print(")--->");
				// if (!getAdjacentVertexes(adjacency_matrix, v1).isEmpty()) {
				List<Vertex> vertexList = getAdjacentVertexes(adjacency_matrix, currentVertexId);
				for (Vertex adjacentVertex : vertexList) {
					//int adjacentVertexId = getUnvisitedAdjacentVertexId(adjacency_matrix, currentVertexId);
					if(adjacentVertex!=null && !adjacentVertex.visited)
					{
						System.out.print("Add(");
						System.out.print(adjacentVertex);
						System.out.print(")--->");
						q.add(adjacentVertex);
						adjacentVertex.visited=true;
	 
					}
					/*if (adjacentVertexId != -1) {// never visited
						Vertex adjacentVertex = nodes.get(adjacentVertexId);
						adjacentVertex.visited = true;
						System.out.print("Add(");
						System.out.print(adjacentVertex);
						System.out.print(")--->");
						q.add(adjacentVertex);
					}*/

				}
			}
			

		}

		int getUnvisitedAdjacentVertexId(int adjacency_matrix[][], int v) {
			for (int j = 0; j < numVertices; j++) {
				if (adjacency_matrix[v][j] == 1 && vertexArray[j].visited == false) {
					return j;
				}
			}
			return -1;
		}

		int getUnvisitedAdjacentVertexId(int adjacency_matrix[][], Vertex currentVertex) {
			int v = currentVertex.getId();
			for (int j = 0; j < numVertices; j++) {
				if (adjacency_matrix[v][j] == 1 && nodes.get(j).visited == false) {
					return j;
				}
			}
			return -1;
		}

		// find neighbors of node using adjacency matrix
		// if adjacency_matrix[i][j]==1, then nodes at index i and index j are
		// connected
		public List<Vertex> getAdjacentVertexes(int adjacency_matrix[][], int x) {
			int nodeIndex = -1;

			List<Vertex> neighbours=new ArrayList<>();

			
			for (int i = 0; i < nodes.size(); i++) {
				Vertex v =nodes.get(i);
				nodeIndex  = v.getId();
				if(nodeIndex==x)
				{
					nodeIndex=i;
					break;
				}
			}


			if (nodeIndex != -1) {
				for (int j = 0; j < adjacency_matrix[nodeIndex].length; j++) {
					if (adjacency_matrix[nodeIndex][j] == 1) {
						neighbours.add(nodes.get(j));
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
				if (nodes.get(i).id == t) {
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

	public static void clearVisitedFlags() {
		for (int i = 0; i < nodes.size(); i++) {
			nodes.get(i).visited = false;
		}
	}

}
