import java.awt.Color;
import static org.junit.Assert.*;
import org.junit.*;

public class Potential{
	public static void main (String [] args){
	
		int SIZE = 800;


	int N = StdIn.readInt();
	Charge[] a = new Charge[N];
	Picture pic = new Picture (SIZE, SIZE);


	for (int k = 0; k < N; k++){
		double x0 = StdIn.readDouble();
		double y0 = StdIn.readDouble();
		double q0 = StdIn.readDouble();
		a[k] = new Charge (x0, y0, q0);
	}




	double V = 0;
	for (int i = 0; i < SIZE; i++){
		for (int j = 0; j < SIZE; j++){
			getValue(i,j);
			for (k = 0; k < N; k++){
				setin (k, x,y,V,a);
				display (t,i,j);
			}
		}
	}
	}
	
	


	//compute the potential at each point and plot

	public static double getValue(int i, int j, int SIZE){

		double V = 0.0;
		double x = 1.0 * i / SIZE;
		double y = 1.0 * j / SIZE;
		return x;
	}
			

	public static double setin (int k, double x, double y, double V,Charge[] a){
		

			V += a[k].potential (x,y);
			
			V = 128+ V / 2.0e10;
			int t= 0;
			if (V < 0) return t = 0;
			else if (V > 255) return t = 255;
			else{ 
				t = (int) V;
				return t;
			}
		
	}

	public static void display (int t, int i, int j){
	Color c = Color.getHSBColor (t / 255.0f, .9f, .9f);
	pic.set (i, SIZE-1-j, c);
	pic.show();
	}
// Tests!!


@Test
public void test_getValue(){
	assertEquals (12, getValue (4, 3, 800));
}

}
			


