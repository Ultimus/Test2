public class Komplexität{


	public static void main (String[] args){
	long start = System.currentTimeMillis();
	int [] a = new int [40000];
	for (int i = 0; i < a .length; i++){
		a[i] = 12345;
	}
	if (dupe1(a) == true || dupe1(a) == false);  long Komp1 = System.currentTimeMillis();
	if (dupe2(a) == true || dupe2(a) == false);	long Komp2 = System.currentTimeMillis();
	
	System.out.println (start);
	System.out.println (Komp1-start);
	System.out.println (Komp2-start);
	}

public static boolean dupe1 (int[] a){
	for (int i = 0; i < a.length; i++){
		for (int j = 0; j < a.length; j++){
			if (a[i] == a[j]) return true;
		}
	}
	return false;
} //Laufzeit ca 0 ms, Laufzeit ändert sich praktisch nicht.


public static boolean dupe2 (int[] a){
	boolean b = false;
	for (int i = 0; i < a.length; i++){
		for (int j = 0; j < a.length; j++){
			if (a[i] == a[j]) b = true;
		
		}
	}
	return b;
}
// Laufzeit steigt Quadratisch an, wenn sich die Größe des Arrays Verdoppelt



}

