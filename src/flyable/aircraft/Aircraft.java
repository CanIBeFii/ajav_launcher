package flyable.aircraft;

import flyable.Coordinates;
import flyable.Flyable;
import tower.WeatherTower;

public abstract class Aircraft implements Flyable{
	protected long id;
	protected String name;
	protected Coordinates coordinates;
	protected WeatherTower tower = null;

	protected Aircraft(long p_id, String p_name, Coordinates p_coordinates) {
		this.id = p_id;
		this.name = p_name;
		this.coordinates = p_coordinates;
	}

	public void registerTower(WeatherTower p_tower) {
		this.tower = p_tower;
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
