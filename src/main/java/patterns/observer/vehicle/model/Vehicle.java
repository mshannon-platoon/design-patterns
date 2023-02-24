package patterns.observer.vehicle.model;


import lombok.Getter;
import lombok.Setter;
import patterns.observer.vehicle.subject.EngineSubject;
import patterns.observer.vehicle.subject.PositionSubject;
import patterns.observer.vehicle.subject.ShockSubject;
import patterns.observer.vehicle.subject.TachographSubject;

@Getter
@Setter
public class Vehicle {

  private Integer vehicleId;
  private EngineSubject engineSubject;
  private TachographSubject tachographSubject;
  private ShockSubject shockSubject;
  private PositionSubject positionSubject;

  public Vehicle(
      Integer vehicleId,
      EngineSubject engineSubject,
      TachographSubject tachographSubject,
      ShockSubject shockSubject,
      PositionSubject positionSubject) {

    this.vehicleId = vehicleId;
    this.engineSubject = engineSubject;
    this.tachographSubject = tachographSubject;
    this.shockSubject = shockSubject;
    this.positionSubject = positionSubject;

  }

}
