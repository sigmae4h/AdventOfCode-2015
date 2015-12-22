package day.one;

public class DayOne {

	public static int getFloor(String input) {
		int floorCount = 0;
		
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '(') {
				floorCount++;
			} else {
				floorCount--;
			}
		}
		
		return floorCount;
	}
}
