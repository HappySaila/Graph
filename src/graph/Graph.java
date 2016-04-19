package graph;
/**
 * 
 * Abstract representation of a simple graph.
 * Edges are undirected, and between any two vertices A, B, there
 * may be at most one edge.
 * 
 * @author Stephan Jamieson
 * @version 1/4/2016
 */
public interface Graph<V, E> {

	/**
	 * Obtain the graph vertices.
	 */
	Iterable<? extends Vertex<V>> getVertices();

	/**
	 * Obtain the graph edges.
	 */
	Iterable<? extends Edge<E>> getEdges();
   
	/**
	 * Obtain the edges incident on the given vertex.
	 */
	Iterable<? extends Edge<E>> getIncidentOn(Vertex<V> vertex);
	
	/**
	 * Obtain the vertices that share an edge with this one.
	 */
	Iterable<? extends Vertex<V>> getNeighbours(Vertex<V> v);
	
	/**
	 * Obtain the pair of vertices connected by this edge.
	 */
	Pair<? extends Vertex<V>> getVertices(Edge<E> e);
   
	/**
	 * Obtain the vertex incident on e that is opposite v.
	 */
	Vertex<V> getOpposite(Vertex<V> v, Edge<E> e);
    
	/** 
	 * Determine whether the given vertices are adjacent.
	 */
	boolean areAdjacent(Vertex<V> v, Vertex<V> w);
   
	/**
	 * Replace the value of vertex v with that given.
	 */
	V replace(Vertex<V> v, V value);
   
	/**
	 * Replace the value of edge e with that given.
	 */
	E replace(Edge<E> e, E value);
   
	/**
	 * Insert a vertex with the given value.
	 */
	Vertex<V> insert(V value);

	/**
	 * Insert an edge with the given value between v and w.
	 * @throws IllegalArgumentException if an edge exists between v and w.
	 */
	Edge<E> insert(Vertex<V> v, Vertex<V> w, E value);
   
	/**
	 * Remove vertex v.
	 */
	V remove(Vertex<V> v);

	/**
	 * Remove edge e.
	 */
	E remove(Edge<E> e); 
   
	/**
	 * Removes marks (if any) from Edges and Vertices in the Graph
	 */
	 void clearMarks();
}
