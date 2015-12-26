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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DayThree {
	private String input;
	private Integer numEntities, count;

	public DayThree(String input, int numEntities) {
		if (input == null || input.length() == 0) {
			throw new IllegalArgumentException("Initial data must not be null or empty.");
		}

		if (numEntities <= 0) {
			throw new IllegalArgumentException("Number of entities must be 1 or more.");
		}

		this.input = input.toLowerCase().replaceAll("[^\\^v><]", "");
		this.numEntities = numEntities;
	}

	public int getCount() {
		if (count == null) {
			int dataLength = input.length();
			List<XmasEntity> entities = new ArrayList<>();
			Map<String, Integer> map = new HashMap<>();

			for (int i = 0; i < numEntities; i++) {
				entities.add(new XmasEntity());
			}

			String key = entities.get(0).getPos();

			map.put(key, numEntities);

			for (int i = 0; i < dataLength; i++) {
				XmasEntity entity = entities.get(i % numEntities);

				entity.moveEntity(input.charAt(i));
				key = entity.getPos();

				if (map.containsKey(key)) {
					map.replace(key, map.get(key) + 1);
				} else {
					map.put(key, 1);
				}
			}

			count = map.size();
		}

		return count;
	}
}
