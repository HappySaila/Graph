package graph;
/**
 *
 * An Entity is a component of a Graph (an Edge or Vertex).
 * It stores a reference to the Graph to which it belongs.
 * It may have a value, and it is markable (to assist 
 * with graph searches).
 * 
 * @author Stephan Jamieson
 * @version 1/4/2016
 */
abstract class GraphEntity<V> {
	
	private Graph graph;
	private V value;
	private boolean marked;
	
	/**
	 * Create a GraphEntity that has the given value 
	 * belongs to the given graph.
	 */
	GraphEntity(final V value, final Graph graph) {
		this.graph = graph;
		this.value = value;
	}

	/**
	 * Set the graph to which this GraphEntity belongs.
	 */
	void setOwner(final Graph graph) {
		assert(this.graph==null);
		this.graph = graph;
	}
		
	/**
	 * Determine whether this GraphEntity belongs to the
	 * given graph.
	 */
	boolean belongsTo(final Graph graph) { return this.graph==graph; }
	
	/**
	 * Obtain the value of this Entity.
	 */
    public V getValue(){ return value; }

	/**
	 * Set the value of this Entity.
	 */
    V setValue(final V value) {
		final V old=this.value;
		this.value=value;
		return old;
	}	
	
	/**
	 * Mark this entity.
	 */
	public void mark() { this.marked=true; }
	
	/**
	 * Clear mark.
	 */
	public void clearMark() { this.marked=false; }
	
	/**
	 * Determine whether this entity has been marked.
	 */
	public boolean isMarked() { return marked; }
}
