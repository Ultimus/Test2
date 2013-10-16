public class fxgrafik{
  public static void draw (double n, double c) {
	
 	for (double i = 1; i < n; i ++)
	{		

	
		StdDraw.line (i, ((i*i)-c), i+1,(((i+1)*(i+1)) - c)) ;
		 

}
}

public static void main (String[] args) {

double n = Double.parseDouble (args[0]);
double c = Double.parseDouble (args[1]);;
draw (n, c);
}
}
