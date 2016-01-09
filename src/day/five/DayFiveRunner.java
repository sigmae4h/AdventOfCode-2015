package day.five;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DayFiveRunner {

	public static void main(String[] args) {
		try (Scanner input = new Scanner(new File("Resources/Input/Five.txt"), "UTF-8")) {
			List<String> data = new ArrayList<>();
			int numNiceStrings = 0, numNiceStringsV2 = 0;

			while (input.hasNext()) {
				data.add(input.nextLine());
			}

			for (String string : data) {
				if (DayFive.isNice(string)) {
					numNiceStrings++;
				}

				if (DayFive.isNiceV2(string)) {
					numNiceStringsV2++;
				}
			}

			System.out.println("Number of nice strings: " + numNiceStrings);
			System.out.println("Number of nice strings V2: " + numNiceStringsV2);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
