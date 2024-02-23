package patterns.behavioral.observer.weather.observers;

import lombok.extern.log4j.Log4j2;
import patterns.behavioral.observer.observer.Observer;
import patterns.behavioral.observer.weather.subject.WeatherDataSubject;

@Log4j2
public class ForecastDisplayObserver implements DisplayElement, Observer {

  private float temperature;
  private float humidity;
  private final WeatherDataSubject weatherDataSubject;

  public ForecastDisplayObserver(WeatherDataSubject weatherDataSubject) {
    this.weatherDataSubject = weatherDataSubject;
    weatherDataSubject.registerObserver(this);
  }

  @Override
  public void display() {
    log.info("ForecastDisplay - temperature: {} humidity: {}", temperature, humidity);
  }

  @Override
  public void update() {
    this.temperature = weatherDataSubject.getTemperature();
    this.humidity = weatherDataSubject.getHumidity();
    display();
  }
}
