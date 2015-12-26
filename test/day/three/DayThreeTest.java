package day.three;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DayThreeTest {

	@Test
	public void test2() {
		int expected = 2;

		assertEquals(expected, new DayThree(">").getHouseCount());
		assertEquals(expected, new DayThree("^v^v^v^v^v").getHouseCount());
	}

	@Test
	public void test4() {
		int expected = 4;

		assertEquals(expected, new DayThree("^>v<").getHouseCount());
	}

	@Test
	public void test3WithRobo() {
		int expected = 3;

		assertEquals(expected, new DayThree("^v").getRoboCount());
		assertEquals(expected, new DayThree("^>v<").getRoboCount());
	}

	@Test
	public void test11WithRobo() {
		int expected = 11;

		assertEquals(expected, new DayThree("^v^v^v^v^v").getRoboCount());
	}

	@Test
	public void testBadInput() {
		int expected = 4;

		assertEquals(expected, new DayThree("^>hv<").getHouseCount());
	}

	@Test(expected = Exception.class)
	public void testNullInput() {
		new DayThree(null);
	}

	@Test(expected = Exception.class)
	public void testEmptyInput() {
		new DayThree("");
	}
}
