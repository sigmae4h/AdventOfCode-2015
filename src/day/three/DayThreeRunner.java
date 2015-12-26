package day.three;

import java.io.File;
import java.util.Scanner;

import day.three.DayThree;

public class DayThreeRunner {

	public static void main(String[] args) {
		try (Scanner input = new Scanner(new File("DayThreeInput.txt"), "UTF-8")) {
			DayThree dayThree = new DayThree(input.nextLine());

			System.out.println("Number of houses that received at least one present: " + dayThree.getHouseCount());
			System.out.println("With Robo-Santa: " + dayThree.getRoboCount());
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
