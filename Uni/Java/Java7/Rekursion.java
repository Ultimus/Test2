import static org.junit.Assert.*;
import org.junit.*;

public class Rekursion{

	public static void main (String args[]){
	int a = 4;
	int b = 8;
	int n = 5;
	int m = 2;
	System.out.println (add (a,b));
	System.out.println (fac (n));
	System.out.println (ack (m, n));
	}

	public static long fac (long n){
		if (n == 1){
			return n;
		}
		if (n > 0){
			n*= fac(n-1);
		}
		
	return n;
	}
	
	@Test public void test_R1(){
	assertEquals(120, fac (5));}

	@Test public void test_R2(){
	assertEquals(0, fac (0));}

	

	public static int add(int a, int b){
	
	if (a >= 0 && b >= 0){
		if (a > 0){
			b = add (a-1, b + 1);
		}
	
	}
	return b;
	}
	
	@Test public void test_R3(){
	assertEquals(0, add (0,0));}

		@Test public void test_R4(){
	assertEquals(12, add (8,4));}


	public static int ack (int m , int n){
	
	if (n == 0){
	m+= 1;
	}
	if (m == 0 && n > 0){
	ack(n-1, m = 1);
	}
	if (n > 0 && m > 0){
	ack(n-1, ack(n, m-1));
	}
	return n;
	}

	@Test public void test_R5(){
	assertEquals (1, ack (1, 1));}	

	@Test public void test_R6(){
	assertEquals (0, ack (0,0));}
	


	public static double intervall (double a, double b, double c, double eps){
	if (Math.abs (a-b)< eps){
	return a;
	}

	if ((Math.abs (a-b)) >= eps && ((((a+b)/2)* ((a+b)/2)) - c) > 0){
	return intervall (b = ((a+b)/2), a, b, eps);
	
	}else{
	return intervall (a = ((a + b)/2), b, c , eps);
	}
	}

	
}
	
	
