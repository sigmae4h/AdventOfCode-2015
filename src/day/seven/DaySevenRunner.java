package day.seven;

import java.io.File;
import java.util.Scanner;

public class DaySevenRunner {
	public static void main(String[] args) {
		DaySeven daySeven = new DaySeven();

		try (Scanner input = new Scanner(new File("Resources/Input/Seven.txt"), "UTF-8")) {
			while (input.hasNext()) {
				daySeven.setWire(input.nextLine());
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}

		long timerStart = System.currentTimeMillis();
		int signalA = daySeven.getWire("a");

		System.out.println("Wire a's final signal: " + signalA
				+ String.format(" (%.3f sec)", (System.currentTimeMillis() - timerStart) * .001));

		timerStart = System.currentTimeMillis();
		daySeven.setWire(signalA + " -> b");

		System.out.println("Wire a's final signal, part 2: " + daySeven.getWire("a")
				+ String.format(" (%.3f sec)", (System.currentTimeMillis() - timerStart) * .001));
	}
}
