import java.awt.Color;

public class Wegi_Apfel
{
	public static void main(String [] args)
	{
		double	minX  = Double.parseDouble(args[0]);
		double	minY  = Double.parseDouble(args[1]);
		double	d	  = Double.parseDouble(args[2]);
		int		pixelCount = Integer.parseInt(args[3]);
		
		Datenpunkt[] satz = mandelset(new DoublePair(minX, minY), pixelCount, d);
		show(satz, pixelCount);
		
	}
	
	public static Datenpunkt mandel(DoublePair start)
	{
		int counter = 0;
		double x = start.x;
		double helper = start.x;
		double y = start.y;
		while((x*x + y*y <= 4) && counter < 255)
		{
			x = x*x - y*y + start.x;
			y = 2*helper*y + start.y;
			helper = x;
			counter++;
		}
		return new Datenpunkt(start, counter);
	}
	
	public static Datenpunkt[] mandelset(DoublePair min, int N, double d)
	{
		double x = min.x;
		double y = min.y;
		double step = d/(double)N;
		Datenpunkt[] result = new Datenpunkt[N*N];
		int k = 0;
		for(int i = 0; i < N; i++)
		{
			for(int j = 0; j < N; j++)
			{
				result[k] = mandel(new DoublePair(x, y));
				y += step;
				k++;
			}
			x += step;
			y = min.y;
		}
		return result;
	}
	
	public static void show(Datenpunkt[] satz, int N)
	{
		Picture pic = new Picture(N, N);
		int k = 0;
		for(int i = 0; i < N; i++)
		{
			for(int j = 0; j < N; j++)
			{
				/*switch(satz[k].value % 8)
				{
					case 0: pic.set(i, j, new Color(138, 42, 226)); break;
					case 1: pic.set(i, j, new Color(0, 206, 209)); break;
					case 2: pic.set(i, j, new Color(205, 51, 51)); break;
					case 3: pic.set(i, j, new Color(255, 193, 193)); break;
					case 4: pic.set(i, j, new Color(124, 252, 0)); break;
					case 5: pic.set(i, j, new Color(255, 165, 0)); break;
					case 6: pic.set(i, j, new Color(255, 215, 0)); break;
					case 7: pic.set(i, j, new Color(139, 71, 38)); break;
				}*/
				switch (satz[i].value % 8)
				{
				case 0: 
			pic.set (i, j,Color.white);break;
			case 1:
			pic.set(i, j,Color.green);break;
			case 2:
			pic.set (i, j,Color.orange);break;
			case 3:
			pic.set (i, j,Color.yellow);break;
			case 4:
			pic.set (i, j, Color.pink);break;
			case 5:
			pic.set (i,j, Color.cyan);break;
			case 6:
			pic.set(i, j,Color.blue);break;
			case 7:
			pic.set (i, j,Color.black);break;
		}
				k++;
			}
		}
		pic.show();
	}
}
