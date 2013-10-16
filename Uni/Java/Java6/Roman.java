import static org.junit.Assert.*;
import org.junit.*;

public class Roman {

	@Test
	public void testTR1() {
		String r = toRoman(1);
		assertEquals("toRoman(1) should be I", "I", r);
	}

	@Test
	public void testTR2() {
		String r = toRoman(2);
		assertEquals("toRoman(2) should be II", "II", r);
	}

	@Test
	public void testTR3() {
		String r = toRoman(3);
		assertEquals("toRoman(3) should be III", "III", r);
	}

	@Test
	public void testTR4() {
		String r = toRoman(4);
		assertEquals("toRoman(4) should be IV", "IV", r);
	}

	@Test
	public void testTR5() {
		String r = toRoman(5);
		assertEquals("toRoman(5) should be V", "V", r);
	}

	@Test
	public void testTR7() {
		String r = toRoman(7);
		assertEquals("toRoman(7) should be VII", "VII", r);
	}

	@Test
	public void testTR9() {
		String r = toRoman(9);
		assertEquals("toRoman(9) should be IX", "IX", r);
	}

	@Test
	public void testTR10() {
		String r = toRoman(10);
		assertEquals("toRoman(10) should be X", "X", r);
	}

	@Test
	public void testTR99() {
		String r = toRoman(99);
		assertEquals("toRoman(99) should be XCIX", "XCIX", r);
	}

	@Test
	public void testTR53() {
		String r = toRoman(53);
		assertEquals("toRoman(53) should be LIII", "LIII", r);
	}

	@Test
	public void testTR77() {
		String r = toRoman(77);
		assertEquals("toRoman(77) should be LXXVII", "LXXVII", r);
	}

	@Test
	public void testTR100() {
		String r = toRoman(100);
		assertEquals("toRoman(100) should be C", "C", r);
	}

	@Test
	public void testTR1000() {
		String r = toRoman(1000);
		assertEquals("toRoman(1000) should be M", "M", r);
	}

	@Test
	public void testLess1() {
		for (int i = 0; i > -10; i--)
			assertEquals("too low", toRoman(i));
	}

	@Test
	public void testGreater3999() {
		for (int i = 4000; i > 4010; i++)
			assertEquals("too high", toRoman(i));
	}

	@Test
	public void testTR6() {
		String r = toRoman(6);
		assertEquals("toRoman(6) should be VI", "VI", r);
	}

	public static String reduce(int i, String one, String five, String ten) {
		if (i == 9)
			return one + ten;
		if (i >= 5) {
			String res = five;
			for (int j = i - 5; j > 0; j--)
				res += one;
			return res;
		}
		if (i == 4)
			return one + five;
		String res = "";
		for (int j = 0; j < i; j++)
			res += one;
		return res;
	}

	public static String toRoman(int i) {
		if (i < 1)
			return "too low";
		if (i > 3999)
			return "too high";
		String res = "";
		while (i >= 1000) {
			res += "M";
			i -= 1000;
		}
		if (i >= 100)
			res += reduce(i / 100, "C", "D", "M");
		i %= 100;
		if (i >= 10)
			res += reduce(i / 10, "X", "L", "C");
		i %= 10;
		res += reduce(i, "I", "V", "X");
		return res;
	}

}

