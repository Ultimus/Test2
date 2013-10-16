import static org.junit.Assert.*;
import org.junit.*;
import static org.junit.Assert.*;
import org.junit.*;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class Lotto{
	public static void main (String[] args){
	

	int n = Integer.parseInt (args[0]);
	int[][] strike = new int [n][6];
		
	tipp (strike);
	for (int i = 0; i < strike.length; i++){
		for (int j = 0; j < strike[0].length; j++){
		if ((j % 6) == 0) System.out.println ("");
		
		System.out.print (strike[i][j]+" ");	
		}
	}
	}
		





	public static int[][] tipp(int [][]strike){
		int[] line= new int [6];

		for (int j = 0; j < strike.length; j++){
			do {

			line =getline();

			}while (compare(strike,line)==true);
			strike[j] = line;
		}
		return sort(strike);
	}


	private static int[] getline(){
		int [] line = new int [6];
		int place = 0;
		
		for (int i = 0; i < 6; i++){
			do{
				place =(int)(1.0+Math.random()*49);
			}while(checkline(line, place));
		line[i] = place;
		}
		return line;
	}



	private static boolean checkline (int[] line, int place){
		for (int i = 0; i < line.length; i++){
			if (line[i] == place){
				return true;
			}
		}
		return false;
	}


	private static int[][] sort (int strike [][]){
	int t;
		for (int i = 0; i < strike.length; i++){
			for (int j = 0; j < strike[0].length; j++){
				for (int k = 0; k < j; k++){
					if (strike[i][k] > strike[i][j]){
						t = strike[i][j];
						strike[i][j] = strike[i][k];
						strike[i][k] = t;
					}
				}
			}
		}
		return strike;
	}
	
						
	private static boolean compare(int[][] strike, int[] search) {
		if(strike[0].length != search.length) {
			return false;
		}

		boolean check;

		for(int i = 0; i < strike.length; i++) {
			check = true;
			for(int x = 0; x < search.length; x++) {
				if(strike[i][x] != search[x]) {
					check = false;
				}
			}
			if(check) {
				return true;
			}
		}
		
		return false;
		}

/*	
	@Test
	public void test_tipp() {
		
		int[][] temp = tipp();
		
		for(int i = 0; i < temp.length; i++) {
			for(int x = 0; x < temp[0].length; x++) {
				System.out.print(temp[i][x] + " ");
			}
			
			System.out.println();
		}
	}
*/	
	@Test
	public void test_compare() {
		assertTrue(compare(new int[][] {{1,2,3,4,5,6}}, new int[] {1,2,3,4,5,6}));
		assertTrue(compare(new int[][] {{2,3,4,5,6,7}, {2,3,4,5,6,8}}, new int[] {2,3,4,5,6,8}));
		assertFalse(compare(new int[][] {{1,2,3,4,5,6}, {2,3,4,5,6,7}}, new int[] {3,4,5,6,7,7}));
		assertFalse(compare(new int[][] {{2,3,4,5,6,7}}, new int[] {1,2,3,4,5,6}));
	}


	@Test
	public void test_checkline() {
		assertTrue(checkline(new int[] {1,2,3,4,5,6}, 5));
		assertFalse(checkline(new int[] {1,2,3,4,5,6}, 13));
	}

	@Test
	public void test_getline() {
		int[] line = getline();
		assertEquals(6, line.length);
		for(int i = 0; i < line.length; i++) {
			System.out.print(line[i] + " ");
		}
	}
	
	@Test
	public void test_sort(){
		int[][] strike = new int[][] {{2,13,46,35,12,7}, {6,47,34,35,28,5}};
		assertArrayEquals (new int[][]{{2,7,12,13,35,46},{5,6,28,34,35,47}}, sort(strike));}





}	
