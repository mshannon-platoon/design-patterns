package patterns.observer;

import lombok.extern.log4j.Log4j2;
import patterns.observer.display.CurrentConditionsDisplay;
import patterns.observer.display.ForecastDisplay;
import patterns.observer.display.StatisticsDisplay;
import patterns.observer.display.ThirdPartyDisplay;
import patterns.observer.subject.WeatherDataSubject;

@Log4j2
public class ObserverDemoMain {

  public static void main(String[] args) {
    WeatherDataSubject weatherDataSubject = new WeatherDataSubject();

    CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(
        weatherDataSubject);
    StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherDataSubject);
    ForecastDisplay forecastDisplay = new ForecastDisplay(weatherDataSubject);
    ThirdPartyDisplay thirdPartyDisplay = new ThirdPartyDisplay(weatherDataSubject);

    weatherDataSubject.setMeasurements(80, 65, 30.4f);
    weatherDataSubject.setMeasurements(60, 23, 1.8f);
    weatherDataSubject.setMeasurements(32, 12, 8.9f);
  }

}
