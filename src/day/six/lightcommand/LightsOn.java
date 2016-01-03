package day.six.lightcommand;

import day.six.Light;

public class LightsOn implements LightCommand {

	@Override
	public void execute(Light light) {
		light.turnOn();
	}
}
