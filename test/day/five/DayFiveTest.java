package day.five;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DayFiveTest {

	@Test
	public void testNice1() {
		assertTrue(DayFive.isNice("ugknbfddgicrmopn"));
	}

	@Test
	public void testNice2() {
		assertTrue(DayFive.isNice("aaa"));
	}

	@Test
	public void testNaughty1() {
		assertFalse(DayFive.isNice("jchzalrnumimnmhp"));
	}

	@Test
	public void testNaughty2() {
		assertFalse(DayFive.isNice("haegwjzuvuyypxyu"));
	}

	@Test
	public void testNaughty3() {
		assertFalse(DayFive.isNice("dvszwmarrgswjxmb"));
	}

	@Test(expected = Exception.class)
	public void testNullInput() {
		DayFive.isNice(null);
	}

	@Test(expected = Exception.class)
	public void testEmptyInput() {
		DayFive.isNice("");
	}
}
