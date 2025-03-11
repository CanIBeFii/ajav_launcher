package flyable.aircraft;

import flyable.Coordinates;

public class Helicopter extends Aircraft {
	public Helicopter(long p_id, String p_name, Coordinates p_coordinates) throws Exception{
		super(p_id, p_name, p_coordinates);
	}
	
	public void updateConditions() throws Exception{
		String weather = this.weatherTower.getWeather(this.coordinates);

		switch (weather) {
			case "SUN":
				coordinates.changeLatitude(10);
				coordinates.changeHeight(2);
				printMessage("The sun is so shinny!");
				break;
			case "RAIN":
				coordinates.changeLongitude(5);
				printMessage("It's rainning man, Aleluia.");
				break;
			case "FOG":
				coordinates.changeLongitude(1);
				printMessage("Can't see a thing outside.");
				break;
			case "SNOW":
				coordinates.changeHeight(-12);
				printMessage("Snowing? Damn climate change is crazy!");
				break;
			default:
				break;
		}
		verifyPosition();
	}

	@Override
	public String tag() {
		return "Helicopter#" + name + "(" + id + ")";
	}
}
