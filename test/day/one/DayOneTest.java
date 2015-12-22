package day.one;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DayOneTest {

	@Test
	public void testFloor0() {
		int expected = 0;
		
		assertEquals(expected, DayOne.getFloor("(())"));
		assertEquals(expected, DayOne.getFloor("()()"));
	}
	
	@Test
	public void testFloor3() {
		int expected = 3;
		
		assertEquals(expected, DayOne.getFloor("((("));
		assertEquals(expected, DayOne.getFloor("(()(()("));
		assertEquals(expected, DayOne.getFloor("))((((("));
	}

	@Test
	public void testFloorMinus1() {
		int expected = -1;
		
		assertEquals(expected, DayOne.getFloor("())"));
		assertEquals(expected, DayOne.getFloor("))("));
	}

	@Test
	public void testFloorMinus3() {
		int expected = -3;
		
		assertEquals(expected, DayOne.getFloor(")))"));
		assertEquals(expected, DayOne.getFloor(")())())"));
	}

	@Test
	public void testBasementEntry1() {
		int expected = 1;
		
		assertEquals(expected, DayOne.getFirstBasementEntry(")"));
	}

	@Test
	public void testBasementEntry5() {
		int expected = 5;
		
		assertEquals(expected, DayOne.getFirstBasementEntry("()())"));
	}
}
