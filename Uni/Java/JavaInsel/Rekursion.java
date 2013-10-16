public class Rekursion{
	public static void main (String [] args){
		int a = Integer.parseInt (args[0]);
		int b = Integer.parseInt (args[1]);
		int c = Integer.parseInt (args[2]);
		System.out.println (add (a,b));
		System.out.println (sub (a,b));
		System.out.println (fak (a));
		System.out.println (fib (c));
		System.out.println (nfib (c));
		System.out.println (invfib (c));
		System.out.println ("tada"+ tripfib (c));
	}

	private static int add (int a , int b){
		if (b == 0)return a;
		return add(a+1, b -1);
	}
	
	private static int sub (int a, int b){
		if (a == 0) return b;
		return sub (a-1, b-1);
	}

	private static int fak (int a){
		if ( a == 1) return a;
		return a *fak(a-1); 
		
		
	}
	
	public static int fib (int c){
		if (c == 0) return 0;
		if (c == 1) return 1;
		return fib(c-1) +fib (c-2);
	}

	private static double nfib (int a){
		if (a == 1) return a;
		return a / nfib (a-1);
	}
	private static double invfib (int c){
		if (c <= 1) return 1;
		return invfib (c-1) / invfib (c-2);
	}
		
	public static int tripfib (int c){
		if (c == 0 ) return 0;
		if (c == 1) return 1;
		if (c == 2) return 2;
		return tripfib (c-1) + tripfib (c-2) + tripfib(c-3);
	}
	

}
	
