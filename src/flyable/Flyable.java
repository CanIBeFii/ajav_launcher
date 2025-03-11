package flyable;

import java.io.FileWriter;

import tower.WeatherTower;
public interface Flyable {
	void updateConditions() throws Exception;
	void registerTower(WeatherTower p_tower) throws Exception;
	void unregisterTower() throws Exception;
	boolean hasLanded();
	String tag();
	public void setFileWriter(FileWriter fileWriter);
}