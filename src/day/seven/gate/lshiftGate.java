package day.seven.gate;

public class lshiftGate extends Gate {

	@Override
	public int execute() {
		return wire1 << wire2;
	}
}
