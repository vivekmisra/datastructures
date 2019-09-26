package org.vivek.myinterview.graph.core.impl.test;
import java.util.*;
import java.util.stream.Collectors;

public class DirectedGraphPeople {
	 private Map<NodeImpl, Set<NodeImpl>> adjVertices;

	    DirectedGraphPeople() {
	        this.adjVertices = new HashMap<NodeImpl, Set<NodeImpl>>(10);
	    }

	    void addVertex(String label) {
	        adjVertices.putIfAbsent(new NodeImpl(label), new HashSet<>());
	    }

	    void removeVertex(String label) {
	        NodeImpl v = new NodeImpl(label);
	        adjVertices.values().stream().map(e -> e.remove(v)).collect(Collectors.toSet());
	        adjVertices.remove(new NodeImpl(label));
	    }

	    void addEdge(String label1, String label2) {
	        NodeImpl v1 = new NodeImpl(label1);
	        NodeImpl v2 = new NodeImpl(label2);
	        adjVertices.get(v1).add(v2);
	        adjVertices.get(v2).add(v1);
	    }

	    void removeEdge(String label1, String label2) {
	        Node v1 = new NodeImpl(label1);
	        Node v2 = new NodeImpl(label2);
	        Set<NodeImpl> eV1 = adjVertices.get(v1);
	        Set<NodeImpl> eV2 = adjVertices.get(v2);
	        if (eV1 != null)
	            eV1.remove(v2);
	        if (eV2 != null)
	            eV2.remove(v1);
	    }

	    Set<NodeImpl> getAdjVertices(String label) {
	        return adjVertices.get(new NodeImpl(label));
	    }
	    
	    String printGraph() {
	        StringBuffer sb = new StringBuffer();
	        for(NodeImpl v : adjVertices.keySet()) {
	            sb.append(v);
	            sb.append(adjVertices.get(v));
	        }
	        return sb.toString();
	    }
	    
	    static Set<String> depthFirstTraversal(DirectedGraphPeople graph, String root) {
	        Set<String> visited = new LinkedHashSet<String>();
	        Stack<String> stack = new Stack<String>();
	        stack.push(root);
	        while (!stack.isEmpty()) {
	            String vertex = stack.pop();
	            if (!visited.contains(vertex)) {
	                visited.add(vertex);
	                for (NodeImpl v : graph.getAdjVertices(vertex)) {              
	                    stack.push(v.label);
	                }
	            }
	        }
	        return visited;
	    }

	    static Set<String> breadthFirstTraversal(DirectedGraphPeople graph, String root) {
	        Set<String> visited = new LinkedHashSet<String>();
	        Queue<String> queue = new LinkedList<String>();
	        queue.add(root);
	        visited.add(root);
	        while (!queue.isEmpty()) {
	            String vertex = queue.poll();
	            for (NodeImpl v : graph.getAdjVertices(vertex)) {
	                if (!visited.contains(v.label)) {
	                    visited.add(v.label);
	                    queue.add(v.label);
	                }
	            }
	        }
	        return visited;
	}

	    interface Node{
	    	String name();
	    	Set<Node> children();
	    }
	    
	     class NodeImpl  implements Node{
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
				Set<NodeImpl> nodeImplSet= getAdjVertices(name());
				Set<Node> nodeSet = new HashSet<>();
				for(Node n: nodeImplSet) {
					nodeSet.add(n);
				}
				return (Set<Node>)nodeSet;
			}
			
			
			
			
	}
}
