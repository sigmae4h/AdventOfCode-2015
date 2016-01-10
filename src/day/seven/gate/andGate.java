package day.seven.gate;

public class andGate implements Gate {

	public int execute(int wire1, int wire2) {
		return wire1 & wire2;
	}
}
