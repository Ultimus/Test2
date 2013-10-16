import java.util.*;
import java.awt.*;

public class Chaos{
	
	static double[] cx = {0.000, 1.000, 0.500};
	static double[] cy = {0.000, 0.000, 0.866};

	public static void main (String[] args){
		int T = Integer.parseInt(args[0]);
		double x = 0;
		double y = 0;
		paint (x,y, T);
		StdDraw.setXscale (0, 1);
		StdDraw.setYscale (0, 1);
		StdDraw.setPenRadius (1);
		
	}
	private static double paint (double x, double y, int T){
		if (T == 0) {
		return 0;}
		int r = (int) (Math.random () * 3);
		x = ((x + cx[r]) / 2); 
		y = ((y + cy[r]) / 2);		
		StdDraw.point (x,y);
		return paint (x ,y, T-1);
	}
}
