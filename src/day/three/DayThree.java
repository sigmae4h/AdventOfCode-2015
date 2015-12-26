/*
 * --- Day 3: Perfectly Spherical Houses in a Vacuum ---
 * 
 * Santa is delivering presents to an infinite two-dimensional grid of houses.
 * 
 * He begins by delivering a present to the house at his starting location, and then an elf at the North Pole calls him 
 * via radio and tells him where to move next. Moves are always exactly one house to the north (^), south (v), east (>), 
 * or west (<). After each move, he delivers another present to the house at his new location.
 * 
 * However, the elf back at the north pole has had a little too much eggnog, and so his directions are a little off, and 
 * Santa ends up visiting some houses more than once. How many houses receive at least one present?
 * 
 * For example:
 * 
 *     > delivers presents to 2 houses: one at the starting location, and one to the east.
 *     ^>v< delivers presents to 4 houses in a square, including twice to the house at his starting/ending location.
 *     ^v^v^v^v^v delivers a bunch of presents to some very lucky children at only 2 houses.
 * 
 * 
 * 
 * --- Part Two ---
 * 
 * The next year, to speed up the process, Santa creates a robot version of himself, Robo-Santa, to deliver presents 
 * with him.
 * 
 * Santa and Robo-Santa start at the same location (delivering two presents to the same starting house), then take turns 
 * moving based on instructions from the elf, who is eggnoggedly reading from the same script as the previous year.
 * 
 * This year, how many houses receive at least one present?
 * 
 * For example:
 * 
 *     ^v delivers presents to 3 houses, because Santa goes north, and then Robo-Santa goes south.
 *     ^>v< now delivers presents to 3 houses, and Santa and Robo-Santa end up back where they started.
 *     ^v^v^v^v^v now delivers presents to 11 houses, with Santa going one direction and Robo-Santa going the other.
 *     
 */

package day.three;

import java.util.HashMap;
import java.util.Map;

public class DayThree {
	private String input;
	private Integer houseCount, roboCount;

	public DayThree(String input) {
		if (input == null || input.length() == 0) {
			throw new IllegalArgumentException("Initial data must not be null or empty.");
		}

		this.input = input.toLowerCase().replaceAll("[^\\^v><]", "");
	}

	public int getHouseCount() {
		if (houseCount == null) {
			int x = 0, y = 0, dataLength = input.length();
			String key = String.valueOf(x + "," + y);
			Map<String, Integer> map = new HashMap<>();
			
			map.put(key, 1);

			for (int i = 0; i < dataLength; i++) {
				switch (input.charAt(i)) {
				case '^':
					y++;
					break;

				case 'v':
					y--;
					break;

				case '<':
					x--;
					break;

				case '>':
					x++;
					break;
				}

				key = String.valueOf(x + "," + y);

				if (map.containsKey(key)) {
					map.replace(key, map.get(key) + 1);
				} else {
					map.put(key, 1);
				}
			}

			houseCount = map.size();
		}

		return houseCount;
	}

	public int getRoboCount() {
		if (roboCount == null) {
			int santaX = 0, santaY = 0, roboX = 0, roboY = 0, dataLength = input.length();
			String key = String.valueOf(santaX + "," + santaY);
			Map<String, Integer> map = new HashMap<>();
			
			map.put(key, 2);

			for (int i = 0; i < dataLength; i++) {
				if (i % 2 == 0) {
					switch (input.charAt(i)) {
					case '^':
						roboY++;
						break;

					case 'v':
						roboY--;
						break;

					case '<':
						roboX--;
						break;

					case '>':
						roboX++;
						break;
					}

					key = String.valueOf(roboX + "," + roboY);
				} else {
					switch (input.charAt(i)) {
					case '^':
						santaY++;
						break;

					case 'v':
						santaY--;
						break;

					case '<':
						santaX--;
						break;

					case '>':
						santaX++;
						break;
					}

					key = String.valueOf(santaX + "," + santaY);
				}

				if (map.containsKey(key)) {
					map.replace(key, map.get(key) + 1);
				} else {
					map.put(key, 1);
				}
			}

			roboCount = map.size();
		}

		return roboCount;
	}
}
