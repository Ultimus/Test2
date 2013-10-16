//Berechnungsmethode 06

import static org.junit.Assert.*;
import org.junit.*;

public class Bank67290100{


 public static void main (String [] args){
	//convert(args[0]);

	}


 public static int calc (int number[]){
	int sum = 0;
	int j = 2;
	for (int i = (number.length-1); i  > 0; i--){
		
		if(j == 7){
			j = 2;
		}


		sum += (number[i]*j);
		j++;
	}

	
	int rest = sum % 11;
	int digit = 0;

	if (rest == 0){
		digit = 0;
	}
	else if (rest == 1){
		digit = 0;
	}

	else {
		digit = 11- rest;
	}	
	

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
	int last = 0;	
	for (int i = 0; i < number.length; i++){
		last = number[i];
	}
	if (last == digit){
		return true;
	}
	else{
		return false;
	}
	
	}


//##########################################################TESTS####################################################\\


@Test
public void test_comp(){
assertEquals (true, compare(new int [] {1,2,4,6,7}, 7));
}
@Test
public void test_comp1(){
assertEquals (false, compare (new int[] {1, 3, 3, 7}, 5));
}

/*@Test
public void test_conv(){
assertEquals (new int [] {1, 3, 3, 7}, convert ("1337"));
}
*/

@Test
public void test_calc(){
assertEquals (1, calc(new int[] {9,4,0,1,2,3,4,1}));
}

/*@Test
public void test_cals1(){
assertEquals (0, calc(new int[] {5,0,7,3,3,2,1,0,1,0}));
}
*/




}
