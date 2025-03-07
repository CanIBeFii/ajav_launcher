package flyable.aircraft;

import flyable.Coordinates;

public class Baloon extends Aircraft {

	public Baloon(long p_id, String p_name, Coordinates p_coordinates) {
		super(p_id, p_name, p_coordinates);
	}

	public void updateConditions() {
		String weather = this.weatherTower.getWeather(this.coordinates);

		switch (weather) {
			case "SUN":
				coordinates.changeLongitude(2);
				coordinates.changeHeight(4);
				//TODO Print message to file simulation.txt
				break;
			case "RAIN":
				coordinates.changeHeight(-5);
				//TODO Print message to file simulation.txt
				break;
			case "FOG":
				coordinates.changeHeight(-3);
				//TODO Print message to file simulation.txt
				break;
			case "SNOW":
				coordinates.changeHeight(-15);
				//TODO Print message to file simulation.txt
				break;
			default:
				break;
		}
	}
	
}
