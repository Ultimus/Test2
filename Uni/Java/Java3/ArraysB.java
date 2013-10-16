public class ArraysB
{
	public static String[] shuffle(String[] input)
	{
		for(int i = 0; i < input.length; i++)
		{
			int randPos 	= (int)(Math.random()*input.length);
			String tmp  	= input[i];
			input[i]	= input[randPos];
			input[randPos]	= tmp;
		}

		return input;
	}

	public static void main(String[] args)
	{
		String[] Basen = {"G", "A", "T", "C"};
		String[] output = shuffle(Basen);

		for(int i = 0; i < output.length; i++)
			System.out.print(output[i]);
	}
}
