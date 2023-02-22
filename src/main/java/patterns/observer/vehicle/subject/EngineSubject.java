package patterns.observer.vehicle.subject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EngineSubject extends AbstractSubject {

  private double oilLevel;
  private double oilTemp;
  private double coolantLevel;
  private double coolantTemp;

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