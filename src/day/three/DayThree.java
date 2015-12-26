/*
 * --- Day 3: Perfectly Spherical Houses in a Vacuum ---
 * 
 * Santa is delivering presents to an infinite two-dimensional grid of houses.
 * 
 * He begins by delivering a present to the house at his starting location, and then an elf at the North Pole calls him via radio and tells him where to move next. Moves are always exactly one house to the north (^), south (v), east (>), or west (<). After each move, he delivers another present to the house at his new location.
 * 
 * However, the elf back at the north pole has had a little too much eggnog, and so his directions are a little off, and Santa ends up visiting some houses more than once. How many houses receive at least one present?
 * 
 * For example:
 * 
 *     > delivers presents to 2 houses: one at the starting location, and one to the east.
 *     ^>v< delivers presents to 4 houses in a square, including twice to the house at his starting/ending location.
 *     ^v^v^v^v^v delivers a bunch of presents to some very lucky children at only 2 houses.
 * 
 */

package day.three;

import java.util.HashMap;
import java.util.Map;

public class DayThree {
	String input;
	Integer houseCount;

	public DayThree(String input) {
		if (input == null || input.length() == 0) {
			throw new IllegalArgumentException("Initial data must not be null or empty.");
		}
		
		this.input = input.replaceAll("[^\\^v><]","");
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
}
