package patterns.observer.vehicle.observers;

import lombok.extern.slf4j.Slf4j;
import patterns.observer.vehicle.subject.TachoSubject;

@Slf4j
public class TachoObserver implements ReportingObserver {

  private int totalDriveTime;

  private final TachoSubject tachoSubject;

  public TachoObserver(TachoSubject tachoSubject) {
    this.tachoSubject = tachoSubject;
    tachoSubject.registerObserver(this);
  }

  @Override
  public void update() {
    this.totalDriveTime = tachoSubject.getTotalDriveTime();
    report();
  }

  @Override
  public void report() {
    // write to CSV etc. but we will just log for an example.
    log.info("Drivers total drive time: {}", totalDriveTime);
  }

}
