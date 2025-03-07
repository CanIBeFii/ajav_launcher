package flyable.aircraft;

import flyable.Coordinates;
import flyable.Flyable;
import tower.WeatherTower;

public abstract class Aircraft implements Flyable{
	protected long id;
	protected String name;
	protected Coordinates coordinates;
	protected WeatherTower weatherTower = null;

	protected Aircraft(long p_id, String p_name, Coordinates p_coordinates) {
		this.id = p_id;
		this.name = p_name;
		this.coordinates = p_coordinates;
	}

	public void registerTower(WeatherTower p_tower) {
		this.weatherTower = p_tower;
	}

	public void unregisterTower() {

		this.weatherTower = null;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Coordinates getCoordinates() {
		return coordinates;
	}
}
