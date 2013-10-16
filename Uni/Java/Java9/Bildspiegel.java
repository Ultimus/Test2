import java.awt.Color;

public class Bildspiegel{
	public static void main(String []args){
	Picture pic = new Picture (args[0]);	
	

		if (args[1].equals ("h")){
			horizontal(pic);
		}
		if (args[1].equals ("v")){
			vertikal(pic);
		}

	}


	public static void vertikal(Picture pic){
		Picture mirror = new Picture (pic.width(), pic.height());
		int width = pic.width();
		int height = pic.height();
		for (int i = 0; i < pic.width(); i++){
			for (int j = 0; j < pic.height(); j ++){
				Color col = pic.get (i, j);
				mirror.set(width-i-1,j, col);
			}
		}
		mirror.show();
	}

	


	public static void horizontal (Picture pic){
		Picture mirror = new Picture (pic.width(), pic.height());
		int width = pic.width();
		int height = pic.height();		


		for (int i = 0; i < pic.width(); i++){
			for (int j = 0; j < pic.height(); j ++){
				Color col = pic.get (i, j);
				mirror.set(i, height-j-1, col);
			}
		}
		mirror.show();
	}

}
