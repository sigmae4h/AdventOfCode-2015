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

	@Test
	public void testNice1V2() {
		assertTrue(DayFive.isNiceV2("qjhvhtzxzqqjkmpb"));
	}

	@Test
	public void testNice2V2() {
		assertTrue(DayFive.isNiceV2("xxyxx"));
	}

	@Test
	public void testNaughty1V2() {
		assertFalse(DayFive.isNiceV2("uurcxstgmygtbstg"));
	}

	@Test
	public void testNaughty2V2() {
		assertFalse(DayFive.isNiceV2("ieodomkazucvgmuy"));
	}

	@Test(expected = Exception.class)
	public void testNullInput2() {
		DayFive.isNiceV2(null);
	}

	@Test(expected = Exception.class)
	public void testEmptyInput2() {
		DayFive.isNiceV2("");
	}
}
