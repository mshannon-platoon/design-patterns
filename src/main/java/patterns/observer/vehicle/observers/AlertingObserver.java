package patterns.observer.vehicle.observers;

import patterns.observer.observer.Observer;

public interface AlertingObserver extends Observer {

  void alert(String alertMessage);

}
