package patterns.behavioral.observer.vehicle.model;


import lombok.Getter;
import lombok.Setter;
import patterns.behavioral.observer.vehicle.subject.PositionSubject;
import patterns.behavioral.observer.vehicle.subject.ShockSubject;
import patterns.behavioral.observer.vehicle.subject.TachographSubject;
import patterns.behavioral.observer.vehicle.subject.EngineSubject;

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
