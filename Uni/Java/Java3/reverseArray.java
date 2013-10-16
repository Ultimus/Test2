public class reverseArray
{
	public static void main(String[] args)
	{
		int[] a = {-2, 1, 3, 4, 7, 8, 13};
		int[] b = new int[a.length];
	
		for(int i = 0; i < a.length; i++)
			b[i] = a[input.length - i - 1];

		for(int i = 0; i < input.length; i++)
			System.out.println(b[i]);
	}
}
