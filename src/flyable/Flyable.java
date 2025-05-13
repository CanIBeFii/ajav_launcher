package flyable;

import java.io.FileWriter;
import tower.WeatherTower;

public abstract class Flyable {
	protected WeatherTower weatherTower = null;

	public void registerTower(WeatherTower p_tower) throws Exception{
		this.weatherTower = p_tower;
		p_tower.register(this);
	}
	
	public void unregisterTower() throws Exception{
		weatherTower = null;
	}
	
	public abstract void updateConditions() throws Exception;
	public abstract boolean hasLanded();
	public abstract String tag();
	protected abstract void printMessage(String message) throws Exception;
	public abstract void setFileWriter(FileWriter fileWriter);
}