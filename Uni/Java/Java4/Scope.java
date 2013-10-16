public class Scope {
	static int a = 1;
	static int b = 2;
	static int c = 3;
	static int [] d;
	static int [] e;

	public static void main (String [] args){
	System.out.println ("1:a="+a);
	System.out.println ("1:b="+b);
	System.out.println ("1:c="+c);
	a= 4;
	int b = 5;
	d = new int [5];
	d[0] = 7;
	e = new int[5];
	e[0] = 8;
	System.out.println ("2:a="+a);
	System.out.println ("2:b="+b);
	System.out.println ("2c:="+c);
	System.out.println ("2d[0] ="+d[0]);
	System.out.println ("2:e[0]="+e[0]);
	method (4,e);
	System.out.println ("4:a="+a);
	System.out.println ("4:b="+b);
	System.out.println ("4:c="+c);
	System.out.println ("4:d[0]="+d[0]);
	System.out.println ("4:e[0]="+e[0]);
}

public static void method (int c, int[] d){
	System.out.println ("3:a="+a);
	System.out.println ("3:b="+b);
	System.out.println ("3:c="+c);
	System.out.println ("3:d[0]="+d[0]);
	System.out.println ("3:e[0]="+e[0]);
	d[0] = 4;
}
}
