package flyable.aircraft;

import flyable.Coordinates;

public class JetPlane extends Aircraft {
	public JetPlane(long p_id, String p_name, Coordinates p_coordinates) {
		super(p_id, p_name, p_coordinates);
	}

	public void updateConditions() {
		String weather = this.weatherTower.getWeather(this.coordinates);

		switch (weather) {
			case "SUN":
				coordinates.changeHeight(2);
				coordinates.changeLatitude(10);
				//TODO Print message to file simulation.txt
				break;
			case "RAIN":
				coordinates.changeLatitude(5);
				//TODO Print message to file simulation.txt
				break;
			case "FOG":
				coordinates.changeLatitude(1);
				break;
			case "SNOW":
				coordinates.changeHeight(-7);
				//TODO Print message to file simulation.txt
				break;
			default:
				break;
		}
	}

	@Override
	public String tag() {
		return "JetPlane#" + name + "(" + id + ")";
	}
}
