import org.junit.Assert.*;
import org.junit.*;

public class Taylor{


	public static int littleGauss (int n){

		for (int i =1; i < n ; i++){
			n += i;
		}
		System.out.println (n);
		return n;
		
	}
	public static int summenformel (int n){
	
	int summe = (n*(n+1))/2;
	return n;

	}

	public class double sinus (double x, double epsilon){
	
	int zaehler = x;
	int sin;
	int nenner;
	int exp;
	int vorzeichen = (-1);
		

	for (int i = 0; sin <= 0.0E-epsilon; i++){
		while (sin <= 0.0E-epsilon){
			vorzeichen *= (-1);
			zaehler *= (2*x);
			nenner *= ((2*i)+1);
		}
		sin = ((zaehler * zaehler) / nenner);
	}
	sin *= vorzeichen;
	x = sin;
	return x;
	} 


	public static double (arcussinus (double x, double epsilon){
	
	int arc;
	int nenner;	
	int zaehler;
	int neins = 1; //4 hoch n
	int nzwei; //fakultät n
	int ndrei; // 2n+1
	int end = x;

	for (int i = 0; arc <= 0.0E-epsilon; i ++)
		while ( arc <= 0.0E-epsilon){
			//Zähler
			zaehler* = 2*(i*i) 
			neins *= 4;
			nzwei *= i;
			ndrei = (2*i+1)
			end *= (2*x);
		}
	arc = (zaehler / (neins * (nzwei*nzwei)* ndrei)*(end*end));		
	}
	x= arc;
	return x;
	}
@Test
public void test1 {
double n = littleGaus(4);
assertEquals = (10, n);
}

@Test
public void test2 {
double n = littleGaus(17);
assertEquals = (153, n);
}

@Test
public void test3 {
double n = summenformel(25);
assertEquals = (325, n);
}

@Test
public void test4 {
double n = summenformel(64);
assertEquals = (2080, n);
}

@Test
public void test5 {
double x = sinus(301);
double epsilon = sinus (7)
assertEquals = (-0.8571673, x);
}

@Test
public void test6 {
double x = sinus (69);
double epsilon = sinus (5);
assertEquals = (0.93358, x);
}

@Test
public void test7 {
double x = arcussius (0,5);
double epsilon = arcussinus (12)
assertEquals = (30, x);
}

@Test
public void test8 {
double x = arcussinus (0.77);
double epsilon = arcussinus (8)
assertEquals = (50.3538885, x);
}

}
