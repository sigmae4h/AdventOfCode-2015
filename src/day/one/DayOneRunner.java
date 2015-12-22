package day.one;

import java.io.BufferedReader;
import java.io.FileReader;

public class DayOneRunner {

	public static void main(String[] args) {
		String input = "";		
		
		try (BufferedReader br = new BufferedReader(new FileReader("DayOneInput.txt"))) {
			input = br.readLine();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		System.out.println("Ending floor: " + DayOne.getFloor(input));
		System.out.println("First basement entry: " + DayOne.getFirstBasementEntry(input));
	}
}
