package org.vivek.myinterview.graph.core.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph<T>{

    private List<Edge<T>> allEdges;
    private Map<Long,Vertex<T>> allVertex;
    public boolean isDirected = false;
    
    public Graph(boolean isDirected){
        allEdges = new ArrayList<Edge<T>>();
        allVertex = new HashMap<Long,Vertex<T>>();
        this.isDirected = isDirected;
    }
    //wrapper to connect to vertices given their id
    public void addEdge(long id1, long id2){
        addEdge(id1,id2,0);
    }
    
    //This works only for directed graph because for undirected graph we can end up
    //adding edges two times to allEdges
    //this method is adding vertex(if not added) and associating relevant connecting edge 
    public void addVertex(Vertex<T> vertex){
        if(allVertex.containsKey(vertex.getId())){
            return;
        }
        allVertex.put(vertex.getId(), vertex);
        //get the list of connecting edges for this vertex
        for(Edge<T> edge : vertex.getConnectingEdgeList()){
            allEdges.add(edge);//update edgelist for this graph
        }
    }
    //this methos just puts a vertex in map of vertices
    //this DOES NOT assciate the connecting edge for added vertex
    public Vertex<T> addSingleVertex(long id){
        if(allVertex.containsKey(id)){
            return allVertex.get(id);
        }
        Vertex<T> v = new Vertex<T>(id);
        allVertex.put(id, v);
        return v;
    }
    
    public Vertex<T> getVertex(long id){
        return allVertex.get(id);
    }
    
    public void addEdge(long id1,long id2, int weight){
        // get Vertex from map allVertex
    	//or if not in map allVertex, add new Vertex with id  to map allVertex  get Vertex
    	Vertex<T> vertex1 = createVertex(id1);
        Vertex<T> vertex2 = createVertex(id2);
        //create an edge
        Edge<T> edge = new Edge<T>(vertex1,vertex2,isDirected,weight);
        //update edge list of graph
        allEdges.add(edge);
        //do necessary logic to add  2 vertices
        connectVertices(vertex1, vertex2, edge);

    }

	private void connectVertices(Vertex<T> vertex1, Vertex<T> vertex2, Edge<T> edge) {
		  //update adjacent vertices list
		   //update connecting edge list of vertices
		vertex1.addAdjacentVertex(edge, vertex2);
        if(!isDirected){
            vertex2.addAdjacentVertex(edge, vertex1);
        }
	}

	private Vertex<T> createVertex(long id) {
		Vertex<T> vertex = null;
        if(allVertex.containsKey(id)){
            vertex = allVertex.get(id);
        }else{
            vertex = new Vertex<T>(id);
            allVertex.put(id, vertex);
        }
		return vertex;
	}
    
    public List<Edge<T>> getAllEdges(){
        return allEdges;
    }
    
    public Collection<Vertex<T>> getAllVertex(){
        return allVertex.values();
    }
    public void setDataForVertex(long id, T data){
        if(allVertex.containsKey(id)){
            Vertex<T> vertex = allVertex.get(id);
            vertex.setData(data);
        }
    }

    @Override
    public String toString(){
        StringBuffer buffer = new StringBuffer();
        for(Edge<T> edge : getAllEdges()){
        	if(edge.isDirected()) {
        	buffer.append(edge.getVertex1() + "----->" + edge.getVertex2() + ",weight= " + edge.getWeight());
        	}else {
            buffer.append(edge.getVertex1() + "----- " + edge.getVertex2() + ",weight= " + edge.getWeight());
        	}
            buffer.append("\n");
        }
        return buffer.toString();
    }

	public void printGraph(Graph<Long> g) {
		System.out.println(">>Adjacency List of Directed Graph<<");
		Collection<Vertex<Long>> allVertex = g.getAllVertex();
		  
		for(Vertex<Long> v : allVertex){
			
			List<Edge<Long>> eList = v.getConnectingEdgeList();
			   for(Edge<Long> e: eList) {
				   System.out.println(e.toString());
				   System.out.println(">");
			   }
			   System.out.println("******************");
		}
		
	}
	   public static void main(String args[]) {
			Graph<Long> g = new Graph<Long>(true);
			g.addEdge(0, 1,6);
			g.setDataForVertex(0L, 2L);
			g.addEdge(0, 2);
			g.addEdge(1, 3);
			g.addEdge(2, 3);
			//g.printGraph(g);
			System.out.println(g);
		}



/*static class Vertex<T> {
    long id;
    private T data;
    private List<Edge<T>> connectingEdgeList = new ArrayList<Edge<T>>();
    private List<Vertex<T>> adjacentVertexList = new ArrayList<Vertex<T>>();
    
    Vertex(long id){
        this.id = id;
    }
    
    public long getId(){
        return id;
    }
    
    public void setData(T data){
        this.data = data;
    }
    
    public T getData(){
        return data;
    }
    
    public void addAdjacentVertex(Edge<T> e, Vertex<T> v){
        connectingEdgeList.add(e);//vertex "has-a"/composition relationship with edge,so whenever we add a adjacent vertex, we add connecting edge
        adjacentVertexList.add(v);//self, add v to adjacacent vertex list  to update
    }
    
    public String toString(){
        return String.valueOf(id);
    }
    
    public List<Vertex<T>> getAdjacentVertexes(){
        return adjacentVertexList;
    }
    
    public List<Edge<T>> getConnectingEdgeList(){
        return connectingEdgeList;
    }
    
    
    public int getDegree(){
        return connectingEdgeList.size();
    }
    
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vertex other = (Vertex) obj;
        if (id != other.id)
            return false;
        return true;
    }
    
}*/

/*class Edge<T>{
    private boolean isDirected = false;
    private Vertex<T> vertex1;
    private Vertex<T> vertex2;
    private int weight;
    
    Edge(Vertex<T> vertex1, Vertex<T> vertex2){
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
    }

    Edge(Vertex<T> vertex1, Vertex<T> vertex2,boolean isDirected,int weight){
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.weight = weight;
        this.isDirected = isDirected;
    }
    
    Edge(Vertex<T> vertex1, Vertex<T> vertex2,boolean isDirected){
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.isDirected = isDirected;
    }
    
    Vertex<T> getVertex1(){
        return vertex1;
    }
    
    Vertex<T> getVertex2(){
        return vertex2;
    }
    
    int getWeight(){
        return weight;
    }
    
    public boolean isDirected(){
        return isDirected;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((vertex1 == null) ? 0 : vertex1.hashCode());
        result = prime * result + ((vertex2 == null) ? 0 : vertex2.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Edge other = (Edge) obj;
        if (vertex1 == null) {
            if (other.vertex1 != null)
                return false;
        } else if (!vertex1.equals(other.vertex1))
            return false;
        if (vertex2 == null) {
            if (other.vertex2 != null)
                return false;
        } else if (!vertex2.equals(other.vertex2))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Edge [isDirected=" + isDirected + ", vertex1=" + vertex1
                + ", vertex2=" + vertex2 + ", weight=" + weight + "]";
    }
    
 
    
 
}*/

}