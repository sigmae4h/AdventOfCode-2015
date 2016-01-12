package day.seven.gate;

public class GateFactory {

	public static GateStrategy getGate(String string) {
		GateStrategy gate;

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
