package day.seven.gate;

public class notGate extends Gate {

	public int execute(int wire1, int wire2) {
		return ~wire1 & 65535;
	}
}
