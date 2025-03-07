import tower.WeatherTower;

import java.util.ArrayList;

import flyable.Coordinates;
import flyable.Flyable;
import flyable.aircraft.factory.AircraftFactory;
import flyable.aircraft.factory.BaloonFactory;
import flyable.aircraft.factory.HelicopterFactory;
import flyable.aircraft.factory.JetPlaneFactory;


public class Simulation {
	private int simulationTimes;
	private WeatherTower weatherTower;
	private AircraftFactory factory;
	private ArrayList<Flyable> flyables;

	public Simulation(int times) {
		this.simulationTimes = times;
		this.weatherTower = new WeatherTower();
		this.flyables = new ArrayList<Flyable>();
		AircraftFactory aircraftFactory = AircraftFactory.getInstance();
		aircraftFactory.addFactory("Baloon", BaloonFactory.getInstance());
		aircraftFactory.addFactory("Helicopter", HelicopterFactory.getInstance());
		aircraftFactory.addFactory("JetPlane", JetPlaneFactory.getInstance());
		this.factory = aircraftFactory;
	}

	public void addFlyable(String line) throws Exception{
		String regex = "[\\s]";
		String[] attributes = line.split(regex);

		if (attributes.length != 5) {
			throw new Exception("Wrong number of attribute for Flyable");
		}
		// not very good this line
		// because it makes difficult to expand the functionality of this program but come on mannn
		if (attributes[0].matches("[Baloon|Helicopter|JetPlane]")) {
			throw new Exception("Not known type of flyable given");
		}
		Integer longitude = Integer.parseInt(attributes[2]);
		Integer latitude = Integer.parseInt(attributes[3]);
		Integer height = Integer.parseInt(attributes[4]);
		Coordinates coordinates = Coordinates.createCoordinates(longitude, latitude, height);

		Flyable aircraft = factory.newAircraft(attributes[0], attributes[1], coordinates);
		flyables.add(aircraft);
		aircraft.registerTower(weatherTower);
	}

	public void runSimulation() {
		while (simulationTimes != 0) {
			weatherTower.changeWeather();
			simulationTimes--;
		}
	}
}
