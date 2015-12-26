package day.three;

import java.io.File;
import java.util.Scanner;

import day.three.DayThree;

public class DayThreeRunner {

	public static void main(String[] args) {
		try (Scanner input = new Scanner(new File("DayThreeInput.txt"), "UTF-8")) {
			DayThree dayThree = new DayThree(input.nextLine());

			System.out.println(
					String.format("Number of houses that receive at least one present: %,d", dayThree.getHouseCount()));
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
