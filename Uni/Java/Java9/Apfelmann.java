import java.awt.Color;

public class Apfelmann{
	public static void main (String[] args){
		double minX = Double.parseDouble(args [0]);
		double minY = Double.parseDouble(args [1]);
		double d = Double.parseDouble (args[2]);
		int size = Integer.parseInt (args[3]);

		Datenpunkt[] val = mandelset (new DoublePair (minX, minY), size, d);
		show (val, size);

		
	

	}

	public static Datenpunkt[] mandelset(DoublePair min, int N, double d){
			Datenpunkt[] erg = new Datenpunkt [N*N];
			double x = min.x;
			double y = min.y;

			for (int i = 0; i < N ; i++){
				for (int j = 0; j < N; j++){
					erg[j] = mandel (new DoublePair (x,y));
					y += (d/N);
				}
				x += (d/N);
				y = min.y;
			}
			return erg;
		
	}

	public static Datenpunkt mandel (DoublePair begin){
		int count = 0;
		double x = begin.x;
		double zw = begin.x;
		double y = begin.y;
		
		while (((x*x) + (y*y)) < 4){
			while (count < 255){
				x = ((x*x) - (y*y) + begin.x);
				y = ((2* zw *y) + begin.y);
				zw = x;
				count++;
			}
		}
		return new Datenpunkt (begin, count);
	}
		






	public static void show (Datenpunkt[] val, int N){
		Picture pic = new Picture(N, N);
		int i = 0;
		
		for (int x = 0; x < N; x++){
			for (int y = 0; y < N; y++){
						

				switch (val[i].value % 8){

					case 0: 
					pic.set (x, y, Color.white);break;
					case 1:
					pic.set (x, y, Color.green);break;
					case 2:
					pic.set (x, y, Color.orange);break;
					case 3:
					pic.set (x, y, Color.yellow);break;
					case 4:
					pic.set (x, y, Color.pink);break;
					case 5:
					pic.set (x,y, Color.cyan);break;
					case 6:
					pic.set (x, y, Color.blue);break;
					case 7:
					pic.set (x, y, Color.black);break;
				}

				i++;

			}

		pic.show();
		}
	}
}
