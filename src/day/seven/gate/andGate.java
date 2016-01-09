package day.seven.gate;

public class andGate extends Gate {

	@Override
	public int execute() {
		return wire1 & wire2;
	}
}
