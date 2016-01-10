package day.seven;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.Scanner;

import org.junit.Test;

public class DaySevenTest {

	@Test
	public void testSetWire() {
		DaySeven daySeven = new DaySeven();
		int expected = 123;

		daySeven.setWire("123 -> x");

		assertEquals(expected, daySeven.getWire("x"));
	}

	@Test
	public void testAndGate() {
		DaySeven daySeven = new DaySeven();
		int expected = 72;

		daySeven.setWire("123 -> x");
		daySeven.setWire("456 -> y");
		daySeven.setWire("x AND y -> d");

		assertEquals(expected, daySeven.getWire("d"));
	}

	@Test
	public void testOrGate() {
		DaySeven daySeven = new DaySeven();
		int expected = 507;

		daySeven.setWire("123 -> x");
		daySeven.setWire("456 -> y");
		daySeven.setWire("x OR y -> e");

		assertEquals(expected, daySeven.getWire("e"));
	}

	@Test
	public void testLshiftGate() {
		DaySeven daySeven = new DaySeven();
		int expected = 492;

		daySeven.setWire("123 -> x");
		daySeven.setWire("x LSHIFT 2 -> f");

		assertEquals(expected, daySeven.getWire("f"));
	}

	@Test
	public void testRshiftGate() {
		DaySeven daySeven = new DaySeven();
		int expected = 114;

		daySeven.setWire("456 -> y");
		daySeven.setWire("y RSHIFT 2 -> g");

		assertEquals(expected, daySeven.getWire("g"));
	}

	@Test
	public void testNotGate() {
		DaySeven daySeven = new DaySeven();
		int expectedX = 65412, expectedY = 65079;

		daySeven.setWire("123 -> x");
		daySeven.setWire("456 -> y");
		daySeven.setWire("NOT x -> h");
		daySeven.setWire("NOT y -> i");

		assertEquals(expectedX, daySeven.getWire("h"));
		assertEquals(expectedY, daySeven.getWire("i"));
	}

	@Test
	public void testUnorderedLshiftGate() {
		DaySeven daySeven = new DaySeven();
		int expected = 492;

		daySeven.setWire("x LSHIFT 2 -> f");
		daySeven.setWire("123 -> x");

		assertEquals(expected, daySeven.getWire("f"));
	}

	@Test
	public void testDirectAndGate() {
		DaySeven daySeven = new DaySeven();
		int expected = 0;

		daySeven.setWire("456 -> y");
		daySeven.setWire("1 AND y -> d");

		assertEquals(expected, daySeven.getWire("d"));
	}

	@Test
	public void testWireToWire() {
		DaySeven daySeven = new DaySeven();
		int expected = 456;

		daySeven.setWire("456 -> y");
		daySeven.setWire("y -> d");

		assertEquals(expected, daySeven.getWire("d"));
	}

	@Test(expected = Exception.class)
	public void testNullInput() {
		new DaySeven().setWire(null);
	}

	@Test(expected = Exception.class)
	public void testEmptyInput() {
		new DaySeven().setWire("");
	}

	@Test
	public void testPart1Answer() {
		DaySeven daySeven = new DaySeven();
		int expected = 46065;

		try (Scanner input = new Scanner(new File("Resources/Input/Seven.txt"), "UTF-8")) {
			while (input.hasNext()) {
				daySeven.setWire(input.nextLine());
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		
		assertEquals(expected, daySeven.getWire("a"));
	}

	@Test
	public void testPart2Answer() {
		DaySeven daySeven = new DaySeven();
		int expected = 14134, signalA = 46065;

		try (Scanner input = new Scanner(new File("Resources/Input/Seven.txt"), "UTF-8")) {
			while (input.hasNext()) {
				daySeven.setWire(input.nextLine());
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		
		daySeven.setWire(signalA + " -> b");
		
		assertEquals(expected, daySeven.getWire("a"));
	}
}
