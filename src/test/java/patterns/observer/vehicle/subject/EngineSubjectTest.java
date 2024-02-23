package patterns.observer.vehicle.subject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import patterns.behavioral.observer.vehicle.subject.EngineSubject;

class EngineSubjectTest {

  @Test
  void testConstructor() {
    EngineSubject engineSubject = new EngineSubject(1);
    assertEquals(1, engineSubject.getVehicleId());
    assertNull(engineSubject.getOilLevel());
    assertNull(engineSubject.getOilTemp());
    assertNull(engineSubject.getCoolantLevel());
    assertNull(engineSubject.getCoolantTemp());
  }

  @Test
  void testSetData() {
    EngineSubject engineSubject = spy(new EngineSubject(1));
    engineSubject.setData(0.1, 0.1, 0.1, 0.1);
    assertEquals(0.1, engineSubject.getOilLevel());
    assertEquals(0.1, engineSubject.getOilTemp());
    assertEquals(0.1, engineSubject.getCoolantLevel());
    assertEquals(0.1, engineSubject.getCoolantTemp());

    verify(engineSubject).notifyObservers();
  }

}
