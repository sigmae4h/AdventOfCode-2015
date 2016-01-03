package day.six;

public class Light {

	private boolean lightIsOn = false;
	private int brightness = 0;
	
	public void turnOn() {
		lightIsOn = true;
		brightness++;
	}
	public void turnOff() {
		lightIsOn = false;
		
		if (brightness > 0) {
			brightness--;
		}
	}
	
	public void toggle() {
		lightIsOn = !lightIsOn;
		brightness += 2;
	}
	
	public int getBrightness() {
		return brightness;
	}
	
	public boolean isLightOn() {
		return lightIsOn;
	}
}
