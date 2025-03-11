package tower;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;

import flyable.Flyable;

public class Tower {
	private ArrayList<Flyable> observers;
	private FileWriter fileWriter;

	public Tower() throws Exception{
		this.observers = new ArrayList<Flyable>();
		this.fileWriter = null;
	}

	public void setFileWriter(FileWriter fileWriter) {
		this.fileWriter = fileWriter;
	}

	public void register(Flyable p_flyable) throws Exception{
		this.observers.add(p_flyable);
		fileWriter.write("Tower says: " + p_flyable.tag() + " registered to tower\n");
	}

	public void unregister(Flyable p_flyable) throws Exception{
		fileWriter.write("Tower says: " + p_flyable.tag() + " unregistered to tower\n");
	}

	protected void conditionChanged() throws Exception{
		Iterator<Flyable> iter = observers.iterator();

		while(iter.hasNext()) {
			Flyable fly = iter.next();
			fly.updateConditions();
			if (fly.hasLanded()) {
				iter.remove();
				unregister(fly);
			}
		}
	}
}
