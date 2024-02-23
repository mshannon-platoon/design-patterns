package patterns.behavioral.observer.vehicle.observers;

import patterns.behavioral.observer.observer.Observer;

public interface AlertingObserver extends Observer {

  void alert(String alertMessage, Double value);
}
