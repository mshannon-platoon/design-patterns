package patterns.behavioral.observer.vehicle.subject;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TachographSubject extends AbstractVehicleSubject {

  private int totalDriveTime;

  public TachographSubject(Integer vehicleId){
    this.setVehicleId(vehicleId);
  }

  private void dataChange() {
    notifyObservers();
  }

  public void setData(Integer totalDriveTime) {
    this.totalDriveTime += totalDriveTime;
    dataChange();
  }

}
