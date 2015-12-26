package day.three;

public class XmasEntity {
	private int x, y;

	public XmasEntity() {
		x = 0;
		y = 0;
	}

	public void moveEntity(Character c) {
		switch (c) {
		case '^':
			y++;
			break;

		case 'v':
			y--;
			break;

		case '<':
			x--;
			break;

		case '>':
			x++;
			break;

		default:
			break;
		}
	}

	public String getPos() {
		return String.valueOf(x + "," + y);
	}
}
