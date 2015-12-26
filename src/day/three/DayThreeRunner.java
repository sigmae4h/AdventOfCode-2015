package day.three;

import java.io.File;
import java.util.Scanner;

public class DayThreeRunner {

	public static void main(String[] args) {
		try (Scanner input = new Scanner(new File("DayThreeInput.txt"), "UTF-8")) {
			String data = input.nextLine();

			System.out.println(
					"Number of houses that received at least one present: " + new DayThree(data, 1).getCount());
			System.out.println("With Robo-Santa: " + new DayThree(data, 2).getCount());
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
