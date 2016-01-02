package day.six.lightcommand;

public class LightsToggle implements LightCommand {

	@Override
	public boolean execute(boolean b) {
		return !b;
	}
}
