import java.io.*; 
public class HelloWorld extends java.lang.Object {
    public static void main(String[] args) {
	int mix[]={5242052,2323512,6432563,6388014,3634522};
	int matrikelnr=0;

        System.out.print("Bitte geben Sie Ihre Matrikelnummer ein :");
	InputStreamReader istream = new InputStreamReader(System.in) ;
	BufferedReader bufRead = new BufferedReader(istream) ;
	try {
	    matrikelnr=Integer.parseInt(bufRead.readLine());
	}
	catch (IOException err) {
	    System.out.println("Error reading line");

	}
         catch(NumberFormatException err) {

               System.out.println("Error Converting Number");

          }		

      	int a;
	a=matrikelnr;
	for (int m=0; m<1000;m++)
	    {
		int p=a%5;
		a=(a*47+mix[p]+17632)%1000201;
		mix[p]=a;
	    }
	System.out.println("Hallo Student mit Matrikenummer "+matrikelnr+" !");
	System.out.println("Ihre Loesung lautet: "+a);
    }
}