package patterns.observer.vehicle.observers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import patterns.behavioral.observer.vehicle.model.Constants.Alerts;
import patterns.behavioral.observer.vehicle.observers.EngineObserver;
import patterns.behavioral.observer.vehicle.subject.EngineSubject;

class EngineObserverTest {

  @Test
  void testConstructor() {
    EngineSubject engineSubject = spy(new EngineSubject(1));
    EngineObserver engineObserver = new EngineObserver(engineSubject);
    assertNotNull(engineObserver.getVehicleId());
    assertNotNull(engineObserver.getEngineSubject());
    assertNull(engineObserver.getLastOilLevel());
    assertNull(engineObserver.getLastOilTemp());
    assertNull(engineObserver.getLastCoolantLevel());
    assertNull(engineObserver.getLastCoolantTemp());

    verify(engineSubject).registerObserver(engineObserver);
  }

  @Test
  void testUpdate_noAlerts() {
    EngineSubject engineSubject = engineSubject(0.5, 80.0, 0.5, 110.0);
    EngineObserver engineObserver = spy(new EngineObserver(engineSubject));

    engineObserver.update();
    assertEquals(1, engineObserver.getVehicleId());
    assertEquals(0.5, engineObserver.getLastOilLevel());
    assertEquals(80.0, engineObserver.getLastOilTemp());
    assertEquals(0.5, engineObserver.getLastCoolantLevel());
    assertEquals(110.0, engineObserver.getLastCoolantTemp());

    verify(engineObserver).monitor();
  }

  @Test
  void testUpdate_alert_lowOil() {
    EngineSubject engineSubject = engineSubject(0.1, 80.0, 0.5, 110.0);
    EngineObserver engineObserver = spy(new EngineObserver(engineSubject));

    engineObserver.update();

    verify(engineObserver).monitor();
    verify(engineObserver).alert(Alerts.OIL_LOW, 0.1);
  }

  @Test
  void testUpdate_alert_oilOverfill() {
    EngineSubject engineSubject = engineSubject(2.0, 80.0, 0.5, 110.0);
    EngineObserver engineObserver = spy(new EngineObserver(engineSubject));

    engineObserver.update();

    verify(engineObserver).monitor();
    verify(engineObserver).alert(Alerts.OIL_OVERFILL, 2.0);
  }

  @Test
  void testUpdate_alert_oilExceedingTemperature() {
    EngineSubject engineSubject = engineSubject(0.5, 150.0, 0.5, 110.0);
    EngineObserver engineObserver = spy(new EngineObserver(engineSubject));

    engineObserver.update();

    verify(engineObserver).monitor();
    verify(engineObserver).alert(Alerts.OIL_EXCEEDING_TEMPERATURE, 150.0);
  }

  @Test
  void testUpdate_alert_coolantLow() {
    EngineSubject engineSubject = engineSubject(0.5, 80.0, 0.01, 110.0);
    EngineObserver engineObserver = spy(new EngineObserver(engineSubject));

    engineObserver.update();

    verify(engineObserver).monitor();
    verify(engineObserver).alert(Alerts.COOLANT_LOW, 0.01);
  }

  @Test
  void testUpdate_alert_coolantOverfill() {
    EngineSubject engineSubject = engineSubject(0.5, 80.0, 2.0, 110.0);
    EngineObserver engineObserver = spy(new EngineObserver(engineSubject));

    engineObserver.update();

    verify(engineObserver).monitor();
    verify(engineObserver).alert(Alerts.COOLANT_OVERFILL, 2.0);
  }

  @Test
  void testUpdate_alert_coolantExceedingTemperature() {
    EngineSubject engineSubject = engineSubject(0.5, 80.0, 2.0, 200.0);
    EngineObserver engineObserver = spy(new EngineObserver(engineSubject));

    engineObserver.update();

    verify(engineObserver).monitor();
    verify(engineObserver).alert(Alerts.COOLANT_EXCEEDING_TEMPERATURE, 200.0);
  }

  private EngineSubject engineSubject(
      double oilLevel,
      double oilTemp,
      double coolantLevel,
      double coolantTemp) {

    EngineSubject engineSubject = new EngineSubject(1);
    engineSubject.setOilLevel(oilLevel);
    engineSubject.setOilTemp(oilTemp);
    engineSubject.setCoolantLevel(coolantLevel);
    engineSubject.setCoolantTemp(coolantTemp);

    return engineSubject;
  }

}
