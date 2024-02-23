package patterns.behavioral.observer.vehicle.subject;

import java.util.ArrayList;
import java.util.List;

import patterns.behavioral.observer.observer.Observer;
import patterns.behavioral.observer.subject.Subject;

public abstract class AbstractSubject implements Subject {

  private final List<Observer> observerList;

  public AbstractSubject() {
    this.observerList = new ArrayList<>();
  }

  @Override
  public void registerObserver(Observer observer) {
    this.observerList.add(observer);
  }

  @Override
  public void removeObserver(Observer observer) {
    this.observerList.remove(observer);
  }

  @Override
  public void notifyObservers() {
    observerList.forEach(Observer::update);
  }
}
