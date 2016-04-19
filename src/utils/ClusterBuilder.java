package utils;
import java.io.Reader;
//
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
/**
 * The class provides a means of, given a list of strings (words) all
 * the same length,  arranging them into clusters such that the members 
 * of a cluster all differ by exactly the ith letter.
 * <p>
 * e.g.  the 3rd letter is the only difference between the words 
 * "heap", "hemp", and "help". Thus these words form a cluster.
 * <p>
 * A cluster always contains two or more words i.e. words that don't fit
 * in any cluster are discarded.
 * <p>
 * Algorithm based on Knuth, "The Stanford GraphBase: {A} Platform 
 * for Combinatorial Algorithms", Proceedings of the Fourth Annual 
 * ACM/SIGACT-SIAM Symposium on Discrete Algorithms, 25-27 January 
 * 1993, Austin, Texas.
 * 
 * @author Stephan Jamieson
 * @version 1/4/2016
 */
public class ClusterBuilder {

	private Iterator<List<String>> iterator;
	private List<String> nextCluster;
	/**
	 * Create a ClusterBuilder for obtaining clusters of words from
	 * the given list.
	 */
	public ClusterBuilder(final Reader input) {
		final Map<String, List<String>> clusters = new HashMap<String, List<String>>();
		final Scanner scanner = new Scanner(input);
		
		while(scanner.hasNext()) {
			final String word = scanner.nextLine();
			for (int i=0; i<word.length(); i++) {
				final String cluster = word.substring(0, i)+'*'+word.substring(i+1, word.length());
				if (clusters.containsKey(cluster)) {
					clusters.get(cluster).add(word);
				}
				else {
					final List<String> wordMatches = new ArrayList<String>();
					wordMatches.add(word);
					clusters.put(cluster, wordMatches);
				}
			}
		}
		this.iterator = clusters.values().iterator();
		this.getNextCluster();
	}	
	
	/**
	 * Get next cluster to be returned by next(), filtering out clusters 
	 * of size one.
	 */
	private void getNextCluster() {
		while(iterator.hasNext()) {
			nextCluster=iterator.next();
			if (nextCluster.size()>1) {
				return;
			}
		}
		nextCluster = null;
	}
	
	/** 
	 * Obtain the next cluster of words.
	 */
	public List<String> next() { 
		final List<String> result = nextCluster; 
		this.getNextCluster();
		return result; 
	}
	
	
	/** 
	 * Returns true if there is another cluster, false otherwise.
	 */
	public boolean hasNext() { return nextCluster!=null; }
	
}
