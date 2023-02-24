package patterns.observer.vehicle.subject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;

class PositionSubjectTest {

  @Test
  void testConstructor() {
    PositionSubject positionSubject = new PositionSubject(1);
    assertEquals(1, positionSubject.getVehicleId());
    assertNull(positionSubject.getLat());
    assertNull(positionSubject.getLon());

  }

  @Test
  void testSetData() {
    PositionSubject positionSubject = new PositionSubject(1);
    positionSubject.setData(1.0, -1.0);
    assertEquals(1, positionSubject.getVehicleId());
    assertEquals(1.0, positionSubject.getLat());
    assertEquals(-1.0, positionSubject.getLat());

    verify(positionSubject).notifyObservers();
  }

}
