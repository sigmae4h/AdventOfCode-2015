package day.seven.gate;

public class rshiftGate implements GateStrategy {

	public int execute(int wire1, int wire2) {
		return wire1 >> wire2;
	}
}
