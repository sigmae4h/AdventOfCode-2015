package day.six;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DaySixTest {

	@Test
	public void testAllOn() {
		String input = "turn on 0,0 through 999,999";
		DaySix daySix = new DaySix();

		daySix.setLights(input);
		boolean lightArray[][] = daySix.getLights();

		for (boolean lightRow[] : lightArray) {
			for (boolean light : lightRow) {
				assertTrue(light);
			}
		}
	}

	@Test
	public void testToggle() {
		String input = "toggle 0,0 through 999,0";
		DaySix daySix = new DaySix();

		daySix.setLights(input);
		boolean lightArray[][] = daySix.getLights();

		for (boolean lightRow[] : lightArray) {
			for (int i = 0; i < lightRow.length; i++) {
				if (i == 0) {
					assertTrue(lightRow[i]);
				} else {
					assertFalse(lightRow[i]);
				}
			}
		}
	}

	@Test
	public void testOff() {
		String input = "turn on 0,0 through 999,999", input2 = "turn off 499,499 through 500,500";
		DaySix daySix = new DaySix();

		daySix.setLights(input);
		daySix.setLights(input2);
		boolean lightArray[][] = daySix.getLights();

		for (int i = 0; i < lightArray.length; i++) {
			for (int j = 0; j < lightArray[i].length; j++) {
				if ((i == 499 && j == 499) || (i == 499 && j == 500) || (i == 500 && j == 499)
						|| (i == 500 && j == 500)) {
					assertFalse(lightArray[i][j]);
				} else {
					assertTrue(lightArray[i][j]);
				}
			}
		}
	}

	@Test(expected = Exception.class)
	public void testNullInput() {
		new DaySix().setLights(null);
	}

	@Test(expected = Exception.class)
	public void testEmptyInput() {
		new DaySix().setLights("");
	}
}
