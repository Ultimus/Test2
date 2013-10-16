public class Graph {
	private static int nodes_count;
	private static int connections_count;
	private static String[] nodes;
	private static boolean[][] connections;
	
	public Graph() {
		
	}
	
	public Graph(Graph that) {
		nodes_count = that.getNodesCount();
		nodes = that.getNodes();
		connections_count = that.getConnectionsCount();
		connections = that.getConnections();
	}
	
	public Graph(String input) {
		String[] inputs = input.split(" ");
		
		//Nodes
		setNodesCount(inputs[0]);
		String[] tNodes = new String[nodes_count];
		for(int i = 0; i < nodes_count; i++) {
			tNodes[i] = inputs[i+1];
		}
		setNodes(tNodes);
		
		//Connections
		setConnectionsCount(inputs[nodes_count+1]);
		String[] tConnections = new String[connections_count*2];
		for(int i = 0; i < connections_count*2; i++) {
			tConnections[i] = inputs[i+nodes_count+2];
		}
		setConnections(tConnections);
	}
	
	
	public int minInDegree() {
		int minimal = Integer.MAX_VALUE;
		int pos = 0;
		
		for(int x = 0; x < nodes.length; x++) {
			if(inDegree(x + 1) < minimal) {
				minimal = inDegree(x + 1);
			}
		}
		
		for(int x = 0; x < nodes.length; x++) {
			if(inDegree(x + 1) == minimal) {
				pos = x + 1;
			}
		}
		
		return pos;
	}
	
	public int inDegree(int i) {
		i--;
		int count = 0;
		
		for(int x = 0; x < connections.length; x++) {
			if(connections[x][i]) {
				count++;
			}
		}
		
		return count;
	}
	
	public Graph removeNode(int i) {
		i--;
		if(i < 0 || i > nodes.length) {
			return this;
		}
		
		nodes[i] = null;
		
		for(int x = 0; x < connections.length; x++) {
			connections[x][i] = false;
			connections[i][x] = false;
		}
		
		return this;
	}
	
	public Graph removeEdge(int i, int j) {
		i--; j--;
		if(i < 0 || i > connections.length) {
			return this;
		}
		if(j < 0 || j > connections[0].length){
			return this;
		}
		
		connections[i][j] = false;
		
		return this;
	}
	
	public void setConnections(String[] arg) {
		int[][] input = new int[arg.length / 2][2];
		connections = new boolean[nodes_count][nodes_count];
		int c = 0;
		
		for(int i = 0; i < connections_count; i++) {
			input[i][0] = Integer.parseInt(arg[c]) - 1; c++;
			input[i][1] = Integer.parseInt(arg[c]) - 1; c++;
		}
		
		for(int i = 0; i < connections_count; i++) {
			connections[input[i][0]][input[i][1]] = true;
		}
	}
	
	public boolean[][] getConnections() {
		return connections;
	}
	
	public void setNodes(String[] arg) {
		nodes = new String[nodes_count];
		nodes = arg;
	}
	
	public String[] getNodes() {
		return nodes;
	}
	
	public void setConnectionsCount(String arg) {
		connections_count = Integer.parseInt(arg);
	}
	
	public int getConnectionsCount() {
		return connections_count;
	}
	
	public void setNodesCount(String arg) {
		nodes_count = Integer.parseInt(arg);
	}
	
	public int getNodesCount() {
		return nodes_count;
	}
}
