import java.util.*;
import java.awt.*;



public class Uhren{

  public static void main (String[] args){


	while (1==1){

	Calendar c = Calendar.getInstance();
	int h = c.get (Calendar.HOUR_OF_DAY);
	int m = c.get (Calendar.MINUTE);
	int s = c.get (Calendar.SECOND);

	String hour = "" + h;
	String minute = "" + m;
	String second = "" +s;
	

	String time = hour +" : "+ minute+" : " + second;

		
		StdDraw.clear (StdDraw.BLACK);
		StdDraw.setPenColor (StdDraw.GREEN);
		StdDraw.text (0.5, 0.5, time);
				
		
		try {
			Thread.sleep(1000);
		}
		catch (InterruptedException ex) {}
	}
  }
}
