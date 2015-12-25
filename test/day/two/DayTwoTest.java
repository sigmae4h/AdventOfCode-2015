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

	@Test
	public void test2x3x4Ribbon() {
		int expected = 34;
		
		assertEquals(expected, new DayTwo("2x3x4").getRibbonLength(), .1);
	}

	@Test
	public void test1x1x10Ribbon() {
		int expected = 14;
		
		assertEquals(expected, new DayTwo("1x1x10").getRibbonLength(), .1);
	}
}
