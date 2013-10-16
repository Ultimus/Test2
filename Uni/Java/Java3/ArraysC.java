public class ArraysC
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
		String[] output = new String[100];

		for(int i = 0; i < output.length; i += 4)
		{
			String[] temp = shuffle(Basen);

			for(int x = 0; x < temp.length; x++)
				output[i+x] = temp[x];
		}

		for(int i = 0; i < output.length; i += 4)
			System.out.println(output[i] + output[i+1] + output[i+2] + output[i+3]);
	}
}
