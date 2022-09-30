package patterns.observer.subject;

import java.util.ArrayList;
import java.util.List;
import patterns.observer.observer.Observer;

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
    observers.forEach(observer -> observer.update(temperature, humidity, pressure));
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
