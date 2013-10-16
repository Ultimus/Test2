import static org.junit.Assert.*;
import org.junit.*;


public class ReverseB{

@Test public void test_F1(){
	assertEquals(-1, MyThing.function2 (-1));}//falsch Ergebniss = 1

	@Test public void test_F2(){
	assertEquals(1, MyThing.function2 (1));} //richtig

@Test public void test_F3(){
	assertEquals(16, MyThing.function2 (16));} // falsch Ergebniss = 7

@Test public void test_F4(){
	assertEquals(-40, MyThing.function2 (-40));} //falsch Ergebniss = 4

@Test public void test_F5(){
	assertEquals(0, MyThing.function2 (0));} //richtig

}




