import org.junit.Assert.*;
import org.junit.*;

public class hanoi{

  public int [][] init(){
	int sticks [][] = new int [3][6];
	
	for (int i = 0; i < 6; i ++){
	sticks [0][i] = 6 - i;
	}

	
  }

  public boolean win (int [][]){
  int counter = 0;
	for ( int i = 0; int i < 6 ; i++){
		if (sticks [3][i] == 0)
			counter++;
	}
	if (counter==6)
		return true;   
  }

  public boolean valid (int[][] sticks){
  	for (int i = 0; i < 3; i++){
		for (int j = 0; j < 5; j++){
			if (sticks [i][j] < sticks [i][j+1])
				return false;
			}
		}
	return true;
	}
	
  }


  public int[][] move (int[][] sticks, int from, int to){
	if (from < 0 || from > 2)
		return sticks;
	if (to < 0 || to > 2)
		return sticks;

	for (int i = 5; i >= 0; i--){
		for (int j = 0; j < 6; j++){
			if (sticks [to][j] == 0){
				if (valid (sticks[to][j]) == true){
		
					sticks [to][j] = sticks [from][i];
					sticks [from][i] = 0;
				}
				else {
					return sticks;
				}
	}
	return sticks;
  }


@Test
public void test1 {
int[][] = init([0][3]);
assertEquals = (4 ,sticks);
}					
		
@Test
public void test2 {
int counter = win(4);
assertEquals = (false, win);
}

@Test
public void test3 {
int counter = win(6);
assertEquals = (true, win);
}

@Test
public void test4 {
int[][] sticks = valid([0][0]);
assertEquals = (true, valid);
}

@Test
public void test5 {
int [][] sticks= valid ([0][2]);
int [][] sticks= valid ([0][1]);
assertEquals = (false, valid);
}

@Test
public void test6 {
int from = move(4);
assertEquals = (false, move);
}

@Test
public void test7 {
int[from][] sticks = move ([1][]);
int[to][] sticks = move ([2][])
assertEquals = (sticks [from][0], sticks [to][!=0], sticks[][]);
}
}
