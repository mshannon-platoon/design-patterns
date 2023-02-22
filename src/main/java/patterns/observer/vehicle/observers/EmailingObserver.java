package patterns.observer.vehicle.observers;

import patterns.observer.observer.Observer;

public interface EmailingObserver extends Observer {

  void email(String reason);
}
