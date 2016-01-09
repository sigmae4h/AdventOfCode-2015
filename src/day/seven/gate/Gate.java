package day.seven.gate;

public abstract class Gate {

	int wire1, wire2;

	public abstract int execute();

	public void setWires(int wire1, int wire2) {
		this.wire1 = wire1;
		this.wire2 = wire2;
	}
}
