package flyable.aircraft.factory;

import flyable.Coordinates;
import flyable.aircraft.Aircraft;

public interface Factory {
	Aircraft newAircraft(long p_id, String p_name, Coordinates p_coordinates) throws Exception;
}
