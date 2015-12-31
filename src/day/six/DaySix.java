/*
 * --- Day 6: Probably a Fire Hazard ---
 * 
 * Because your neighbors keep defeating you in the holiday house decorating contest year after year, you've decided to 
 * deploy one million lights in a 1000x1000 grid.
 * 
 * Furthermore, because you've been especially nice this year, Santa has mailed you instructions on how to display the 
 * ideal lighting configuration.
 * 
 * Lights in your grid are numbered from 0 to 999 in each direction; the lights at each corner are at 0,0, 0,999, 
 * 999,999, and 999,0. The instructions include whether to turn on, turn off, or toggle various inclusive ranges given 
 * as coordinate pairs. Each coordinate pair represents opposite corners of a rectangle, inclusive; a coordinate pair 
 * like 0,0 through 2,2 therefore refers to 9 lights in a 3x3 square. The lights all start turned off.
 * 
 * To defeat your neighbors this year, all you have to do is set up your lights by doing the instructions Santa sent you 
 * in order.
 * 
 * For example:
 * 
 *     turn on 0,0 through 999,999 would turn on (or leave on) every light.
 *     toggle 0,0 through 999,0 would toggle the first line of 1000 lights, turning off the ones that were on, and 
 *     turning on the ones that were off.
 *     turn off 499,499 through 500,500 would turn off (or leave off) the middle four lights.
 * 
 * After following the instructions, how many lights are lit?
 * 
 */

package day.six;

public class DaySix {

	private boolean lights[][];

	public DaySix() {
		lights = new boolean[1000][1000];
	}

	public void setLights(String input) {
		isNullOrEmpty(input);

		String commands[] = input.toLowerCase().replaceAll("t(urn|hrough)\\s", "").split("\\s");
		int from[] = convertString(commands[1].split(","));
		int to[] = convertString(commands[2].split(","));

		switch (commands[0]) {
		case "on":
			for (int i = from[0]; i <= to[0]; i++) {
				for (int j = from[1]; j <= to[1]; j++) {
					lights[i][j] = true;
				}
			}

			break;

		case "off":
			for (int i = from[0]; i <= to[0]; i++) {
				for (int j = from[1]; j <= to[1]; j++) {
					lights[i][j] = false;
				}
			}

			break;

		default: // Toggle
			for (int i = from[0]; i <= to[0]; i++) {
				for (int j = from[1]; j <= to[1]; j++) {
					lights[i][j] = !lights[i][j];
				}
			}
		
			break;
		}
	}

	public boolean[][] getLights() {
		return lights;
	}

	private static void isNullOrEmpty(String string) {
		if (string == null || string.length() == 0) {
			throw new IllegalArgumentException("Input cannot be null or empty.");
		}
	}

	private int[] convertString(String string[]) {
		int result[] = new int[string.length];

		for (int i = 0; i < string.length; i++) {
			result[i] = Integer.parseInt(string[i]);
		}

		return result;
	}
}
