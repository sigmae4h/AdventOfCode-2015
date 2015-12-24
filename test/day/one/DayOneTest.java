package day.one;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DayOneTest {

	@Test
	public void testFloor0() {
		int expected = 0;
		
		assertEquals(expected, new DayOne("(())").getFloorCount());
		assertEquals(expected, new DayOne("()()").getFloorCount());
	}
	
	@Test
	public void testFloor3() {
		int expected = 3;
		
		assertEquals(expected, new DayOne("(((").getFloorCount());
		assertEquals(expected, new DayOne("(()(()(").getFloorCount());
		assertEquals(expected, new DayOne("))(((((").getFloorCount());
	}

	@Test
	public void testFloorMinus1() {
		int expected = -1;
		
		assertEquals(expected, new DayOne("())").getFloorCount());
		assertEquals(expected, new DayOne("))(").getFloorCount());
	}

	@Test
	public void testFloorMinus3() {
		int expected = -3;
		
		assertEquals(expected, new DayOne(")))").getFloorCount());
		assertEquals(expected, new DayOne(")())())").getFloorCount());
	}

	@Test
	public void testBadInput() {
		int expected = -3;
		
		assertEquals(expected, new DayOne(")a)b)--").getFloorCount());
		assertEquals(expected, new DayOne("c)()dd)(#$))").getFloorCount());
	}

	@Test(expected = Exception.class)
	public void testNullInput() {
		new DayOne(null);
	}

	@Test(expected = Exception.class)
	public void testEmptyInput() {
		new DayOne("");
	}

	@Test
	public void testBasementEntry1() {
		String expected = "1";
		
		assertEquals(expected, new DayOne(")").getFirstBasementEntry());
	}

	@Test
	public void testBasementEntry5() {
		String expected = "5";
		
		assertEquals(expected, new DayOne("()())").getFirstBasementEntry());
	}

	@Test
	public void testNoBasementEntry() {
		assertEquals("never", new DayOne("(((").getFirstBasementEntry());
	}
}
