package patterns.observer.vehicle.subject;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShockSubject extends AbstractVehicleSubject {

  private Double brakeThreshold;
  private Double hardCornerThreshold;

  public ShockSubject(Integer vehicleId){
    this.setVehicleId(vehicleId);
  }

  private void dataChange() {
    notifyObservers();
  }

  public void setData(double brakeThreshold, double hardCornerThreshold) {
    this.brakeThreshold = brakeThreshold;
    this.hardCornerThreshold = hardCornerThreshold;
    dataChange();
  }

}
