public class Filter
{
	public static void main(String[] args)
	{
		int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		int counter = 0;

		for(int i = 0; i < a.length; i++)
			if( (a[i] % 2) == 0)
				counter++;		/*Zählt erstmal wie groß das array werden soll*/

		int[] b = new int[counter];
		counter = 0;

		for(int i = 0; i < a.length; i++)
			if( (a[i] % 2) == 0)
			{
				b[counter] = a[i];	/*c2, da b[5] schon out of bounce gehen würde*/
				counter++;
			}


		System.out.println("Arraylenge: " + b.length);

		for(int i = 0; i < b.length; i++)
			System.out.println(b[i]);
	}
}
