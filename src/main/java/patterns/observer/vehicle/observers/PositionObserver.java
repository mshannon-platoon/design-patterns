package patterns.observer.vehicle.observers;

import lombok.extern.slf4j.Slf4j;
import patterns.observer.vehicle.subject.PositionSubject;

@Slf4j
public class PositionObserver implements ReportingObserver {

  private double lat;
  private double lon;

  private final PositionSubject positionSubject;

  public PositionObserver(PositionSubject positionSubject) {
    this.positionSubject = positionSubject;
    positionSubject.registerObserver(this);
  }

  @Override
  public void update() {
    this.lat = positionSubject.getLat();
    this.lon = positionSubject.getLon();
    report();
  }

  @Override
  public void report() {
    log.info("Vehicle position has changed: lat: {} lon: {}", lat, lon);
  }

}
