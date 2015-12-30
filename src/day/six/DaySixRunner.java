package day.six;

import java.io.File;
import java.util.Scanner;

public class DaySixRunner {

	public static void main(String[] args) {
		try (Scanner input = new Scanner(new File("DaySixInput.txt"), "UTF-8")) {
			DaySix daySix = new DaySix();

			System.out.println();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
