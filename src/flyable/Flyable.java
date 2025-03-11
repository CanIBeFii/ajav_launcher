package flyable;

import tower.WeatherTower;
public interface Flyable {
	void updateConditions() throws Exception;
	void registerTower(WeatherTower p_tower) throws Exception;
	void unregisterTower() throws Exception;
	boolean hasLanded();
	String tag();
}