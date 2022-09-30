package patterns.observer.one.display;

import lombok.extern.log4j.Log4j2;
import patterns.observer.one.observer.Observer;
import patterns.observer.one.subject.WeatherDataSubject;

@Log4j2
public class ForecastDisplay implements DisplayElement, Observer {

  private float temperature;
  private float humidity;
  private final WeatherDataSubject weatherDataSubject;

  public ForecastDisplay(WeatherDataSubject weatherDataSubject) {
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
