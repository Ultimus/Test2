import java.io.*;

public class Wurzelc{

 public static void main(String args[]){      	//Zahl einlesen

 
  InputStreamReader istream = new InputStreamReader(System.in);
  BufferedReader bufRead = new BufferedReader(istream);
  
  int zahl;
  System.out.print("Wurzel berechnen von: ");

  try {
   String input = bufRead.readLine();
   zahl = Integer.parseInt(input);

   System.out.println("Wurzeln sind : "+wurzeln(zahl)+" und "+-wurzeln(zahl)); 

  } catch (IOException err) {
   System.out.println("Error reading line");
  } catch (NumberFormatException err) {
   System.out.println("Error impossibile rilevare il numero");
  }

 }

 public static double wurzeln(double c){
 
  if(c < 0) return Double.NaN;
 
  double epsilon = 1e-15;
  double a = 0;
  double b = c;
  double x = 0;
  double fa = 0;
  double fx = 0;
 
  while(!(x == Math.sqrt(c))){

   	x = (a + b)/2;
  
   	fa = a*a - c;
   	fx = x*x - c;
  
 
   		if((fx >= 0 &&  fa >=0) || (fx < 0 && fa <0)){
		//Falls f(x) das gleiche Vorzeichen wie f(a) hat, setzen wir a auf den Wert x und behalten b bei.
    			a = x;
 
   }
		else{
 
		    b = x;
   
		   }
 

  }

  return x;

 }
}
