import static org.junit.Assert.*;
import org.junit.*;

public class MyWeirdFunktion{

	public static void main (String[] args){
	for (int i = 1; i <= 10; i++){
		System.out.println ("f("+i+")="+f(i));
	}
	}

	public static int f (int n){
	int y = 0; 
	int i = 0;
	int j = 1;
	int k = 6;
	
	while (i<n){
		y= y+j;
		i++;
		j = j+k;
		k+=6;
		System.out.println ("y= "+y+" i="+i+" j= " +j+" k= "+k);
	}
	System.out.println ("y= "+y+" i= "+i+" j= " +j+" k= "+k);
return y;
}

@Test
public void weird1(){
assertEquals (64, f(4));}

@Test
public void weird2(){
assertEquals (27, f(3));}

@Test
public void weird3(){
assertEquals (1, f(1));}

@Test
public void weird4(){
assertEquals (8, f(2));}

@Test
public void weird5(){
assertEquals (125, f(5));}




}
