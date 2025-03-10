package flyable.aircraft.factory;

import java.util.HashMap;

import flyable.Coordinates;
import flyable.Flyable;

public class AircraftFactory {
	private final static AircraftFactory instance = new AircraftFactory();
	private long aircraftIds;
	private HashMap<String, Factory> factories;
	
	private AircraftFactory() {
		this.factories = new HashMap<String, Factory>();
		this.aircraftIds = -1;
	}

	public static AircraftFactory getInstance() {
		return instance;
	}

	public void addFactory(String type, Factory factory) {
		this.factories.putIfAbsent(type, factory);
	}

	public void removeFactory(String type) {
		this.factories.remove(type);
	}
	
	public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates) throws Exception{
		Factory factory =  this.factories.get(p_type);
		if (factory == null) {
			return null;
		}
		aircraftIds += 1;
		return factory.newAircraft(aircraftIds, p_name, p_coordinates);
	}
}
 