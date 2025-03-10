package flyable.aircraft.factory;

import flyable.Coordinates;
import flyable.aircraft.Aircraft;
import flyable.aircraft.JetPlane;

public class JetPlaneFactory implements Factory{
	private static final JetPlaneFactory instance = new JetPlaneFactory();

	private JetPlaneFactory() {}

	public static JetPlaneFactory getInstance() {
		return instance;
	}

	public Aircraft newAircraft(long p_id, String p_name, Coordinates p_coordinates) throws Exception{
		return new JetPlane(p_id, p_name, p_coordinates);
	}
}
