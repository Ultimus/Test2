import static org.junit.Assert.*;
import org.junit.*;

public class SchleifenA{

	public static boolean count (int i){  //findet primzahlen	
		boolean check = true;
		for (int j = 2; j < i; j++){
			if ((i % j) == 0){
				check = false;
				
			}
		}
		return check;
	}



	public static void main (String[] args){
	int[] prime = new int [97];
	int place = 0;

	for (int i = 0; i <= 500; i++){
		if (count(i) == true){
			prime[place] = i;
			place++;
		}
	}

	for (int j = 0; j < prime.length - 1; j++){
		if ((prime[j]+2) == prime[j+1]){
			if (((prime[j]+1) % 3) == 0) {
				System.out.println(prime[j]+1);
			}
		}
	}
	}

@Test
public void test_count1(){
assertTrue (count(5));}

@Test
public void test_count2(){
assertfalse (count(4));}
	
}
