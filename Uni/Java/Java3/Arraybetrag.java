public class Arraybetrag
{
	public static void main (String args[])
	{
		int a[] = { -1 , 2, -5};

		for (int i = 0;i < a.length; i++)
		{
			a[i] = Math.abs (a[i]);
		}
		
		for (int j = 0; j < a.length; j++)
		{
			System.out.println (a[j]);
		}
	}
}
