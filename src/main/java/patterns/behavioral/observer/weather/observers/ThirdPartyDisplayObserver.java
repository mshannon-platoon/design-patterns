package patterns.behavioral.observer.weather.observers;

import lombok.extern.log4j.Log4j2;
import patterns.behavioral.observer.observer.Observer;
import patterns.behavioral.observer.weather.subject.WeatherDataSubject;

@Log4j2
public class ThirdPartyDisplayObserver implements DisplayElement, Observer {

  private float temperature;
  private float humidity;
  private float pressure;
  private final WeatherDataSubject weatherDataSubject;

  public ThirdPartyDisplayObserver(WeatherDataSubject weatherDataSubject) {
    this.weatherDataSubject = weatherDataSubject;
    weatherDataSubject.registerObserver(this);
  }

  @Override
  public void display() {
    log.info("ThirdPartyDisplay - temperature: {} humidity: {} pressure: {}", temperature, humidity,
        pressure);
  }

  @Override
  public void update() {
    this.temperature = weatherDataSubject.getTemperature();
    this.humidity = weatherDataSubject.getHumidity();
    this.pressure = weatherDataSubject.getPressure();
    display();
  }
}
