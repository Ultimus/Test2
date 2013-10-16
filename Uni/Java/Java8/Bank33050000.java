//Prüfziffernmethode 00

import static org.junit.Assert.*;
import org.junit.*;

public class Bank33050000{
	public static void main (String [] args){
		//convert (args[0]);

	}

	public static int calc (int number[]){
	int sum = 0;
	int zwsum = 0;
	int digit = 0;

	for (int i = (number.length - 1); i > 0; i= i-2){
		sum += number[i];
	}

	for (int j = (number.length-1); j > 0; j = j -2){	//hässlich
		if ((number[j]* 2)> 10){
			int zahl = (number[j] * 2);			
			quersumme (zahl);
			zwsum += zahl;
			zahl = 0;
			}
				
		else {
		zwsum += number[j] * 2;
		}
				
	}

	int rest = (sum + zwsum) % 10;


	if (rest == 0){
		digit = 0;}
	else{
		digit = 10 - rest;
	}
	
	return digit;
	}

	



	public static int quersumme (int zahl){
		int sqr = zahl%10 + zahl/10;
		return (sqr);
	}
	

		public static int[] convert (String[] KTNR){
	int[] number = new int [KTNR.length];	

	for (int i = 0; i < (KTNR.length-1); i++){
		number[i] = Integer.parseInt (KTNR[i]);
	}
	return number;
	}

	

	public static boolean compare (int[] number, int digit){
	if (number[number.length] == digit){
		return true;
	}
	else{
		return false;
	}

	}
 
//############################################################TESTS###############################################\\

@Test
public void test_quer(){
assertEquals (8, quersumme (17));
}

@Test
public void test_quer1(){
assertEquals (10, quersumme (64));
}

/*@Test
public void test_calc(){
assertEquals(1, calc (new int[] {9,2,9,0,7,0,1}));
}
*/
@Test
public void test_calc1(){
assertEquals (8, calc(new int[] {5,3,9,2,9,0,8,5,8}));
}

@Test
public void test_calc2(){
assertEquals (4, calc(new int[] {1,5,0,1,8,2,4}));
}
/*
@Test
public void test_calc3(){
assertEquals (2, calc(new int[] {1,5,0,1,8,3,2}));
}
*/


}
	
