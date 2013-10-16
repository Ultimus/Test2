public class Graph<Key extends Comparable <Key>>{

	private ST<String, SET<String>> st;
	public Graph (){
		st = new ST<String, SET<String>>();
	}
	
	public Graph (In in){
		st = new St<String, SET<String>>();
		while (!in.isEmpty()){
			String line = in.readLine();
			String[] names = line.split ("/");
			for (int i = 1; i < names.length; i++){
				addEdge (name[0], name[i]);
			}
		}
	}

	public void addEdge (String v, String w){
		if (!st.contains(v)) addVertex (v);
		if (!st.contains (w)) addVertex (w);
		st.get (v).add(w);
		st.get(w).add(v);
		}

	private void addVertex (String v){
		st.put (v, new SET<String>());
	}
	
	public Iterable<String> adjacentTo (String v){
		return st.get (v);
	}

}
