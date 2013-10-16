import static org.junit.Assert.*;
import org.junit.*;

public class Charge{
	private double rx, ry; 
	private double q;
	
	/*public Charge (double x0, double y0, double q0){
		rx = x0;
		ry = y0;
		q = q0;
	}*/

	public void setCharge (double x0, double y0, double q0){
		rx = x0;
		ry = y0;
		q = q0;
	}

	public double potentialAt (double x, double y){
		double k = 8.99e09;
		double dx = x - rx;
		double dy = y - ry;
		return k * q / Math.sqrt(dx*dx + dy*dy);
		
	}


	public String toString (){
		return q + " at " + "(" + rx + ", " + ry + ")";
	}

	 


@Test
public void test_potentialAt(){
Charge c = new Charge ();
c.setCharge (4, 3 , 1);
	assertEquals(0.0, potentialAt ( 1, 1), 0);
}

@Test
public void test_potentialAt1(){
Charge c = new Charge();
c.setCharge (0.77, 666, 99.7);
assertEquals (0.0, potentialAt ( 55, 1064), 64);
}


@Test
public void test_toString(){
Charge c = new Charge ();
c.setCharge (.51, .61, 12.3);	
	assertEquals("0.0 at (0.0, 0.0)", toString ());
} 
}
