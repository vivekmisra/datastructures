package org.vivek.myinterview.graph.core;

import java.util.Collection;
import java.util.Set;



public interface IGraph<T> {
	 boolean addVertex(T t);

     Double addEdge(Integer from, Integer to);

     boolean addEdge(Integer from, Integer to, Double weight);

     boolean removeVertex(Integer t);

     boolean removeEdge(Integer from, Integer to);

     Set<Integer> getVertices();


     Set<Integer> getNeighbors(Integer ver);
     int size();
}
