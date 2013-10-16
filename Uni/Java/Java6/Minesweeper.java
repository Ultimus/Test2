public class Minesweeper{
	
	public static void main (String[] args){
		int width = Integer.parseInt [0];
		int height = Integer.parseInt [1];
		int n = Integer.parseInt [2];
	}

	public static int [][] randomPositions (int width, int height, int n){


		int [][]mines = new int [width][height];
		

		for (int i = 0; i < n; i++){
			mines [(int) (Math.random()*width)][(int) (Math.random() * height)] = -1;
		}
		
		return mines;
	}

	public static int createField(int width, int height, int[][] mines){
		int field = new int[width][height];
		
		for (int i = 0; i < field.length; i ++){
			for (int j = 0; j < field[0].length; j++){
			field[i][j] = mines [i][j];
			}
		}
		
		//Spielfeld erzeugen
	
		for (int x = 0; x < field.length; x++){
		for (int y = 0; y < field[0].length; y++){
		System.out.println (field[i][j]);

	}
		
	public static int[][]field;


	public static boolean[][] known;

	public static void start(int width, int height, int nrMines){
	
		spielFeld = createField (width, height, randomPositions(width, height, nrMines));

		known = new boolean [width][height];
	}



	public static boolean lost(int[][] field, boolean[][]known){
		
		for (int i = 0; i < field.length; i++){
			for (int j = 0; j < field[0].length; j++){
				if (field [i][j] == -1 && known[i][j] == true){
					return true;
				}
			}
		}
		return false;
	}

	public static String createLineString (int[][] field, int i){
		char LS[] = new char[];

		if (i >= 0 && <= field[0].length){

		for	(int j = 0; j < field[0].length; j++){
			if (known[i][j]	== false){
				LS[j] = ' ';
			}
			if (known[i][j] == true){
				if (field[i][j] = =-1){
					LS[j] = "-1";
				}
			}
		}

		} 
		
	}


		 		
}
		
