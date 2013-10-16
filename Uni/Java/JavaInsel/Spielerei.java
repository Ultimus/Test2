public class Spielerei{
	public static void main (String [] args){
		int n = Integer.parseInt (args[0]);
		for (int i = 1; i <= n; i++){
			System.out.println (i+ ": Quotient: " + (double)(Rekursion.tripfib (i) / Rekursion.fib (i)));
		}
	}
}
