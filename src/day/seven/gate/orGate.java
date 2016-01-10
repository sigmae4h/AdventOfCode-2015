package day.seven.gate;

public class orGate extends Gate {

	public int execute(int wire1, int wire2) {
		return wire1 | wire2;
	}
}
