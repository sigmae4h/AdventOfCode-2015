/*
 * http://adventofcode.com/day/1
 * 
 * --- Day 1: Not Quite Lisp ---
 * 
 * Santa was hoping for a white Christmas, but his weather machine's "snow" function is powered by stars, and he's fresh 
 * out! To save Christmas, he needs you to collect fifty stars by December 25th.
 * 
 * Collect stars by helping Santa solve puzzles. Two puzzles will be made available on each day in the advent calendar; 
 * the second puzzle is unlocked when you complete the first. Each puzzle grants one star. Good luck!
 * 
 * Here's an easy puzzle to warm you up.
 * 
 * Santa is trying to deliver presents in a large apartment building, but he can't find the right floor - the directions 
 * he got are a little confusing. He starts on the ground floor (floor 0) and then follows the instructions one 
 * character at a time.
 * 
 * An opening parenthesis, (, means he should go up one floor, and a closing parenthesis, ), means he should go down one 
 * floor.
 * 
 * The apartment building is very tall, and the basement is very deep; he will never find the top or bottom floors.
 * 
 * For example:
 * 
 *     (()) and ()() both result in floor 0.
 *     ((( and (()(()( both result in floor 3.
 *     ))((((( also results in floor 3.
 *     ()) and ))( both result in floor -1 (the first basement level).
 *     ))) and )())()) both result in floor -3.
 * 
 * To what floor do the instructions take Santa?
 * 
 * --- Part Two ---
 * 
 * Now, given the same instructions, find the position of the first character that causes him to enter the basement 
 * (floor -1). The first character in the instructions has position 1, the second character has position 2, and so on.
 * 
 * For example:
 * 
 *     ) causes him to enter the basement at character position 1.
 *     ()()) causes him to enter the basement at character position 5.
 * 
 * What is the position of the character that causes Santa to first enter the basement?
 * 
 */

package day.one;

public class DayOne {

	private String data, firstBasementEntry;
	private Integer floorCount;

	public DayOne(String data) {
		if (data == null || data.length() == 0) {
			throw new IllegalArgumentException("Initial data must not be null or empty.");
		}

		this.data = data;
	}

	public int getFloorCount() {
		analyze();

		return floorCount;
	}

	public String getFirstBasementEntry() {
		analyze();
		
		if (firstBasementEntry == null) {
			firstBasementEntry = "never";
		}

		return firstBasementEntry;
	}

	private void analyze() {
		if (floorCount == null) {
			int floor = 0, dataLength = data.length();

			for (int i = 0; i < dataLength; i++) {
				switch (data.charAt(i)) {
				case '(':
					floor++;
					break;

				case ')':
					floor--;
					break;

				default: // Ignore characters that are not '(' or ')'
					break;
				}

				if (firstBasementEntry == null && floor == -1) {
					firstBasementEntry = String.valueOf(i + 1);
				}
			}

			this.floorCount = floor;
		}
	}
}
