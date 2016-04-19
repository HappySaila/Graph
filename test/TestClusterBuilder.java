import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;
//
import java.io.CharArrayReader;
//
import java.util.List;
//
import utils.ClusterBuilder;
/*
* JUnit test class for ClusterBuilder
*
* @author Stephan Jamieson
* @version 1/4/2016
*/
public class TestClusterBuilder {

	
	@Test
	public void testEmptyStream() {
		final ClusterBuilder builder = new ClusterBuilder(new CharArrayReader("".toCharArray()));
		assertFalse(builder.hasNext());
	}
	
	@Test
	public void testOneWordStream() {
		final ClusterBuilder builder = new ClusterBuilder(new CharArrayReader("word".toCharArray()));
		assertFalse(builder.hasNext());
	}
	
	@Test
	public void testTwoWordStreamOneCluster() {
		final ClusterBuilder builder = new ClusterBuilder(new CharArrayReader("word\nward".toCharArray()));
		assertTrue(builder.hasNext());
		final List<String> cluster = builder.next();
		assertTrue(cluster.size()==2);
		assertFalse(builder.hasNext());
	}

	@Test
	public void testFourWordStreamOneCluster() {
		final ClusterBuilder builder = new ClusterBuilder(new CharArrayReader("weed\nword\nwing\nward\nwide".toCharArray()));
		assertTrue(builder.hasNext());
		final List<String> cluster = builder.next();
		assertTrue(cluster.size()==2);
		assertTrue(cluster.contains("word"));
		assertTrue(cluster.contains("ward"));
		assertFalse(builder.hasNext());
	}

	@Test
	public void testFourWordStreamTwoClusters() {
		final ClusterBuilder builder = new ClusterBuilder(new CharArrayReader("weed\nword\nwing\nward\nwide\nwood".toCharArray()));
		assertTrue(builder.hasNext());
		List<String> cluster = builder.next();
		assertTrue(cluster.size()==2);
		assertTrue(builder.hasNext());
		cluster = builder.next();
		assertTrue(cluster.size()==2);
	}

	@Test
	public void testLeftBoundary() {
		final ClusterBuilder builder = new ClusterBuilder(new CharArrayReader("lord\n\nword\n\nwool\nwide\ncord".toCharArray()));
		assertTrue(builder.hasNext());
		List<String> cluster = builder.next();
		assertTrue(cluster.size()==3);
		assertFalse(builder.hasNext());
	}

	@Test
	public void testRightBoundary() {
		final ClusterBuilder builder = new ClusterBuilder(new CharArrayReader("word\n\nweed\nwort\nwool\nworn\ncard".toCharArray()));
		assertTrue(builder.hasNext());
		List<String> cluster = builder.next();
		assertTrue(cluster.size()==3);
		assertFalse(builder.hasNext());
	}
}
