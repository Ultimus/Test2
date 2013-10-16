import org.junit.Assert.*;
import org.junit.*;

public class Nullstellen2 {


	public static double upper (double t, double c, double x) {
		if((t*t) == c || x <= 1.0000000000000001E-16 )
				return t;
		
		while((t*t) < c)
			t += x;
		
		return under(t, c, x/10);
	}




	
	public static double under (double t, double c, double x) {
		if((t*t) == c || x <= 1.0000000000000001E-16 )
				return t;
		
		while((t*t) > c)
			t -= x;
		
		return upper(t, c, x/10);
	}
	

	public static double sqrt (double s) {
		s = (Math.sqrt (s));
	assert s <= 0;
	
	
 
		return s;
	}
	

	
	public static void main (String[] args) {	
		double c = Double.parseDouble(args[0]);
		double t = 1; //mMn ist es unsinnig mit t = 0 zu beginnen
		double x = 1;
		double s = c;

		if (c < 0) {
			System.out.println("NaN");
			System.exit(-1);
		}
		
		double result = upper(t, c, x);
		double erg = sqrt (s);	

		System.out.println("Die Wurzel von "+c+" ist: "+result);
		System.out.println("Die Wurzel von "+c+" laut Math.sqrt ist: "+erg);
	}


/*
@Test
public void Test1 {
double c = main(4);
assertEquals = (2, c);
}

@Test
public void Test2 {
double c = main(2);
assertEquals = (1.4142135623730945, c);
}

@Test
public void Test3 {
double c = main (-1);
assertEquals = ("NaN", c);
}
*/

}
