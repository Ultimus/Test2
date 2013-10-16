public class Test {
	public static void main (String [] args){
		int [] a = {1,2,3,4,5,0};
		String [] b = {"Hello", "Sicky", "Tanja"};
		System.out.println (b[0].compareTo (b[1]));
		System.out.println (b[1].compareTo (b[0]));
		System.out.println (b[0].compareTo (b[0]));
	}
}
