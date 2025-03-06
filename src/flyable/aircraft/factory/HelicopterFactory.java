package flyable.aircraft.factory;

import flyable.Coordinates;
import flyable.aircraft.Aircraft;
import flyable.aircraft.Helicopter;

public class HelicopterFactory implements Factory{
	private final static HelicopterFactory instance = new HelicopterFactory();

	private HelicopterFactory() {}

	public static HelicopterFactory getInstance() {
		return instance;
	}

	public Aircraft newAircraft(long p_id, String p_name, Coordinates p_coordinates) {
		return new Helicopter(p_id, p_name, p_coordinates);
	}
	
}
