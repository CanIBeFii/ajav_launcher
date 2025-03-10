package flyable.aircraft;

import flyable.Coordinates;
import flyable.Flyable;
import tower.WeatherTower;

public abstract class Aircraft implements Flyable{
	protected long id;
	protected String name;
	protected Coordinates coordinates;
	protected boolean landed;
	protected WeatherTower weatherTower = null;

	protected Aircraft(long p_id, String p_name, Coordinates p_coordinates) {
		this.id = p_id;
		this.name = p_name;
		this.coordinates = p_coordinates;
		this.landed = false;
	}

	public void registerTower(WeatherTower p_tower) {
		this.weatherTower = p_tower;
		p_tower.register(this);
	}

	public void unregisterTower() {
		weatherTower.unregister(this);
		weatherTower = null;
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

	public boolean hasLanded() {
		return landed;
	}

	protected void verifyPosition() {
		if (coordinates.getHeight() <= 0) {
			landed = true;
		}
	}

	public String aircraftTag() {
		return "Aircraft#" + name + "(" + id + "): ";
	}
}
