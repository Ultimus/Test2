public class Galton{

	public static void main( String [] args){
		int n = Integer.parseInt(args[0]);
		draw(calculate(n));
	}

	public static int[] calculate (int n){
		int Brett[] = new int [10];
		int position = 0;
		for (int i = 0; i <= n; i++){
			position = 0;
			for (int j = 0; j <= 9; j++){
				int calculus = (int)(Math.random()*2);
				if (calculus == 0) position++;
				else position+=2;
			}
			
			for (int k = 0; k <= 9; k++){
				if (position == (9 + k)) Brett[k]++;
			}
		}
		return Brett;
	}


	public static void draw(int Brett[]){
		StdDraw.setXscale(-1,11);
		//StdDraw.setPenRadius(0.1);
		int max = 0;
		for (int j = 0; j < Brett.length; j++){
			if (max < Brett[j]) max = Brett[j];
		}
		StdDraw.setYscale (-1,max);
		for (int i = 0; i < Brett.length; i++){
			System.out.println(Brett[i]);
			StdDraw.line (i,0, i, Brett[i]);
		}
	}
}
				
			
