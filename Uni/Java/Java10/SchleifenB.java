import java.io.*;

public class SchleifenB{
	public static void main(String[] args) throws Exception {
		int temp;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Bitte geben sie eine Zahl ein: ");
		do {
			temp = Integer.parseInt(br.readLine());
			if(temp <= 0) System.out.println("Programm wird beendet");
			else if(temp % 2 == 0) System.out.println("Die Zahl ist gerade");
			else System.out.println("Die Zahl ist nicht gerade");
		} while(temp >= 0);
	}
}
