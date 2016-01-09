/*
 * --- Day 7: Some Assembly Required ---
 * 
 * This year, Santa brought little Bobby Tables a set of wires and bitwise logic gates! Unfortunately, little Bobby is a 
 * little under the recommended age range, and he needs help assembling the circuit.
 * 
 * Each wire has an identifier (some lowercase letters) and can carry a 16-bit signal (a number from 0 to 65535). A 
 * signal is provided to each wire by a gate, another wire, or some specific value. Each wire can only get a signal from 
 * one source, but can provide its signal to multiple destinations. A gate provides no signal until all of its inputs 
 * have a signal.
 * 
 * The included instructions booklet describes how to connect the parts together: x AND y -> z means to connect wires x 
 * and y to an AND gate, and then connect its output to wire z.
 * 
 * For example:
 * 
 *     123 -> x means that the signal 123 is provided to wire x.
 *     x AND y -> z means that the bitwise AND of wire x and wire y is provided to wire z.
 *     p LSHIFT 2 -> q means that the value from wire p is left-shifted by 2 and then provided to wire q.
 *     NOT e -> f means that the bitwise complement of the value from wire e is provided to wire f.
 * 
 * Other possible gates include OR (bitwise OR) and RSHIFT (right-shift). If, for some reason, you'd like to emulate the 
 * circuit instead, almost all programming languages (for example, C, JavaScript, or Python) provide operators for these 
 * gates.
 * 
 * For example, here is a simple circuit:
 * 
 * 123 -> x
 * 456 -> y
 * x AND y -> d
 * x OR y -> e
 * x LSHIFT 2 -> f
 * y RSHIFT 2 -> g
 * NOT x -> h
 * NOT y -> i
 * 
 * After it is run, these are the signals on the wires:
 * 
 * d: 72
 * e: 507
 * f: 492
 * g: 114
 * h: 65412
 * i: 65079
 * x: 123
 * y: 456
 * 
 * In little Bobby's kit's instructions booklet (provided as your puzzle input), what signal is ultimately provided to 
 * wire a?
 * 
 *
 * 
 * --- Part Two ---
 * 
 * Now, take the signal you got on wire a, override wire b to that signal, and reset the other wires (including wire a).
 * What new signal is ultimately provided to wire a?
 * 
 */

package day.seven;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import day.seven.gate.Gate;
import day.seven.gate.GateFactory;

public class DaySeven {

	private Map<String, String> wires;

	public DaySeven() {
		wires = new HashMap<String, String>();
	}

	public void setWire(String input) {
		isNullOrEmpty(input);

		String command[] = input.split(" -> ");
		wires.put(command[1], command[0]);
	}

	public void runCircuit() {

		Map<String, String> temp = new HashMap<String, String>(wires);

		while (temp.size() > 0) {
			Iterator<Entry<String, String>> it = temp.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry<String, String> pair = (Map.Entry<String, String>) it.next();
				if (pair.getValue().matches("\\d+")) {
					wires.put(pair.getKey(), pair.getValue());
					it.remove();
				} else {
					try {
						String options[] = pair.getValue().split("\\s");
						Gate gate;

						if (options.length == 1) {
							temp.put(pair.getKey(), wires.get(options[0]));
						} else {
							if ("NOT".equals(options[0])) {

								gate = GateFactory.getGate(options[0]);

								gate.setWires(Integer.parseInt(wires.get(options[1])), 0);
							} else {
								gate = GateFactory.getGate(options[1]);

								if (options[2].matches("\\d+")) {
									gate.setWires(Integer.parseInt(wires.get(options[0])),
											Integer.parseInt(options[2]));
								} else if (options[0].matches("\\d+")) {
									gate.setWires(Integer.parseInt(options[0]),
											Integer.parseInt(wires.get(options[2])));
								} else {
									gate.setWires(Integer.parseInt(wires.get(options[0])),
											Integer.parseInt(wires.get(options[2])));
								}
							}
							temp.put(pair.getKey(), String.valueOf(gate.execute()));
						}
					} catch (Exception e) {
						// System.out.println(e);
					}
				}
			}
		}
	}

	public int getWire(String string) {
		return Integer.parseInt(wires.get(string));
	}

	private static void isNullOrEmpty(String string) {
		if (string == null || string.length() == 0) {
			throw new IllegalArgumentException("Input cannot be null or empty.");
		}
	}
}
