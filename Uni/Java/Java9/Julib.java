import java.awt.Color;
public class Julib{
	public static void main(String [] args){

	StdDraw.setXscale(-1,1);
	StdDraw.setYscale(-1,1);
	Color col = new Color (0,0,0);
	int a,b,c = 0;
	int what=0;
	
	while (true){
		// Farbe bestimmen
		a = (int)Math.random() *255;
		b = (int)Math.random() *255;
		c = (int)Math.random() * 255;
		col.setColor(a,b,c);
	


		//was wird gezeichnet?
		what = (int)Math.random() *5;
		switch (what){
			case (0):

				break;
			case(1):
		
				break;
			case(2):
			
				break;
		
			case(3):
		
				break;
		
			case(4):
				break;

	}



			

	}
}
