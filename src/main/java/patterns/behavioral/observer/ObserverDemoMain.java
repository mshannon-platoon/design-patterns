package patterns.behavioral.observer;

import lombok.extern.log4j.Log4j2;
import patterns.behavioral.observer.weather.observers.CurrentConditionsDisplayObserver;
import patterns.behavioral.observer.weather.observers.ForecastDisplayObserver;
import patterns.behavioral.observer.weather.observers.StatisticsDisplayObserver;
import patterns.behavioral.observer.weather.observers.ThirdPartyDisplayObserver;
import patterns.behavioral.observer.weather.subject.WeatherDataSubject;

@Log4j2
public class ObserverDemoMain {

  public static void main(String[] args) {
    WeatherDataSubject weatherDataSubject = new WeatherDataSubject();

    CurrentConditionsDisplayObserver currentConditionsDisplay = new CurrentConditionsDisplayObserver(
        weatherDataSubject);
    StatisticsDisplayObserver statisticsDisplay = new StatisticsDisplayObserver(weatherDataSubject);
    ForecastDisplayObserver forecastDisplay = new ForecastDisplayObserver(weatherDataSubject);
    ThirdPartyDisplayObserver thirdPartyDisplay = new ThirdPartyDisplayObserver(weatherDataSubject);

    weatherDataSubject.setMeasurements(80, 65, 30.4f);
    weatherDataSubject.setMeasurements(60, 23, 1.8f);
    weatherDataSubject.setMeasurements(32, 12, 8.9f);
  }

}
