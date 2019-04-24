package org.vivek.myinterview.graph.core.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import org.vivek.myinterview.graph.core.impl.AdjacencyMatrixGraph.Vertex;

public class NeighbourListGraph {
	
	 class AdjacencyListNode {
			int data;
			boolean visited;
			List<AdjacencyListNode> neighbours;

			AdjacencyListNode(int data) {
				this.data = data;
				this.neighbours = new ArrayList<>();

			}

			public void addneighbours(AdjacencyListNode neighbourNode) {
				this.neighbours.add(neighbourNode);
			}

			public List<AdjacencyListNode> getNeighbours() {
				return neighbours;
			}

			public void setNeighbours(List<AdjacencyListNode> neighbours) {
				this.neighbours = neighbours;
			}
			
		

		}

	public NeighbourListGraph() {
		// TODO Auto-generated constructor stub
	}

	public void bfs(AdjacencyListNode node)
	{
		Queue<AdjacencyListNode> queue = new LinkedList<AdjacencyListNode>();
		queue.add(node);
		node.visited=true;
		while (!queue.isEmpty())
		{
 
			AdjacencyListNode element=queue.remove();
			System.out.print(element.data + "\t");
			List<AdjacencyListNode> neighbours=element.getNeighbours();
			for (int i = 0; i < neighbours.size(); i++) {
				AdjacencyListNode n=neighbours.get(i);
				if(n!=null && !n.visited)
				{
					queue.add(n);
					n.visited=true;
 
				}
			}
 
		}
	}

	// Recursive DFS
	public void dfs(AdjacencyListNode node) {
		System.out.print(node.data + " \t");
		List<AdjacencyListNode> neighbours = node.getNeighbours();
		node.visited = true;
		for (int i = 0; i < neighbours.size(); i++) {
			AdjacencyListNode n = neighbours.get(i);
			if (n != null && !n.visited) {
				dfs(n);
			}
		}
	}

	// Iterative DFS using stack
	public void dfsUsingStack(AdjacencyListNode node) {
		Stack<AdjacencyListNode> stack = new Stack<AdjacencyListNode>();
		stack.add(node);
		node.visited = true;
		while (!stack.isEmpty()) {
			AdjacencyListNode element = stack.pop();
			System.out.print(element.data + " \t");

			List<AdjacencyListNode> neighbours = element.getNeighbours();
			for (int i = 0; i < neighbours.size(); i++) {
				AdjacencyListNode n = neighbours.get(i);
				
				if (n != null && !n.visited) {
					stack.add(n);
					n.visited = true;

				}
			}
		}
	}

	public static void main(String arg[]) {
		NeighbourListGraph  ng  = new NeighbourListGraph();
		
		AdjacencyListNode node40 = ng.new AdjacencyListNode(40);
		AdjacencyListNode node10 = ng.new AdjacencyListNode(10);
		AdjacencyListNode node20 = ng.new AdjacencyListNode(20);
		AdjacencyListNode node30 = ng.new AdjacencyListNode(30);
		AdjacencyListNode node60 = ng.new AdjacencyListNode(60);
		AdjacencyListNode node50 = ng.new AdjacencyListNode(50);
		AdjacencyListNode node70 = ng.new AdjacencyListNode(70);

		node40.addneighbours(node10);
		node40.addneighbours(node20);
		node10.addneighbours(node30);
		node20.addneighbours(node10);
		node20.addneighbours(node30);
		node20.addneighbours(node60);
		node20.addneighbours(node50);
		node30.addneighbours(node60);
		node60.addneighbours(node70);
		node50.addneighbours(node70);

		NeighbourListGraph dfsExample = new NeighbourListGraph();

		System.out.println("The DFS traversal of the graph using stack ");
		dfsExample.dfsUsingStack(node40);

		System.out.println();

		// Resetting the visited flag for nodes
		node40.visited = false;
		node10.visited = false;
		node20.visited = false;
		node30.visited = false;
		node60.visited = false;
		node50.visited = false;
		node70.visited = false;

		System.out.println("The DFS traversal of the graph using recursion ");
		dfsExample.dfs(node40);
		
		// Resetting the visited flag for nodes
		node40.visited = false;
		node10.visited = false;
		node20.visited = false;
		node30.visited = false;
		node60.visited = false;
		node50.visited = false;
		node70.visited = false;
		System.out.println();
		NeighbourListGraph bfsExample = new NeighbourListGraph();
		System.out.println("The BFS traversal of the graph is ");
		bfsExample.bfs(node40);
		
	}
}