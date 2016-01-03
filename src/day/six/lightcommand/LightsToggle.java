package day.six.lightcommand;

import day.six.Light;

public class LightsToggle implements LightCommand {

	@Override
	public void execute(Light light) {
		light.toggle();
	}
}
