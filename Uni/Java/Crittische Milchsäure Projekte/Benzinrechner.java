public class Benzinrechner{

	public static void main (String[] args){
		int km = Integer.parseInt (args[0]);
		double liter = Double.parseDouble (args[1]);
		
		
		System.out.println ("Verbrauch auf 100 km: "+perhundert(km, liter));
		System.out.println ("Gefahrene Km pro Liter: "+perliter(km, liter));
	}


	private static double perhundert (int km, double liter){
		return (100 / (km/liter));
	}

	private static double perliter (int km, double liter){
		return (km /liter);
	}
}
	
