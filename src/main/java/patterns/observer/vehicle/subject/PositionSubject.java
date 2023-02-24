package patterns.observer.vehicle.subject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PositionSubject extends AbstractVehicleSubject {

  private Double lat;
  private Double lon;

  public PositionSubject(Integer vehicleId){
    this.setVehicleId(vehicleId);
  }

  private void dataChange(){
    notifyObservers();
  }

  public void setData(double lat, double lon){
    this.lat = lat;
    this.lon = lon;
    dataChange();
  }

}
