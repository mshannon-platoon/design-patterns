package patterns.observer.display;

import lombok.extern.log4j.Log4j2;
import patterns.observer.observer.Observer;
import patterns.observer.subject.WeatherDataSubject;

@Log4j2
public class StatisticsDisplay implements DisplayElement, Observer {

  private float temperature;
  private float humidity;
  private float pressure;
  private final WeatherDataSubject weatherDataSubject;

  public StatisticsDisplay(WeatherDataSubject weatherDataSubject) {
    this.weatherDataSubject = weatherDataSubject;
    weatherDataSubject.registerObserver(this);
  }

  @Override
  public void display() {
    log.info("StatisticsDisplay - temperature: {} humidity: {} pressure: {}", temperature, humidity,
        pressure);
  }

  @Override
  public void update(float temperature, float humidity, float pressure) {
    this.temperature = temperature;
    this.humidity = humidity;
    this.pressure = pressure;
    display();
  }
}
