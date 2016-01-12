package day.seven.gate;

public class notGate implements GateStrategy {

	public int execute(int wire1, int wire2) {
		return ~wire2 & 65535;
	}
}
