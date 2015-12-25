package day.two;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DayTwoRunner {

	public static void main(String[] args) {
		List<DayTwo> list = new ArrayList<>();
		double total = 0, totalRibbon = 0;
		
		try (Scanner input = new Scanner(new File("DayTwoInput.txt"), "UTF-8")) {
			while (input.hasNext()) {
				list.add(new DayTwo(input.nextLine()));
			}
			
			for (DayTwo dayTwo : list) {
				total += dayTwo.getSurfaceArea();
				totalRibbon += dayTwo.getRibbonLength();
			}
			
			System.out.println("Total square feet of wrapping paper needed: " + total);
			System.out.println("Total square feet of ribbon needed: " + totalRibbon);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
