package day.four;

public class DayFourRunner {

	public static void main(String[] args) {
		System.out.println("The MD5 hash for 5 0's is: " + DayFour.calculate("ckczppom", "00000"));
		System.out.println("The MD5 hash for 6 0's is: " + DayFour.calculate("ckczppom", "000000"));
	}
}
