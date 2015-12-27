/*
 * --- Day 4: The Ideal Stocking Stuffer ---
 * 
 * Santa needs help mining some AdventCoins (very similar to bitcoins) to use as gifts for all the economically 
 * forward-thinking little girls and boys.
 * 
 * To do this, he needs to find MD5 hashes which, in hexadecimal, start with at least five zeroes. The input to the MD5 
 * hash is some secret key (your puzzle input, given below) followed by a number in decimal. To mine AdventCoins, you 
 * must find Santa the lowest positive number (no leading zeroes: 1, 2, 3, ...) that produces such a hash.
 * 
 * For example:
 * 
 *     If your secret key is abcdef, the answer is 609043, because the MD5 hash of abcdef609043 starts with five zeroes 
 *     (000001dbbfa...), and it is the lowest such number to do so.
 *     If your secret key is pqrstuv, the lowest number it combines with to make an MD5 hash starting with five zeroes 
 *     is 1048970; that is, the MD5 hash of pqrstuv1048970 looks like 000006136ef....
 * 
 */

package day.four;

import java.security.MessageDigest;

public class DayFour {

	public static int calculate(String key) {
		if (key == null || key.length() == 0) {
			throw new IllegalArgumentException("Initial data must not be null or empty.");
		}
		
		int response = 0;

		try {
			MessageDigest md = MessageDigest.getInstance("MD5");

			for (int i = 0; i < Integer.MAX_VALUE; i++) {
				String test = key + i;
				md.update(test.getBytes());
				byte[] digest = md.digest();

				StringBuffer sb = new StringBuffer();
				for (byte b : digest) {
					sb.append(String.format("%02x", b & 0xff));
				}

				if (sb.toString().startsWith("00000")) {
					response = i;
					break;
				} else {
					System.out.println("Failed: " + i + " -> " + sb);
				}

				md.reset();
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		return response;
	}
}
