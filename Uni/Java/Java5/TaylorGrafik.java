import java.util.*;

public class TaylorGrafik {
  public static void main (String [] args){
	double d = Double.parseDouble (args[0]);
	
	StdDraw.setPenRadius (0.001);
	StdDraw.setXscale (-5, 5);
	StdDraw.setYscale ( -5,5);
	for (double i = (-1); i < d; i+=0.1){	
	StdDraw.point (i,Math.asin (i) );
	}
}
}
