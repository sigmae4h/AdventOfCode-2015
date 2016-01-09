package day.seven;

import java.io.File;
import java.util.Scanner;

public class DaySevenRunner {
	public static void main(String[] args) {
		try (Scanner input = new Scanner(new File("Resources/Input/Seven.txt"), "UTF-8")) {
			while (input.hasNext()) {
				input.nextLine();
			}

			System.out.println("Wire a's final signal: ");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
