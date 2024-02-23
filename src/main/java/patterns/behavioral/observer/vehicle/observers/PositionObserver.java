package patterns.behavioral.observer.vehicle.observers;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import patterns.behavioral.observer.vehicle.subject.PositionSubject;

@Slf4j
@Getter
public class PositionObserver extends AbstractVehicleObserver implements ReportingObserver {

  private Double lat;
  private Double lon;

  private final PositionSubject positionSubject;

  public PositionObserver(PositionSubject positionSubject) {
    this.positionSubject = positionSubject;
    positionSubject.registerObserver(this);
    this.setVehicleId(positionSubject.getVehicleId());
  }

  @Override
  public void update() {
    this.lat = positionSubject.getLat();
    this.lon = positionSubject.getLon();
    report();
  }

  @Override
  public void report() {
    log.info("Vehicle position has changed for vehicleId: {} lat: {} lon: {}", getVehicleId(), lat,
        lon);
  }

}
