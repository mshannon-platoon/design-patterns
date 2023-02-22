package patterns.observer.vehicle.subject;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShockSubject extends AbstractSubject {

  private double brakeThreshold;
  private double hardCornerThreshold;

  private void dataChange() {
    notifyObservers();
  }

  public void setData(double brakeThreshold, double hardCornerThreshold) {
    this.brakeThreshold = brakeThreshold;
    this.hardCornerThreshold = hardCornerThreshold;
    dataChange();
  }

}
