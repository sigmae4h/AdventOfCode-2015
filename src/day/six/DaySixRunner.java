package day.six;

import java.io.File;
import java.util.Scanner;

public class DaySixRunner {

	public static void main(String[] args) {
		try (Scanner input = new Scanner(new File("DaySixInput.txt"), "UTF-8")) {
			DaySix daySix = new DaySix();

			while (input.hasNext()) {
				daySix.setLights(input.nextLine());
			}

			int illuminationCount = 0;

			for (boolean lightRow[] : daySix.getLights()) {
				for (boolean light : lightRow) {
					if (light) {
						illuminationCount++;
					}
				}
			}

			System.out.println("Lights lit: " + illuminationCount);
			System.out.println("Brightness: " + daySix.getBrightness());
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
