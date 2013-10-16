import static org.junit.Assert.*;
import org.junit.*;

public class Weird2{

public static void main (String[] args){
	
	int y=0;
	for (int i= 1;i <= 5; i++){ 
	System.out.println (hoch(y, i));
	}
}
	public static int hoch(int y, int i){
		y = i*i*i;
	return y;
	
}

@Test
public void weird1(){
assertEquals (1, hoch(0,1));}

@Test
public void weird2(){
assertEquals (8, hoch(0,2));}

@Test
public void weird3(){
assertEquals (27, hoch(0,3));}

@Test
public void weird4(){
assertEquals (64, hoch(0,4));}

@Test
public void weird5(){
assertEquals (125, hoch(0,5));}


}
