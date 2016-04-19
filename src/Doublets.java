import java.io.FileReader;
//
import graph.Vertex;
import graph.Graph;
//
import utils.ClusterBuilder;
//
import java.io.FileNotFoundException;
//
import java.util.List;
import java.util.Map;
/**
 *
 * Solver for Lewis Carrol's Doublets game.
 *
 */
 public class Doublets {
 
	private Map<String, Vertex<String>> wordList;
	private Graph<String, String> graph;
	
	/**
	 * Create a Doublets object for solving problems over the words in the given file.
	 * @throws FileNotFoundException
	 */
	public Doublets(final String wordFile) throws FileNotFoundException {
		// Your code here.
	}

	/**
	 * Obtain the solution to the doublet (wordOne, wordTwo).
	 * Returns null if one or other of the words is not in the lexicon.
	 * Returns an empty list if there is no solution.
	 * Otherwise returns a list of words beginning with wordOne and ending 
	 * in wordTwo, with zero or more intervening words. 
	 * <p>
	 * The list is such that (i) any adjacent pair of words in the list differ
	 * by at most one letter, and (ii) it represents the shortest route from
	 * wordOne to wordTwo.
	 */
	public List<String> solve(final String wordOne, final String wordTwo) { 
		// Your code here.
		return null;
	}
			
	// Your code here.
 }
