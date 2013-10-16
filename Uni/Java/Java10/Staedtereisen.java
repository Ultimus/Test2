import static org.junit.Assert.*;
import org.junit.*;
import java.io.*;

public class Staedtereisen{
	public static void main (String[] args){
	System.out.println (readnames());

	}


	public static String[] readnames (){
		System.out.println ("Bitte geben sie die Anzahl der Personen ein: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//int n = Integer.parseInt(br.readLine());		
		String[] names = new String [n];
		
		int count = 0;
		do {
			//names[count] = Stdin.readln (br.readLine());
			count++;
		}while (count < n);
		readsum(n);
		return names;
	}
	
	public static double readsum (int n){
	
		System.out.println ("Bitte geben sie die Summen der Rechnungen ein und bestätigen sie jede einzeln mit der 'Enter' Taste: ");
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		double sum= 0;
		double value;
		System.out.println ("Beenden sie die Eingabe indem sie eine 0 eingebe: ");
		
		do{
			//value = Integer.parseInt (br.readLine());
			sum += value;
		}while (value != 0);
		sum /= n;
		return sum;
	}


						


}
/*Personen:
Simon, Thomas, Jens

Gerd Kathrin
Christoph Sina

Jessica*/
