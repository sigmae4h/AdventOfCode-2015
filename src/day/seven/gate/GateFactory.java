package day.seven.gate;

public class GateFactory {

	public static Gate getGate(String string) {
		Gate gate;

		switch (string.toLowerCase()) {
		case "and":
			gate = new andGate();
			break;

		case "or":
			gate = new orGate();
			break;

		case "lshift":
			gate = new lshiftGate();
			break;

		case "rshift":
			gate = new rshiftGate();
			break;

		default: // Case "not"
			gate = new notGate();
			break;
		}

		return gate;
	}
}
