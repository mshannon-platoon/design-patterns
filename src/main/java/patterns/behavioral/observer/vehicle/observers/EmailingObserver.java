package patterns.behavioral.observer.vehicle.observers;

import patterns.behavioral.observer.observer.Observer;

public interface EmailingObserver extends Observer {

  void email(String reason);
}
