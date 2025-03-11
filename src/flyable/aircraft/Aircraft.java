package flyable.aircraft;

import java.io.FileWriter;

import flyable.Coordinates;
import flyable.Flyable;
import tower.WeatherTower;

public abstract class Aircraft implements Flyable{
	protected long id;
	protected String name;
	protected Coordinates coordinates;
	protected boolean landed;
	protected FileWriter fileWriter;
	protected WeatherTower weatherTower = null;


	protected Aircraft(long p_id, String p_name, Coordinates p_coordinates) throws Exception{
		this.id = p_id;
		this.name = p_name;
		this.coordinates = p_coordinates;
		this.landed = false;
		this.fileWriter = null;
	}

	public void registerTower(WeatherTower p_tower) throws Exception{
		this.weatherTower = p_tower;
		p_tower.register(this);
	}

	public void unregisterTower() throws Exception{
		weatherTower = null;
	}

	public void setFileWriter(FileWriter fileWriter) {
		this.fileWriter = fileWriter;
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

	protected void verifyPosition() throws Exception{
		if (coordinates.getHeight() <= 0) {
			landed = true;
			printMessage("Has landed");
		}
	}

	public String tag() {
		return "Aircraft#" + name + "(" + id + ")";
	}

	protected void printMessage(String message) throws Exception {
		fileWriter.write(tag() + ": " + message + "\n");
	}
}
