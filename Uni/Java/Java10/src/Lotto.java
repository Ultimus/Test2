import static org.junit.Assert.*;
import org.junit.*;

public class Lotto {
	public static void main(String[] args) {
		if(args.length != 1) {
			System.out.println("Error:\nUsage: java Lotto [count]\n- Example: java Lotto 2000");
			return;
		}
		
		print(fill(Integer.parseInt(args[0])));
	}
	
	//print
	private static void print(int[][] numbers) {
		for(int i = 0; i < numbers.length; i++) {
			for(int x = 0; x < numbers[0].length; x++) {
				System.out.print(String.format("%d ", numbers[i][x]));
			}
			System.out.println();
		}
	}
	
	
	
	private static int[][] fill(int n) {
		int[][] numbers = init(n);
		int[] sequence = new int[6];
		
		
		for(int i = 0; i < numbers.length; i++) {
			do {
				sequence = getSequence();
			} while(inArray(numbers, sequence));
			
			numbers[i] = sequence;
		}
		
		return numbers;
	}
	
	
	
	private static int[] getSequence() {
		int[] seq = new int[6];
		int current;
		
		for(int i = 0; i < 6; i++) {
			do {
				current = (int)(1.0+Math.random()*49);
			} while(inArray(seq, current));
			
			seq[i] = current;
		}
		
		return seq;
	}
	
	
	
	private static boolean inArray(int[] array, int number) {
		for(int i = 0; i < array.length; i++) {
			if(array[i] == number) {
				return true;
			}
		}
		
		return false;
	}
	
	
	
	private static int[][] insert(int[][] array, int[] object) {
		if(array[0].length != object.length) {
			return array;
		}
		
		for(int i = 0; i < array.length; i++) {
			if(array[i][0] == 0) {
				array[i] = object;
				
				return array;
			}
		}
		
		return array;
	}
	
	private static int[][] init(int n) {
		return new int[n][6];
	}	
	

	private static boolean inArray(int[][] array, int[] search) {
		if(array[0].length != search.length) {
			return false;
		}

		boolean check;

		for(int i = 0; i < array.length; i++) {
			check = true;
			for(int x = 0; x < search.length; x++) {
				if(array[i][x] != search[x]) {
					check = false;
				}
			}
			if(check) {
				return true;
			}
		}
		
		return false;
	}
	
	//init
	@Test
	public void test_init() {
		assertArrayEquals(new int[][] {{0,0,0,0,0,0}}, init(1));
	}
	


	//fill
	@Test
	public void test_fill() {
		System.out.println("test_fill()");
		
		int[][] t = fill(2);
		
		for(int i = 0; i < t.length; i++) {
			for(int x = 0; x < t[0].length; x++) {
				System.out.print(t[i][x] + " ");
			}
			
			System.out.println();
		}
	}
	
	//inArray
	@Test
	public void test_inArray() {
		assertTrue(inArray(new int[][] {{1,2,3,4,5,6}}, new int[] {1,2,3,4,5,6}));
		assertFalse(inArray(new int[][] {{2,3,4,5,6,7}}, new int[] {1,2,3,4,5,6}));
		assertTrue(inArray(new int[][] {{1,2,3,4,5,6}, {2,3,4,5,6,7}}, new int[] {2,3,4,5,6,7}));
		assertTrue(inArray(new int[][] {{2,3,4,5,6,7}, {2,3,4,5,6,8}}, new int[] {2,3,4,5,6,8}));
		assertFalse(inArray(new int[][] {{1,2,3,4,5,6}, {2,3,4,5,6,7}}, new int[] {3,4,5,6,7,7}));
	}

	//insert
	@Test
	public void test_insert() {
		int[][] t = init(2);
		insert(t, new int[] {1,2,3,4,5,6});
		
		assertArrayEquals(new int[][] {{1,2,3,4,5,6}, {0,0,0,0,0,0}}, t);
	}

	//inArray
	@Test
	public void test_inArray2() {
		assertTrue(inArray(new int[] {1,2,3,4,5,6}, 3));
		assertFalse(inArray(new int[] {1,2,3,4,5,6}, 7));
	}

	//getSequence
	@Test
	public void test_getSequence() {
		System.out.println("test_getSequence()");
		
		int[] seq = getSequence();
		assertEquals(6, seq.length);
		for(int i = 0; i < seq.length; i++) {
			System.out.print(seq[i] + " ");
		}
	}

}
