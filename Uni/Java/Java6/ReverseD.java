import static org.junit.Assert.*;
import org.junit.*;


public class ReverseD{


@Test public void test_F1(){
	assertEquals(-1, 99, "Hallo", MyThing.function4 (-1, 99, "Hallo"));}


@Test public void test_F2(){
	assertEquals(0.003, 64, "Bismark", MyThing.function4 (0.003, 64, "Bismark"));}


@Test public void test_F3(){
	assertEquals(8, 8, "", MyThing.function4 (8, 8, ""));}


}
