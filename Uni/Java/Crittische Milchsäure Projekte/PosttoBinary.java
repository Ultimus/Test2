import java.lang.*;

public class PosttoBinary{
	public static void main (String [] args){
		String s= "Satan";
		String dummy="";
		for (int i = 0; i< s.length(); i++){
			int d = s.charAt(i);
			dummy += Integer.toBinaryString(d);
		}
		System.out.println (dummy);
	}
}
