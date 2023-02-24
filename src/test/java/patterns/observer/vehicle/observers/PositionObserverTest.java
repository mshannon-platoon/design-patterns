package patterns.observer.vehicle.observers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import patterns.observer.vehicle.subject.PositionSubject;

class PositionObserverTest {

  @Test
  void testConstructor() {
    PositionSubject positionSubject = new PositionSubject(1);
    PositionObserver positionObserver = new PositionObserver(positionSubject);
    assertNotNull(positionObserver.getVehicleId());
    assertNull(positionObserver.getLat());
    assertNull(positionObserver.getLon());
  }

  @Test
  void testUpdate() {
    PositionSubject positionSubject = new PositionSubject(1);
    positionSubject.setLat(-50);
    positionSubject.setLon(100);
    PositionObserver positionObserver = spy(new PositionObserver(positionSubject));

    positionObserver.update();
    assertNotNull(positionObserver.getVehicleId());
    assertEquals(-50.0, positionObserver.getLat());
    assertEquals(100.0, positionObserver.getLon());

    verify(positionObserver).report();
  }

}