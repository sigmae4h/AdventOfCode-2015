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
 * 
 * 
 * --- Part Two ---
 * 
 * You just finish implementing your winning light pattern when you realize you mistranslated Santa's message from 
 * Ancient Nordic Elvish.
 * 
 * The light grid you bought actually has individual brightness controls; each light can have a brightness of zero or 
 * more. The lights all start at zero.
 * 
 * The phrase turn on actually means that you should increase the brightness of those lights by 1.
 * 
 * The phrase turn off actually means that you should decrease the brightness of those lights by 1, to a minimum of 
 * zero.
 * 
 * The phrase toggle actually means that you should increase the brightness of those lights by 2.
 * 
 * What is the total brightness of all lights combined after following Santa's instructions?
 * 
 * For example:
 * 
 *     turn on 0,0 through 0,0 would increase the total brightness by 1.
 *     toggle 0,0 through 999,999 would increase the total brightness by 2000000.
 * 
 */

package day.six;

import day.six.lightcommand.LightCommand;
import day.six.lightcommand.LightsOff;
import day.six.lightcommand.LightsOn;
import day.six.lightcommand.LightsToggle;

public class DaySix {

	private Light lights[][];
	private int x, y;

	public DaySix() {
		x = 1000;
		y = x;
		
		lights = new Light[x][y];
		
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				lights[i][j] = new Light();
			}
		}
	}

	public void setLights(String input) {
		isNullOrEmpty(input);

		String command[] = input.toLowerCase().replaceAll("t(urn|hrough)\\s", "").split("\\s");
		int from[] = convertString(command[1]);
		int to[] = convertString(command[2]);
		LightCommand lightCommand;

		switch (command[0]) {
		case "on":
			lightCommand = new LightsOn();
			break;

		case "off":
			lightCommand = new LightsOff();
			break;

		default:
			lightCommand = new LightsToggle();
			break;
		}

		for (int i = from[0]; i <= to[0]; i++) {
			for (int j = from[1]; j <= to[1]; j++) {
				lightCommand.execute(lights[i][j]);
			}
		}
	}

	public boolean[][] getLights() {
		boolean[][] response = new boolean[x][y];
		
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				response[i][j] = lights[i][j].isLightOn();
			}
		}
		
		return response;
	}

	public int getBrightness() {
		int brightness = 0;
		
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				brightness += lights[i][j].getBrightness();
			}
		}
		
		return brightness;
	}

	private static void isNullOrEmpty(String string) {
		if (string == null || string.length() == 0) {
			throw new IllegalArgumentException("Input cannot be null or empty.");
		}
	}

	private int[] convertString(String input) {
		String string[] = input.split(",");
		int result[] = new int[string.length];

		for (int i = 0; i < string.length; i++) {
			result[i] = Integer.parseInt(string[i]);
		}

		return result;
	}
}
