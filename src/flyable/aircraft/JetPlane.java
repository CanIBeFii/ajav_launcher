package flyable.aircraft;

import flyable.Coordinates;

public class JetPlane extends Aircraft {
	public JetPlane(long p_id, String p_name, Coordinates p_coordinates) throws Exception{
		super(p_id, p_name, p_coordinates);
	}

	public void updateConditions() throws Exception {
		String weather = this.weatherTower.getCurrentWeather(this.coordinates);

		switch (weather) {
			case "SUN":
				coordinates.changeHeight(2);
				coordinates.changeLatitude(10);
				printMessage("The sun is so shinny!");
				break;
			case "RAIN":
				coordinates.changeLatitude(5);
				printMessage("It's rainning man, Aleluia.");
				break;
			case "FOG":
				coordinates.changeLatitude(1);
				printMessage("Can't see a thing outside.");
				break;
			case "SNOW":
				coordinates.changeHeight(-7);
				printMessage("Snowing? Damn climate change is crazy!");
				break;
			default:
				break;
		}
		verifyPosition();
	}

	@Override
	public String tag() {
		return "JetPlane#" + name + "(" + id + ")";
	}
}
