/*
 * --- Day 5: Doesn't He Have Intern-Elves For This? ---
 * 
 * Santa needs help figuring out which strings in his text file are naughty or nice.
 * 
 * A nice string is one with all of the following properties:
 * 
 *     It contains at least three vowels (aeiou only), like aei, xazegov, or aeiouaeiouaeiou.
 *     It contains at least one letter that appears twice in a row, like xx, abcdde (dd), or aabbccdd (aa, bb, cc, or 
 *     dd).
 *     It does not contain the strings ab, cd, pq, or xy, even if they are part of one of the other requirements.
 * 
 * For example:
 * 
 *     ugknbfddgicrmopn is nice because it has at least three vowels (u...i...o...), a double letter (...dd...), and 
 *     none of the disallowed substrings.
 *     aaa is nice because it has at least three vowels and a double letter, even though the letters used by different 
 *     rules overlap.
 *     jchzalrnumimnmhp is naughty because it has no double letter.
 *     haegwjzuvuyypxyu is naughty because it contains the string xy.
 *     dvszwmarrgswjxmb is naughty because it contains only one vowel.
 * 
 * How many strings are nice?
 * 
 */

package day.five;

import java.util.regex.Pattern;

public class DayFive {

	public static boolean isNice(String string) {
		if (string == null || string.length() == 0) {
			throw new IllegalArgumentException("Input not be null or empty.");
		}

		string = string.toLowerCase();
		boolean response = false;
		Pattern notAllowed = Pattern.compile("ab|cd|pq|xy");
		Pattern doubleLetter = Pattern.compile("(\\w)\\1+");
		Pattern threeVowels = Pattern.compile("(?i)(?:[a-z]*[aeiou]){3}[a-z]*");

		if (!notAllowed.matcher(string).find() && doubleLetter.matcher(string).find()
				&& threeVowels.matcher(string).find()) {
			response = true;
		}

		return response;
	}
}
