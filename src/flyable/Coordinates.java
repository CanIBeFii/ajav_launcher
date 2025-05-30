package flyable;

public class Coordinates {
	private int longitude;
	private int latitude;
	private int height;

	Coordinates(int p_longitude, int p_latitude, int p_height) {
		this.longitude = p_longitude;
		this.latitude = p_latitude;
		this.height = p_height;
	}

	public static Coordinates createCoordinates(int p_longitude, int p_latitude, int p_height) {
		return new Coordinates(p_longitude, p_latitude, p_height);
	}

	public int getLongitude() {
		return this.longitude;
	}

	public int getLatitude() {
		return this.latitude;
	}

	public int getHeight() {
		return this.height;
	}

	public void changeLongitude(int change) {
		this.longitude += change;
	}

	public void changeLatitude(int change) {
		this.latitude += change;
	}

	public void changeHeight(int change) {
		this.height += change;
		if(height > 100) {
			this.height = 100;
		}
	}
}
