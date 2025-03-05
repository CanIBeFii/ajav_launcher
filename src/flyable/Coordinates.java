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

	public int getLongitude() {
		return this.longitude;
	}

	public int getLatitude() {
		return this.latitude;
	}

	public int getHeight() {
		return this.height;
	}

	public boolean setLongitude(int p_longitude) {
		if (p_longitude >= 0) {
			this.longitude = p_longitude;
			return true;
		}
		return false;
	}

	public boolean setLatitude(int p_latitude) {
		if (p_latitude >= 0) {
			this.latitude = p_latitude;
			return true;
		}
		return false;
	}

	public boolean setHeight(int p_height) {
		if (p_height >= 0 && p_height <= 100) {
			this.height = p_height;
			return true;
		}
		return false;
	}
}
