package patterns.observer.vehicle.subject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PositionSubject extends AbstractSubject {

  private double lat;
  private double lon;

  private void dataChange(){
    notifyObservers();
  }

  public void setData(double lat, double lon){
    this.lat = lat;
    this.lon = lon;
    dataChange();
  }

}
