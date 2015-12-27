package day.four;

import static org.junit.Assert.*;

import org.junit.Test;

import day.four.DayFour;

public class DayFourTest {

	@Test
	public void testAbcdef() {
		int expected = 0x609043;

		assertEquals(expected, DayFour.calculate("abcdef"));
	}

	@Test
	public void testPqrstuv() {
		int expected = 0x1048970;

		assertEquals(expected, DayFour.calculate("pqrstuv"));
	}

	@Test(expected = Exception.class)
	public void testNullInput() {
		DayFour.calculate(null);
	}

	@Test(expected = Exception.class)
	public void testEmptyInput() {
		DayFour.calculate("");
	}
}
