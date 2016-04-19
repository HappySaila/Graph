package graph;


/**
 * Pair class after Apache Commons:
 * <p>
 * http://commons.apache.org/proper/commons-lang/javadocs/api-release/org/apache/commons/lang3/tuple/Pair.html
 * 
 * @author Stephan Jamieson 
 * @version 1/4/2016
 */
public class Pair<T> {


    private T left;
    private T right;
    
    /**
     * Create an ordered pair of the given values.
     */
    public Pair(T left, T right) { 
        this.left=left;
        this.right=right;
    }
    
    /**
     * Obtain the left-hand value.
     */
    public T getLeft() { return left; }

	/**
	 * Obtain the right-hand value.
	 */
    public T getRight() { return right; }
    
    
    /**
     * Obtain an ordered pair of the given values.
     */
    public static <T> Pair<T> of(T left, T right) {
        return new Pair<T>(left, right);
    }
    

    public boolean equals(Object o) {
        if (!(o instanceof Pair<?>)) {
            return false;
        }
        else {
            Pair<?> other = (Pair<?>)o;
            return this.getLeft().equals(other.getLeft()) && this.getRight().equals(other.getRight());
        }
    }
    
    /**
     * Returns a String representation of the form '(left, right)'.
     */
    public String toString() {
        return "("+left.toString()+", "+right.toString()+")";
    }
    
}
