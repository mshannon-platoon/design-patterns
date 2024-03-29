package patterns.observer.vehicle.model;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import patterns.behavioral.observer.vehicle.model.Vehicle;
import patterns.behavioral.observer.vehicle.subject.EngineSubject;
import patterns.behavioral.observer.vehicle.subject.PositionSubject;
import patterns.behavioral.observer.vehicle.subject.ShockSubject;
import patterns.behavioral.observer.vehicle.subject.TachographSubject;

public class VehicleTest {

  @Test
  void testConstructor() {
    Vehicle vehicle = new Vehicle(1,
        new EngineSubject(1),
        new TachographSubject(1),
        new ShockSubject(1),
        new PositionSubject(1));

    assertNotNull(vehicle.getVehicleId());
    assertNotNull(vehicle.getEngineSubject());
    assertNotNull(vehicle.getTachographSubject());
    assertNotNull(vehicle.getShockSubject());
    assertNotNull(vehicle.getPositionSubject());
  }
}
