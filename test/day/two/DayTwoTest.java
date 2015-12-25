package day.two;

import static org.junit.Assert.*;

import org.junit.Test;

public class DayTwoTest {

	@Test
	public void test2x3x4() {
		int expected = 58;
		
		assertEquals(expected, new DayTwo("2x3x4").getSurfaceArea(), .1);
	}

	@Test
	public void test1x1x10() {
		int expected = 43;
		
		assertEquals(expected, new DayTwo("1x1x10").getSurfaceArea(), .1);
	}
}
