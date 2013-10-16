public class Stopwatch{

	private static long start;
	public Stopwatch(){
		start = System.currentTimeMillis();
	}
	
	public double elapsedTime(){
		return (System.currentTimeMillis() - start) /1000.0;
	}

public static void main (String[] args){
	int [] a = StdArrayIo.readInt1D();
	Stopwatch timer = new Stopwatch();
	Stdout.println (count(a));
	Stdout.println (timer.elapsedTime());
}
}
