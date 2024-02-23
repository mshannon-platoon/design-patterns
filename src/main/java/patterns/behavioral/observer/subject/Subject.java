package patterns.behavioral.observer.subject;

import patterns.behavioral.observer.observer.Observer;

public interface Subject {

  void registerObserver(Observer observer);

  void removeObserver(Observer observer);

  void notifyObservers();
}
