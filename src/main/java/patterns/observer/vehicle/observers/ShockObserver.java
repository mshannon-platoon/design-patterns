package patterns.observer.vehicle.observers;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import patterns.observer.vehicle.model.Constants.Email;
import patterns.observer.vehicle.model.Constants.Shock;
import patterns.observer.vehicle.subject.ShockSubject;
import patterns.observer.vehicle.util.Monitor;

@Slf4j
@Getter
public class ShockObserver extends AbstractVehicleObserver implements EmailingObserver, Monitor {

  private Double brakeThreshold;
  private Double hardCornerThreshold;

  private final ShockSubject shockSubject;

  public ShockObserver(ShockSubject shockSubject) {
    this.shockSubject = shockSubject;
    shockSubject.registerObserver(this);
    this.setVehicleId(shockSubject.getVehicleId());
  }

  @Override
  public void update() {
    this.brakeThreshold = shockSubject.getBrakeThreshold();
    this.hardCornerThreshold = shockSubject.getHardCornerThreshold();
    monitor();
  }

  @Override
  public void email(String reason) {
    // Example only here, just a log for now.
    log.info("Shock sensors triggered, sending email - reason: {}, vehicleId: {}", reason, getVehicleId());
  }

  @Override
  public void monitor() {
    if (brakeThreshold > Shock.BREAK_THRESHOLD) {
      email(Email.EXCESSIVE_BREAKING_DETECTED);
    }
    if (hardCornerThreshold > Shock.HARD_CORNER_THRESHOLD) {
      email(Email.HARD_CORNERING_DETECTED);
    }
  }

}
