package day.four;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DayFourTest {

	@Test
	public void testAbcdef() {
		int expected = 609043;

		assertEquals(expected, DayFour.calculate("abcdef", "00000"));
	}

	@Test
	public void testPqrstuv() {
		int expected = 1048970;

		assertEquals(expected, DayFour.calculate("pqrstuv", "00000"));
	}

	@Test(expected = Exception.class)
	public void testNullInput() {
		DayFour.calculate(null, "00000");
	}

	@Test(expected = Exception.class)
	public void testEmptyInput() {
		DayFour.calculate("", "00000");
	}

	@Test(expected = Exception.class)
	public void testPrefixNullInput() {
		DayFour.calculate("abcdef", null);
	}

	@Test(expected = Exception.class)
	public void testPrefixEmptyInput() {
		DayFour.calculate("abcdef", "");
	}
}
