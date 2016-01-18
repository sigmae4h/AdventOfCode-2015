package day.eight;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

public class DayEightTest {

	@Test
	public void test1() {
		Integer expectedLength = 2, expectedData = 0;
		Integer results[] = DayEight.process("\"\"");
		
		assertEquals(expectedLength, results[0]);
		assertEquals(expectedData, results[1]);
	}

	@Test
	public void test2() {
		Integer expectedLength = 5, expectedData = 3;
		Integer results[] = DayEight.process("\"abc\"");
		
		assertEquals(expectedLength, results[0]);
		assertEquals(expectedData, results[1]);
	}

	@Test
	public void test3() {
		Integer expectedLength = 10, expectedData = 7;
		Integer results[] = DayEight.process("\"aaa\\\"aaa\"");
		
		assertEquals(expectedLength, results[0]);
		assertEquals(expectedData, results[1]);
	}

	@Test
	public void test4() {
		Integer expectedLength = 6, expectedData = 1;
		Integer results[] = DayEight.process("\"\\x27\"");
		
		assertEquals(expectedLength, results[0]);
		assertEquals(expectedData, results[1]);
	}

	@Test
	public void testPart1Answer() {
		Integer expectedLength = 6195, expectedData = 4845;
		Integer results[] = {0, 0};
		List<Integer[]> fileInput = new ArrayList<Integer[]>();
		
		try (Scanner input = new Scanner(new File("Resources/Input/Eight.txt"), "UTF-8")) {
			while (input.hasNext()) {
				fileInput.add(DayEight.process(input.nextLine()));
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		
		for (Integer[] integers : fileInput) {
			results[0] = results[0] + integers[0];
			results[1] = results[1] + integers[1];
		}
		
		assertEquals(expectedLength, results[0]);
		assertEquals(expectedData, results[1]);
	}
}
