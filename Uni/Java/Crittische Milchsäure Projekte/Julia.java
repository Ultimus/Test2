import java.awt.Color;

public class Julia{
	
	public static void main(String args[]){
		int x = Integer.parseInt(args[0]);
		int y = Integer.parseInt(args[1]);
		int z = Integer.parseInt(args[2]);
		
		Color col = new Color(x,y,z);
		

		StdDraw.setXscale(-1,1);
		StdDraw.setYscale(-1,1);
		StdDraw.setPenColor(col);
		StdDraw.filledCircle(0,0, 0.5);
	}
}
