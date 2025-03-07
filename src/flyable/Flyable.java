package flyable;

import tower.WeatherTower;
public interface Flyable {
	void updateConditions();
	void registerTower(WeatherTower p_tower);
	void unregisterTower();
	boolean hasLanded();
}