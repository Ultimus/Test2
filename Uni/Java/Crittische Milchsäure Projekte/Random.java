import java.io.*;

public class Random{
	public static void main (String[] args){
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
	int temp;
	System.out.println ("Bitte geben sie eine Maximalzahl ein: ");
		do {
			try {
				temp = Integer.parseInt(br.readLine());
				if (temp > 0){
			System.out.println ((int)(1.0+Math.random()*temp));}
			else { System.out.println ("Bitte geben sie eine Zahl über 0 ein.");}
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				System.out.println("Spasti! Gib ne Zahl ein!");
				temp=1;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Spasti! Gib ne Zahl ein!");
				temp=1;
			}
			
		} while(temp > 0);
	}
}
