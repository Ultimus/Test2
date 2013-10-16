import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GraphTest {
	@Test
	public void test_Graph() {
		Graph gr = new Graph("4 first second third fourth 6 1 4 1 3 2 2 2 4 4 3 2 1");
		
		assertEquals(4, gr.getNodesCount());
		
		assertArrayEquals(new String[] {"first", "second", "third", "fourth"}, gr.getNodes());
		
		assertEquals(6, gr.getConnectionsCount());
		
		boolean[][] t = {	{false, false, true, true},
							{true, true, false, true},
							{false, false, false, false},
							{false, false, true, false}};
		boolean[][] o = gr.getConnections();
		for(int i = 0; i < t.length; i++) {
			for(int x = 0; x < t[0].length; x++) {
				assertEquals(t[i][x], o[i][x]);
			}
		}
		
		//Graph(Graph that)
		
		Graph gr2 = new Graph(gr);
		
		assertEquals(4, gr2.getNodesCount());
		
		assertArrayEquals(new String[] {"first", "second", "third", "fourth"}, gr2.getNodes());
		
		assertEquals(6, gr2.getConnectionsCount());
		
		boolean[][] t2 = {	{false, false, true, true},
							{true, true, false, true},
							{false, false, false, false},
							{false, false, true, false}};
		boolean[][] o2 = gr2.getConnections();
		for(int i = 0; i < t.length; i++) {
			for(int x = 0; x < t2[0].length; x++) {
				assertEquals(t2[i][x], o2[i][x]);
			}
		}
	}
	
	@Test
	public void test_minInDegree() {
		Graph gr = new Graph("4 first second third fourth 7 1 4 1 3 2 2 2 4 4 3 2 1 1 2");
		assertEquals(1, gr.minInDegree());
		
		gr = new Graph("4 first second third fourth 7 1 4 1 3 2 2 2 4 4 3 2 1 1 1");
		assertEquals(2, gr.minInDegree());
	}
	
	@Test
	public void test_inDegree() {
		Graph gr = new Graph("4 first second third fourth 6 1 4 1 3 2 2 2 4 4 3 2 1");
		
		assertEquals(1, gr.inDegree(1));
		assertEquals(2, gr.inDegree(3));
	}
	
	@Test
	public void test_removeNode() {
		Graph gr = new Graph("4 first second third fourth 6 1 4 1 3 2 2 2 4 4 3 2 1");
		gr.removeNode(1);
		
		boolean[][] t = {	{false, false, false, false},
							{false, true, false, true},
							{false, false, false, false},
							{false, false, true, false}};
		boolean[][] o = gr.getConnections();
		for(int i = 0; i < t.length; i++) {
			for(int x = 0; x < t[0].length; x++) {
				assertEquals(t[i][x], o[i][x]);
			}
		}
	}
	
	@Test
	public void test_removeEdge() {
		Graph gr = new Graph("4 first second third fourth 6 1 4 1 3 2 2 2 4 4 3 2 1");
		gr.removeEdge(1, 4);
		
		boolean[][] t = {	{false, false, true, false},
							{true, true, false, true},
							{false, false, false, false},
							{false, false, true, false}};
		boolean[][] o = gr.getConnections();
		for(int i = 0; i < t.length; i++) {
			for(int x = 0; x < t[0].length; x++) {
				assertEquals(t[i][x], o[i][x]);
			}
		}
	}
	
	@Test
	public void test_setConnections() {
		Graph gr = new Graph();
		
		gr.setNodesCount("4");
		gr.setConnectionsCount("6");
		gr.setConnections(new String[] {	"1", "4",
											"1", "3",
											"2", "2",
											"2", "4",
											"4", "3",
											"2", "1"});
		boolean[][] t = {	{false, false, true, true},
							{true, true, false, true},
							{false, false, false, false},
							{false, false, true, false}};
		boolean[][] o = gr.getConnections();
		
		for(int i = 0; i < t.length; i++) {
			for(int x = 0; x < t[0].length; x++) {
				assertEquals(t[i][x], o[i][x]);
			}
		}
	}
	
	@Test
	public void test_setNodes() {
		Graph gr = new Graph();
		
		gr.setNodes(new String[] {"1", "2", "3"});
		assertArrayEquals(new String[] {"1", "2", "3"}, gr.getNodes());
	}
	
	@Test
	public void test_setConnectionsCount() {
		Graph gr = new Graph();
		
		gr.setConnectionsCount("3");
		assertEquals(3, gr.getConnectionsCount());
	}
	
	@Test
	public void test_setNodesCount() {
		Graph gr = new Graph();
		
		gr.setNodesCount("3");
		assertEquals(3, gr.getNodesCount());
	}
}
