package patterns.observer.vehicle.observers;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import patterns.observer.vehicle.subject.TachographSubject;

@Slf4j
@Getter
public class TachographObserver extends AbstractVehicleObserver implements ReportingObserver {

  private Integer totalDriveTime;

  private final TachographSubject tachographSubject;

  public TachographObserver(TachographSubject tachographSubject) {
    this.tachographSubject = tachographSubject;
    tachographSubject.registerObserver(this);
    this.setVehicleId(tachographSubject.getVehicleId());
  }

  @Override
  public void update() {
    this.totalDriveTime = tachographSubject.getTotalDriveTime();
    report();
  }

  @Override
  public void report() {
    // write to CSV etc. but we will just log for an example.
    if (totalDriveTime % 5 == 0) {
      log.info("Drivers total drive time: {} vehicleId: {}", totalDriveTime, getVehicleId());
    }
  }

}
