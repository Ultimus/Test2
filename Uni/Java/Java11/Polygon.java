public class Polygon{

	public Polygon (Polygon that){}

	public Polygon (String input){
		String[] in = input.split(",");
		int n = Integer.parseInt (in[0]);

		String[] coords = new String [n];
		boolean[][] connect = new boolean[n][n];

		for (int i = 1; i < in.length; i+=2){
			int arrayPosA = i+n+2;
			int arrayPosB = i+n+3;
			int x = Integer.parseInt(in[arrayPosA]);
			int y = Integer.parseInt(in[arrayPosB]);
			connect[x][y] = true;
		}
		

	}

	/*public int neighbours(boolean[][] poly, int i , int j){
		boolean[][] neighbour = new boolean[7][6];
		poly[i][j] = false;
		gr.removeNode(i, j);
		for (int k = 0; k < edge.length; k++){
			if (edge[k][0] == true){
				edge[][] = true;
			}
		}
		return poly;
*/

	/*public double plane (boolean[][]poly){
		double F = 0;
		for (int i = 0; i < poly.length; i++){
			for (int j = 0; j < poly[0].length; j++){
				if (poly[i][j] == true){
					for (int k = 0; k < edge.length; k++){
						if (edge[k] == true){
							//zugehörigen Punkt finden Koordinaten finden und für Rechnung verwenden
					F += 0.5 * (a[0]* (b[1] - c[1]) + b[0] * (c[1] - a[1]) + c[0] * (a[1] - b[1]));
					poly[i][j] = false;
					
					plane(poly);
				}
			}
		}*/
}
