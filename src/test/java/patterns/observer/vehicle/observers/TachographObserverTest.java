package patterns.observer.vehicle.observers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import patterns.observer.vehicle.subject.TachographSubject;

class TachographObserverTest {

  @Test
  void testConstructor() {
    TachographSubject tachographSubject = new TachographSubject(1);
    TachographObserver tachographObserver = new TachographObserver(tachographSubject);
    assertNotNull(tachographObserver.getVehicleId());
    assertNull(tachographObserver.getTotalDriveTime());
  }

  @Test
  void testUpdate_report() {
    TachographSubject tachographSubject = new TachographSubject(1);
    tachographSubject.setTotalDriveTime(5);
    TachographObserver tachographObserver = spy(new TachographObserver(tachographSubject));

    tachographObserver.update();
    assertEquals(5, tachographObserver.getTotalDriveTime());

    verify(tachographObserver).report();
  }

}
