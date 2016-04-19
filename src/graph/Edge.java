package graph;
/**
 * An Edge object represents an undirected edge in a Graph object.
 * 
 * @author Stephan Jamieson
 * @version 1/4/2016
 */
public abstract class Edge<E> extends GraphEntity<E> {

	/**
	 * Create an Edge with the given value and Asset owner.
	 */
	Edge(final E value, final Graph owner) {
		super(value, owner);
	}

}
