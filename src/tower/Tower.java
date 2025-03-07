package tower;

import java.util.ArrayList;
import flyable.Flyable;

public class Tower {
	private ArrayList<Flyable> observers;

	public Tower() {
		this.observers = new ArrayList<Flyable>();
	}

	public void register(Flyable p_flyable) {
		this.observers.add(p_flyable);
	}

	public void unregister(Flyable p_flyable) {
		this.observers.remove(p_flyable);
	}

	protected void conditionChanged() {
		for (Flyable fly : observers) {
			fly.updateConditions();
		}
	}
}
