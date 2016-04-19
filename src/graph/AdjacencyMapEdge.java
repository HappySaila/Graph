package graph;
/**
 *  
 * An AdjacencyMapEdge<E, V> is the concrete type of Edge<E> object
 * used in the AdjacencyMapGraph<V, E> implementation of Graphh<V,E>.
 * 
 * @author Stephan Jamieson
 * @version 1/4/2016
 */
class AdjacencyMapEdge<E, V> extends Edge<E> {

    private Pair<AdjacencyMapVertex<V, E>> vertices;
    
    /**
     * Create an AdjacencyMap edge with the given vertices and value.
     */
    AdjacencyMapEdge(final AdjacencyMapVertex<V, E> v, final AdjacencyMapVertex<V,E> w, final E value) {
        this(Pair.of(v, w), value);
    }
    
    /**
     * Create an AdjacencyMapEdge with the given pair of vertices and value.
     */
    AdjacencyMapEdge(final Pair<AdjacencyMapVertex<V, E>> vertices, final E value) {
		super(value, null);
        this.vertices=vertices;
    }
    
   
    /**
     * Obtain the pair of vertices indicent on this edge.
     */
    Pair<AdjacencyMapVertex<V, E>> getVertices() { return vertices; }
    	
    /**
     * Obtain the vertex at the opposite end of the edge to v.
     */
    AdjacencyMapVertex<V, E> getOpposite(final AdjacencyMapVertex<V, E> vertex) {
        if (vertices.getLeft().equals(vertex)) {
            return vertices.getRight();
        }
        else if (vertices.getRight().equals(vertex)) {
            return vertices.getLeft();
        }
        else {
            throw new IllegalArgumentException("Vertex not incident on this edge.");
        }
    }
    
    
    /**
     * Replace vertex v with vertex w.
     */
    void replace(final AdjacencyMapVertex<V, E> v, final AdjacencyMapVertex<V, E> w) {
			if (vertices.getLeft().equals(v)) {
				vertices = Pair.of(w, vertices.getRight());
			}
			else if (vertices.getRight().equals(v)) {
				vertices = Pair.of(vertices.getLeft(), w);
			}
			else {
				throw new IllegalArgumentException("Vertex not incident on this edge.");
			}
	}
	
    /**
     * Returns a String representation of the form 'edge((v, w), value)'.
     */
	public String toString() { return "edge("+vertices+", "+getValue()+")"; }
}
