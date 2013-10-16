public class KlapptNicht{
	public static int value = 0;
	public static void main (String [] s){
	
	KlapptNicht a = new KlapptNicht();
	KlapptNicht b = new KlapptNicht();
	a.value = 5;
	System.out.println (a==b);
	System.out.println (b.value);
}
}
