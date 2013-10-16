import static org.junit.Assert.*;
import org.junit.*;

public class Geometrie{
	public static void main (String[] args){

	int[] a = convert(args[0]);
	int[] b = convert(args[1]);
	int[] c = convert(args[2]);


	
	System.out.println ("Der Flächeninhalt des eingegebenen Dreickes ist: "+calc(a,b,c));
	}
	
	


	public static int[] convert (String args){
		String[] c = args.split (",");
		
		return new int[] {Integer.parseInt(c[0]), Integer.parseInt(c[1])};
	}

	private static double calc (int[] a, int[] b, int[] c){
		double F = 0.5 * (a[0]* (b[1] - c[1]) + b[0] * (c[1] - a[1]) + c[0] * (a[1] - b[1]));
		return F;
	}


/*
@Test
public void test_convert(){
assertArrayEquals ({3, 4} convert ("3,4"));}

@Test
public void test_calc (){
assertEquals (17.5 calc(a{1,1}, b {6,1} c{6,8}));}

@Test
public void test_calc1(){
assertEquals (3.5 calc (a{32,4} b{35,5} c{64,17}));}
*/


}
