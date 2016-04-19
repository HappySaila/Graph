package graph;
/**
 * Utility methods for graphs.
 */
public class Graphs {


	public static <V>  List<Vertex<V>> shortestPath(final Vertex<V> vOne, final Vertex<V> vTwo) {
			
			// Set up
		final List<List<Vertex<V>>> paths = new ArrayList<List<Vertex<V>>>();
		final List<Vertex<V>> initialPath = new ArrayList<Vertex<V>>();
		vOne.mark();
		initialPath.add(vOne);	paths.add(initialPath);
			
		List<Vertex<V>> path;
		while (true) {
			path = paths.remove(0);
			final Vertex<V> end = path.get(path.size()-1);
			if (end==vTwo) {
				break;
			}
			else {
				for(Vertex<V> neighbour : graph.getNeighbours(end)) {
					final List<Vertex<V>> newPath = new ArrayList<Vertex<V>>(path);
					if (!neighbour.isMarked()) {
						neighbour.mark();
						newPath.add(neighbour);
						paths.add(newPath);
					}
				}
			}
		}
		graph.clearMarks();
		if (path.size()==1) {
			return null;
		}
		else {
			return path;
		}
	}	

}
