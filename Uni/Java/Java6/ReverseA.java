import static org.junit.Assert.*;
import org.junit.*;


public class ReverseA{

@Test public void test_F1(){
	assertEquals(true, MyThing.function1 (true,true));}  //falsch



@Test public void test_F2(){
	assertEquals(false, MyThing.function1 (true,true));}

@Test public void test_F3(){
	assertEquals(true, MyThing.function1 (true,false));} //falsch

@Test public void test_F4(){
	assertEquals(true, MyThing.function1 (false,true));}//falsch

@Test public void test_F5(){
	assertEquals(true, MyThing.function1 (false,false));}

@Test public void test_F6(){
	assertEquals(false, MyThing.function1 (false,false));} //falsch


@Test public void test_F7(){
	assertEquals(false, MyThing.function1 (false,true));}

@Test public void test_F8(){
	assertEquals(false, MyThing.function1 (true,false));}
}
