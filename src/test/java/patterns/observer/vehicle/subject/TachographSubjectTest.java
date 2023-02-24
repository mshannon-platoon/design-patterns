package patterns.observer.vehicle.subject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;

class TachographSubjectTest {

  @Test
  void testConstructor() {
    TachographSubject tachographSubject = new TachographSubject(1);
    assertEquals(1, tachographSubject.getVehicleId());
    assertEquals(0, tachographSubject.getTotalDriveTime());
  }

  @Test
  void testSetData() {
    TachographSubject tachographSubject = spy(new TachographSubject(1));
    tachographSubject.setData(10);
    assertEquals(1, tachographSubject.getVehicleId());
    assertEquals(10, tachographSubject.getTotalDriveTime());

    verify(tachographSubject).notifyObservers();
  }

}
