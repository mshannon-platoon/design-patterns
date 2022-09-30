package patterns.observer.one.subject;

import patterns.observer.one.observer.Observer;

public interface Subject {

  void registerObserver(Observer observer);

  void removeObserver(Observer observer);

  void notifyObservers();
}
