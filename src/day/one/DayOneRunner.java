package day.one;

import java.io.BufferedReader;
import java.io.FileReader;

public class DayOneRunner {

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new FileReader("Resources/DayOneInput.txt"))) {
			DayOne dayOne = new DayOne(br.readLine());
			
			System.out.println("Ending floor: " + dayOne.getFloorCount());
			System.out.println("First basement entry: " + dayOne.getFirstBasementEntry());
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
