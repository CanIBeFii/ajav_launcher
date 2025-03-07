package tower;

import java.util.Random;

import flyable.Coordinates;

public class WeatherTower extends Tower{
	private int weatherVariable;
	private Random numberGenerator;
	private final static String[] weather = {"RAIN", "SUN", "SNOW", "FOG"};

	public WeatherTower() {
		super();
		this.weatherVariable = 0;
		this.numberGenerator =  new Random();
	}

	public String getWeather(Coordinates p_coordinates) {
		String newWeather = weather[p_coordinates.getLongitude() 
					+ p_coordinates.getLatitude()
					+ p_coordinates.getHeight()
					+ weatherVariable];
		return newWeather;
	}

	public void changeWeather() {
		this.weatherVariable = this.numberGenerator.nextInt(4);
		conditionChanged();
	}
}


