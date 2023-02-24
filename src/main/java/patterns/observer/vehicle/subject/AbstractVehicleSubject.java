package patterns.observer.vehicle.subject;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractVehicleSubject extends AbstractSubject {
  private Integer vehicleId;
}
