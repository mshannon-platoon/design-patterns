package patterns.observer.subject;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import patterns.observer.observer.Observer;

@Getter
public class WeatherDataSubject implements Subject {

  private final List<Observer> observers;
  private float temperature;
  private float humidity;
  private float pressure;

  public WeatherDataSubject() {
    observers = new ArrayList<>();
  }

  @Override
  public void registerObserver(Observer observer) {
    observers.add(observer);

  }

  @Override
  public void removeObserver(Observer observer) {
    observers.remove(observer);
  }

  @Override
  public void notifyObservers() {
    observers.forEach(Observer::update);
  }

  public void measurementsChanged() {
    notifyObservers();
  }

  public void setMeasurements(float temperature, float humidity, float pressure) {
    this.temperature = temperature;
    this.humidity = humidity;
    this.pressure = pressure;
    measurementsChanged();
  }
}
