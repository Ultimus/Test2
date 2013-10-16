import static org.junit.Assert.*;
import org.junit.*;

public class Simulator{

	public int[] init (int n){

	int[] band = new int [n+2];

	for (int i = 2; i < n+2; i++){
		band [i] = -1;
	}
	band [0] = 0;
	band [1] = 2;
	band [2] = 0;
	return band;	
	}

	@Test public void test_S1(){
	int[] tband = init(5);
	assertEquals(0, tband[0]);}
	
	@Test public void test_S2(){
	int[] tband = init (5);
	assertEquals(2,tband[1]);}

	@Test public void test_S3(){
	int[] tband = init (5);
	assertEquals(-1, tband [4]);}

	@Test public void test_S4(){
	int[] tband = init (5);
	assertEquals(0, tband[2]);}
	

	public String asString (int[] band){
	
	String Sband;
	for (int i = 2; i < band.length; i++){
		if (band [i] == -1){
		Sband += '_';
		}else{
		Sband += ""+i ;
		}
	}
	return Sband;
	}
	

	public void print (int[] band){
	
	for (int i = 2; i < band.length; i++){
	System.out.println (asString(band[i]));
	}
	}


	public int [] readInput (String input, int bandlaenge){
	 
	int[] band = init(bandlaenge);

	for (int i = 2; i < band.length; i++){ 	
		for (int j = 0; j < input.length; j++){
			if (input.charAt(j) == '_'){
				band [i] = -1;
			}
			else{
				band [i] = input.charAt(j);
			}
			
		}
	}
	return band;
	}


	public int[] step (int [] band, int [][] kontrolleinheit){
	for (int i = 0; i < kontrolleinheit.length; i++){
		if (band[0] == kontrolleinheit [i][0] && band[band[1]] == kontrolleinheit [i][1]){
			band[0] = kontrolleinheit [i][2];
			band[band[1]] = kontrolleinheit [i][3];
			band [1] += kontrolleinheit [i][4];
			return band;
		}
	}
	
	return band;
	}
	




	public int [][] parse(String program){
	
	String[] entries = prog.split(' ');
	int [][] control = new int[entries.length/5][5];

	for (int i = 0; i < entries.length; i++){
		control[i % entries.length/5][i%5] = Integer.parseInt (entries[i]);
	}
	return control;
	}


}
