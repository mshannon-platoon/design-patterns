package patterns.observer.vehicle.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import patterns.observer.vehicle.subject.EngineSubject;
import patterns.observer.vehicle.subject.PositionSubject;
import patterns.observer.vehicle.subject.ShockSubject;
import patterns.observer.vehicle.subject.TachoSubject;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {

  private EngineSubject engineSubject;
  private TachoSubject tachoSubject;
  private ShockSubject shockSubject;
  private PositionSubject positionSubject;

}
