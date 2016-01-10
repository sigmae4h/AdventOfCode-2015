package day.seven.gate;

public class notGate implements Gate {

	public int execute(int wire1, int wire2) {
		return ~wire2 & 65535;
	}
}
