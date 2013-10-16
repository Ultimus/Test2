import java.awt.Color;

public class Bilddreh{
	public static void main (String [] args){

		Picture pic = new Picture (args[0]);
		int n = Integer.parseInt (args[1]);

		if (n < 0 && n > 3){
			System.out.println("Bitte geben sie eine Zahl zwischen 0 und 3 ein!");
		}
		else{
			int i=0;

			while (i < n){
				rotate (pic,i, n);
			}
		
		}
	}
	

	 		 public static int rotate (Picture pic, int i, int n){
				Color col;
				Picture spin = new Picture (pic.height(), pic.width());
			
				for (int x = 0; x < pic.width(); x++){
					for (int y = 0; y < pic.height(); y++){
						col = pic.get(x,y);
						spin.set (y, x, col);
						
					}
				}
				i++;
				if (i == n)
				spin.show();
				return (i);
			}
}			
