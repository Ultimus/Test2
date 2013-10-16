import java.awt.Color;
public class Julib{
	public static void main(String [] args){

	StdDraw.setXscale(0,1);
	StdDraw.setYscale(-1,1);
	int a,b,c = 0;
	int what=0;
	double x,y = 0;	


	while (true){
		StdDraw.clear();
		// Farbe bestimmen
		a = (int)(Math.random() *255);
		b = (int)(Math.random() *255);
		c = (int)(Math.random() * 255);
		Color col = new Color(a,b,c);
		StdDraw.setPenColor(col);
		
		//Koordinaten bestimmen
		x = Math.random();
		y = Math.random();


		//was wird gezeichnet?
		what = (int)(Math.random() *4);
		switch (what){
			case (0)://Kreis
				double radius = Math.random();
				StdDraw.filledCircle(x,y,radius);
			
				break;
			case(1): //Elipse
				double xAchse = Math.random();
				double yAchse = Math.random();
				StdDraw.filledEllipse(x,y,xAchse,yAchse);
				break;
			case(2)://Rechteck
				double height = Math.random();
				double width = Math.random();
				StdDraw.filledRectangle(x,y,width, height);
		
				break;
		
			case(3)://square
				double r = Math.random();
				StdDraw.filledSquare(x,y,r);

				break;
	
		}

		//Schreibe Farbe

		StdDraw.setPenColor();
		String colors = ""+a+"   "+b+"   "+c;
		StdDraw.text(0.1,-0.8, colors);

		try{
		Thread.sleep(2000); // Sleep for 4 sec
		}
		catch(InterruptedException e){}


	}



			

	}
}
