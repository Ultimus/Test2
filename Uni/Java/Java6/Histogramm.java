import java.util.*;


public class Histogramm{
	public static void main (String[] args){
 	int[] count = new int [15];
	double n = 1000;
	double wert = 0;
	double wuerfe = 0;
	
	for (int i = 0; i < n; i++){
		wert = 0; 
		wert = flip(wert);
		wuerfe += wert;
		for (int j = 0; j < count.length; j++){
		
			if (j == wert){
				count[j]++;
			}
		
		}

	}


	for (int k = 0; k < count.length; k++){
	System.out.println(count[k]);
	}
	System.out.println ("Erwartunsgwert: "+wuerfe/1000);
	paint (count, n);
	}


	public static void paint (int count[], double n){
		StdDraw.setXscale (0, 16);
		StdDraw.setYscale (-2, n);
		StdDraw.setPenRadius (0.01);

		for (int i = 0; i < count.length; i++){
		StdDraw.line (i, 50, i, count[i]+50);
		StdDraw.text (i, (n*0.8), ""+count[i]); 
		} 
		for (int j = 0; j < count.length; j++){
		StdDraw.text (j, -2, ""+j);
		}
		
	}
	
	public static double flip (double wert){
	boolean kopf;
	boolean zahl;
	double coin;
	

	kopf = false;
	zahl = false;

	while(kopf==false || zahl==false){

		coin = Math.random();

		if (coin <= 0.45){
			kopf = true;
		}
		else{
			zahl = true;
		}
	wert++;
	
	}
	return wert;
	}


}
	
