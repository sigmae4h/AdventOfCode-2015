package day.seven.gate;

public class notGate extends Gate {

	@Override
	public int execute() {
		return ~wire1 & 65535;
	}
}
