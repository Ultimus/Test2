public class PerfekteZahlen{
public static void main (String args[]){

int zahl = Integer.parseInt (args[0]);
int n;
boolean p= false;
//Perfekte Zahlen lassen sich auch mit der Formel 2^(n-1)*(2^n-1) berechnen:

for (n = 2; zahl >= (int)(Math.pow(2, (n-1))*(double)(Math.pow(2,n)-1)); n++) {
	if (zahl == (int)(Math.pow(2, (n-1)))*(double)(Math.pow(2,n)-1)){
p = true;}
		else {p = false; 
}}
	if (p == true){
		System.out.println ("Die eingegebene Zahl ist eine perfekte Zahl.");
}
	else{
		System.out.println ("Die eingegebene Zahl ist keine perfekte Zahl.");}


// ab hier Aufgabenteil b
if (zahl < (int)(Math.pow(2, (n-1))*(double)(Math.pow(2,n)-1))){
System.out.println ((int)(Math.pow(2, (n-1)))*(double)(Math.pow(2,n)-1));
}
}

}
