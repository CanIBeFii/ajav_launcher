package tower;

import flyable.Coordinates;

public class WeatherTower extends Tower{

	public WeatherTower() throws Exception{
		super();
	}

	public String getWeather(Coordinates p_coordinates) {
		return WeatherProvider.getInstance().getWeather(p_coordinates);
	}

	public void changeWeather() throws Exception {
		conditionChanged();
	}
}