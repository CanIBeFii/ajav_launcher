package flyable.aircraft.factory;

import flyable.Coordinates;
import flyable.aircraft.Aircraft;
import flyable.aircraft.Baloon;

public class BaloonFactory implements Factory{
	private final static BaloonFactory instance = new BaloonFactory();

	private BaloonFactory() {}

	public static BaloonFactory getInstance() {
		return instance;
	}

	public Aircraft newAircraft(long p_id, String p_name, Coordinates p_coordinates) throws Exception{
		return new Baloon(p_id, p_name, p_coordinates);
	}
}
