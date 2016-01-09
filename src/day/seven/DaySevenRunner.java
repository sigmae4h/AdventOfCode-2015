package day.seven;

import java.io.File;
import java.util.Scanner;

public class DaySevenRunner {
	public static void main(String[] args) {
		try (Scanner input = new Scanner(new File("Resources/Input/Seven.txt"), "UTF-8")) {
			DaySeven daySeven = new DaySeven();

			while (input.hasNext()) {
				daySeven.setWire(input.nextLine());
			}

			daySeven.runCircuit();

			System.out.println("Wire a's final signal: " + daySeven.getWire("a"));
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
