import org.junit.*;
import org.junit.Assert.*;

public class viergewinnt{
 public static int[][] feld = new int [5][6];

 public static void main (String  [] args)
 {
 char gamer = Charakter.parseChar (args [0]); // Symbol von Spieler auswählen
 
 
 for (int x = 0; x < 6; x++)
 {
	System.out.println (feld[x]+'_');
 }
 for (int y = 0; y < 7; y++)
 {
	System.out.println (feld[y]'|');
 }
 if (win == true)
	System.out.println (gamer+"hat das Spiel gewonnen");





 public static boolean checkWin (int[][] feld, char gamer)
 {
	boolean win;
	//horizontale gewinne prüfen
	for (int x = 0; x < 3; x++) 
	{
		for (int y = 0; y < 7; y++)  
		{
			if (feld [x][y] == gamer && feld [x+1][y] == gamer && feld [x+2][y] == gamer && feld [x+3][y] == gamer)
				win = true;
				return win;
		}
	}

	//vertikale prüfen
	for (int x = 0; x < 6; x++)
	{
		for (int y = 0; y < 4; y++)
		{
			if (feld [x][y] == gamer && feld [x][y+1] == gamer && feld [x][y+2] == gamer && feld[x] [y+3] == gamer)
				win = true;
				return win;
		}
	}
	
	//diagonal abfallend prüfen
	for (int x = 0; x < 3; x++)
	{
		for (int y = 3; y < 7; y++)
		{
			if (feld [x][y] == gamer && feld [x+1][y-1] == gamer && feld [x+2][-2] == gamer && [x+3][y-3] == gamer)
				win = true;				
				return win;
		}

	}

	//diagonal steigend prüfen
	for (int x = 0; x < 3; x ++)
	{
		for (int y = 0; y < 4; y++)
		{
			if  (feld [x][y] == gamer && feld [x+1][y+1] == gamer && feld [x+2][y+2] == gamer && [x+3][y+3] == gamer)
				win = true;
  				return win;
		}
	}
	return false;
 }
	 		
	
 public static boolean canset (int [][] feld, int column)
 {
	if (column < 0)
		return false;
	if (column > 6)
		return false;
	

	if (feld[column][y] == 0)
	{
	feld[column][y] = gamer;
	return true;
	}

 }



 public static int set (int[][]feld, int column, int gamer);
 {
	if (feld[column][y] == 0)
	{
		feld[column][y] = gamer;
		//neues Spielfeld ausgeben
		}
	else 
	//spielfeld erneut ausgeben
	
 }








@Test
public void test1 () 
{
int feld = checkwin(1, 3);
char gamer = checkwin('x');
assertEquals = (true, win);
}

@Test
public void test2 ()
{
int feld = checkwin (5, 2);
char gamer = checkwin('o');
assertEquals = (true, win);
}

@Test
public void test3 ()
{
int feld = checkwin (0,3);
char gamer = checkwin('j');
assertEquals = (true, win);
}

@Test 
public void test4 ()
{
int feld = checkwin (3, 7);
char gamer = checkwin('v');
assertEquals = (true, win);
}

@Test
public void test5 ()
{
int feld = checkwin (6,6);
char gamer = checkwin('s');
assertEquals = (false, win);
}

@Test
public void test6 ()
{
int feld = canset (1, 4);
int column = canset (3);
assertEquals = (true);
}

@Test
public void test7 ()
{
int feld = canset (3, 6);
int column = canset (-4);
assertEquals = (false);
}

@Test
public void test8 ()
{
int feld = set (3,3);
int column = set (3);
char gamer = set ('f');
assertEquals = /*neues Spielfeld mit 'f' auf der x achse an Stelle 3, auf höhe der ersten nicht besetzten y -Achsen -Stelle*/
}

