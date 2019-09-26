package org.vivek.myinterview.graph.core.impl.test;
import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;
import org.vivek.myinterview.graph.core.impl.test.DiGraph.Node;
import org.vivek.myinterview.graph.core.impl.test.DiGraph.NodeImpl;

public class DiGraphPeopleUnitTest {
	 @Test
	    public void testConnected_thenExpectedResult() {
	        DiGraph graph = createGraph();
	        LinkedList<Node> visited = new LinkedList();
	        Node START = new NodeImpl("Bob");
	        Node END = new NodeImpl("Maria");
	        visited.add(START);
	        Assert.assertEquals(2,graph.depthFirst(graph,  visited,END,0));
	    }
	    
	   /* @Test
	    public void givenAGraph_whenTraversingBreadthFirst_thenExpectedResult() {
	        DiGraph graph = createGraph();
	        Assert.assertEquals("[Bob, Alice, Rob, Mark, Maria]", 
	        		graph.breadthFirstTraversal(graph, "Bob").toString());
	    }*/
	    
	    DiGraph createGraph() {
	        DiGraph graph = new DiGraph();
	        DiGraph.Node Bob = new DiGraph.NodeImpl("Bob");
	        DiGraph.Node Alice = new DiGraph.NodeImpl("Alice");
	        DiGraph.Node Mark = new DiGraph.NodeImpl("Mark");
	        DiGraph.Node Rob = new DiGraph.NodeImpl("Rob");
	        DiGraph.Node Maria = new DiGraph.NodeImpl("Maria");
	        
	        graph.addEdge(Bob, Alice);
	        graph.addEdge(Bob, Rob);
	        graph.addEdge(Alice, Mark);
	        graph.addEdge(Rob, Mark);
	        graph.addEdge(Alice, Maria);
	        graph.addEdge(Rob, Maria);
	        return graph;
	}
}
