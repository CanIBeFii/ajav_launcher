package flyable;

import tower.WeatherTower;

public abstract class Flyable {

	protected WeatherTower tower = null;

	public Flyable() {}
	abstract void updateConditions();
	public void registerTower(WeatherTower p_tower) {
		this.tower = p_tower;
	}
}