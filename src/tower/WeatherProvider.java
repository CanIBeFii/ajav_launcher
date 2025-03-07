package tower;

import java.util.Random;

import flyable.Coordinates;

public class WeatherProvider {
	private final static WeatherProvider instance = new WeatherProvider();
	private Random weatherGenerator;
	private final static String[] weather = {"RAIN", "SUN", "SNOW", "FOG"};


	private WeatherProvider() {
		this.weatherGenerator =  new Random();
	}

	public static WeatherProvider getInstance() {
		return instance;
	}
	
	public String getWeather(Coordinates p_coordinates) {
		int weatherVariable = weatherGenerator.nextInt(4);
		String newWeather = weather[p_coordinates.getLongitude() 
					+ p_coordinates.getLatitude()
					+ p_coordinates.getHeight()
					+ weatherVariable];
		return newWeather;
	}
}
