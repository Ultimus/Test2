import java.awt.Color;
import static org.junit.Assert.*;
import org.junit.*;


public class Bildgrau {
	public static void main(String[] args) {
		Picture pic = new Picture (args[0]);
		write (pic);
			

	}
	


	public static int getgrey (Color col){
		int r = col.getRed();
		int g = col.getGreen();
		int b = col.getBlue();
		return ((r+g+b)/3);
	}

	


	public static int write (Picture pic){
		int[] greyscale = new int [256];
		int grey = 0;
		for (int x = 0; x < pic.width(); x++){
			for (int y = 0; y < pic.height(); y++){
				Color col = pic.get(x,y);
				grey = getgrey(col);
				for (int i = 0; i< greyscale.length; i++){
					if (grey == i){
						greyscale[i]++;
					}
				}
			}
		}
		return paint(greyscale);
	}	


	public static int paint(int[] greyscale){

		int max = 0;
	
		for (int j = 0; j < greyscale.length; j++){
			if (max < greyscale[j]){
				max = greyscale[j];
			}
		}

		StdDraw.setXscale (-10,266 );
		StdDraw.setYscale (-200, (max));
		StdDraw.setPenRadius (0.000001);

	for (int i = 0; i < greyscale.length; i++){
		StdDraw.line (i, 0, i, greyscale[i]);
	}	
	return max;
	}

@Test
public void test_bild(){
assertEquals (256, getgrey(new Color(256,256,256)));}

@Test
public void test_bild1(){
assertEquals (136, getgrey (new Color (256, 0, 136)));}

}
