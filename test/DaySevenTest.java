
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import day.seven.DaySeven;

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

		daySeven.runCircuit();

		assertEquals(expected, daySeven.getWire("d"));
	}

	@Test
	public void testOrGate() {
		DaySeven daySeven = new DaySeven();
		int expected = 507;

		daySeven.setWire("123 -> x");
		daySeven.setWire("456 -> y");
		daySeven.setWire("x OR y -> e");

		daySeven.runCircuit();

		assertEquals(expected, daySeven.getWire("e"));
	}

	@Test
	public void testLshiftGate() {
		DaySeven daySeven = new DaySeven();
		int expected = 492;

		daySeven.setWire("123 -> x");
		daySeven.setWire("x LSHIFT 2 -> f");

		daySeven.runCircuit();

		assertEquals(expected, daySeven.getWire("f"));
	}

	@Test
	public void testRshiftGate() {
		DaySeven daySeven = new DaySeven();
		int expected = 114;

		daySeven.setWire("456 -> y");
		daySeven.setWire("y RSHIFT 2 -> g");

		daySeven.runCircuit();

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

		daySeven.runCircuit();

		assertEquals(expectedX, daySeven.getWire("h"));
		assertEquals(expectedY, daySeven.getWire("i"));
	}

	@Test
	public void testUnorderedLshiftGate() {
		DaySeven daySeven = new DaySeven();
		int expected = 492;

		daySeven.setWire("x LSHIFT 2 -> f");
		daySeven.setWire("123 -> x");

		daySeven.runCircuit();

		assertEquals(expected, daySeven.getWire("f"));
	}

	@Test
	public void testDirectAndGate() {
		DaySeven daySeven = new DaySeven();
		int expected = 0;

		daySeven.setWire("456 -> y");
		daySeven.setWire("1 AND y -> d");

		daySeven.runCircuit();

		assertEquals(expected, daySeven.getWire("d"));
	}

	@Test
	public void testWireToWire() {
		DaySeven daySeven = new DaySeven();
		int expected = 456;

		daySeven.setWire("456 -> y");
		daySeven.setWire("y -> d");

		daySeven.runCircuit();

		assertEquals(expected, daySeven.getWire("d"));
	}
}
