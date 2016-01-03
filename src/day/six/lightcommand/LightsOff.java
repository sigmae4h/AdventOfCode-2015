package day.six.lightcommand;

import day.six.Light;

public class LightsOff implements LightCommand {

	@Override
	public void execute(Light light) {
		light.turnOff();
	}
}
