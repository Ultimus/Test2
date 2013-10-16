import java.io.*;

public class ArrayStackofStrings{

	private String[] a;
	private int N = 0;
	
	public ArrayStackofStrings (int max) { a = new String[max];}
	public boolean isEmpty() {return N == 0;}
	public void push (String item) { a[N++] = item;}
	public String pop () { return a[--N];}

	public static void main (String[] args){
		StackofStrings stack = new StackofStrings();
		while (!StdIn.isEmpty()){
		String s = StdIn.readString();
		if (s.equals ("-"))
			StdOut.println (stack.pop());
		
		else stack.push(s);
		}
	}

}
	
