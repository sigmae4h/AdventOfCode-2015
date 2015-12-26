package day.three;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DayThreeTest {

	@Test
	public void test2() {
		int expected = 2;

		assertEquals(expected, new DayThree(">", 1).getCount());
		assertEquals(expected, new DayThree("^v^v^v^v^v", 1).getCount());
	}

	@Test
	public void test4() {
		int expected = 4;

		assertEquals(expected, new DayThree("^>v<", 1).getCount());
	}

	@Test
	public void test3WithRobo() {
		int expected = 3;

		assertEquals(expected, new DayThree("^v", 2).getCount());
		assertEquals(expected, new DayThree("^>v<", 2).getCount());
	}

	@Test
	public void test11WithRobo() {
		int expected = 11;

		assertEquals(expected, new DayThree("^v^v^v^v^v", 2).getCount());
	}

	@Test
	public void testBadInput() {
		int expected = 4;

		assertEquals(expected, new DayThree("^>hV<", 1).getCount());
	}

	@Test(expected = Exception.class)
	public void testNullInput() {
		new DayThree(null, 1);
	}

	@Test(expected = Exception.class)
	public void testEmptyInput() {
		new DayThree("", 1);
	}

	@Test(expected = Exception.class)
	public void testInvalidEntitieCount() {
		new DayThree("^v", 0);
	}
}
