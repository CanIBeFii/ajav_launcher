package flyable.aircraft;

import flyable.Coordinates;

public class Helicopter extends Aircraft {
	public Helicopter(long p_id, String p_name, Coordinates p_coordinates) {
		super(p_id, p_name, p_coordinates);
	}
	
	public void updateConditions() {
		String weather = this.weatherTower.getWeather(this.coordinates);

		switch (weather) {
			case "SUN":
				coordinates.changeLatitude(10);
				coordinates.changeHeight(2);
				//TODO Print message to file simulation.txt
				break;
			case "RAIN":
				coordinates.changeLongitude(5);
				//TODO Print message to file simulation.txt
				break;
			case "FOG":
				coordinates.changeLongitude(1);
				//TODO Print message to file simulation.txt
				break;
			case "SNOW":
				coordinates.changeHeight(-12);
				//TODO Print message to file simulation.txt
				break;
			default:
				break;
		}
	}

	@Override
	public String aircraftTag() {
		return "Helicopter#" + name + "(" + id + "): ";
	}
}
