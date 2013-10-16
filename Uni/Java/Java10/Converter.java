import static org.junit.Assert.*;
import org.junit.*;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class Converter{

	public static void main (String[] args){
	int n = Integer.parseInt(args[0]);
	System.out.println ("Oktal: "+octal(n));
	System.out.println ("Binär: "+binar(n));
	System.out.println ("Hexadezimal: "+hex(n));
	}
	
	public static String hex(int n) {
		StringBuilder sb = new StringBuilder();
		if (n <= 0) return "0";
		
		do {
			if((n % 16) > 9) {
				sb.append((char)((n % 16)+87));;
			}
			else{
				sb.append ((n % 16));
			}
		n/=16;

		} while(n > 0);

		return sb.reverse().toString();
	}

	public static String octal (int n){
		StringBuilder sb = new StringBuilder();
		
		do {
			sb.append((n % 8));
			n /= 8;

		}while ((n / 8) != 0); 
		
		if ((n % 8) != 0){

			sb.append((n % 8));
		}
															// /-/4xX0|2
		return sb.reverse().toString();
	} 

	public static String binar (int n){ 
		if (n == 0){
			return "0";
		}
		StringBuilder bin = new StringBuilder();
	
		int i = 0;
		while (n > 0){
			i = n % 2;
			if (i > 0){
				bin.append ("1");
			}else{
				bin.append ("0");
			}
			n /= 2;
		}
		return bin.reverse().toString();
	}

/*
	public static int oktal (int n){
		int count = 0;
		for (int i = 0; i < n; i++){
			count++;
			if (String.valueOf(count).endsWith ("8")){
				count+=2;
			}
			 
		}
		return count;
	}			
*/


@Test
public void test_binar(){
assertEquals ("1100", binar(12));}

@Test
public void test_binar1(){
assertEquals ("1", binar (1));}

@Test
public void test_binar2(){
assertEquals ("11111", binar (31));}

@Test
public void test_octal1(){
assertEquals ("10", octal (8));}

@Test
public void test_octal2(){
assertEquals ("14", octal (12));}


@Test
public void test_hex1(){
assertEquals ("a", hex (10));}

/*@Test//String exception
public void test_hex2(){
assertEquals ("affe0815" hex(2952661013));}
*/
}
