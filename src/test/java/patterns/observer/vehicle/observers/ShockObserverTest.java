package patterns.observer.vehicle.observers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import patterns.observer.vehicle.model.Constants.Email;
import patterns.observer.vehicle.subject.ShockSubject;

public class ShockObserverTest {

  @Test
  void testConstructor() {
    ShockSubject shockSubject = new ShockSubject(1);
    ShockObserver shockObserver = new ShockObserver(shockSubject);
    assertNotNull(shockObserver.getVehicleId());
    assertNull(shockObserver.getBrakeThreshold());
    assertNull(shockObserver.getHardCornerThreshold());
  }

  @Test
  void testUpdate_noEmail() {
    ShockSubject shockSubject = new ShockSubject(1);
    shockSubject.setBrakeThreshold(0.60);
    shockSubject.setHardCornerThreshold(0.11);
    ShockObserver shockObserver = spy(new ShockObserver(shockSubject));

    shockObserver.update();
    assertEquals(0.60, shockObserver.getBrakeThreshold());
    assertEquals(0.11, shockObserver.getHardCornerThreshold());

    verify(shockObserver, times(0)).email(any());
  }

  @Test
  void testUpdate_email_excessiveBreakingDetected() {
    ShockSubject shockSubject = new ShockSubject(1);
    shockSubject.setBrakeThreshold(0.99);
    shockSubject.setHardCornerThreshold(0.11);
    ShockObserver shockObserver = spy(new ShockObserver(shockSubject));

    shockObserver.update();

    verify(shockObserver, times(1)).email(Email.EXCESSIVE_BREAKING_DETECTED);
  }

  @Test
  void testUpdate_email_hardCorneringDetected() {
    ShockSubject shockSubject = new ShockSubject(1);
    shockSubject.setBrakeThreshold(0.60);
    shockSubject.setHardCornerThreshold(0.50);
    ShockObserver shockObserver = spy(new ShockObserver(shockSubject));

    shockObserver.update();

    verify(shockObserver, times(1)).email(Email.HARD_CORNERING_DETECTED);
  }

}
