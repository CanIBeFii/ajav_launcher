package flyable.aircraft;

import flyable.Coordinates;

public class Baloon extends Aircraft {

	public Baloon(long p_id, String p_name, Coordinates p_coordinates) throws Exception{
		super(p_id, p_name, p_coordinates);
	}

	public void updateConditions() throws Exception {
		String weather = this.weatherTower.getCurrentWeather(this.coordinates);

		switch (weather) {
			case "SUN":
				coordinates.changeLongitude(2);
				coordinates.changeHeight(4);
				printMessage("The sun is so shinny!");
				break;
			case "RAIN":
				coordinates.changeHeight(-5);
				printMessage("It's rainning man, Aleluia.");
				break;
			case "FOG":
				coordinates.changeHeight(-3);
				printMessage("Can't see a thing outside.");
				break;
			case "SNOW":
				coordinates.changeHeight(-15);
				printMessage("Snowing? Damn climate change is crazy!");
				break;
			default:
				break;
		}
		verifyPosition();
	}

	@Override
	public String tag() {
		return "Baloon#" + name + "(" + id + ")";
	}
	
}
