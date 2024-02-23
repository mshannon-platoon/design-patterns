package patterns.behavioral.observer.vehicle.subject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EngineSubject extends AbstractVehicleSubject {

  private Double oilLevel;
  private Double oilTemp;
  private Double coolantLevel;
  private Double coolantTemp;

  public EngineSubject(Integer vehicleId){
    this.setVehicleId(vehicleId);
  }

  private void dataChange() {
    notifyObservers();
  }

  public void setData(double oilLevel, double oilTemp, double coolantLevel, double coolantTemp) {
    this.oilLevel = oilLevel;
    this.oilTemp = oilTemp;
    this.coolantLevel = coolantLevel;
    this.coolantTemp = coolantTemp;
    dataChange();
  }

}
