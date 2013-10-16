//Pruefziffernmethode 24

import static org.junit.Assert.*;
import org.junit.*;

public class Bank10010010{
	

	public static void main (String [] args){
	
	//convert (args[0]);
	/*if (compare(number, digit) == true){
		System.out.println ("Die Kontonummer ist gueltig.");
	}
	else{
		System.out.println ("Die Kontonummer ist ungueltig.");
	
	}*/
	}
	public static int calc (int[] number){
	int check = 0;
	int digit = 0;
	int sum = 0;


	for (int i = 3; i <= 6; i++){
		if (number[0] == i){
			number[0] = 0;
		}
	}



		if (number[0] == 9){
			number[0] = 0;
			number[1] = 0;
			number[2] = 0;
		}


		for (int i = 0; i < (number.length-1); i++){
			if (number[i] > 0){
				check = i;
			}
		}

		
		int increment = 1;


		for (int i = check; i < (number.length-1); i++){
			int c = (increment % 3) +1;
			increment++;
			number[i] = number[i] * c + c;
		} 
		
		
		for (int k = 0; k < (number.length-1); k++){
			number[k] = number[k] % 11;
		}
		
		for (int j = 0; j < (number.length-1); j++){
			sum += number[j];
		}
		digit = sum %10;
	
		
	return digit;
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

/*@Test
public void test_calc(){
assertEquals (1, calc(new int[] {1,3,8,3,0,1}));
}
	
@Test
public void test_calc1(){
assertEquals (5, calc(new int[] {1,3,0,6,1,1,8,6,0,5}));
}

@Test
public void test_calc2(){
assertEquals (8, calc(new int[] {3,3,0,7,1,1,8,6,0,8}));
}
*/	
@Test
public void test_calc3(){
assertEquals (3, calc(new int[] {9,3,0,7,1,1,8,6,0,3}));
}



}
