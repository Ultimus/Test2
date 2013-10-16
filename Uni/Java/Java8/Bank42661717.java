//Pruefziffernmethode 34

import static org.junit.Assert.*;
import org.junit.*;

public class Bank42661717{
	public static void main (String[] args){

		//convert (args[0]);


	}
	
	public static int calc (int number[]){
	int digit = 0;

	number[6] = (number[6] * 2);
	number[5] = (number[5] * 4);
	number[4] = (number[4] * 8);
	number[3] = (number[3] * 5);
	number[2] = (number[2] * 10);
	number[1] = (number[1] * 9);
	number[0] = (number [0] * 7);

	for (int i = 0; i < number.length; i++){
		if (number[i] > 10){
		quersumme (number[i]);
		}
	}



	int sum = 0;


	for (int j = 0; j < (number.length-1); j++){
		sum += number[j];
	}



	if (sum % 11 == 0| sum % 11 == 10){
		digit = 0;
	}


	else{
		digit = 11 - sum % 11; 
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
public void test_calc(){
assertEquals (0, calc(new int[] {9,9,1,3,0,0,0,7,0,0}));
}
	
@Test
public void test_calc1(){
assertEquals (0, calc(new int[] {9,9,1,4,0,0,1,0,0,0}));
}


}
