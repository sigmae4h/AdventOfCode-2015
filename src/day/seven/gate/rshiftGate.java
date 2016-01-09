package day.seven.gate;

public class rshiftGate extends Gate {

	@Override
	public int execute() {
		return wire1 >> wire2;
	}
}
