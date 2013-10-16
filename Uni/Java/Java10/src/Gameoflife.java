import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

public class Gameoflife{

	public static void main (String[] args){
	
	int n = Integer.parseInt (args[0]); // FPS
	int width = Integer.parseInt (args[1]);
	int height = Integer.parseInt (args[2]);
	boolean[] survive = convert(args[3]);
	boolean[] birth = convert(args[4]);
	boolean[][] field = init (width, height);
	
	
	do {
		field = step (field, survive, birth);
		display (field);
		StdDraw.show (1000/n);
	} while (anytrue(field) == true);

	return;
	}



	public static boolean[] convert (String args){
		String[] c = args.split (",");
		boolean[] need = new boolean[9];
		
		for (int i = 0; i < need.length; i++){
			for (int j = 0; j < c.length; j++){
				if (i == Integer.parseInt (c[j]))
					need[i] = true; 
			}
		}
		return need;
	}


	public static boolean anytrue (boolean[][] field){
		for (int x = 0; x < field.length; x++){
			for (int y = 0; y < field[0].length; y++){
				if (field[x][y] == true){
					return true;
				}
			}
		}
		return false;
	}



	public static boolean[][] init (int width, int height){
		boolean[][] field = new boolean[width][height];

		for (int i = 0; i < width; i++){
			for (int j = 0; j < height; j++){
				field[i][j] = false;
			}
		}

		for(int i = 0; i < (width * height) / 2; i++) {
			field[(int)(Math.random()*width)][(int)(Math.random()*height)] = true;
		}		

	return field;
	}



	public boolean [][] copyPattern (boolean[][] field, boolean[][] pattern, int x, int y){
		for (int i = x; i < (pattern.length + x); i++){
			for (int j = y; j < (pattern[0].length+y); j++){
				field[i][j] = pattern [i-x][j-y];
			}
		}
		return field;	
	}


	public static int count (boolean[][] field, int x, int y){
		int alive = 0;

			for (int i = -1; i <= 1; i++){
				for (int j = -1; j <= 1; j++){
					if (((i+x) >= 0) && ((i+x) < field.length)){
						if (((j+y) >=0) && ((j+y) < field[0].length)){
							if (field[i+x][j+y] == true){
								alive++;
							}
						}
					}
				}
			}
			if (field[x][y] == true){
				return (alive-1);
			}
			
		return alive;  
	}
				
	public static boolean newValue (boolean[][] field, boolean[] survives, boolean[] birth, int x, int y){
			
			for (int i = 0; i < 9; i++){
				int cells = count (field, x, y);
				if (survives[i] == true && i == cells || birth[i] == true && i== cells){
					return true;
				}
				
			}
		return false;
	}

	public static boolean[][] step (boolean[][] field, boolean[] survive, boolean[] birth){
		for (int x = 0; x < field.length; x++){
			for (int y = 0; y < field[0].length; y++){
				field[x][y] = newValue (field, survive, birth, x, y);				
			}
		}
		return field;
						 					
	}

	public static void display(boolean[][] field){
	StdDraw.clear();
	StdDraw.setXscale (0,field.length);
	StdDraw.setYscale (0,field[0].length);

		for (int x = 0; x <= field.length; x++){
			for (int y = 0; y <= field[0].length; y++){
				StdDraw.line (x, y, field.length, y);
				StdDraw.line (x, y, x, field[0].length);
			}
		}
		for (int x = 0; x < field.length; x++){
			for (int y = 0; y < field[0].length; y++){
				if (field[x][y] == true){				
					StdDraw.filledRectangle (x+0.5, y+0.5 , 0.5, 0.5);
				}
			}
		}
	}

//Tests!!!

	@Test
	public void test_anytrue(){
	assertFalse(anytrue (init(10,10)));}
	
	@Test
	public void test_convert(){
	boolean[] t1 = {false,false,true,false,false,false,false,false,false};
	boolean[] t2 = convert("2");
	for (int i = 0; i < 9; i++){
		System.out.println(String.format("t1[%d] = %s || t2[%d] = %s", i, t1[i], i, t2[i]));
		assertEquals(t1[i], t2[i]);
	}
	}

	/*@Test
	public void test_init(){
	assertArrayEquals (new boolean[10][10], init (10,10));}
*/
//Der test funktioniert nicht mehr weil ich random Punkte auf true setze, tue ich das nicht, funktioniert der test einwandfrei. 
	
	@Test
	public void test_count(){
	boolean[][]i1 ={ {false,false,false,false},
				  {false,false,false,false},
				  {false,false,false,false},
				  {false,false,false,false}};
	assertEquals (0, count(i1, 1,1));
	assertEquals (0, count (i1, 3,3));
	assertEquals (0, count (i1, 2,1));
	}
	
	@Test
	public void test_count1(){
	boolean[][] i2 ={ {false,false,true,false},
				   {false,true,true,false},
				   {false,false,true,true},
				   {false,false,false,true}};
	assertEquals (3, count(i2, 1,1));
	assertEquals (4, count(i2, 1,2));
	assertEquals (1, count(i2, 3,1));
	}

	@Test
	public void test_newValue(){
	boolean[][]field = init(5,5);
	field [0][0] = true;
	field [1][1] = true;
	field [1][0] = true;
	boolean[] survives = {false, false,true,true,false,false,false,false,false};
	boolean[] birth = {false,false,false,true,false,false,false,false,false}; 
	
	assertTrue (newValue (field,survives,birth, 0,1));
	assertTrue (newValue (field,survives,birth, 1,0));
	}


}
