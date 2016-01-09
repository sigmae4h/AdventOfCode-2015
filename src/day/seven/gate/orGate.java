package day.seven.gate;

public class orGate extends Gate {

	@Override
	public int execute() {
		return wire1 | wire2;
	}
}
