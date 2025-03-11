package tower;

import java.io.FileWriter;
import java.util.ArrayList;
import flyable.Flyable;

public class Tower {
	private ArrayList<Flyable> observers;
	private FileWriter fileWriter;

	public Tower() throws Exception{
		this.observers = new ArrayList<Flyable>();
		this.fileWriter = new FileWriter("simulation.txt");
	}

	public void register(Flyable p_flyable) throws Exception{
		this.observers.add(p_flyable);
		fileWriter.write("Tower says: " + p_flyable.tag() + " registered to tower");
	}

	public void unregister(Flyable p_flyable) throws Exception{
		this.observers.remove(p_flyable);
		fileWriter.write("Tower says: " + p_flyable.tag() + " unregistered to tower");
	}

	protected void conditionChanged() throws Exception{
		for (Flyable fly : observers) {
			fly.updateConditions();
		}
	}
}
