
import static org.junit.Assert.assertEquals;

public class Geometrie3{

	public static void main(String[] args){
		int n = Integer.parseInt(args[0]);
		int k = Integer.parseInt (args[1]);
		
		System.out.println ("Flächeninhalt des Poligons: "+calc(n,k));
	}
		
	private static double calc (int n, int k){
		double F = 0;
		F = 0.5*(n-2)+k;
		return F;
	}
}
 
