package org.vivek.myinterview.graph.core.impl.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.vivek.myinterview.graph.core.impl.test.DirectedGraphPeople.Node;
import org.vivek.myinterview.graph.core.impl.test.DirectedGraphPeople.NodeImpl;
/*
 * https://stackoverflow.com/questions/58306/graph-algorithm-to-find-all-connections-between-two-arbitrary-vertices
 */
public class DiGraph {
	
	 private static final Node START = new NodeImpl("F");
	    private static final Node END = new NodeImpl("B");
	private static Map<Node, LinkedHashSet<Node>> map = new HashMap();

	public void addEdge(Node node1, Node node2) {
		LinkedHashSet<Node> adjacent = map.get(node1);
		if (adjacent == null) {
			adjacent = new LinkedHashSet();
			map.put(node1, adjacent);
		}
		adjacent.add(node2);
	}
	
	 void addNode(String label) {
	        map.putIfAbsent(new NodeImpl(label), new LinkedHashSet<Node>());
	    }


	public void addTwoWayVertex(Node node1, Node node2) {
		addEdge(node1, node2);
		addEdge(node2, node1);
	}

	public boolean isConnected(Node node1, Node node2) {
		Set adjacent = map.get(node1);
		if (adjacent == null) {
			return false;
		}
		return adjacent.contains(node2);
	}
	
	public int connected(Node node1, Node node2) {
		DiGraph graph = new DiGraph();
		LinkedList<Node> visited = new LinkedList();
		visited.add(node1);
		int dist =depthFirst( graph,  visited,node2,0);
		if (dist <=0 )
		   return -1;
		else
			return dist;
	}

	public LinkedList<Node> adjacentNodes(Node last) {
		LinkedHashSet<Node> adjacent = map.get(last);
		if (adjacent == null) {
			return new LinkedList();
		}
		return new LinkedList<Node>(adjacent);
	}
	public  int depthFirst(DiGraph graph, LinkedList<Node> visited,Node destination, int hops) {
        LinkedList<Node> nodes = graph.adjacentNodes(visited.getLast());
        
        // examine adjacent nodes
        for (Node node : nodes) {
            if (visited.contains(node)) {
                continue;
            }
            if (node.equals(destination)) {
                visited.add(node);
                hops++;
                //printPath(visited);               
                visited.removeLast();
                break;
            }
        }
        for (Node node : nodes) {
            if (visited.contains(node) || node.equals(destination)) {
                continue;
            }
            visited.addLast(node);
            hops++;
            depthFirst(graph, visited,destination,hops);
            visited.removeLast();
        }
       return hops;
    }

    public void printPath(LinkedList<Node> visited) {
        for (Node node : visited) {
            System.out.print(node.name());
            System.out.print( ",");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        // this graph is directional
    	Node A = new NodeImpl("A");
    	Node B = new NodeImpl("B");
    	Node C = new NodeImpl("C");
    	Node D = new NodeImpl("D");
    	Node E = new NodeImpl("E");
    	Node F = new NodeImpl("F");
    	Node G = new NodeImpl("G");
    	Node H = new NodeImpl("H");
    	Node I = new NodeImpl("I");
    	Node J = new NodeImpl("J");
    	Node K = new NodeImpl("K");
        DiGraph graph = new DiGraph();
        graph.addEdge(A, B);
        graph.addEdge(A, C);
        graph.addEdge(A, D);
        graph.addEdge(B, A);
        graph.addEdge(B, D);
        graph.addEdge(B, E); // this is the only one-way connection
        graph.addEdge(B, F);
        graph.addEdge(C, A);
        graph.addEdge(C, E);
        graph.addEdge(C, F);
        graph.addEdge(D, B);
        graph.addEdge(D, G);
        graph.addEdge(D, H);
        graph.addEdge(E, C);
        graph.addEdge(E, F);
        graph.addEdge(E, I);
        graph.addEdge(E, J);
        graph.addEdge(F, B);
        graph.addEdge(F, C);
        graph.addEdge(F, E);
        graph.addEdge(G, K);
        graph.addEdge(G, J);
        graph.addEdge(G, I);
        graph.addEdge(H, I);
        graph.addEdge(H, G);
        graph.addEdge(H, F);
        graph.addEdge(I, A);
        graph.addEdge(I, B);
        graph.addEdge(I, C);
        graph.addEdge(J, D);
        graph.addEdge(J, E);
        graph.addEdge(J, F);
        graph.addEdge(K, G);
        graph.addEdge(K, H);
        graph.addEdge(K, I);
       
        LinkedList<Node> visited = new LinkedList();
        visited.add(F);
        Node destination = new NodeImpl("B");
        int hops= graph.depthFirst(graph, visited,destination,0);
        System.out.println("hops:" +hops);
      
        System.out.println("connected?:" +graph.connected(F, E) );	
    }
    
    interface Node{
    	String name();
    	Set<Node> children();
    }
    
     static class NodeImpl  implements Node{
        String label;
        NodeImpl() {
            
        }
        NodeImpl(String label) {
            this.label = label;
        }
        @Override
        public boolean equals(Object obj) {
            NodeImpl vertex = (NodeImpl) obj;
            return vertex.label == label;
        }
        @Override
        public int hashCode() {
            return label.hashCode();
        }
        @Override
        public String toString() {
            return label;
        }
		@Override
		public String name() {
			// TODO Auto-generated method stub
			return label;
		}
		@Override
		public Set<Node> children() {
			// TODO Auto-generated method stub
			Set<Node> set=(Set) map.values();
			
			return (Set<Node>)set;
		}
		
		
		
		
}
}