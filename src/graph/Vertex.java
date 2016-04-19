package graph;
import java.util.HashMap;
import java.util.Map;
/**
 * A Vertex object represents vertex in a Graph object.
 * 
 * @author Stephan Jamieson 
 * @version 1/4/2016
 */
public class Vertex<V> extends GraphEntity<V> {
    
	/**
	 * Create a Vertex with the given value
	 * and belonging to the given Graph.
	 */

	Vertex(final V value, final Graph owner) {
		super(value, owner);
	}
	
}
