package org.vivek.myinterview.graph.core.impl;

import java.util.ArrayList;
import java.util.List;



public class Vertex<T> {
    long id;
    private T data;
    private List<Edge<T>> connectingEdgeList = new ArrayList<Edge<T>>();
    private List<Vertex<T>> adjacentVertexList = new ArrayList<Vertex<T>>();
    
    public Vertex(long id){
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
    
}
