package flyable.aircraft.factory;

import flyable.Coordinates;
import flyable.aircraft.Aircraft;
import flyable.aircraft.Ballon;

public class BallonFactory implements Factory{
	private final static BallonFactory instance = new BallonFactory();

	private BallonFactory() {}

	public static BallonFactory getInstance() {
		return instance;
	}

	public Aircraft newAircraft(long p_id, String p_name, Coordinates p_coordinates) {
		return new Ballon(p_id, p_name, p_coordinates);
	}
}
