package patterns.observer.vehicle.subject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TachoSubject extends AbstractSubject{

  private int totalDriveTime;

  private void dataChange(){
    notifyObservers();
  }

  public void setData(Integer totalDriveTime) {
    this.totalDriveTime = totalDriveTime;
    dataChange();
  }
  
}
