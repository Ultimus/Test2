public class Komplexität2{

	public static void main (String[] args){

	int n = Integer.parseInt (args[0]);
	long start = System.currentTimeMillis();
	long Komp1=0;
	long Komp2 = 0;
	if (fib2(n) > 0){Komp1 = System.currentTimeMillis();}
	if (fib1(n) > 0){Komp2 = System.currentTimeMillis();}
	
	System.out.println (start);
	System.out.println (Komp1-start);
	System.out.println (Komp2-start);
	}


public static int fib1(int n){
	if (n== 0) return 0; 
	if (n == 1) return 1;
	return fib1(n-1) + fib1(n-2);
}
/*
43 = 2732
44 = 4389
45 = 8412
46 = 13461
exponentielles Wachstum, wird ungefähr verdoppelt, wenn um eins erhöht wird
*/
public static int fib2 (int n){
int a = 0;
int b = 1;
int c = 0;
while (true){
	if (n == c) return a;
	int t = a+b;
	a = b;
	b = t;
	c++;
	}
}
//Immer gleiche Laufzeit, wird praktisch instant berechnet

}

