public class Graph{
	private int n;
	private int k;
	private String[] knoten;
	private boolean[][] kanten;


	public Graph (Graph that){
	}

	public Graph (String input){
		String[] data = input.split(" ");
		
		n = Integer.parseInt(data[0]);
		k = Integer.parseInt(data[n+1]);

		knoten = new String[n];
		kanten = new boolean[n][n];

		for(int i = 0; i < n; i++) {
			knoten[i] = data[i+1];
		}

		for(int i = 0; i < k*2; i+=2) { // Graph("2 nodeA nodeB 3 1 1 1 2 2 1")
			int arrayPosA = i+n+2;
			int arrayPosB = i+n+3;
			int x = Integer.parseInt(data[arrayPosA]);
			int y = Integer.parseInt(data[arrayPosB]);
			kanten[x][y] = true;
		}
	}
	
	public Graph removeEdge (int i, int j){
		if (i < 0 || i > kanten.length) return this;
		if (j < 0 || j > kanten[0].length) return this;
		kanten[i][j] = false;
		return this;
	}

	public Graph removeNode (int i){
		
		if (i < 0 || i > kanten.length) return this;
		for (int a = 0; a < kanten.length; a++){
			kanten[a][i] = false;
		}
		for (int b = 0; b < kanten.length; b++){
			kanten[i][b] = false;
		}
		knoten[i] = null;

		return this;
	}

	
	public int inDregree (int i){
		int count = 0;
		for (int j = 0; j < kanten[0].length; j++){
			if (kanten[0][j] == true){
				count++;
			}
		}
		return count;
	}


	public int minInDegree (int i,boolean[][] kanten ){
		int[] count = new int [kanten.length];

		for (int j = 0; j < kanten.length; j++){
			for (int k = 0; k < kanten[0].length; k++){
				count[j]++;
			}
		}
		
		int min = 0;
		for (int seek = 0; seek<= count.length; seek++){
			if (min < count[seek]){
				min = count[seek];
			}
		}
		return min;
	}

/*
@Test
public void test_removeEdge(){
assertfalse (removeEdge (5, 5));}

@Test
public void test_minInDegree(){
assertEquals (2, minInDegree (2
*/

}
