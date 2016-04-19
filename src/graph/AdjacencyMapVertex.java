package graph;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/**
 * 
 * An AdjacencyMapVertex<V, E> is the concrete type of Vertex<V> object
 * used in the AdjacencyMapGraph<V, E> implementation of Graphh<V,E>.
 * <p>
 * As its name suggests, an AdjacencyMapVertex stores a map of the edges
 * incident upon it. 
 * <p>
 * The map contains (key, value) pairs of AdjacencyMapVertex
 * and AdjacencyMapEdge. The key is a neighbour, and the value is the
 * edge that connects them. 
 * 
 * 
 * @author Stephan Jamieson 
 * @version 1/4/2016
 */
class AdjacencyMapVertex<V, E> extends Vertex<V> {
    
    private Map<AdjacencyMapVertex<V, E>, AdjacencyMapEdge<E, V>> edges;

	/**
	 * Create an AdjacencyMapVertex with the given value.
	 */
    AdjacencyMapVertex(final V value) { 
		super(value, null);
		this.edges = new HashMap<AdjacencyMapVertex<V, E>, AdjacencyMapEdge<E, V>>();
	}
	
     
	/**
	 * Obtain the edges incident on this vertex.
	 */
	Iterable<AdjacencyMapEdge<E, V>> getIncidentOn() { return edges.values(); }
	
	/**
	 * Obtain this vertices neighbours (i.e. those vertices to which it is
	 * connected by an edge.)
	 */
	Iterable<AdjacencyMapVertex<V, E>> getNeighbours() { return edges.keySet(); }
	
	/**
	 * Determine whether this vertex is adjacent to that given. (i.e. that the
	 * given vertex is in the adjacency map.)
	 */
	boolean isAdjacentTo(final AdjacencyMapVertex<V, E> other) { 
		// Your code here
		return false;
	}
	
	/**
	 * Insert the given edge into the adjacency map.
	 */
	void insert(final AdjacencyMapEdge<E, V> edge) { 
		// Your code here
	}
	
	/**
	 * Remove the given edge (and associated vertex) from the adjacency
	 * map. 
	 */
	void remove(final AdjacencyMapEdge<E, V> edge) { 
		// Your code here
	}
	
	/**
	 * Remove the given vertex (and associated edge) from the adjacency
	 * map.
	 */
	void remove(final AdjacencyMapVertex<V, E> vertex) {
		// Your code here
	}
	
	/**
	 * Obtain a String representation of this vertex of the form 'vertex(value)'.
	 */
	public String toString() { return "vertex("+getValue()+")"; }
	
	/**
	 * Obtain a dump (for debugging purposes) of the internal representation
	 * of this vertex.
	 */
	public void dump() {
		System.out.print("\nVertex: value="+getValue()+" edges=[");
		
		Iterator<AdjacencyMapVertex<V, E>> iterator = edges.keySet().iterator();
		if (iterator.hasNext()) {
			System.out.print(edges.get(iterator.next()));
			while (iterator.hasNext()) {
				System.out.print(", "+edges.get(iterator.next()));
			}
		}
		System.out.print(']');
	}
		
}
