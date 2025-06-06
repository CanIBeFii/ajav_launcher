import tower.WeatherTower;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import flyable.Coordinates;
import flyable.Flyable;
import flyable.aircraft.factory.AircraftFactory;
import flyable.aircraft.factory.BaloonFactory;
import flyable.aircraft.factory.HelicopterFactory;
import flyable.aircraft.factory.JetPlaneFactory;


public class Simulation {
	private int					simulationTimes;
	private WeatherTower		weatherTower;
	private AircraftFactory		factory;
	private ArrayList<Flyable>	flyables;
	private FileWriter			fileWriter;

	public Simulation(int times) throws Exception{
		this.simulationTimes = times;
		this.weatherTower = new WeatherTower();
		this.flyables = new ArrayList<Flyable>();

		File file = new File("simulation.txt");
		file.createNewFile();
		this.fileWriter = new FileWriter("simulation.txt");
		this.weatherTower.setFileWriter(fileWriter);

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
		if (!attributes[0].matches("Baloon|Helicopter|JetPlane")) {
			throw new Exception("Not known type of flyable given:" + attributes[0]);
		}
		Integer longitude = Integer.parseInt(attributes[2]);
		Integer latitude = Integer.parseInt(attributes[3]);
		Integer height = Integer.parseInt(attributes[4]);

		if (longitude < 0 || latitude < 0 || height < 0 || height > 100) {
			throw new Exception("Coordinates do not obey the law! Get him police officer, he did a crime!!");
		}
		Coordinates coordinates = Coordinates.createCoordinates(longitude, latitude, height);
		
		Flyable aircraft = factory.newAircraft(attributes[0], attributes[1], coordinates);
		aircraft.setFileWriter(fileWriter);
		flyables.add(aircraft);
		aircraft.registerTower(weatherTower);
	}

	public void runSimulation() throws Exception {
		while (simulationTimes != 0) {
			weatherTower.changeWeather();
			simulationTimes--;
		}
		fileWriter.close();
	}
}
