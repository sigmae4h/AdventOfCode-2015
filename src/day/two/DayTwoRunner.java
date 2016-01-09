package day.two;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DayTwoRunner {

	public static void main(String[] args) {
		List<DayTwo> list = new ArrayList<>();
		double totalPaper = 0, totalRibbon = 0;

		try (Scanner input = new Scanner(new File("Resources/DayTwoInput.txt"), "UTF-8")) {
			while (input.hasNext()) {
				try {
					list.add(new DayTwo(input.nextLine()));
				} catch (Exception ex) {
					System.out.println("Input file error: " + ex.getMessage());
				}
			}

			for (DayTwo dayTwo : list) {
				totalPaper += dayTwo.getSurfaceArea();
				totalRibbon += dayTwo.getRibbonLength();
			}

			System.out.println(String.format("Total square feet of wrapping paper needed: %,.0f", totalPaper));
			System.out.println(String.format("Total square feet of ribbon needed: %,.0f", totalRibbon));
			System.out.println("Number of items: " + list.size());
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
