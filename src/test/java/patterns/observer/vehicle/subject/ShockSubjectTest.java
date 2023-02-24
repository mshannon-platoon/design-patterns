package patterns.observer.vehicle.subject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;

class ShockSubjectTest {

  @Test
  void testConstructor() {
    ShockSubject shockSubject = new ShockSubject(1);
    assertEquals(1, shockSubject.getVehicleId());
    assertNull(shockSubject.getBrakeThreshold());
    assertNull(shockSubject.getHardCornerThreshold());

  }

  @Test
  void testSetData() {
    ShockSubject shockSubject = new ShockSubject(1);
    shockSubject.setData(0.1, 0.1);
    assertEquals(1, shockSubject.getVehicleId());
    assertEquals(0.1, shockSubject.getBrakeThreshold());
    assertEquals(0.1, shockSubject.getHardCornerThreshold());

    verify(shockSubject).notifyObservers();
  }

}
