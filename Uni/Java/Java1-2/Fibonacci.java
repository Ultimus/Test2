public class Fibonacci{
public static void main(String[] args){

double f0=0;
double f1=1;
double f2=1;
int i=0;
int j=Integer.parseInt(args[0]);
double [] f = new double[j+3];
double q;

        System.out.println("Fibonacci-Zahl: " + "0.0");
        System.out.println("Fibonacci-Zahl: " + "1.0");

        f[0]=0.0;
        f[1]=1.0;

        for (i=0; i<j; i=i+1)
          {
          
          f2=f0 + f1;

          q=f1/f0;

          f[i+3]=f2;
          System.out.println("Fibonacci-Zahl: " + f2+" 		    Quotient: " + q);

          f0=f1;
          f1=f2;
          
          }

        }

}
